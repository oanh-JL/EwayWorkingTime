package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.Organization
import org.springframework.http.ResponseEntity

interface OrganizationService {

    Organization findByManagerId(String managerId)

    ResponseEntity<SystemResponse> create(Organization organization)

    ResponseEntity<SystemResponse> update(Organization organization)

    ResponseEntity<SystemResponse> delete(String organizationId)

    ResponseEntity<SystemResponse> updateOrganization(String organizationId, String managerId)


}