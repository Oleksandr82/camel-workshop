# Exercise 3 - JMS routing

JMS has been part of the java standard for years now and is used a lot.
That is why it is an integral part of Camel just as File and FTP. 
This exercise will show how easy it is to get messaging working...

* Check out branch ex3 (`git checkout ex3`)
* Open class `JmsRoute`
* Follow the instructions there and make it all work...

## Bonus material 

* In this case both spring-boot and camel make a lot of magic happen.

## Bonus Question(s):

* Can you read the split up books from the Queue and write them back to file with the target/books/<title>.txt as the filename?

## Hint(s)

* jms component
* maven artifacts met o.a....

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-activemq</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-jms</artifactId>
</dependency>
```