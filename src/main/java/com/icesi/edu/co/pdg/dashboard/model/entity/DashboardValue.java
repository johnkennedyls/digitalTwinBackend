package com.icesi.edu.co.pdg.dashboard.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dashboard_value")
@Getter
@Setter
public class DashboardValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="value_id")
	    private Integer valueId;
	    
	    @Column(name="tag_name", length=40)
	    private String tagName;
	    
	    @ManyToOne
	    @JoinColumn(name="graphic_id")
	    private Graphic graphic;
	    
	    @Lob
	    @Column(name="svg_id")
	    private byte[] svgId;

}
