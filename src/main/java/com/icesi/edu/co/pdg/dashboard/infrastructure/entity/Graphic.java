package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "graphic")
@Getter
@Setter

public class Graphic implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="graphic_id")
    private Long graphicId;
    
    @Column(name="graphic_name", length=50)
    private String graphicName;
    
    @Column(name="graphic_description", length=5000)
    private String graphicDescription;
    
    @ManyToOne
    @JoinColumn(name="graphic_type_id")
    private GraphicType graphicType;
    
    @ManyToOne
    @JoinColumn(name="plant_id")
    private Plant plant;
}
