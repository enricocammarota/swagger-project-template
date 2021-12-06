# Swagger Project Template

The project has the purpose of giving some guidelines over the inclusion of Swagger within your application. A basic API
has been developed in order to offer a rough idea on how's supposed to work.

### Swagger

Swagger is a powerful yet easy-to-use suite of API developer tools for teams and individuals, enabling development across 
the entire API lifecycle, from design and documentation, to test and deployment.

Swagger consists of a mix of open source, free and commercially available tools that allow anyone, from technical 
engineers to street smart product managers to build amazing APIs that everyone loves.

Swagger started out as a simple, open source specification for designing RESTful APIs in 2010. Open source tooling like 
the Swagger UI, Swagger Editor and the Swagger Codegen were also developed to better implement and visualize APIs defined 
in the specification. The Swagger project, consisting of the specification and the open source tools, became immensely 
popular, creating a massive ecosystem of community driven tools.

In 2015, the Swagger project was acquired by SmartBear Software. The Swagger Specification was donated to the Linux 
foundation and renamed the OpenAPI

Specification to formally standardize the way REST APIs are described. The OpenAPI Initiative was created to guide the 
development of the OAS in an open and transparent manner.

Swagger has since become the most popular suite of tools to fully leverage the power of the OAS across the API lifecycle.

### Swagger Implementation

These paragraph lists the necessary steps to be performed in order to include Swagger in your api:

1. Add the necessary dependencies in the pom.xml (see "Swagger dependencies" in pom.xml)
2. Add a specific config file (see SwaggerConfig.java) and mark it with the necessary annotations
3. Add the necessary annotations in the controller class(es)
4. Add the necessary annotations in the model class(es) - please bear in mind adding getters/setters for all the attributes
5. Navigate to the [Swagger URL](http://localhost:8801/api/swagger-ui.html). and enjoy! 

#### Swagger Controller class annotations

| Syntax      | Description | 
| :---        |    :----:   |
| @ApiOperation   | Describes an operation or typically a HTTP method against a specific path. Operations with equivalent paths are grouped in a single Operation Object. A combination of a HTTP method and a path creates a unique operation | 
| @ApiResponses   | The annotation may be used at method level or as field of @Operation to define one or more responses of the Operation. It maps to OpenAPI spec ApiResponse        | 
| @ApiParam   |  Used solely with the JAX-RS 1.x/2.x parameter annotations like @PathParam, @QueryParam, @HeaderParam, @FormParam, and @BeanParam. Although swagger-core scans these annotations by default, we can use @ApiParam to add more details about the parameters or change the values as they are read from the code.        | 

#### Swagger Model class annotations

| Syntax      | Description | 
| :---        |    :----:   |
| @ApiModelProperty   | The @ApiModelProperty annotation allows us to control Swagger-specific definitions such as description (value), name, data type, example values, and allowed values for the model properties. Also, it offers additional filtering properties in case we want to hide the property in certain scenarios. |  

### Swagger URLs

Swagger UI URL:

``
<hostname>/api/swagger-ui.html
``

Swagger API Documentation:

``
<hostname>/v2/api-docs
``

### Hot to run

Build using Maven.

```bash
mvn clean install
```

If you want to additionally build the docker image, you can run with a profile as follows:
```bash
mvn clean install -P docker
```

And you're now ready to query the API:

```bash
curl --location --request GET 'http://localhost:8801/student-api/{studentName}'
```


### Running the application locally

There is a compose file you can use:

- docker-compose.yml

The file is configured to run the application on port 8801 and therefore will be possible for you
to query the API through that port. Please run:

```bash
docker-compose up
```

In order to be able to use the API.