package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.DayOff
import org.springframework.http.ResponseEntity

interface DayOffService {

    List<DayOff> findAll()

    ResponseEntity<SystemResponse> create(DayOff dayOff)

    DayOff findByDayOffId(int dayOffId)

    ResponseEntity<SystemResponse> update(DayOff dayOff)

    ResponseEntity<SystemResponse> delete(int dayOffId)
}