package com.fitness.activityService.dto;
import com.fitness.activityService.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponse {

        private String id;
        private String userId;
        private ActivityType type;
        private Integer duration;
        private Integer caloriesBurned;
        private LocalDateTime startTime;
        private Map<String,Object> additionalMetrics;
        private LocalDateTime cratedAt;
        private LocalDateTime updatedAt;

}
