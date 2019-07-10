package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.Role
import eway.intern.management_staff.repositories.RoleRepository
import eway.intern.management_staff.services.RoleService
import eway.intern.management_staff.services.mapper.RoleMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository
    @Autowired
    RoleMapper mapper

    @Override
    ResponseEntity<SystemResponse> create(Role role) {
        mapper.create(role)
        repository.save(role)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    Role findByRoleId(String roleId) {
        return repository.findByRoleId(roleId)
    }

    @Override
    ResponseEntity<SystemResponse> update(Role role) {
        Role roleFound = repository.findById(role.getId()).orElse(null)
        if (roleFound) {
            mapper.update(role)
            repository.save(role)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String roleId) {
        Role roleDelete = repository.findByRoleId(roleId)
        if (roleDelete) {
            repository.delete(roleDelete)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
