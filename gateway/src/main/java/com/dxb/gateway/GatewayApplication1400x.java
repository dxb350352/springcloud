package com.dxb.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Spencer Gibb
 */
@SpringBootConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication1400x {

    public static final String HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS = "hello from fake /actuator/metrics/gateway.requests";

    @Value("${test.uri:lb://eureka-client}")
    String uri;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication1400x.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        System.out.println(uri + "....................");
        //@formatter:off
        // String uri = "http://httpbin.org:80";
        // String uri = "http://localhost:9080";
        return builder.routes()
                //stripPrefix就是去掉几个‘/’的内容
                //http://localhost:14001/api/eureka-client/add?authToken=x&a=3&b=3
                .route("abc", r -> r.path("/api/eureka-client/**").filters(f -> f.stripPrefix(2)).uri(uri))
                //http://localhost:14001/apiclient/add?authToken=x&a=3&b=3
                .route("cba", r -> r.path("/apiclient/**").filters(f -> f.stripPrefix(1)).uri(uri))
                .route(r -> r.host("**.abc.org").and().path("/anything/png")
                        .filters(f ->
                                f.prefixPath("/httpbin")
                                        .addResponseHeader("X-TestHeader", "foobar"))
                        .uri(uri)
                )
                .route("read_body_pred", r -> r.host("*.readbody.org")
                        .and().readBody(String.class,
                                s -> s.trim().equalsIgnoreCase("hi"))
                        .filters(f -> f.prefixPath("/httpbin")
                                .addResponseHeader("X-TestHeader", "read_body_pred")
                        ).uri(uri)
                )
                .route("rewrite_request_obj", r -> r.host("*.rewriterequestobj.org")
                        .filters(f -> f.prefixPath("/httpbin")
                                .addResponseHeader("X-TestHeader", "rewrite_request")
                                .modifyRequestBody(String.class, Hello.class, MediaType.APPLICATION_JSON_VALUE,
                                        (exchange, s) -> {
                                            return Mono.just(new Hello(s.toUpperCase()));
                                        })
                        ).uri(uri)
                )
                .route("rewrite_request_upper", r -> r.host("*.rewriterequestupper.org")
                        .filters(f -> f.prefixPath("/httpbin")
                                .addResponseHeader("X-TestHeader", "rewrite_request_upper")
                                .modifyRequestBody(String.class, String.class,
                                        (exchange, s) -> {
                                            return Mono.just(s.toUpperCase() + s.toUpperCase());
                                        })
                        ).uri(uri)
                )
                .route("rewrite_response_upper", r -> r.host("*.rewriteresponseupper.org")
                        .filters(f -> f.prefixPath("/httpbin")
                                .addResponseHeader("X-TestHeader", "rewrite_response_upper")
                                .modifyResponseBody(String.class, String.class,
                                        (exchange, s) -> {
                                            return Mono.just(s.toUpperCase());
                                        })
                        ).uri(uri)
                )
                .route("rewrite_response_obj", r -> r.host("*.rewriteresponseobj.org")
                        .filters(f -> f.prefixPath("/httpbin")
                                .addResponseHeader("X-TestHeader", "rewrite_response_obj")
                                .modifyResponseBody(Map.class, String.class, MediaType.TEXT_PLAIN_VALUE,
                                        (exchange, map) -> {
                                            Object data = map.get("data");
                                            return Mono.just(data.toString());
                                        })
                                .setResponseHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE)
                        ).uri(uri)
                )
                .route(r -> r.path("/image/webp")
                        .filters(f ->
                                f.prefixPath("/httpbin")
                                        .addResponseHeader("X-AnotherHeader", "baz"))
                        .uri(uri)
                )
                .route(r -> r.order(-1)
                        .host("**.throttle.org").and().path("/get")
                        .filters(f -> f.prefixPath("/httpbin")
                                .filter(new TimeGatewayFilter()))
                        .uri(uri)
                )
                .build();
        //@formatter:on
    }

    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/testfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
        return route;
    }

    @Bean
    public RouterFunction<ServerResponse> testWhenMetricPathIsNotMeet() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/actuator/metrics/gateway.requests"),
                request -> ServerResponse.ok().body(BodyInserters
                        .fromObject(HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS)));
        return route;
    }

    static class Hello {

        String message;

        Hello() {
        }

        Hello(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

}


