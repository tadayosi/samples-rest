# CORS (Cross-Origin Resource Sharing) Sample

This sample demonstrates how to enable CORS in RESTEasy.

## How to run this example

1. Start JBoss AS 7

2. Deploy the REST application:

        $ cd rest/
        $ mvn clean package jboss-as:deploy

3. Run the other web server:

        $ cd js/
        $ mvn jetty:run

4. Access http://localhost:18080/
