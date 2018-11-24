# Spring REST + HATEOAS demo

Run this as a Java application.
 
HAL Browser is available at http://localhost:8080/ (redirects to http://localhost:8080/browser/index.html).

Point the HAL Browser Explorer to "/projects" (without ") and press "Go!". A JSON formatted array is returned with two projects,
each containing a link to their detail page (one has called the link "self", the other "details").

If we'd point the Explorer to "/project/Starship%20Enterprise" then a JSON would be returned with a link to 
self (the HAL browser shows the link separately at the bottom left). 

HATEOAS is a nifty concept but the Spring HATEOAS library is cumbersome to use as
classes need to be wrapped into Resource and Resources classes.

##Reading Material
- [Spring REST HATEOAS guide](https://spring.io/guides/gs/rest-hateoas/)
- [Spring Boot 2: Building a RESTful Web Service](https://dzone.com/articles/spring-boot-2-building-a-restful-web-service)
- [Embedded (multiple) HATEOAS resources](https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support)
- [Spring HATEOAS - Embedded Resources with HAL](http://keaplogik.blogspot.com/2015/01/spring-hateoas-embedded-resources-with.html)
- [How to correctly use PagedResourceAssembler From Spring Data](https://stackoverflow.com/questions/21346387/how-to-correctly-use-pagedresourcesassembler-from-spring-data/21362291#21362291)
- [Spring REST and HAL Browser](https://www.baeldung.com/spring-rest-hal)
- [Spring Boot Actuator endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints)