package eway.intern.management_staff.controllers


import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.User
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
