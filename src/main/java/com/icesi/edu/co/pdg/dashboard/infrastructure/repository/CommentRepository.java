package com.icesi.edu.co.pdg.dashboard.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.infrastructure.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.infrastructure.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
