package com.braveinnov.config;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration extends RouteBuilder {

    @Autowired
    private CamelContext ctx;

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("servlet")
            .contextPath("ws")
            .host("localhost")
            .enableCORS(true)
            .bindingMode(RestBindingMode.auto)
            .jsonDataFormat("json-gson")
            .dataFormatProperty("prettyPrint", "true")
            .apiContextPath("api-doc")
            .apiVendorExtension(true)
                .apiProperty("api.title", "User API")
                .apiProperty("api.version", "1.0.0")
                .apiProperty("cors", "true");


        // Class<? extends Object> simpleTypeClass = new ByteBuddy()
        // .subclass(Object.class)
        //     .name("com.braveinnov.Hype")
        //     .defineField("myName", String.class, Visibility.PRIVATE)
        //     .defineMethod("getMyName", String.class, Visibility.PUBLIC).intercept(FieldAccessor.ofBeanProperty())
        //     .defineMethod("setMyName", String.class, Visibility.PUBLIC).withParameter(String.class).intercept(FieldAccessor.ofBeanProperty())
        // .make()
        // .load(getClass().getClassLoader())
        // .getLoaded();

        // ClassLoader loader = new CustomClassLoader(simpleTypeClass);

        // ctx.getClassResolver().addClassLoader(loader);

        // rest()
        //     .get("/ping")
        //         .produces("text/plain")
        //         .consumes("text/plain")
        //         .param()
        //             .name("test")
        //             .type(RestParamType.query)
        //             .description("test ...")
        //         .endParam()
        //     .to("direct:pong");
        //     .post("/user")
        //         .type(simpleTypeClass)
        //         .outType(User.class)
        //         .to("direct:simple");


        // from("direct:simple")
        //     .process(exchange -> {
        //         String response = new GsonBuilder().create().toJson(exchange.getIn().getBody());
        //         System.out.println(response);
        //     });

        // from("direct:pong")
        //     .transform().constant("Ping Pong!");

    }

}