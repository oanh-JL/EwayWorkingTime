package eway.intern.management_staff.services.impl

import eway.intern.management_staff.controllers.viewmodel.response.SystemResponse
import eway.intern.management_staff.models.AnnualDayOff
import eway.intern.management_staff.repositories.AnnualDayOffRepository
import eway.intern.management_staff.services.AnnualDayOffService
import eway.intern.management_staff.services.mapper.AnnualDayOffMapper
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.LookupOperation
import org.springframework.data.mongodb.core.aggregation.MatchOperation
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class AnnualDayOffServiceImpl implements AnnualDayOffService {

    @Autowired
    AnnualDayOffRepository repository
    @Autowired
    AnnualDayOffMapper mapper
    @Autowired
    MongoTemplate mongoTemplate
    @Autowired
    MongoOperations mongoOperations


    @Override
    ResponseEntity<SystemResponse> create(AnnualDayOff dayOff) {
        mapper.create(dayOff)
        repository.save(dayOff)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> update(AnnualDayOff dayOff) {

        AnnualDayOff dayOffFound = repository.findById(dayOff.getId()).orElse(null)
        if (dayOffFound) {
            mapper.update(dayOff)
            repository.save(dayOff)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("notfound"), HttpStatus.NOT_FOUND)

    }

    @Override
    List<AnnualDayOff> findByDate(String date) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match((Criteria.where("start_day_off")
                        .lt(LocalDate.parse(date))
                        & "end_day_off").gt(LocalDate.parse(date)))
        )

        List<AnnualDayOff> annualDayOffs = mongoTemplate.aggregate(aggregation,
                "annual_day_offs", AnnualDayOff.class) as List<AnnualDayOff>

        return annualDayOffs
    }

    @Override
    List<Document> showOrganizationDayOff(String annualDayOffId) {

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("organizations").localField("organization_id")
                .foreignField("organization_id").as("OrganizationsDayOff")
        MatchOperation matchOperation = Aggregation.match(new Criteria()
                .where("annual_day_off_id").is(annualDayOffId))

        ProjectionOperation projectionOperation = Aggregation
                .project("annual_day_off_id", "organization_id", "start_day_off",
                        "end_day_off", "OrganizationsDayOff").andExclude("_id")

        Aggregation aggregation = Aggregation
                .newAggregation(matchOperation, lookupOperation, projectionOperation)

        List<Document> result = mongoTemplate.aggregate(aggregation,
                "annual_day_offs", Document.class) as List<Document>

        return result
    }

    @Override
    ResponseEntity<SystemResponse> delete(String annualDayOffId) {
        return null
    }
}
