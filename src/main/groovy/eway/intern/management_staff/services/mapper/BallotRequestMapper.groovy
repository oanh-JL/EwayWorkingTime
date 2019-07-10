package eway.intern.management_staff.services.mapper

import eway.intern.management_staff.models.BallotRequest
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class BallotRequestMapper {

    static void create(BallotRequest ballotRequest) {
        ballotRequest.setCreatedAt(LocalDate.now())
        ballotRequest.setModifiedAt(null)
    }

    static void update(BallotRequest ballotRequest) {
        ballotRequest.setModifiedAt(LocalDate.now())
    }
}
