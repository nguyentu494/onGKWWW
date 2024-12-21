/*
 * @ (#) CandidateService.java   1.0     20/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.services;

import com.example.onthiwww2.backend.models.Candidate;

import java.util.List;
import java.util.Optional;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/12/2024
 * @version: 1.0
 */
public interface CandidateService {
    public List<Candidate> findAll();
    Optional<Candidate> findById(long id);

    List<Candidate> findByCompanyName(String companyName);
    List<Candidate> findByExperience();


}
