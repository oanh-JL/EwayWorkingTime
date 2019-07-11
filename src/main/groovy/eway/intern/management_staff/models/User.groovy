package eway.intern.management_staff.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import eway.intern.management_staff.services.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(value = "authorities")
@Document(collection = "users")
class User {

    @Id
    String id

    String roleId

    String organizationId

    @Indexed(unique = true)
    int fingerId

    @Indexed(unique = true)
    String userId

    String fullName

    @Indexed(unique = true)
    String email

    String userName

    String password

    boolean status

    LocalDate createdAt

    LocalDate modifiedAt

    @Autowired
    RoleService service

    List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>()
            authorities.add(new SimpleGrantedAuthority(service.findByRoleId(roleId).getRoleName()))
        return authorities
    }


}
