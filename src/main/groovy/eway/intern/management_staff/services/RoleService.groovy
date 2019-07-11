package eway.intern.management_staff.services

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.Role
import org.springframework.http.ResponseEntity

interface RoleService {

    ResponseEntity<SystemResponse> create(Role role)

    Role findByRoleId(String roleId)


    ResponseEntity<SystemResponse> update(Role role)

    ResponseEntity<SystemResponse> delete(String roleId)
}
