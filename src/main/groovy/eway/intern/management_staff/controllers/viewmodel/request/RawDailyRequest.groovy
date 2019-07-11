package eway.intern.management_staff.controllers.viewmodel.request

import java.time.LocalDate
import java.time.LocalTime

class RawDailyRequest {

    String id

    int fingerId

    String userName

    LocalDate date

    LocalTime checkIn

    LocalTime checkOut

    LocalDate createdAt
}
