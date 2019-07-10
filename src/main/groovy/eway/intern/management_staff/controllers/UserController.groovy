package eway.intern.management_staff.controllers

import eway.intern.management_staff.controllers.viewmodel.PageResponse
import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.User
import eway.intern.management_staff.repositories.UserRepository
import eway.intern.management_staff.services.UserService
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
@RequestMapping("/user")
class UserController {

    @Autowired
    UserService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody User user) {
        return service.create(user)
    }

    @GetMapping
    PageResponse<User> findAllPagingUser(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam('sort_by') String sortBy,
            @RequestParam('sort_direction') String sortDirection) {
        return service.findAllPagingUser(page, size, sortBy, sortDirection)
    }

    @GetMapping("/{user_id}")
    User getUser(@PathVariable("user_id") String userId) {
        return service.findByUserId(userId)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(@RequestBody User user) {
        return service.update(user)
    }

    @DeleteMapping("/{user_id}")
    ResponseEntity<SystemResponse> delete(@PathVariable("user_id") String userId) {
        return service.delete(userId)
    }
}
