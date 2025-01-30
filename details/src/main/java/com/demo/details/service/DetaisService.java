package com.demo.details.service;

import com.demo.details.entity.Detailsmodel;
import com.demo.details.repository.IDetailsRepo;
import org.springframework.stereotype.Service;

@Service
public class DetaisService {
    private final IDetailsRepo repo;
    public DetaisService(IDetailsRepo repo) {
        this.repo = repo;
    }
    public String saveDetails(Detailsmodel details){
        repo.save(details);
        return "Details saved successfully";
    }
}
