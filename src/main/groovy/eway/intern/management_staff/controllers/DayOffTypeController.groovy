package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.DayOffType
import eway.intern.management_staff.services.DayOffTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/day_off_type")
class DayOffTypeController {

    @Autowired
    DayOffTypeService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody DayOffType dayOffType) {
        return service.create(dayOffType)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody DayOffType dayOffType) {
        return service.update(dayOffType)
    }

    @GetMapping("/{day_off__id}")
    DayOffType getDayOffType(@PathVariable("day_off__id") int dayOffTypeId) {
        return service.findByDayOffTypeId(dayOffTypeId)
    }

    @DeleteMapping("/{day_off__id}")
    ResponseEntity<SystemResponse> delete(@PathVariable("day_off__id") int dayOffTypeId) {
        return service.delete(dayOffTypeId)
    }
}
