package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.DayOff
import eway.intern.management_staff.repositories.DayOffRepository
import eway.intern.management_staff.services.DayOffService
import eway.intern.management_staff.services.mapper.DayOffMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DayOffServiceImpl implements DayOffService {
    @Autowired
    DayOffMapper mapper

    @Autowired
    DayOffRepository repository

    @Override
    List<DayOff> findAll() {
        return repository.findAll()
    }

    @Override
    ResponseEntity<SystemResponse> create(DayOff dayOff){
        mapper.create(dayOff)
        repository.save(dayOff)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    DayOff findByDayOffId(int dayOffId) {
        return repository.findByDayOffId(dayOffId)
    }

    @Override
    ResponseEntity<SystemResponse> update(DayOff dayOff) {
        DayOff dayOffFound = repository.findById(dayOff.getId()).orElse(null)
        if (dayOffFound){
            mapper.update(dayOff)
            repository.save(dayOff)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> delete(int dayOffId) {
        DayOff dayOffDelete = repository.findByDayOffId(dayOffId)
        if (dayOffDelete){
            repository.delete(dayOffDelete)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
