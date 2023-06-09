package com.icesi.edu.co.pdg.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.AssignedUser;

public interface AlarmRepository  extends JpaRepository<Alarm,Integer>{	

    @Query("SELECT COUNT(a) FROM Alarm a WHERE a.typeAlarm.typeAlarmId = :typeAlarmId")
    Integer countByTypeAlarm(@Param("typeAlarmId") Integer typeAlarmId);
    
    List<Alarm> findByTypeAlarmTypeAlarmId( Integer typeAlarmId);
    
    @Query("SELECT a FROM Alarm a WHERE a.stateAlarm.stateAlarmName = 'Cerrado'")
    List<Alarm> findClosedAlarms();

    @Query("SELECT a FROM Alarm a WHERE a.stateAlarm.stateAlarmName IN ('Activa', 'En Revision')")
    List<Alarm> findActiveOrUnderReviewAlarms();
    
    @Query("SELECT a FROM Alarm a WHERE a.stateAlarm.stateAlarmName = 'Cerrado' AND a.typeAlarm.plant.plantId=:plantid")
    List<Alarm> findClosedAlarmsAndPlantid(@Param("plantid")Integer plantid);

    @Query("SELECT a FROM Alarm a WHERE a.stateAlarm.stateAlarmName IN ('Activa', 'En Revision') AND a.typeAlarm.plant.plantId=:plantid")
    List<Alarm> findActiveOrUnderReviewAlarmsAndPlantid(@Param("plantid")Integer plantid);
    
	public List<Alarm> deleteByTypeAlarmTypeAlarmId(Integer typeAlarmid);
    

}
