package com.doggo.app.domain.people.customer.web;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String userId;
}
