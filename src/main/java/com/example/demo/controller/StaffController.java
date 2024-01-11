package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> products = staffService.getAllStaff();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Staff> getStaff(@PathVariable int staffId) {
        Staff staff = staffService.getStaffById(staffId);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/checkin/{staffId}")
    public ResponseEntity<Staff> checkIn(@PathVariable int staffId) {
        Staff staff = staffService.checkIn(staffId);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/checkout/{staffId}")
    public ResponseEntity<Staff> checkout(@PathVariable int staffId) {
        Staff staff = staffService.checkOut(staffId);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
