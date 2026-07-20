package com.Project.fitness.service;

import com.Project.fitness.dto.ActivityRequest;
import com.Project.fitness.dto.ActivityResponse;
import com.Project.fitness.model.Activity;
import com.Project.fitness.model.User;
import com.Project.fitness.repository.ActivityRepository;
import com.Project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        User user = userRepository.findById(activityRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("Invalid Id : " + activityRequest.getUserId()));

        Activity activity = Activity.builder()
                .type(activityRequest.getType())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .user(user)
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return mappedToActivityResponse(savedActivity);
    }

    private ActivityResponse mappedToActivityResponse(Activity savedActivity) {
        return ActivityResponse.builder()
                .id(savedActivity.getId())
                .userId(savedActivity.getUser().getId())
                .type(savedActivity.getType())
                .duration(savedActivity.getDuration())
                .caloriesBurned(savedActivity.getCaloriesBurned())
                .startTime(savedActivity.getStartTime())
                .createdAt(savedActivity.getCreatedAt())
                .updateAt(savedActivity.getUpdateAt())
                .additionalMetrics(savedActivity.getAdditionalMetrics())
                .build();
    }

    public List<ActivityResponse> retrieveActivity(String userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);

        return activityList.stream()
                .map(this::mappedToActivityResponse)
                .collect(Collectors.toList());
    }

}
