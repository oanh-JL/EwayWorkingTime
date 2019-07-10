package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.Daily
import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.LocalTime

@Component
class DailyMapper {

    static void create(Daily daily) {

        LocalTime checkIn = LocalTime.parse(daily.getCheckIn().toString())
        LocalTime checkOut = LocalTime.parse(daily.getCheckOut().toString())

        daily.setDate(LocalDate.parse(daily.getDate().toString()))
        daily.setCheckIn(checkIn)
        daily.setCheckOut(checkOut)
        daily.setCreatedAt(LocalDate.now())
        daily.setModifiedAt(null)

    }

    static void update(Daily daily) {
        daily.setDate(LocalDate.parse(daily.getDate().toString()))
        daily.setCheckIn(LocalTime.parse(daily.getCheckIn().toString()))
        daily.setCheckOut(LocalTime.parse(daily.getCheckOut().toString()))
        daily.setModifiedAt(LocalDate.now())
    }
}
