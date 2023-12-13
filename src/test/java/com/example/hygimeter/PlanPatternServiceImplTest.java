//package com.example.hygimeter;
//
//import com.example.hygimeter.dto.PlanPatternDTO;
//import com.example.hygimeter.repository.PlanPatternRepository;
//import com.example.hygimeter.service.PlanPatternServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class PlanPatternServiceImplTest {
//
//    @Mock
//    private PlanPatternRepository planPatternRepository;
//
//    @Mock
//    private PlanPatternMapper planPatternMapper;
//
//    @InjectMocks
//    private PlanPatternServiceImpl planPatternService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createPlanPatternTest() {
//        // Given
//        PlanPatternDTO planPatternDTO = new PlanPatternDTO(); // Add necessary properties
//        PlanPattern planPattern = new PlanPattern(); // Add necessary properties
//        when(planPatternMapper.toPlanPattern(planPatternDTO)).thenReturn(planPattern);
//        when(planPatternRepository.save(planPattern)).thenReturn(planPattern);
//        when(planPatternMapper.toPlanPatternDTO(planPattern)).thenReturn(planPatternDTO);
//
//        // When
//        PlanPatternDTO result = planPatternService.createPlanPattern(planPatternDTO);
//
//        // Then
//        assertEquals(planPatternDTO, result);
//        verify(planPatternMapper).toPlanPattern(planPatternDTO);
//        verify(planPatternRepository).save(planPattern);
//        verify(planPatternMapper).toPlanPatternDTO(planPattern);
//    }
//}
