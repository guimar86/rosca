package com.kixikila.repository;

import com.kixikila.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {

    Participant findByEmail(String email);
}
