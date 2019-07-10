package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.CyclePayRoll
import eway.intern.management_staff.repositories.CyclePayRoleRepository
import eway.intern.management_staff.services.CyclePayRollService
import eway.intern.management_staff.services.mapper.CyclePayRollMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CyclePayRollServiceImpl implements CyclePayRollService {

    @Autowired
    CyclePayRollMapper mapper
    @Autowired
    CyclePayRoleRepository repository

    @Override
    ResponseEntity<SystemResponse> create(CyclePayRoll cyclePayRoll) {
        mapper.create(cyclePayRoll)
        repository.save(cyclePayRoll)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(CyclePayRoll cyclePayRoll) {
        CyclePayRoll cycleFound = repository.findById(cyclePayRoll.getId()).orElse(null)
        if (cycleFound) {
            mapper.update(cyclePayRoll)
            repository.save(cyclePayRoll)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }

    @Override
    ResponseEntity<SystemResponse> delete(String id) {
        if (repository.deleteById(id)) {
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    List<CyclePayRoll> findAll() {
        return repository.findAll()
    }
}
