package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.Organization
import org.springframework.data.mongodb.repository.MongoRepository

interface OrganizationRepository extends MongoRepository<Organization, String> {

    Organization findByManagerId(String managerId)

    Organization findByOrganizationId(String organizationId)

}