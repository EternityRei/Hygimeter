package com.example.hygimeter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "microclimate_plan")
public class MicroclimatePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "initially_microclimate_id")
    private Microclimate goalMicroclimate;

    @OneToOne
    @JoinColumn(name = "goal_microclimate_id")
    private Microclimate goalMicroclimate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String device;
}
