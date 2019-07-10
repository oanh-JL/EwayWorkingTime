package eway.intern.management_staff.repositories

import eway.intern.management_staff.models.RawDaily
import org.bson.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

import java.time.LocalDate

interface RawDailyRepository extends MongoRepository<RawDaily, String> {

    RawDaily findByFingerIdAndDate(String fingerId, LocalDate date)

    @Query(value = "{date:?0}", fields = "{id:0, created_at:0, modified_at:0, _class:0}")
    List<Document> findAllByDate(LocalDate date)
}