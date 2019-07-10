package eway.intern.management_staff.controllers.viewmodel

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import groovy.transform.CompileStatic
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

@CompileStatic
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class PageResponse<T> extends PageImpl<T> {

    @JsonIgnore
    private Pageable pageable
    @JsonIgnore
    private Sort sort
    /**
     * Size of this page.
     */
    private long size
    /**
     * Number of total elements
     */
    private long elements
    /**
     * List elements <T>
     */
    @JsonProperty("data")
    private List<T> content
    /**
     * Number of this page's elements
     */
    @JsonProperty("page_elements")
    private long numberOfElements
    /**
     * Index of this page
     */
    @JsonProperty("page_number")
    private long number

    PageResponse(List<T> content, Pageable pageable, long elements) {
        super(content, pageable, elements)
        this.elements = elements
        this.pageable = pageable
    }

    PageResponse(Page page) {
        super(page.getContent(), page.getPageable(), page.getTotalElements())
        this.elements = page.getTotalElements()
        this.pageable = page.getPageable()
    }

}
