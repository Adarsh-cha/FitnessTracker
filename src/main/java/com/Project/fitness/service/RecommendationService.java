package com.Project.fitness.service;


import com.Project.fitness.dto.RecommendationRequest;
import com.Project.fitness.dto.RecommendationResponse;
import com.Project.fitness.model.Activity;
import com.Project.fitness.model.Recommendation;
import com.Project.fitness.model.User;
import com.Project.fitness.repository.ActivityRepository;
import com.Project.fitness.repository.RecommendationRepository;
import com.Project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public RecommendationResponse generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Invalid user Id : " + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Invalid activity Id : " + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .safety(request.getSafety())
                .suggestions(request.getSuggestions())
                .improvements(request.getImprovements())
                .build();

        Recommendation savedrecommendation = recommendationRepository.save(recommendation);

        return mappedToResponse(savedrecommendation);
    }

    public List<RecommendationResponse> getRecommendationsByUserId(String userId) {
        return recommendationRepository.findByUserId(userId)
                .stream()
                .map(this::mappedToResponse)
                .toList();
    }

    public List<RecommendationResponse> getRecommendationsByActivityId(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .stream()
                .map(this::mappedToResponse)
                .toList();
    }

    private RecommendationResponse mappedToResponse(Recommendation savedrecommendation) {
        return RecommendationResponse.builder()
                .id(savedrecommendation.getId())
                .userId(savedrecommendation.getUser().getId())
                .activityId(savedrecommendation.getActivity().getId())
                .improvements(savedrecommendation.getImprovements())
                .suggestions(savedrecommendation.getSuggestions())
                .safety(savedrecommendation.getSafety())
                .build();
    }
}
