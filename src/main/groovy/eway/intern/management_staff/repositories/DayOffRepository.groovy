package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.DayOff
import org.springframework.data.mongodb.repository.MongoRepository

interface DayOffRepository extends MongoRepository<DayOff, String> {

    DayOff findByDayOffId(int dayOffId)

}