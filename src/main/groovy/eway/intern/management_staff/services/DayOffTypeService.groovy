package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.DayOffType
import org.springframework.http.ResponseEntity

interface DayOffTypeService {

    ResponseEntity<SystemResponse> create(DayOffType dayOff)

    ResponseEntity<SystemResponse> update(DayOffType dayOff)

    DayOffType findByDayOffTypeId(int dayOffTypeId)

    ResponseEntity<SystemResponse> delete(int daOffTypeId)

}