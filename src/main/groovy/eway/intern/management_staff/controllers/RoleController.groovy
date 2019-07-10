package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.Role
import eway.intern.management_staff.services.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/role")
class RoleController {

    @Autowired
    RoleService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody Role role) {
        return service.create(role)
    }

    @GetMapping("{/role_id}")
    Role getRole(@PathVariable("/role_id") String roleId) {
        return service.findByRoleId(roleId)
    }
}
