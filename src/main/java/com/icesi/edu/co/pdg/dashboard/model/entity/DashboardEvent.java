package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity

@Table(name = "dashboard_event")
@Getter
@Setter
public class DashboardEvent implements Serializable {
	
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="event_id")
	    private Integer eventId;
	    
	    @Column(name="event_name", length=40)
	    private String eventName;
	    
	    @Column(name="event_description", length=5000)
	    private String eventDescription;
	    
	    @ManyToOne
	    @JoinColumn(name="type_alarm_id")
	    private TypeAlarm typeAlarm;


}
