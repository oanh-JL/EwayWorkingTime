package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.RawDaily
import org.bson.Document
import org.springframework.http.ResponseEntity

interface RawDailyService {

    ResponseEntity<SystemResponse> create(RawDaily daily)

    List<Document> findAllByDate(String date)

    ResponseEntity<SystemResponse> update(RawDaily daily)

    ResponseEntity<SystemResponse> delete(String fingerId, String date)

}