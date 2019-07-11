package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.repositories.RawDailyRepository
import eway.intern.management_staff.services.DailyService
import eway.intern.management_staff.services.RawDailyService
import eway.intern.management_staff.services.mapper.RawDailyMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class RawDailyServiceImpl implements RawDailyService {

    @Autowired
    RawDailyRepository repository
    @Autowired
    DailyService dailyService
    @Autowired
    RawDailyMapper mapper

    @Override
    ResponseEntity<SystemResponse> create(List<RawDaily> rawDailies) {

        rawDailies.forEach({

            raw ->
                RawDaily rawFound = repository.findByFingerIdAndDate(raw.fingerId, LocalDate.parse(raw.date.toString()))
                if (!rawFound) {
                    mapper.update(raw)
                    repository.save(raw)
                    dailyService.create(raw)
                } else {
                    mapper.update(raw)
                    raw.setId(rawFound.getId())
                    raw.setModifiedAt(LocalDate.now())
                    repository.save(raw)
                    dailyService.update(raw)
                }

        })
        return new ResponseEntity<>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    };
}
