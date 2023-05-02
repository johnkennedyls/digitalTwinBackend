package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "log_type")
@Getter
@Setter
public class LogType implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )
    private Long id;
    
	
	
	@Column(name="log_type_id")
	private Long log_type_id;
	
	@Column(name="log_type_name")
	private String log_type_name;
	
	@Column(name="log_type_description")
	private String log_type_description;
	
}


