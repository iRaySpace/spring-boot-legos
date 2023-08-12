package com.example.demo.service

import org.springframework.stereotype.Service
import com.example.demo.model.Staff
import com.example.demo.repository.StaffRepository


@Service
class StaffService(val staffRepository: StaffRepository) {
    fun getStaffs(): List<Staff> = staffRepository.findAll()
    fun createStaff(staff: Staff): Staff = staffRepository.save(staff)
}
