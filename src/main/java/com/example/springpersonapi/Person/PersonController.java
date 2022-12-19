package com.example.springpersonapi.Person;

import com.example.springpersonapi.Exception.CustomHttpResponse;
import com.example.springpersonapi.Exception.InvalidAgeException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request";

    private final PersonService personService;

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) throws InvalidAgeException, ParseException {
        return personService.addPerson(person);
    }

    @GetMapping("/list")
    public List<Person> getListOfPersons(){
        return personService.getListOfPersons();
    }

    @GetMapping("/byFirsName")
    public List<Person> getListOfPersonsByFN(){
        return personService.getListOfPersonsOrderedByFirsName();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<CustomHttpResponse> internalServerErrorException(Exception exception) {
        LOGGER.error(exception.getMessage());
        return createCustomHttpResponse(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<CustomHttpResponse> tokenExpiredException(InvalidAgeException exception) {
        return createCustomHttpResponse(BAD_REQUEST, exception.getMessage());
    }
    private ResponseEntity<CustomHttpResponse> createCustomHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new CustomHttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }
}
