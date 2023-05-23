package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TypeAlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmDetailOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.TypeAlarmListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.model.mappers.TypeAlarmMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.AlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.DashboardEventRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AssignedUserService;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.TypeAlarmService;

@Service
@Transactional
public class TypeAlarmServiceImp implements TypeAlarmService{
	
	@Autowired
    private TypeAlarmRepository typeAlarmRepository;
	@Autowired
    private AlarmService alarmService;
	@Autowired
    private PlantRepository plantRepository;
	@Autowired
    private DashboardEventRepository dashboardEventRepository;
	@Autowired
	private AssignedUserService assignedUserService;

	@Override
	public TypeAlarmDTO addTypeAlarm(TypeAlarmDTO typeAlarm) throws Exception {
		if(typeAlarm.getTypeAlarmName()==null || typeAlarm.getTypeAlarmName().isEmpty() || 
		typeAlarm.getTypeAlarmDescription()==null || typeAlarm.getTypeAlarmDescription().isEmpty() ||
		typeAlarm.getCondition()==null || typeAlarm.getCondition().isEmpty() || typeAlarm.getEvent_id()==null
		|| typeAlarm.getPlant_id()==null) {
			throw new BadRequestDataException();
		}else {
			TypeAlarm typeAlarmFoundNamAndConditione=typeAlarmRepository.findByTypeAlarmName(typeAlarm.getTypeAlarmName());
			if(typeAlarmFoundNamAndConditione==null) {
				typeAlarmFoundNamAndConditione=typeAlarmRepository.findByCondition(typeAlarm.getCondition());
				if(typeAlarmFoundNamAndConditione==null) {
					Optional<Plant> plant=plantRepository.findById(typeAlarm.getPlant_id());
					TypeAlarm saved = null;
					if(!plant.isEmpty()) {
						Optional<EventDashboard> event=dashboardEventRepository.findById(typeAlarm.getEvent_id());
						if(!event.isEmpty()) {
							TypeAlarm typealarm=TypeAlarmMapper.INSTANCE.addTypeAlarmDTOtotypeAlarm(typeAlarm);
							typealarm.setPlant(plant.get());
							typealarm.setDashboardEvent(event.get());
							saved=typeAlarmRepository.save(typealarm);
						}
					}
					if(typeAlarm.getUsersAssigned()!=null) {
						List <AssignedUser> list=typeAlarm.assignedUserListDTOoAssignedUserList();
						assignedUserService.addAssignedUser(list, saved.getTypeAlarmId());
					}			
					return typeAlarm;
				}
				else {
					throw new BadRequestDataException("La condición del tipo de alarma ya existe");
				}
			}else {
				throw new BadRequestDataException("El nombre del tipo de alarma ya existe");
			}
			
		}
		
	}

	@Override
	public TypeAlarmDTO editTypeAlarm(Integer typeAlarmid, TypeAlarmDTO typeAlarm) throws Exception {
		if(typeAlarm==null || typeAlarmid <0 || typeAlarm.getTypeAlarmName()==null || typeAlarm.getTypeAlarmName().isEmpty() || 
				typeAlarm.getTypeAlarmDescription()==null || typeAlarm.getTypeAlarmDescription().isEmpty() ||
				typeAlarm.getCondition()==null || typeAlarm.getCondition().isEmpty() || typeAlarmid==null 
				|| typeAlarm.getEvent_id()==null || typeAlarm.getPlant_id()==null) {
			throw new BadRequestDataException();
		}else {
			TypeAlarm typeAlarmFoundNamAndCondition=null;
			TypeAlarm typeAlarmEdited=typeAlarmRepository.findById(typeAlarmid).get();
			if(typeAlarmEdited!=null) {
				Optional<Plant> plant=plantRepository.findById(typeAlarm.getPlant_id());
				Optional<EventDashboard> event=dashboardEventRepository.findById(typeAlarm.getEvent_id());
				
				if(!plant.isEmpty() && !event.isEmpty()) {
					if(typeAlarmEdited.getTypeAlarmName().equals(typeAlarm.getTypeAlarmName())) {						
						if(typeAlarmEdited.getCondition().equals(typeAlarm.getCondition())) {
							return editTypeAlarmValidation(typeAlarmid,typeAlarm,typeAlarmEdited,plant.get(),event.get());
						}else {
							typeAlarmFoundNamAndCondition=typeAlarmRepository.findByCondition(typeAlarm.getCondition());
							if(typeAlarmFoundNamAndCondition==null) {
								return editTypeAlarmValidation(typeAlarmid,typeAlarm,typeAlarmEdited,plant.get(),event.get());
							}
							else {
								throw new BadRequestDataException("La condición del tipo de alarma ya existe");
							}
						}
					}else {
						typeAlarmFoundNamAndCondition=typeAlarmRepository.findByTypeAlarmName(typeAlarm.getTypeAlarmName());
						if(typeAlarmFoundNamAndCondition==null) {
							if(typeAlarmEdited.getCondition().equals(typeAlarm.getCondition())) {
								return editTypeAlarmValidation(typeAlarmid,typeAlarm,typeAlarmEdited,plant.get(),event.get());
							}else {
								typeAlarmFoundNamAndCondition=typeAlarmRepository.findByCondition(typeAlarm.getCondition());
								if(typeAlarmFoundNamAndCondition==null) {
									return editTypeAlarmValidation(typeAlarmid,typeAlarm,typeAlarmEdited,plant.get(),event.get());
								}
								else {
									throw new BadRequestDataException("La condición del tipo de alarma ya existe");
								}
							}
						}else {
							throw new BadRequestDataException("El nombre del tipo de alarma ya existe");
						}
					}
				}else {
					throw new BadRequestDataException();
				}
				
			}else {
				throw new NoResultException();
			}
		}
	}
	@Override
	public TypeAlarmDTO editTypeAlarmValidation(Integer typeAlarmid, TypeAlarmDTO typeAlarm,TypeAlarm typeAlarmEdited,Plant plant, EventDashboard event) throws Exception {
		typeAlarmEdited.setTypeAlarmId(typeAlarmid);
		typeAlarmEdited.setTypeAlarmName(typeAlarm.getTypeAlarmName());
		typeAlarmEdited.setTypeAlarmDescription(typeAlarm.getTypeAlarmDescription());
		typeAlarmEdited.setCondition(typeAlarm.getCondition());
		typeAlarmEdited.setNumberAlarmsMax(typeAlarm.getNumberAlarmsMax());
		typeAlarmEdited.setPlant(plant);
		typeAlarmEdited.setDashboardEvent(event);
		
		if(typeAlarm.getUsersAssigned()!=null) {
			assignedUserService.deleteByTypeAlarmTypeAlarmId(typeAlarmid);
			List <AssignedUser> list=typeAlarm.assignedUserListDTOoAssignedUserList();
			assignedUserService.addAssignedUser(list,typeAlarmid);
		}
						
		typeAlarmRepository.save(typeAlarmEdited);	
		return typeAlarm;
	}
	

