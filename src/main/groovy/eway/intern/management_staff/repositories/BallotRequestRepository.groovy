package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.BallotRequest
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface BallotRequestRepository extends MongoRepository<BallotRequest, String> {

    @Query("{user_id:0}")
    List<BallotRequest> getAll(String userId)
}
