package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String userId)
}
