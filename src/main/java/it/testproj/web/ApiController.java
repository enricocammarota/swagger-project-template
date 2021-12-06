package it.testproj.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import it.testproj.entity.Student;
import it.testproj.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/student-api")
public class ApiController {

    private final IApiService apiService;

    @Autowired
    public ApiController(IApiService apiService) {
        this.apiService = apiService;
    }

    @ApiOperation(value = "Get the Student information by name", tags = "getStudentInformationByName",
            notes = "These are possible notes for the endpoint.", produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "The request was successful and student information are returned in the response", response = Student.class),
                    @ApiResponse(code = 404, message = "The student you searched doesn't exist"),
                    @ApiResponse(code = 500, message = "Internal error during retrieval of Student information. Please try again later.")
            })
    @GetMapping("/{studentName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> getStudentInformationByName(@ApiParam(value = "The student name",
            name = "studentName",
            required = true,
            examples = @Example(value = {
                @ExampleProperty(value = "/foo123")
            })
    ) @PathVariable String studentName) {
        return apiService.getStudentByName(studentName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }

}
