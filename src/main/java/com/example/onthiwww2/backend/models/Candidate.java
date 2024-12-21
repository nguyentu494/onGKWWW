/*
 * @ (#) Candidate.java   1.0     20/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.models;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/12/2024
 * @version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private long id;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String fullName;
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;
}
