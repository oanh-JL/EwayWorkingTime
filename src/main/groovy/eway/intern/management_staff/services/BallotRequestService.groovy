package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.BallotRequest
import org.springframework.http.ResponseEntity

interface BallotRequestService {

    ResponseEntity<SystemResponse> create(BallotRequest ballotRequest)

    ResponseEntity<SystemResponse> update(BallotRequest ballotRequest)

    List<BallotRequest> getAll(String userId)

    ResponseEntity<SystemResponse> delete(String id)

}