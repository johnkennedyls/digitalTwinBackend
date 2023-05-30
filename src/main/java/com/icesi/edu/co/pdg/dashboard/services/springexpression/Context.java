package com.icesi.edu.co.pdg.dashboard.services.springexpression;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

@Service
public class Context {

	@Autowired
	private Functions functions;
	@Autowired
	private SpringExpressions interpreter;
	@Autowired
	private AlarmService alarmService;

	public void checkAlarms(MeasurementDTO measurementDTO) throws Exception {
		AlarmDTO alarmDTO=null;

		List<TypeAlarm> typeAlarms=functions.loadTypeAlarmsFromDatabase(measurementDTO.assetName);
		for (TypeAlarm typeAlarm : typeAlarms) {
			if (evaluateCondition(measurementDTO, typeAlarm.getCondition())) {
				alarmDTO=new AlarmDTO();
				alarmDTO.setTypeAlarm(typeAlarm);
				alarmDTO.setTagValue(measurementDTO.value);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				alarmDTO.setActivationDate(timestamp);
			}
		}
		if(alarmDTO!=null) {
			alarmService.addAlarm(alarmDTO);	
		}
	}

	private boolean evaluateCondition(MeasurementDTO tagValue, String condition) {
	    interpreter.setVariable("assetName", tagValue.assetName);
	    interpreter.setVariable("value", tagValue.value);

	    String modifiedCondition = condition.replace(tagValue.assetName, "#value");

	    Boolean result = (Boolean) interpreter.parseExpression(modifiedCondition);

	    return result != null && result;
	}

}
