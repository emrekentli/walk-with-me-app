package com.doggo.core.rest;

import java.util.List;

public class BaseController {

    public <T> Response<DataResponse<T>> respond(List<T> items) {
        return ResponseBuilder.build(items);
    }


    protected <T> Response<T> respond(T item) {
        return ResponseBuilder.build(item);
    }

    protected Response<MetaResponse> respond(MetaResponse metaResponse) {
        return ResponseBuilder.build(metaResponse);
    }
}
