package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;


@Entity
@Table(name = "graphic_type")
@Getter
@Setter


public class GraphicType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="graphic_type_id")
	    private Integer graphicTypeId;
	    
	    @Column(name="graphic_type_name", length=40)
	    private String graphicTypeName;
	    
	    @Column(name="graphic_type_description", length=5000)
	    private String graphicTypeDescription;
	    
	    @OneToMany(mappedBy="graphicType")
	    private List<Graphic> graphics;
	

}
