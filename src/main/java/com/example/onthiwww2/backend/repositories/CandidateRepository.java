package com.example.onthiwww2.backend.repositories;

import com.example.onthiwww2.backend.enums.Roles;
import com.example.onthiwww2.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByExperiences_CompanyNameContainsIgnoreCaseAndExperiences_Roles(String companyName, Roles roles);
}