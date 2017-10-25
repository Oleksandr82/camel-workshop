# Exercise 4 - EIP - Message Translator

Now you have gotten acquainted with the basic functionality of Camel we can dive a bit deeper.

## Enterprise Integration Patterns

Application Integration problems are many and varied. Gregor Hohpe and Bobby Woolf noticed that many of these problems and their solutions are quite similar.
They cataloged them in their book [Enterprise Integration Patterns (EIP)](http://www.enterpriseintegrationpatterns.com/). Many developers have
used more of these EIP's without even knowing of their existence. If you do know of the EIP's then you will recognize what is happening here.

In this exercise we will try to implement the [Message Translator EIP](http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageTranslator.html)
Translating and transforming messages is one of the things we do a lot as programmers. From Java objects to XML to Json and back are just
some of the possible translations we do almost daily.

* Check out branch ex4 (`git checkout ex4`)
* Open class `MessageTranslatorUsingProcessorRoute`
* Follow the instructions there and make it all work...
* See what happens in target/csv
* Open class `MessageTranslatorUsingBeanRoute`
* Follow the instructions there and make it all work...
* See what happens in target/json
* Open class `MessageTranslatorUsingTransformRoute`
* Follow the instructions there and make it all work...
* See what happens in target/

## Provided

* `nl.ordina.route.eip.messaging_systems.message_translator.boundary` contains model classes needed
* `CsvToJson` is provided for the `MessageTranslatorUsingBeanRoute` exercise
* `CustomFormatToCsvProcessor` is provided for the `MessageTranslatorUsingProcessorRoute` exercise
* `LocalDateTimeAdapter` is provided for the `MessageTranslatorUsingTransformRoute` exercise and configured here `nl.ordina.route.eip.messaging_systems.message_translator.boundary.package-info.java`

## Hint(s)

* Hint if stuff starts to do strange things sometimes a `mvn clean package` will work wonders or throwing the target/csv,json etc folders away.
* maven artifact o.a...

```xml
<dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-jsonpath</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-csv</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-jaxb</artifactId>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jdk8</artifactId>
    <version>2.8.9</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.8.9</version>
</dependency>
```