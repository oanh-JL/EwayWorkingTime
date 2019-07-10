package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.services.RawDailyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/raw_daily")
class RawDailyController {

    @Autowired
    RawDailyService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody List<RawDaily> rawDailies) {
        return service.create(rawDailies)
    }

}
