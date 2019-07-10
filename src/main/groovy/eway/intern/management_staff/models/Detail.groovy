package eway.intern.management_staff.models

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "details")
class Detail {

    @Id
    String id

    String userId

    LocalDate dayFrom

    LocalDate dayTo

    float totalTime

    float totalDay

    int totalDayOff

    int totalForgetCheck

    List<Daily> dailies

    LocalDate createdAt

    LocalDate modifiedAt
}
