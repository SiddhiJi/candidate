package com.incture.candidate.service;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.incture.candidate.entity.Candidate;
import com.incture.candidate.helper.Helper;
import com.incture.candidate.repo.CandidateRepository;
import com.incture.candidate.repo.ProductRepo;

import java.io.IOException;
import java.util.List;

@Service

public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ProductRepo productRepo;


    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate candidate) {
        candidate.setCandidateId(id);
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    // ----------------------------------------------------------------
    
    public void save(MultipartFile file) {

        try {
            List<Candidate> candidates = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.candidateRepository.saveAll(candidates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Candidate> getAllProducts() {
        return this.candidateRepository.findAll();
    }
}
