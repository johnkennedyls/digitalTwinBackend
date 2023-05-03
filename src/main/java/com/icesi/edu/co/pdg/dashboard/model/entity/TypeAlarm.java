package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_alarm")
@Getter
@Setter

public class TypeAlarm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="type_alarm_id")
	    private Integer typeAlarmId;
	    
	    @Column(name="type_alarm_name", length=40)
	    private String typeAlarmName;
	    
	    @Column(name="type_alarm_description", length=5000)
	    private String typeAlarmDescription;
	    
	    @Column(name="condition", length=100)
	    private String condition;
	    
	    @ManyToOne
	    @JoinColumn(name="value_id")
	    private DashboardValue value;
}
