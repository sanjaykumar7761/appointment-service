package com.appointmentservice.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Long id;

    private String name;
    private String specialization;
    private String email;

    // Constructors, getters, and setters
}

