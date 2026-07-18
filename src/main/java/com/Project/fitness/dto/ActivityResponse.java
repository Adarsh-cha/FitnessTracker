package com.Project.fitness.dto;

import com.Project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityResponse {

    private String id;
    private ActivityType type;
    private Map<String, Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String userId;
}
