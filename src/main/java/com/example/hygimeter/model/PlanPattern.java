package com.example.hygimeter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PlanPattern")
public class PlanPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "optimalmicroclimate_id", referencedColumnName = "id")
    private Microclimate microclimate;

    @OneToMany(mappedBy = "planPattern")
    private List<MicroclimatePlan> microclimatePlans;

    @Column
    private String device;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planParameters_id", referencedColumnName = "id")
    private PlanParameters planParameters;
}
