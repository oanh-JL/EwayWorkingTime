package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.BallotRequest
import eway.intern.management_staff.models.Daily
import eway.intern.management_staff.repositories.DailyRepository
import eway.intern.management_staff.services.DailyService
import eway.intern.management_staff.services.mapper.DailyMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class DailyServiceImpl implements DailyService {

    @Autowired
    DailyMapper mapper
    @Autowired
    DailyRepository repository

    @Override
    ResponseEntity<SystemResponse> create(Daily daily) {
        mapper.create(daily)
        repository.save(daily)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(Daily daily) {
        Daily dailyFound = repository.findById(daily.getId()).orElse(null)
        if (dailyFound) {
            mapper.update(daily)
            repository.save(daily)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    Daily findByFingerIdAndDate(String fingerId, String date) {
        return repository.findByFingerIdAndDate(fingerId, LocalDate.parse(date))
    }

    @Override
    ResponseEntity<SystemResponse> delete(String fingerId, String date) {
        Daily dailyFound = repository.findByFingerIdAndDate(fingerId, LocalDate.parse(date))
        if (dailyFound) {
            repository.delete(dailyFound)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> confirm(BallotRequest ballotRequest) {
        return null
    }

}
