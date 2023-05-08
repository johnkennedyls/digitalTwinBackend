package com.icesi.edu.co.pdg.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;

public interface AlarmRepository  extends JpaRepository<Alarm,Integer>{	

    @Query("SELECT COUNT(a) FROM Alarm a WHERE a.typeAlarm.typeAlarmId = :typeAlarmId")
    Integer countByTypeAlarm(@Param("typeAlarmId") Integer typeAlarmId);
    
    List<Alarm> findByTypeAlarmTypeAlarmId( Integer typeAlarmId);
    

}
