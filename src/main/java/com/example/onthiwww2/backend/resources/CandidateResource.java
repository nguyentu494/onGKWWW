/*
 * @ (#) CandidateResource.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.resources;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */

import com.example.onthiwww2.backend.models.Candidate;
import com.example.onthiwww2.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/v1/candidates")
public class CandidateResource {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("")
    public ResponseEntity<List<Candidate>> findAll(){
        return ResponseEntity.ok(candidateService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(candidateService.findById(id).get());
    }
    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<Candidate>> findByCompanyName(@PathVariable("companyName") String companyName){
        return ResponseEntity.ok(candidateService.findByCompanyName(companyName));
    }

    @GetMapping("/exp")
    public ResponseEntity<List<Candidate>> findByExp(){
        return ResponseEntity.ok(candidateService.findByExperience());
    }

}
