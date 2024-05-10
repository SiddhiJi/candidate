package com.incture.candidate.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incture.candidate.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
