package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.DayOffType
import org.springframework.data.mongodb.repository.MongoRepository

interface DayOffTypeRepository extends MongoRepository<DayOffType, String> {

    DayOffType findByDayOffTypeId(int dayOffTypeId)
}