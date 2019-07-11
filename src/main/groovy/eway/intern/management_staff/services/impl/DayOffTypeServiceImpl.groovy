package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.DayOffType
import eway.intern.management_staff.repositories.DayOffTypeRepository
import eway.intern.management_staff.services.DayOffTypeService
import eway.intern.management_staff.services.mapper.DayOffTypeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DayOffTypeServiceImpl implements DayOffTypeService {

    @Autowired
    DayOffTypeMapper mapper
    @Autowired
    DayOffTypeRepository repository

    @Override
    ResponseEntity<SystemResponse> create(DayOffType dayOff) {

        mapper.create(dayOff)
        repository.save(dayOff)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(DayOffType dayOff) {

        DayOffType dayOffFound = repository.findById(dayOff.getId()).orElse(null)
        if (dayOffFound) {
            mapper.update(dayOff)
            repository.save(dayOff)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }

    @Override
    DayOffType findByDayOffTypeId(int dayOffTypeId) {
        return repository.findByDayOffTypeId(dayOffTypeId)
    }

    @Override
    ResponseEntity<SystemResponse> delete(int dayOffTypeId) {

        DayOffType dayOffFound = repository.findByDayOffTypeId(dayOffTypeId)
        if (dayOffFound) {
            repository.delete(dayOffFound)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
