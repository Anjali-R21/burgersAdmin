package com.egentraining.burgersadmin.repository;
import com.egentraining.burgersadmin.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BranchRepository extends MongoRepository<Branch,String> {

}
