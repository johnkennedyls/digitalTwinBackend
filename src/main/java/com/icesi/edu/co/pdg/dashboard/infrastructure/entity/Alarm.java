package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "alarm")
@Getter
@Setter

public class Alarm implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="alarm_id")
	    private Integer alarmId;
	    
	    @ManyToOne
	    @JoinColumn(name="type_alarm_id")
	    private TypeAlarm typeAlarm;
	    
	    @Column(name="activation_date")
	    private Timestamp activationDate;
	    
	    @ManyToOne
	    @JoinColumn(name="state_alarm_id")
	    private StateAlarm stateAlarm;

}
