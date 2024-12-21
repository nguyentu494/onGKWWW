/*
 * @ (#) Experience.java   1.0     20/12/2024
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

import com.example.onthiwww2.backend.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private long id;
    @Column
    private String workDescription;
    @Column
    private Roles roles;
    @Column
    private String companyName;
    @Column
    private LocalDate toDate;
    @Column
    private LocalDate fromDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
}
