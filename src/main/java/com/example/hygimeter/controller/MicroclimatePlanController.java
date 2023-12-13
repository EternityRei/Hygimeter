package com.example.hygimeter.controller;

import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.RemoteResponse;
import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.exception.StatusCodes;
import com.example.hygimeter.model.MicroclimatePlan;
import com.example.hygimeter.service.MicroclimatePlanService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/microclimat-plan")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Microclimate Plan", description = "Microclimate Plan controller")
@Validated
public class MicroclimatePlanController {

    private final MicroclimatePlanService microclimatePlanService;

    @PostMapping
    public ResponseEntity<RemoteResponse> createPlan(
            @Parameter(description = "Microclimate Plan creation", required = true) @Validated(OnCreate.class)
            @RequestBody MicroclimatePlanDTO microclimatePlanDTO) {
        log.info("Microclimate Plan creation");

        MicroclimatePlanDTO createdPlan = microclimatePlanService.createMicroclimatePlan(microclimatePlanDTO);

        log.info("Microclimate Plan was created successfully with id={}", microclimatePlanDTO.getId());

        RemoteResponse successfulResponse = RemoteResponse.create(true, OK.name(),
                "Microclimate Plan is successfully created", List.of(createdPlan));
        return ResponseEntity.status(HttpStatus.CREATED).body(successfulResponse);
    }

    @Operation(summary = "Update Microclimate Plan")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Microclimate Plan updated successfully", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation Error", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    public ResponseEntity<RemoteResponse> updateMicroclimatePlan(@PathVariable("id") String microclimatePlanId, @Validated(OnUpdate.class) @RequestBody MicroclimatePlanDTO microclimatePlanDTO) {
        MicroclimatePlanDTO result = microclimatePlanService.updateMicroclimatePlan(Integer.valueOf(microclimatePlanId), microclimatePlanDTO);
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(),
                "Microclimate Plan has been updated successfully", List.of(result));
        return ResponseEntity.ok()
                .body(remoteResponse);
    }

    @Operation(summary = "Delete specific microclimate plan given its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Microclimate Plan has been successfully deleted", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Microclimate Plan for a given id has not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<RemoteResponse> deleteMicroclimatePlan(@Parameter(description = "Microclimate Plan Identification", required = true)
                                                            @PathVariable("id") String id) {
        microclimatePlanService.deleteMicroclimatePlan(Integer.valueOf(id));
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(),
                String.format("Microclimate Plan with Id %s has been deleted", id), null);
        return ResponseEntity.ok().body(remoteResponse);
    }

    @Operation(summary = "Find specific microclimate plan given its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Microclimate Plan has been successfully found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Microclimate Plan for a given id has not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<RemoteResponse> getMicroclimetePlanById(@PathVariable("id") String id){
        log.info("Starting get microclimate plan with id={}", id);
        MicroclimatePlanDTO microclimatePlanDTO = microclimatePlanService.getMicroclimatePlanById(Integer.valueOf(id));
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(), "Microclimate Plan found", List.of(microclimatePlanDTO));
        return ResponseEntity.ok().body(remoteResponse);
    }

    @Operation(summary = "Find all microclimate plans")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Microclimate Plan have been successfully found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "404", description = "Microclimate Plan have not found", content = @Content(schema = @Schema(implementation = RemoteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Unexpected internal error", content = @Content(schema = @Schema(implementation = RemoteResponse.class)))
    })
    @GetMapping
    public ResponseEntity<RemoteResponse> getAllMicroclimatePlans(){
        log.info("Starting get all microclimate plans");
        List<MicroclimatePlanDTO> list = microclimatePlanService.findAllMicroclimatePlans();
        RemoteResponse remoteResponse = RemoteResponse.create(true, StatusCodes.OK.name(), "Microclimate Plans found", list);
        return ResponseEntity.ok().body(remoteResponse);
    }
}
