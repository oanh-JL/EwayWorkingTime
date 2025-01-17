package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.RawDaily
import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.LocalTime

@Component
class RawDailyMapper {

    static void update(RawDaily rawDaily) {
        if(rawDaily.checkIn == null && rawDaily.checkOut == null) {
            rawDaily.setCheckIn(LocalTime.parse("00:00"))
            rawDaily.setCheckOut(LocalTime.parse("00:00"))
        }
        rawDaily.setDate(LocalDate.parse(rawDaily.getDate().toString()))
        rawDaily.setCheckIn(LocalTime.parse(rawDaily.getCheckIn().toString()))
        rawDaily.setCheckOut(LocalTime.parse(rawDaily.getCheckOut().toString()))
        rawDaily.setCreatedAt(LocalDate.parse(rawDaily.getCreatedAt().toString()))
    }

}
