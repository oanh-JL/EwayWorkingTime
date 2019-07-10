package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.services.RawDailyService
import org.bson.Document
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
    @RequestMapping("/raw_daily")
class RawDailyController {

    @Autowired
    RawDailyService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody RawDaily rawDaily) {
        return service.create(rawDaily)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody RawDaily rawDaily) {
        return service.update(rawDaily)
    }

    @DeleteMapping("/{finger_id}/{date}")
    ResponseEntity<SystemResponse> delete(@PathVariable("finger_id") String fingerId,
    @PathVariable("date") String date) {
        return service.delete(fingerId,date)
    }
    @GetMapping("/{date}")
    List<Document> findAllByDate(@PathVariable("date") String date) {
        return  service.findAllByDate(date)
    }
}
