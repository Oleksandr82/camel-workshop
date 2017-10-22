/*
 * Copyright 2017 Ivo Woltring <WebMaster@ivonet.nl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.ordina.route.eip.messaging_systems.message_translator.using_transform;

import lombok.extern.slf4j.Slf4j;
import nl.ordina.context.CamelDemoContext;
import nl.ordina.route.eip.messaging_systems.message_translator.boundary.JsonPathBean;
import nl.ordina.route.eip.messaging_systems.message_translator.boundary.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.lang.String.format;

/**
 * A.k.a the Adapter pattern.
 *
 * This route demo's the MessageTranslator pattern by using the .transfom builder method.
 * In this case it will use destination of the {@link nl.ordina.route.eip.messaging_systems.message_translator.using_beans.MessageTranslatorUsingBean}
 * as the monitor start place (from) and will convert json to xml.
 * First it will transform the json back to it's java object {@link Order} using the provided "fromJson" method of that class
 * then it will marshal it to xml using jaxb.
 * it will also log at various levels the body as it is at that time.
 * It will write its resulting xml to the target/MessageTranslatorUsingTransform folder
 *
 * The .bean ({@link JsonPathBean}) call in the route is only there to demonstrate the usage of a {@link JsonPath} in the bean.
 *
 * Important note in this is that, because java 8 is used, an adapter was needed for the {@link LocalDateTime}
 * The definition of this adapter is found in the package-info.java file. See also the {@link LocalDateTimeAdapter} class.
 *
 * @author Ivo Woltring
 */
@Slf4j
@Component
public class MessageTranslatorUsingTransform extends RouteBuilder {

    private final CamelDemoContext context;

    @Autowired
    public MessageTranslatorUsingTransform(final CamelDemoContext context) {
        this.context = context;
    }

    @Override
    public void configure() throws Exception {
        final String projectBaseLocation = this.context.projectBaseLocation();
        final String name = this.getClass().getSimpleName();

        from(format("file://%s/target/MessageTranslatorUsingBean/?noop=true", projectBaseLocation))
              .routeId(name)
              .log("Found file [$simple{header.CamelFileName}] processing csv to json in this route.")
              .bean("jsonPathBean")
              .log("Input message:\n${body}")
              .transform(method(Order.class, "fromJson"))
              .marshal()
              .jaxb()
              .log("Xml marshalled:\n${body}")
              .to(format("file://%s/target/%s?fileName=${header.CamelFileName}.xml", projectBaseLocation, name));

    }
}
