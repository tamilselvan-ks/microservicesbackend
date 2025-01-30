package com.demo.details.repository;

import com.demo.details.entity.Detailsmodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailsRepo extends MongoRepository<Detailsmodel, String> {
}
