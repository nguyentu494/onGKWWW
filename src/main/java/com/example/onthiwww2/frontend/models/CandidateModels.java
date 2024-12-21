/*
 * @ (#) CandiateModels.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.frontend.models;

import com.example.onthiwww2.backend.models.Candidate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */
@Component
public class CandidateModels {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String URI = "http://localhost:8080/api/v1/candidates";

    public List<Candidate> findAll(){
        return restTemplate.getForObject(URI, List.class);
    }

    public Candidate findById(long id){
        return restTemplate.getForObject(URI + "/" + id, Candidate.class);
    }

    public List<Candidate> findByCompanyName(String compName){
        return restTemplate.getForObject(URI + "/company/"+ compName, List.class);
    }

    public List<Candidate> findByExperienceGreaterThan5Year(){
        return restTemplate.getForObject(URI + "/exp", List.class);
    }
}
