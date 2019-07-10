package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.CyclePayRoll
import org.springframework.data.mongodb.repository.MongoRepository

interface CyclePayRoleRepository extends MongoRepository<CyclePayRoll, String> {

}