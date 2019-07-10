package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.DayOff
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class DayOffMapper {

    static void create(DayOff dayOff){
        dayOff.setCreatedAt(LocalDate.now())
        dayOff.setModifiedAt(null)
    }

    static void update(DayOff dayOff){
        dayOff.setModifiedAt(LocalDate.now())
    }
}
