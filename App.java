package com.hospital;

import java.util.ArrayList;
import java.util.List;

class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String getDetails() {
        return id + " - " + name + " (" + specialization + ")";
    }
}

class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
        return id + " - " + name + " (Age: " + age + ")";
    }
}

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public String getDetails() {
        return "Appointment on " + date + " with Dr. " + doctor.getDetails() +
               " for Patient: " + patient.getDetails();
    }
}

class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }
}

class PatientService {
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
}

class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}

public class App {
    public static void main(String[] args) {
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();

        // Sample doctor and patient
        Doctor doc1 = new Doctor(1, "Dr. Ravi", "Cardiology");
        Patient pat1 = new Patient(101, "Manisha", 22);

        // Add to services
        doctorService.addDoctor(doc1);
        patientService.addPatient(pat1);

        // Book appointment
        Appointment appt = new Appointment(doc1, pat1, "2025-08-01");
        appointmentService.bookAppointment(appt);

        // Show appointment
        for (Appointment a : appointmentService.getAllAppointments()) {
            System.out.println(a.getDetails());
        }
    }
}