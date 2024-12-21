package com.example.onthiwww2.backend.repositories;

import com.example.onthiwww2.backend.models.Candidate;
import com.example.onthiwww2.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    @Query("select can from Experience expr inner join Candidate can on expr.candidate = can where ( year (expr.toDate) -  year (expr.fromDate)) > 5 ")
    List<Candidate> findCandidateGreaterThan5Years();
}