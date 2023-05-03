package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state_alarm")
@Getter
@Setter


public class StateAlarm implements Serializable {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="state_alarm_id")
    private Integer stateAlarmId;
    
    @Column(name="state_alarm_name", length=40)
    private String stateAlarmName;
    
    @Column(name="state_alarm_description", length=5000)
    private String stateAlarmDescription;
    
    @ManyToOne
    @JoinColumn(name="state_in_process_id")
    private Integer stateInProcess;
    
    
}
