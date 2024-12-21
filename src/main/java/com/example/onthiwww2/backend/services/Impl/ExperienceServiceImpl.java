/*
 * @ (#) ExperienceServiceImpl.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.services.Impl;

import com.example.onthiwww2.backend.models.Experience;
import com.example.onthiwww2.backend.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceService experienceService;

    @Override
    public List<Experience> findByCandidateId(long id) {
        return experienceService.findByCandidateId(id);
    }
}
