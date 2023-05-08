package com.icesi.edu.co.pdg.dashboard.services.springexpression;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagValueDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.AlarmService;

@Service
public class Context {

	private List<TagValueDTO> tagValueList = new ArrayList<>();

	@Autowired
	private Functions functions;
	@Autowired
	private SpringExpressions interpreter;
	@Autowired
	private AlarmService alarmService;

	public void updateTagValues(List<TagValueDTO> newTagValues) {
		tagValueList = newTagValues;
	}

	public List<AlarmDTO> checkAlarms() throws Exception {
		List<AlarmDTO> triggeredAlarms = new ArrayList<>();

		for (TagValueDTO tagValue : tagValueList) {
			List<TypeAlarm> typeAlarms=functions.loadTypeAlarmsFromDatabase(tagValue.getAssetName());
			for (TypeAlarm typeAlarm : typeAlarms) {
				if (evaluateCondition(tagValue, typeAlarm.getCondition())) {
					AlarmDTO alarm=new AlarmDTO();
					alarm.setTypeAlarm(typeAlarm);
					alarm.setTagValue(tagValue.getValue());
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					alarm.setActivationDate(timestamp);
					triggeredAlarms.add(alarm);
				}
			}
		}
		alarmService.addAlarms(triggeredAlarms);
		return triggeredAlarms;
	}

	private boolean evaluateCondition(TagValueDTO tagValue, String condition) {
	    interpreter.setVariable("assetName", tagValue.getAssetName());
	    interpreter.setVariable("value", tagValue.getValue());

	    String modifiedCondition = condition.replace(tagValue.getAssetName(), "#value");

	    Boolean result = (Boolean) interpreter.parseExpression(modifiedCondition);

	    return result != null && result;
	}

}
