/*
 * @ (#) CandidateServiceImpl.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.services.Impl;

import com.example.onthiwww2.backend.enums.Roles;
import com.example.onthiwww2.backend.models.Candidate;
import com.example.onthiwww2.backend.repositories.CandidateRepository;
import com.example.onthiwww2.backend.repositories.ExperienceRepository;
import com.example.onthiwww2.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */
@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> findById(long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> findByCompanyName(String companyName) {
        return candidateRepository.findByExperiences_CompanyNameContainsIgnoreCaseAndExperiences_Roles(companyName, Roles.STAFF);
    }

    @Override
    public List<Candidate> findByExperience() {
        return experienceRepository.findCandidateGreaterThan5Years();
    }
}
