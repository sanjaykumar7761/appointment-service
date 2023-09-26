package com.appointmentservice.api.service;

import com.appointmentservice.api.entity.Appointment;
import com.appointmentservice.api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public  Appointment saveAppointment(Appointment apppointment){
        return appointmentRepository.save(apppointment);
    }

    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepository.findById(id).orElse(null);
    }
}

