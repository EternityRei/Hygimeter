package com.example.hygimeter.controller;

import com.example.hygimeter.controller.types.FileContent;
import com.example.hygimeter.controller.types.FileScore;
import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.RemoteResponse;
import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.exception.StatusCodes;
import com.example.hygimeter.exception.UnauthorizedPlanCreationException;
import com.example.hygimeter.model.Role;
import com.example.hygimeter.service.MicroclimatePlanService;
import com.example.hygimeter.service.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class RemoteResponse {
//    private boolean succeeded;
//    private String statusCode;
//    private String statusMessage;
//    private List results;
//
//    public static com.example.hygimeter.dto.RemoteResponse create(boolean succeeded, String statusCode, String statusMessage, List additionalElements) {
//        com.example.hygimeter.dto.RemoteResponse response = new com.example.hygimeter.dto.RemoteResponse();
//        response.setSucceeded(succeeded);
//        response.setStatusCode(statusCode);
//        response.setStatusMessage(statusMessage);
//        response.setResults(additionalElements);
//
//        return response;
//    }
//
//}

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Topics", description = "Topics controller")
@Validated
public class TopicController {
    @PostMapping("/top")
    public ResponseEntity<RemoteResponse> getTopTopics() {
        String url = "http://localhost:3001/top-files";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(null); // Replace 'null' with your request body if needed

        // Assuming each array element is the type that 'results' should hold
        FileScore[] responseArray = restTemplate.postForObject(url, entity, FileScore[].class);

        RemoteResponse response = RemoteResponse.create(
                true, // or determine based on responseArray contents
                "200", // same as above
                "OK", // same as above
                Arrays.asList(responseArray)
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Get Topic")
    @GetMapping("/{id}")
    public ResponseEntity<RemoteResponse> getTopic(@PathVariable("id") String topicId) {
        // we make our own post request to localhost:3001/top-files here to get the top topics
        String url = "http://localhost:3001/file";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("id", topicId);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(requestBody, null); // Replace 'null' with your request body if needed

        // Assuming each array element is the type that 'results' should hold
        FileContent responseArray = restTemplate.postForObject(url, entity, FileContent.class);

        RemoteResponse response = RemoteResponse.create(
                true, // or determine based on responseArray contents
                "200", // same as above
                "OK", // same as above
                Arrays.asList(responseArray)
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
