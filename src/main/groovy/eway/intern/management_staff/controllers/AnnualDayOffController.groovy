package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.AnnualDayOff
import eway.intern.management_staff.services.AnnualDayOffService
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.print.Doc

@RestController
@RequestMapping("/annual_day_off")
class AnnualDayOffController {

    @Autowired
    AnnualDayOffService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody AnnualDayOff dayOff) {
        return service.create(dayOff)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody AnnualDayOff dayOff) {
        return service.update(dayOff)
    }

    @GetMapping("/{annual_day_off_id}")
    List<Document> showOrganizationDayOff(@PathVariable("annual_day_off_id") String annualDayOffId) {
        return service.showOrganizationDayOff(annualDayOffId)
    }

    @GetMapping("/one/{date}")
    List<AnnualDayOff> getDate(@PathVariable("date") String date) {
        return service.findByDate(date)
    }
}
