package eway.intern.management_staff.models

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "dailies")
class Daily {

    @Id
    String id

    int fingerId

    LocalDate date

    LocalTime checkIn

    LocalTime checkOut

    LocalTime totalTime

    int status

    LocalDate createdAt

    LocalDate modifiedAt

    Daily(int fingerId, LocalDate date, LocalTime checkIn, LocalTime checkOut, LocalTime totalTime,
          int status, LocalDate createdAt, LocalDate modifiedAt) {
        this.fingerId = fingerId
        this.date = date
        this.checkIn = checkIn
        this.checkOut = checkOut
        this.totalTime = totalTime
        this.status = status
        this.createdAt = createdAt
        this.modifiedAt = modifiedAt
    }
}
