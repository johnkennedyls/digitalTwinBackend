package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_alarm")
@Getter
@Setter
public class Comment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="comment_id")
    private Integer commentId;
    
    @Column(name="comment_description", length=5000)
    private String commentDescription;
    
    @Column(name="comment_username", length=200)
    private String commentUsername;
    
    @ManyToOne
    @JoinColumn(name="alarm_id")
    private Alarm alarm;

}
