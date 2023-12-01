# SpringBootCRUDApplication
15.	 What is Spring Boot and List out the Features?
	Spring Boot is an open-source, java-based framework that provides support for Rapid Application Development and gives a platform for developing stand-alone and production-ready applications within minutes.
It has extra support of auto-configuration and embedded server like Tomcat, Jetty, Undertow.
Features of Spring Boot
1.	Inbuild Tomcat Server available 
2.	We are able to create Production Ready application with in minute
3.	No XML Configuration required
4.	DevTool Depedency- Not need to restart application after changes. DevTool help us for Live Reload application.
5.	Development Faster
6.	Spring Boot also offers pinpointed ‘started’ POMs to Maven configuration.
7.	Spring Initializer – This is a web application that helps a developer in creating an internal project structure. The developer does not have to manually set up the structure of the project while making use of this feature.
8.	Auto-Configuration – This helps in loading the default configurations according to the project you are working on. In this way, unnecessary WAR files can be avoided.
9.	Spring Actuator – Spring boot uses actuator to provide “Management Endpoints” which helps the developer in going through the Application Internals, Metrics etc.
10.	 Logging and Security – This ensures that all the applications made using Spring Boot are properly secured without any hassle.

Spring Boot Application Workflow-
The entry point of a spring boot application is @SpringBootApplication and the main method. It scans all the components automatically that are present in the project by using @ComponentScan annotation. It also configures the application automatically based on the dependencies added to the project by using @EnableAutoConfiguration annotation.
1.	The client makes the HTTP requests.
2.	This request goes to the controller, and the controller maps and handles it.
3.	The request is passed on to the service layer where all the business logic is performed on the data that is mapped to JPA with model classes.
4.	As a result, a web page is returned to the user if no error occurred.

16.	 What does @SpringBootApplication annotation do internally?
	@SpringBootApplication annotation is one point replacement for using @SpringBootConfiguration, @EnableAutoConfiguration and @ComponentScan annotations alongside their default attributes.
This enables the developer to use a single annotation instead of using multiple annotations thus lessening the lines of code. However, Spring provides loosely coupled features which is why we can use these annotations as per our project needs.
If you are not using @SpringBootApplication annotation then application goes to failure in startup only.

 

1.	@SpringBootConfiguration: Designates this class as a configuration class. Configuration classes are the heart of Java-based application configuration in Spring. They can use @Bean annotated methods to specify bean definitions.
2.	@EnableAutoConfiguration: Enables Spring Boot’s auto-configuration feature, which attempts to automatically configure your application based on the dependencies in its classpath. For example, if Spring MVC is on the classpath, this annotation flags the application to be web-applicable and activates key behaviours like setting up a DispatcherServlet.
3.	@ComponentScan: Enables component scanning. This allows Spring to automatically discover other components, configurations and services in the same package as the one where the @SpringBootApplication is placed, allowing it to automatically manage them (i.e., create bean instances for your classes at application startup)