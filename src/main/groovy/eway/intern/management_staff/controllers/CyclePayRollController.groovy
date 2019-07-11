package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.CyclePayRoll
import eway.intern.management_staff.services.CyclePayRollService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cycle_pay_roll")
class CyclePayRollController {

    @Autowired
    CyclePayRollService service

    @PostMapping
    ResponseEntity<SystemResponse> create(CyclePayRoll cycle) {
        return service.create(cycle)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(CyclePayRoll cycle) {
        return service.update(cycle)
    }

    @DeleteMapping("/{id}")
    ResponseEntity<SystemResponse> delete(@PathVariable("id") String id) {
        return service.delete(id)
    }

    @GetMapping
    List<CyclePayRoll> getAll() {
        return service.findAll()
    }


}
