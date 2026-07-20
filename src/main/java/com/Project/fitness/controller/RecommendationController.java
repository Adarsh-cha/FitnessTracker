package com.Project.fitness.controller;

import com.Project.fitness.dto.RecommendationRequest;
import com.Project.fitness.dto.RecommendationResponse;
import com.Project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
        return ResponseEntity.ok(recommendationService.generateRecommendation(recommendationRequest));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendationsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(recommendationService.getRecommendationsByUserId(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendationsByActivityId(@PathVariable String activityId) {
        return ResponseEntity.ok(recommendationService.getRecommendationsByActivityId(activityId));
    }
}
