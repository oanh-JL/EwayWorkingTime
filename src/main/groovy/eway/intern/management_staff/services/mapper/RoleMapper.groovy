package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.Role
import eway.intern.management_staff.models.User
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class RoleMapper {
    static void create(Role role) {
        role.setCreatedAt(LocalDate.now())
        role.setModifiedAt(null)
    }

    static void update(Role role) {
        role.setModifiedAt(LocalDate.now())
    }
}
