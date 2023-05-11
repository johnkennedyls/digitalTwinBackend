package com.icesi.edu.co.pdg.dashboard.model.dtos.out;

import java.util.List;

public class TypeAlarmListOutDTO {
		
		private Integer typeAlarmId;
		private String typeAlarmName;
		private String typeAlarmDescription;
	    private String condition;
	    private Integer numberAlarmsMax;
		private String plantName;
		private List<String> usersAssigned;
		
		public Integer getTypeAlarmId() {
			return typeAlarmId;
		}
		public void setTypeAlarmId(Integer typeAlarmId) {
			this.typeAlarmId = typeAlarmId;
		}	
		public String getTypeAlarmName() {
			return typeAlarmName;
		}
		public void setTypeAlarmName(String typeAlarmName) {
			this.typeAlarmName = typeAlarmName;
		}
		public String getTypeAlarmDescription() {
			return typeAlarmDescription;
		}
		public void setTypeAlarmDescription(String typeAlarmDescription) {
			this.typeAlarmDescription = typeAlarmDescription;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public Integer getNumberAlarmsMax() {
			return numberAlarmsMax;
		}
		public void setNumberAlarmsMax(Integer numberAlarmsMax) {
			this.numberAlarmsMax = numberAlarmsMax;
		}
		public String getPlantName() {
			return plantName;
		}
		public void setPlantName(String plantName) {
			this.plantName = plantName;
		}
		public List<String> getUsersAssigned() {
			return usersAssigned;
		}
		public void setUsersAssigned(List<String> usersAssigned) {
			this.usersAssigned = usersAssigned;
		}

}
