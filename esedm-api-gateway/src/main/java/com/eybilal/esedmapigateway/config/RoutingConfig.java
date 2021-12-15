package com.eybilal.esedmapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RoutingConfig {
    @Profile({"local-ide"})
    @Bean
    RouteLocator localIdeRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                                  .route(route -> route.path("/login")
                                      .uri("http://localhost:8081")
                                      .id("login")
                                  )
                                  .route(route -> route.path("/refresh-token")
                                      .uri("http://localhost:8081")
                                      .id("refresh-token")
                                  )
                                  .route(route -> route.path("/api/v1/customers/**")
                                      .uri("http://localhost:8085")
                                      .id("customer-service")
                                  )
                                  .route(route -> route.path(
                                          "/api/v1/products/**",
                                          "/api/v1/categories/**"
                                      )
                                      .uri("http://localhost:8086")
                                      .id("inventory-service")
                                  )
                                  .route(route -> route.path("/api/v1/orders/**")
                                      .uri("http://localhost:8087")
                                      .id("order-service")
                                  )
                                  .build();
    }

    @Profile({"local-docker"})
    @Bean
    RouteLocator localDockerRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                                  .route(route -> route.path("/login")
                                      .uri("lb://auth-service")
                                      .id("login")
                                  )
                                  .route(route -> route.path("/refresh-token")
                                      .uri("lb://auth-service")
                                      .id("refresh-token")
                                  )
                                  .route(route -> route.path("/api/v1/customers/*")
                                      .uri("lb://customer-service")
                                      .id("customer-service")
                                  )
                                  .route(route -> route.path(
                                        "/api/v1/products/**",
                                        "/api/v1/categories/**"
                                        )
                                      .uri("lb://inventory-service:8086")
                                      .id("inventory-service")
                                  )
                                  .build();
    }
}
