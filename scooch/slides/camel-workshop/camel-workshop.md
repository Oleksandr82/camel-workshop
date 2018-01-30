<!-- .element class="center" -->
# <center>Apache Camel Workshop</center>

<center>![jtech](./pics/jtech-logo.png)</center>
---
## Agenda
- Introduction
- What are we going to do today?
  - Enterprise Integration Patterns (EIP)
  - Apache Camel Basics
  - Workshop
---
## Introduction
**Ivo Woltring**  

Software Architect and CodeSmith @ Ordina

![ivo](./pics/ivo-bio.png)

**Edwin Derks**  

Solutions Architect @ Ordina

![edwin](./pics/edwinderks-bio.png)

---
## What are we going to do today?
- Theory
- Hands-on building your own Camel integration module

![checklist](./pics/checklist.png)
---

<center>
<img src="./pics/CamelNuHumpsJoke.png" style="width:50%;height:50%;"/>
</center>

---
## Enterprise Integration Patterns (EIP)
- What are they and what do they do?

![eips](./pics/eips.png)
---
## Apache Camel
- History
- How does it work?
- Community
- Literature

![camel-logo](./pics/apache-camel-logo.png)
---
## Apache Camel History

![camel-logo](./pics/apache-camel-logo.png)
---
## Apache Camel
- Software integration framework
- Huge number of integration components
- Made in Java, runs on the JVM
- Various DSL's, e.g. XML and Java
- Available as Maven artifacts
- Run standalone or integrate with Spring

![camel-logo](./pics/apache-camel-logo.png)
---
## Apache Camel Components
![maven-logo](./pics/maven-logo-black-on-white.png)

https://mvnrepository.com/artifact/org.apache.camel/camel-core

    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-core</artifactId>
        <version>2.20.1</version>
    </dependency>

https://mvnrepository.com/artifact/org.apache.camel/camel-amqp

    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-amqp</artifactId>
        <version>2.20.1</version>
    </dependency>
    
---
## Apache Camel Java DSL

![camel-java-dsl](./pics/camel-java-dsl.png)
---
## Apache Camel XML DSL

![camel-xml-dsl](./pics/camel-xml-dsl.png)
---
## Apache Camel: The Basics
- Camel components
- Define routes
- Data is being shipped via a route, packed as an Exchange

![camel-exchange-structure](./pics/camel-exchange-structure.png)
---
## Apache Camel Community
Community  

    http://camel.apache.org/

- Unknown, but with a solid fan base
- Only integration, no GUI
- Cloud

![camel-box](./pics/camel-box-small.png)

---
## Apache Camel Literature
- Camel in Action (2nd Edition)

    https://www.manning.com/books/camel-in-action-second-edition
    (http://ivo2u.nl/5P)

![camel-in-ation](./pics/camel-in-action-2nd-ed-small.png)

---
## Workshop
Github repo:  
**https://github.com/Ordina-JTech/camel-workshop**
(http://ivo2u.nl/5b)

Read the instructions and follow these up to "Workshop"

<img src="./pics/hump-day-funny-camel-yosemite-sam.png" style="width:50%;height:50%;"/>

---
## Workshop
- The first exercise
  - Checkout branch "ex1"
  - We will build a simple route to transfer a file with Apache Camel
  
**https://github.com/Ordina-JTech/camel-workshop**