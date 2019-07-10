package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.AnnualDayOff
import org.springframework.data.mongodb.repository.MongoRepository

interface AnnualDayOffRepository extends MongoRepository<AnnualDayOff, String> {

    List<AnnualDayOff> findByAnnualDayOffId(String annualDayOffId)
}
