package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.Role
import org.springframework.data.mongodb.repository.MongoRepository

interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRoleId(String roleId)
}