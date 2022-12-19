package com.example.springpersonapi.Person;

import com.example.springpersonapi.Exception.InvalidAgeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    /**
     * @return List of persons without sort
     */
    public List<Person> getListOfPersons(){
        return personRepository.findAll();
    }

    /**
     * @return List of person by FirstName
     */
    public List<Person> getListOfPersonsOrderedByFirsName(){
        return personRepository.findAllByOrderByFirstName();
    }

    /**
     * @param person the person data
     * @return saved data with id
     * @throws InvalidAgeException If the person age is invalid
     * @throws ParseException if error occurred during the parsing
     */
    public Person addPerson(Person person) throws InvalidAgeException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        String dateInString = "1872-01-01";
        Date date = formatter.parse(dateInString);
        if (person.getBirthday().before(date)){
            throw new InvalidAgeException("Your age must be less than or equal to 150 (" + dateInString+")");
        }
        return personRepository.save(person);
    }

}
