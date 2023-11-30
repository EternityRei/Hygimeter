package com.example.hygimeter.controller;

import com.example.hygimeter.dto.PlanPatternDTO;
import com.example.hygimeter.dto.RemoteResponse;
import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.exception.StatusCodes;
import com.example.hygimeter.service.PlanPatternService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/plan-pattern")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Plan Pattern", description = "Plan pattern controller")
@Validated
public class PlanPatternController {

    private final PlanPatternService planPatternService;

    @PostMapping
    public ResponseEntity<RemoteResponse> createPlan(
            @Parameter(description = "Plan Pattern creation", required = true) @Validated(OnCreate.class)
            @RequestBody PlanPatternDTO planPatternDTO) {
        log.info("Plan pattern creation");

        PlanPatternDTO createdPlan = planPatternService.createPlanPattern(planPatternDTO);

        log.info("Plan Pattern was created successfully with id={}", planPatternDTO.getId());

        RemoteResponse successfulResponse = RemoteResponse.create(true, OK.name(),
                "Plan Pattern is successfully created", List.of(createdPlan));
        return ResponseEntity.status(HttpStatus.CREATED).body(successfulResponse);
    }

    @Operation(summary = "Update Plan Pattern")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan pattern updated successfully", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation Error", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    public ResponseEntity<RemoteResponse> updatePlanPattern(@PathVariable("id") String planPatternId, @Validated(OnUpdate.class) @RequestBody PlanPatternDTO planPatternDTO) {
        PlanPatternDTO result = planPatternService.updatePlanPattern(Integer.valueOf(planPatternId), planPatternDTO);
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(),
                "Plan pattern has been updated successfully", List.of(result));
        return ResponseEntity.ok()
                .body(remoteResponse);
    }
}
