package eway.intern.management_staff.services.impl

import eway.intern.management_staff.models.Daily
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.repositories.DailyRepository
import eway.intern.management_staff.services.DailyService
import eway.intern.management_staff.services.mapper.DailyMapper
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

import java.time.LocalDate
import java.time.LocalTime

@Service
class DailyServiceImpl implements DailyService {

    @Autowired
    DailyMapper mapper
    @Autowired
    DailyRepository repository

    @Override
    void create(RawDaily raw) {
        Daily daily = parseDaily(raw)
        Daily dailyFound = repository.findByFingerIdAndDate(daily.fingerId, daily.date)
        if (!dailyFound) {
            mapper.create(daily)
            daily.setCreatedAt(LocalDate.now())
            daily.setModifiedAt(null)
            repository.save(daily)
        }
    }

    @Override
    void update(RawDaily raw) {
        Daily daily = parseDaily(raw)
        Daily dailyFound = repository.findByFingerIdAndDate(daily.fingerId, daily.date)
        if (dailyFound) {
            daily.setId(dailyFound.getId())
            daily.setStatus(dailyFound.status)
            daily.setTotalTime(dailyFound.totalTime)
            mapper.create(daily)
            repository.save(daily)
        }
    }

    static Daily parseDaily(RawDaily raw) {
        int status = 1
        String totalTime = "00:00"
        LocalTime nullTime = LocalTime.parse("00:00")
        String day = LocalDate.parse(raw.date.toString()).dayOfWeek
        if (raw.checkIn == nullTime && raw.checkOut == nullTime) {
            status = 0
        }
        if (day.equals("SATURDAY") || day.equals("SUNDAY")) {
            status = 0
        }
        return new Daily(raw.fingerId,
                raw.date,
                raw.checkIn,
                raw.checkOut,
                LocalTime.parse(totalTime),
                status,
                raw.createdAt,
                raw.modifiedAt)
    }
}
