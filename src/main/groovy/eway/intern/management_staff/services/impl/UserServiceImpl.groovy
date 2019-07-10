package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.PageResponse
import eway.intern.management_staff.controllers.viewmodel.SystemResponse
import eway.intern.management_staff.models.User
import eway.intern.management_staff.repositories.UserRepository
import eway.intern.management_staff.services.UserService
import eway.intern.management_staff.services.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper
    @Autowired
    UserRepository repository

    @Override
    ResponseEntity<SystemResponse> create(User user) {
        mapper.create(user)
        repository.save(user)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    PageResponse<User> findAllPagingUser(int page, int size, String sortBy, String sortDirection) {
        Sort.Direction direction = (sortDirection == "ASC") ?
                Sort.Direction.ASC : Sort.Direction.DESC
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy))
        Page<User> pages = this.repository.findAllPagingUser(pageable)
        PageResponse<User> pageResponse = new PageResponse(
                pages.toList(),
                pages.pageable,
                pages.totalElements)
        return new PageResponse<User>(pageResponse)
    }

    @Override
    User findByUserId(String userId) {
        return repository.findByUserId(userId)
    }

    @Override
    ResponseEntity<SystemResponse> update(User user) {
        User userFound = repository.findById(user.getId()).orElse(null)
        if (userFound) {
            mapper.update(user)
            repository.save(user)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String userId) {
        User userDelete = repository.findByUserId(userId)
        if(userDelete) {
            repository.delete(userDelete)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)
    }
}
