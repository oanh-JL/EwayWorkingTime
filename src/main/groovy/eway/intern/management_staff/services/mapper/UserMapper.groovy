package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.User
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class UserMapper {

    static void create(User user) {
        user.setCreatedAt(LocalDate.now())
        user.setModifiedAt(null)
    }

    static void update(User user) {
        user.setModifiedAt(LocalDate.now())
    }
}
