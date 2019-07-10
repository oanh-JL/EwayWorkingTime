package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.Organization
import eway.intern.management_staff.repositories.OrganizationRepository
import eway.intern.management_staff.services.OrganizationService
import eway.intern.management_staff.services.mapper.OrganizationMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository repository
    @Autowired
    OrganizationMapper mapper

    @Override
    Organization findByManagerId(String managerId) {
        return repository.findByManagerId(managerId)
    }

    @Override
    ResponseEntity<SystemResponse> create(Organization organization) {
        mapper.create(organization)
        repository.save(organization)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(Organization organization) {
        Organization organizationFound = repository.findById(organization.getId()).orElse(null)
        if (organizationFound) {
            mapper.update(organization)
            repository.save(organization)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String organizationId) {
        Organization organizationDelete = repository.findByOrganizationId(organizationId)
        if (organizationDelete) {
            repository.delete(organizationDelete)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> updateOrganization(String organizationId, String managerId) {
        Organization organizationFound = repository.findByOrganizationId(organizationId)
        if (organizationFound) {
            mapper.update(organizationFound)
            organizationFound.setManagerId(managerId)
            repository.save(organizationFound)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)

        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
