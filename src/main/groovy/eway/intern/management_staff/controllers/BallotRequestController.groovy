package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.BallotRequest
import eway.intern.management_staff.services.BallotRequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ballot_request")
class BallotRequestController {

    @Autowired
    BallotRequestService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody BallotRequest ballotRequest) {
        return service.create(ballotRequest)
    }

    @GetMapping("/{user_id}")
    List<BallotRequest> getAll(@PathVariable("user_id") String userId) {
        return service.getAll(userId)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody BallotRequest ballotRequest) {
        return service.update(ballotRequest)
    }
}
