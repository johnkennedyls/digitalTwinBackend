package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Id;

@Entity
@Table(name = "plant")
@Getter
@Setter
public class Plant implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	
	@Column(name = "plant_id")
	private Long plantid;

	@Column(name = "plant_name")
	private String plantName;
	
	@Column(name = "plant_description")
	private String plantDescription;

	@Column(name = "plant_photo")
	private byte[] plantPhoto;

}
