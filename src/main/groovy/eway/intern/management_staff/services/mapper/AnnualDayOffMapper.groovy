package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.AnnualDayOff
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class AnnualDayOffMapper {

    static void create(AnnualDayOff dayOff) {
        dayOff.setStartDayOff(LocalDate.parse(dayOff.getStartDayOff().toString()))
        dayOff.setEndDayOff(LocalDate.parse(dayOff.getEndDayOff().toString()))
        dayOff.setCreatedAt(LocalDate.now())
        dayOff.setModifiedAt(null)
    }

    static void update(AnnualDayOff dayOff) {
        dayOff.setStartDayOff(LocalDate.parse(dayOff.getStartDayOff().toString()))
        dayOff.setEndDayOff(LocalDate.parse(dayOff.getEndDayOff().toString()))
        dayOff.setModifiedAt(LocalDate.now())
    }
}
