package eway.intern.management_staff.models

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "roles")
class Role {

    @Id
    String id

    @Indexed(unique = true)
    String roleId

    String roleName

    @Indexed(unique = true)
    String parentRole

    LocalDate createdAt

    LocalDate modifiedAt
}
