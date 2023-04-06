package com.doggo.apigateway.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Configuration
public class DefaultConfig {

    @Value("${spring.gateway.excludedURLsNew}")
    private String urlsStrings;

    @Bean
    @Qualifier("excludedUrls")
    public List<String> excludedUrls() {
        return Arrays.stream(urlsStrings.split(",")).toList();
    }

    private static final String APP = "app";
    private static final String PANEL_APPLICATION = "panel-application";
    private static final String AUTHENTICATION = "authentication";
    private static final String SERVICE_ROUTE = "-service-route";

    @Bean
    public ObjectMapper objectMapper() {
        JsonFactory factory = new JsonFactory();
        factory.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

        ObjectMapper objectMapper = new ObjectMapper(factory);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return objectMapper;
    }


    @Bean
    public RouteLocator routes(
            RouteLocatorBuilder builder) {
        return builder.routes()
                .route(AUTHENTICATION + SERVICE_ROUTE, getPredicateSpecBuildableFunction(AUTHENTICATION ))
                .route(PANEL_APPLICATION + SERVICE_ROUTE, getPredicateSpecBuildableFunction(PANEL_APPLICATION ))
                .route(APP + SERVICE_ROUTE, getPredicateSpecBuildableFunction(APP))
                .build();
    }

    private Function<PredicateSpec, Buildable<Route>> getPredicateSpecBuildableFunction(String serviceName) {
        return r -> r
                .path("/" + serviceName + "/**")
                .uri("lb://" + serviceName);
    }
}
