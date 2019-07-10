package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.RawDaily
import org.springframework.data.mongodb.repository.MongoRepository

import java.time.LocalDate

interface RawDailyRepository extends MongoRepository<RawDaily, String> {

    List<RawDaily> findAllByDate(LocalDate date)
}