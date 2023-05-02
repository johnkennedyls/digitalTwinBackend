package com.icesi.edu.co.pdg.dashboard.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.infrastructure.entity.UserEvent;

@Repository
public interface UserEventRepository  extends JpaRepository<UserEvent,Long>{

}
