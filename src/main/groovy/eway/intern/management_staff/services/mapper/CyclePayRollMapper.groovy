package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.CyclePayRoll
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class CyclePayRollMapper {

    static void  create(CyclePayRoll cycle) {
        cycle.setDateTo(LocalDate.parse(cycle.getDateTo().toString()))
        cycle.setDateFrom(LocalDate.parse(cycle.getDateFrom().toString()))
        cycle.setCreatedAt(LocalDate.now())
        cycle.setModifiedAt(null)
    }

    static void update(CyclePayRoll cycle) {
        cycle.setDateTo(LocalDate.parse(cycle.getDateTo().toString()))
        cycle.setDateFrom(LocalDate.parse(cycle.getDateFrom().toString()))
        cycle.setModifiedAt(LocalDate.now())
    }
}
