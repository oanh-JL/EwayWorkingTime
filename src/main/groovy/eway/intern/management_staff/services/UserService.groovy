package eway.intern.management_staff.services


import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.User
import org.springframework.http.ResponseEntity

interface UserService {

    ResponseEntity<SystemResponse> create(User user)

    User findByUserId(String userId)

    ResponseEntity<SystemResponse> update(User user)

    ResponseEntity<SystemResponse> delete(String userId)
}