	@Override
	public TypeAlarm deleteTypeAlarm(Integer typeAlarmid) throws Exception {
		if(typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<TypeAlarm> typeAlarmDeleted=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarmDeleted.isEmpty()) {
				assignedUserService.deleteByTypeAlarmTypeAlarmId(typeAlarmid);
				alarmService.deleteByTypeAlarmTypeAlarmId(typeAlarmid);
				typeAlarmRepository.deleteById(typeAlarmid);
				return typeAlarmDeleted.get();
			}else {
				throw new NoResultException();
			}
		}
	}

	@Override
	public TypeAlarmDetailOutDTO getTypeAlarm(Integer typeAlarmid) throws Exception {
		if(typeAlarmid<0 || typeAlarmid==null) {
			throw new BadRequestDataException();
		}else {
			Optional<TypeAlarm> typeAlarm=typeAlarmRepository.findById(typeAlarmid);
			if(!typeAlarm.isEmpty()) {
				TypeAlarmDetailOutDTO typeAlarmDTO=TypeAlarmMapper.INSTANCE.typeAlarmToTypeAlarmDetailOutDTO(typeAlarm.get().getTypeAlarmId(),typeAlarm.get(),typeAlarm.get().getPlant(),typeAlarm.get().getDashboardEvent());
				typeAlarmDTO.setUsersAssigned(typeAlarm.get().getEmailsAssignedUsers());
				return typeAlarmDTO;
			}else{
				throw new NoResultException();
			}
		}
	}

	@Override
	public List<TypeAlarmListOutDTO> getAllTypeAlarms() throws Exception {
		List<TypeAlarm> typeAlarms = typeAlarmRepository.findAll();
        if(typeAlarms.isEmpty()) {
			throw new NoResultException();
        }else {
            List<TypeAlarmListOutDTO> typealarmsDTO = new ArrayList<TypeAlarmListOutDTO>();
            for(TypeAlarm typeAlarm:typeAlarms) {
            	TypeAlarmListOutDTO alarmListDTO=TypeAlarmMapper.INSTANCE.typeAlarmToAlarmListOutDTO(typeAlarm, typeAlarm.getPlant());
            	alarmListDTO.setUsersAssigned(typeAlarm.getEmailsAssignedUsers());
            	typealarmsDTO.add(alarmListDTO);
            }
                       
            return typealarmsDTO;
        }
	}
	@Override
	public List<TypeAlarmListOutDTO> getAllTypeAlarmsByPlantid(Integer plantid) throws Exception {
		List<TypeAlarm> typeAlarms = typeAlarmRepository.findByPlantPlantId(plantid);
            List<TypeAlarmListOutDTO> typealarmsDTO = new ArrayList<TypeAlarmListOutDTO>();
            for(TypeAlarm typeAlarm:typeAlarms) {
            	TypeAlarmListOutDTO alarmListDTO=TypeAlarmMapper.INSTANCE.typeAlarmToAlarmListOutDTO(typeAlarm, typeAlarm.getPlant());
            	alarmListDTO.setUsersAssigned(typeAlarm.getEmailsAssignedUsers());
            	typealarmsDTO.add(alarmListDTO);
            }
                       
            return typealarmsDTO;
	}

}
