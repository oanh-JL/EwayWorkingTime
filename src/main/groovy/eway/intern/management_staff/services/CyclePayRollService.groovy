package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.CyclePayRoll
import org.springframework.http.ResponseEntity

interface CyclePayRollService {

    ResponseEntity<SystemResponse> create(CyclePayRoll cyclePayRoll)

    ResponseEntity<SystemResponse> update(CyclePayRoll cyclePayRoll)

    ResponseEntity<SystemResponse> delete(String id)

    List<CyclePayRoll> findAll()

}