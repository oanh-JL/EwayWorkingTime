package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.Organization
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class OrganizationMapper {

    static void create(Organization organization) {
        organization.setCreatedAt(LocalDate.now())
        organization.setModifiedAt(null)
    }

    static void update(Organization organization) {
        organization.setModifiedAt(LocalDate.now())
    }
}
