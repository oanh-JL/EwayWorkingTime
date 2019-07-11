package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.BallotRequest
import eway.intern.management_staff.repositories.BallotRequestRepository
import eway.intern.management_staff.services.BallotRequestService
import eway.intern.management_staff.services.mapper.BallotRequestMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BallotRequestServiceImpl implements BallotRequestService {

    @Autowired
    BallotRequestMapper mapper
    @Autowired
    BallotRequestRepository repository

    @Override
    ResponseEntity<SystemResponse> create(BallotRequest ballotRequest) {

        mapper.create(ballotRequest)
        repository.save(ballotRequest)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(BallotRequest ballotRequest) {

        BallotRequest ballotFound = repository.findById(ballotRequest.getId()).orElse(null)
        if (ballotFound) {
            mapper.update(ballotRequest)
            repository.save(ballotRequest)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }

    @Override
    List<BallotRequest> getAll(String userId) {
        return repository.getAll(userId)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String id) {

        BallotRequest ballotDelete = repository.findById(id).orElse(null)
        if (ballotDelete) {
            repository.delete(ballotDelete)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }
}