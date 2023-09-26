package com.appointmentservice.api.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDateTime;
    private String reason;

    // Constructors, getters, and setters
}
