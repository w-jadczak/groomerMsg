<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Groomer Msg Microservice</h1>

<p>The Groomer Msg microservice was created with the idea of extending the Groomer Web App application to enable sending notifications to users via email. The service receives notifications sent from the application through a queue system built in RabbitMQ. Then, based on HTML templates, it constructs the appropriate message and sends it using JavaMail.</p>

<h2>Table of Contents</h2>

<ul>
    <li><a href="#features">Features</a></li>
    <li><a href="#technologies-used">Technologies Used</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#documentation">API Documentation</a></li>
</ul>

<h2 id="features">Features</h2>

<ul>
    <li>Configures RabbitMQ queue system.</li>
    <li>Provides html template based email buildnig mechanisms</li>
    <li>Integrates with PostgreSQL database for message persistance</li>
    <li>Implements admin management</li>
    <li>Incorporates Liquibase for database migrations</li>
</ul>

<h2 id="technologies-used">Technologies Used</h2>

<ul>
    <li>Spring Boot 3.2.4</li>
    <li>Java 17</li>
    <li>Hibernate</li>
    <li>Maven</li>
    <li>PostgreSQL</li>
    <li>Springdoc OpenAPI</li>
    <li>Liquibase</li>
    <li>Mapstruct</li>
    <li>JUnit</li>
    <li>Mockito</li>
    <li>Lombok</li>
    <li>Jasypt</li>
    <li>Docker</li>
</ul>

<h2 id="getting-started">Getting Started</h2>

<p>To get started with the Groomer Web Application, follow these steps:</p>

<ol>
    <li>Clone the repository:</li>
</ol>

<pre><code>git clone https://github.com/your-username/groomerWebApp.git
cd groomerWebApp
</code></pre>

<ol start="2">
    <li>Build the project:</li>
</ol>

<pre><code>mvn clean install
</code></pre>

<ol start="3">
    <li>Run the application:</li>
</ol>

<pre><code>mvn spring-boot:run
</code></pre>


<h2 id="contributing">Contributing</h2>

<p>Contributions to the Groomer Msg Application are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.</p>

<h2 id="documentation">API Documentation</h2>

<p>Swagger API documentation available at:</p>
</body>
</html>

<pre><code>http://localhost:8082/swagger-ui-custom.html
</code></pre>
