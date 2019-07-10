package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.AnnualDayOff
import eway.intern.management_staff.models.Organization
import org.bson.Document
import org.springframework.http.ResponseEntity

interface AnnualDayOffService {

    ResponseEntity<SystemResponse> create(AnnualDayOff dayOff)

    ResponseEntity<SystemResponse> update(AnnualDayOff dayOff)

    List<AnnualDayOff> findByDate(String date)

    List<Document> showOrganizationDayOff(String annualDayOffId)

    ResponseEntity<SystemResponse> delete(String annualDayOffId)
}
