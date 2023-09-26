package com.appointmentservice.api.controller;

import com.appointmentservice.api.entity.Appointment;
import com.appointmentservice.api.payload.Doctor;
import com.appointmentservice.api.payload.Patient;
import com.appointmentservice.api.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;

    }



    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {

        ResponseEntity<Patient> patientResponse=restTemplate.getForEntity("http://localhost:8080/patients/"
        + appointment.getPatientId(), Patient.class);

        if(patientResponse.getStatusCode()!=HttpStatus.OK || patientResponse.getBody() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Patient patient=patientResponse.getBody();

        ResponseEntity<Doctor> doctorResponse= restTemplate.getForEntity("http://localhost:8081/doctors/"
         + appointment.getDoctorId(), Doctor.class);


        //Additional logic here(e.g. handling doctorResponse)

        Appointment appointment1=appointmentService.saveAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment1);

    }


}

