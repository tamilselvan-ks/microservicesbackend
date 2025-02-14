package com.demo.details.service;

import com.demo.details.entity.Detailsmodel;
import com.demo.details.repository.IDetailsRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DetaisService {
    private final IDetailsRepo repo;
    
    private final RestTemplate restTemplate;
    
    public DetaisService(IDetailsRepo repo , RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
        
    }
    public String saveDetails(Detailsmodel details){
    	String userCheckUrl = "http://localhost:8081/micro/get/" + details.getUserId();
         try {
             restTemplate.getForObject(userCheckUrl, String.class);
         } catch (Exception e) {
             return "Error: User does not exist in Register Service!";
         }

         // Save details if user exists
         repo.save(details);
         return "Details saved successfully";
     }
    
    public List<Map<String, Object>> getAllUsersWithDetails() {
        // Step 1: Fetch all users from Register Service
        String registerServiceUrl = "http://localhost:8081/micro/all";
        List<Map<String, Object>> users = restTemplate.getForObject(registerServiceUrl, List.class);

        // Step 2: Fetch all details from Details Service
        List<Detailsmodel> detailsList = repo.findAll();

        // Step 3: Merge the data based on userId
        if (users == null || users.isEmpty()) {
            return List.of(); // Return empty if no users exist
        }

        return users.stream().map(user -> {
            String userId = String.valueOf(user.get("id"));
            List<Detailsmodel> userDetails = detailsList.stream()
                    .filter(detail -> userId.equals(detail.getUserId()))
                    .collect(Collectors.toList());

            user.put("details", userDetails); // Attach details to the user
            return user;
        }).collect(Collectors.toList());
    }
}

    
    
    

