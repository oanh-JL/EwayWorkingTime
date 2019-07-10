package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.RawDaily
import eway.intern.management_staff.repositories.RawDailyRepository
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
    RawDailyMapper mapper
    @Autowired
    RawDailyRepository repository

    @Override
    ResponseEntity<SystemResponse> create(List<RawDaily> dailies) {

        dailies.forEach({
            raw ->
                mapper.create(raw)
                repository.save(raw)
        })
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }
}
