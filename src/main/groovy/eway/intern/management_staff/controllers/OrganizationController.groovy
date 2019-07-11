package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.Organization
import eway.intern.management_staff.services.OrganizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/organization")
class OrganizationController {

    @Autowired
    OrganizationService service

    @GetMapping("/{manager_id}")
    Organization findByManagerId(@PathVariable("manager_id") String managerId) {
        return service.findByManagerId(managerId)
    }

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody Organization organization) {
        return service.create(organization)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody Organization organization) {
        return service.update(organization)
    }

    @DeleteMapping("/{organization_id}")
    ResponseEntity<SystemResponse> delete(@PathVariable("organization_id") String organizationId) {
        return service.delete(organizationId)
    }

    @PutMapping("/update_organization/{organization_id}")
    ResponseEntity<SystemResponse> updateOrganization(
            @PathVariable("organization_id") String organizationId,
            @RequestParam("manager_id") String managerId) {
        return service.updateOrganization(organizationId, managerId)
    }
}
