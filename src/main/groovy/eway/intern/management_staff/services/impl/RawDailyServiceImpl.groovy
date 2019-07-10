package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.repositories.RawDailyRepository
import eway.intern.management_staff.services.RawDailyService
import eway.intern.management_staff.services.mapper.RawDailyMapper
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class RawDailyServiceImpl implements RawDailyService {

    @Autowired
    RawDailyMapper mapper
    @Autowired
    RawDailyRepository repository

    @Override
    ResponseEntity<SystemResponse> create(RawDaily daily) {
        mapper.create(daily)
        repository.save(daily)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    List<Document> findAllByDate(String date) {
        return repository.findAllByDate(LocalDate.parse(date)) as List<Document>
    }

    @Override
    ResponseEntity<SystemResponse> update(RawDaily daily) {
        RawDaily rawDaily = repository.findById(daily.getId()).orElse(null)
        if (rawDaily) {
            mapper.update(daily)
            repository.save(daily)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }

    @Override
    ResponseEntity<SystemResponse> delete(String fingerId, String date) {
        RawDaily rawDaily = repository.findByFingerIdAndDate(fingerId, LocalDate.parse(date))
        if (rawDaily) {
            repository.delete(rawDaily)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
