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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Operation(summary = "Delete specific plan pattern given its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan Pattern has been successfully deleted", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Plan Pattern for a given id has not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{patternId}")
    public ResponseEntity<RemoteResponse> deletePlanPattern(@Parameter(description = "Plan Pattern Identification", required = true)
                                                            @PathVariable("patternId") String id) {
        planPatternService.deletePlanPattern(Integer.valueOf(id));
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(),
                String.format("Plan Pattern with Id %s has been deleted", id), null);
        return ResponseEntity.ok().body(remoteResponse);
    }

    @Operation(summary = "Find specific plan pattern given its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan Pattern has been successfully found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Plan Pattern for a given id has not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @GetMapping("/{patternId}")
    public ResponseEntity<RemoteResponse> getPlanPatternById(@PathVariable("patternId") String id){
        log.info("Starting get plan pattern with id={}", id);
        PlanPatternDTO planPatternDTO = planPatternService.getPlanPatternById(Integer.valueOf(id));
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(), "Plan Pattern found", List.of(planPatternDTO));
        return ResponseEntity.ok().body(remoteResponse);
    }

    @Operation(summary = "Find all plan patterns")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan Patterns have been successfully found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Plan Patterns have not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @GetMapping
    public ResponseEntity<RemoteResponse> getAllPlanPatterns(){
        log.info("Starting get all plan patterns");
        List<PlanPatternDTO> list = planPatternService.getAllPlanPatterns();
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(), "Plan Patterns found", list);
        return ResponseEntity.ok().body(remoteResponse);
    }


}
