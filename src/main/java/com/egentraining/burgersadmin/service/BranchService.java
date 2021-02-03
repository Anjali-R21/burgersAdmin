package com.egentraining.burgersadmin.service;

import com.egentraining.burgersadmin.model.Branch;
import com.egentraining.burgersadmin.model.Location;
import com.egentraining.burgersadmin.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService {
    @Autowired
    private BranchRepository repository;


    public Branch getNearest (Double lat, Double longi){

        double minDistance = Double.MAX_VALUE;
        Branch nearest = new Branch();
        Location location = new Location("", lat, longi);
        Iterable<Branch> allBranches = repository.findAll();
        for (Branch temp :allBranches){

            double dist = temp.distanceTo(location);
            if (dist < minDistance){
                minDistance = dist;
                nearest = temp;
            }

        }
        return nearest;

    }

}
