package com.example.demo.repository

import org.springframework.stereotype.Repository
import com.example.demo.model.Staff

@Repository
class StaffRepository(val data: MutableMap<Long, Staff>) {

    private var lastId: Long = 0

    fun save(staff: Staff): Staff {
        staff.id = lastId
        data.put(lastId, staff)
        lastId = lastId + 1
        return staff
    }

    fun findAll(): List<Staff> = data.toList().map { it.second }
}