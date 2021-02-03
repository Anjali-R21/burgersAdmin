package com.egentraining.burgersadmin.controller;

import com.egentraining.burgersadmin.model.Branch;
import com.egentraining.burgersadmin.repository.BranchRepository;
import com.egentraining.burgersadmin.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @Autowired
    private BranchRepository repository;

    @GetMapping("/list")
    @ResponseBody
    public List<Branch> allUsers() {
//        List<Branch> b= new ArrayList<>();
//        b.add(new Branch("name","sad","sdsf",34.34,345.45));
//        return b;
        return repository.findAll();
    }

    @GetMapping("/count")
    public Long count() {
        return repository.count();
    }

    @GetMapping("/nearest")
    public Branch getNearest(@RequestParam String latitude, @RequestParam String longitude){
        Double lat = Double.parseDouble(latitude);
        Double longi = Double.parseDouble(longitude);

        return branchService.getNearest(lat, longi);
    }

    @PostMapping ("/update/{id}")
    public void updateBranch(@PathVariable("id") String id, @RequestBody Map<String, Object> body) {
        Optional<Branch> b = repository.findById(id);
            System.out.println(body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }


}
