package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepository extends MongoRepository<User, String> {

    @Query("?0")
    Page<User> findAllPagingUser(Pageable pageable)

    User findByUserId(String userId)
}
