/*
 * @ (#) ExperienceService.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.services;

import com.example.onthiwww2.backend.models.Experience;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */
public interface ExperienceService {
    List<Experience> findByCandidateId(long id);
}
