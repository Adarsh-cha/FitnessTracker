package com.Project.fitness.controller;

import com.Project.fitness.dto.ActivityRequest;
import com.Project.fitness.dto.ActivityResponse;
import com.Project.fitness.model.Activity;
import com.Project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping()
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest) {
        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }

//    @GetMapping()
//    public ResponseEntity<ActivityResponse> retriveActivity(Activity activity) {
//    }
}
