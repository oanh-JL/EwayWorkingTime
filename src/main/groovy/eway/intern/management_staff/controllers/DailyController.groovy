package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.Daily
import eway.intern.management_staff.services.DailyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/daily")
class DailyController {

    @Autowired
    DailyService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody Daily daily) {
        return service.create(daily)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody Daily daily) {
        return service.update(daily)
    }

    @DeleteMapping("/{finger_id}/{date}")
    ResponseEntity<SystemResponse> delete(@PathVariable("finger_id") String fingerId,
                                          @PathVariable("date") String date) {
        return service.delete(fingerId, date)
    }
}
