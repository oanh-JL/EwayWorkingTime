package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.Daily
import org.springframework.data.mongodb.repository.MongoRepository

import java.time.LocalDate

interface DailyRepository extends MongoRepository<Daily, String> {

    Daily findByFingerIdAndDate(String fingerId, LocalDate date)

}