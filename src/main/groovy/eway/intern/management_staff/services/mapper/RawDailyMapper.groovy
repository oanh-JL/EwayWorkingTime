package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.RawDaily
import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.LocalTime

@Component
class RawDailyMapper {

    static void create(RawDaily rawDaily) {
        rawDaily.setDate(LocalDate.parse(rawDaily.getDate().toString()))
        rawDaily.setCheckIn(LocalTime.parse(rawDaily.getCheckIn().toString()))
        rawDaily.setCheckOut(LocalTime.parse(rawDaily.getCheckOut().toString()))
        rawDaily.setCreatedAt(LocalDate.now())
        rawDaily.setModifiedAt(null)
    }

    static void update(RawDaily rawDaily) {
        rawDaily.setDate(LocalDate.parse(rawDaily.getDate().toString()))
        rawDaily.setCheckIn(LocalTime.parse(rawDaily.getCheckIn().toString()))
        rawDaily.setCheckOut(LocalTime.parse(rawDaily.getCheckOut().toString()))
        rawDaily.setModifiedAt(LocalDate.now())
    }
}
