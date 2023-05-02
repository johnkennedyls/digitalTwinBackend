package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;



import java.io.Serializable;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "user_event")
@Getter
@Setter
public class UserEvent  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="user_event_id")
	    private Integer userEventId;
	    
	    @Column(name="username", length=100)
	    private String username;
	    
	    @ManyToOne
	    @JoinColumn(name="event_id")
	    private DashboardEvent event;

}

