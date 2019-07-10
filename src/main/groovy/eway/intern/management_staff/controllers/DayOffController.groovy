package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.DayOff
import eway.intern.management_staff.services.DayOffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dayOff")
class DayOffController {

    @Autowired
    DayOffService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody DayOff dayOff){
        return service.create(dayOff)
    }

    @GetMapping("/allDayOff")
    List<DayOff> getDayOff(){
        return service.findAll()
    }

    @GetMapping("/{day_off_id}")
    DayOff getDayOff(@PathVariable("day_off_id") int dayOffId){
        return service.findByDayOffId(dayOffId)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody DayOff dayOff) {
        return service.update(dayOff)
    }

    @DeleteMapping("/{day_off_id}")
    ResponseEntity<SystemResponse> delete(@PathVariable("day_off_id") int dayOffId) {
        return service.delete(dayOffId)
    }
}
