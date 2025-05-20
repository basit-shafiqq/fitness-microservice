package com.fitness.activityService.service;

import com.fitness.activityService.ActivityRespository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRespository activityRespository;
    private final UserValidationService userValidationService;
    public ActivityResponse trackActivity(ActivityRequest request) {

        boolean isValidUser = userValidationService.validateUser(request.getUserId());
        if(!isValidUser) throw new RuntimeException("Invalid user");
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .caloriesBurned(request.getCaloriesBurned())
                .duration(request.getDuration())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
        Activity savedActivity = activityRespository.save(activity);

        return mapToActivityResponse(savedActivity);

    }

    private ActivityResponse mapToActivityResponse(Activity activity){
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(response.getStartTime());
        response.setUpdatedAt(response.getUpdatedAt());
        response.setCratedAt(response.getCratedAt());

        return response;
    }

    public List<ActivityResponse> getUserActivities(String userId) {
       List<Activity>activities =  activityRespository.findByUserId(userId);
       return activities.stream()
               .map(this::mapToActivityResponse)
               .collect(Collectors.toList());
    }

    public ActivityResponse getUserActivity(String activityId) {

        return activityRespository.findById(activityId)
                .map(this::mapToActivityResponse).orElseThrow(()->new RuntimeException("Activity not with id" +activityId+ "not found"));
    }
}
