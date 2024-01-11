package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    StaffService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(int id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));
    }

    public Staff checkIn(int id) {
        Staff staff = getStaffById(id);
        if (staff != null) {
            staff.setActive(true);
            staff.setLastUpdate(LocalDateTime.now());
            staffRepository.save(staff);
            return staff;
        }
        else return null;
    }

    public Staff checkOut(int id) {
        Staff staff = getStaffById(id);
        if (staff != null) {
            staff.setActive(false);
            staff.setLastUpdate(LocalDateTime.now());
            staffRepository.save(staff);
            return staff;
        }
        else return null;
    }
}
