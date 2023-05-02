package com.icesi.edu.co.pdg.dashboard.infrastructure.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "log")
@Getter
@Setter

public class Log  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="log_id")
	    private Integer logId;
	    
	    @Column(name="log_date")
	    private LocalDateTime logDate;
	    
	    @Column(name="user", length=50)
	    private String user;
	    
	    @Column(name="detail_log", length=5000)
	    private String detailLog;
	    
	    @ManyToOne
	    @JoinColumn(name="log_type_id")
	    private LogType logType;

}
