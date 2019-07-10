package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.BallotRequest
import eway.intern.management_staff.models.Daily
import org.bson.Document
import org.springframework.http.ResponseEntity

interface DailyService {

    ResponseEntity<SystemResponse> create(Daily daily)

    ResponseEntity<SystemResponse> update(Daily daily)

    Daily findByFingerIdAndDate(String fingerId, String date)

    ResponseEntity<SystemResponse> delete(String fingerId, String date)

    ResponseEntity<SystemResponse> confirm(BallotRequest ballotRequest)

}