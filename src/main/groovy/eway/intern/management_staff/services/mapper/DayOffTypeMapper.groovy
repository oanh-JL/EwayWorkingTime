package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.DayOffType
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class DayOffTypeMapper {

    static void create(DayOffType dayOffType) {
        dayOffType.setCreatedAt(LocalDate.now())
        dayOffType.setModifiedAt(null)
    }

    static void update(DayOffType dayOffType) {
        dayOffType.setModifiedAt(LocalDate.now())
    }
}
