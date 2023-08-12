package com.example.demo.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import jakarta.validation.Valid

import com.example.demo.model.Staff
import com.example.demo.service.StaffService


@CrossOrigin
@RestController
@RequestMapping("/staff")
class StaffController(val staffService: StaffService) {

    @GetMapping
    fun get(): List<Staff> = staffService.getStaffs()

    @PostMapping
    fun create(@Valid @RequestBody staff: Staff): Staff = staffService.createStaff(staff)
}