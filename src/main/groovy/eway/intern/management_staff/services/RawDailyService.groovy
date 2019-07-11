package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.RawDaily
import org.springframework.http.ResponseEntity

interface RawDailyService {

    ResponseEntity<SystemResponse> create(List<RawDaily> rawDailies)
}