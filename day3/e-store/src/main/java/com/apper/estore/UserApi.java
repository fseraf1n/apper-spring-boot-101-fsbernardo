package com.apper.estore;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("user")
public class UserApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) throws InvalidUserAgeException {
        LocalDate birthDate = LocalDate.parse(request.getBirthDate());
        LocalDate dateToday = LocalDate.now();
        int yearDifference = dateToday.getYear() - birthDate.getYear();
        int monthDifference = dateToday.getMonthValue() - birthDate.getMonthValue(); // 7 (july) - 8 (aug)
        int dayDifference = dateToday.getDayOfMonth() - birthDate.getDayOfMonth(); // 4 - 25

        if (yearDifference > 15) {
            //System.out.println(request);
            return new CreateUserResponse("RANDOM_STRING");
        }
        if (monthDifference > 0 || (dayDifference > 0 && monthDifference == 0)) {
            //System.out.println(request);
            return new CreateUserResponse("RANDOM_STRING");
        } else {
            //System.out.println(request);
            throw new InvalidUserAgeException("Age must be at least 15 years old.");

        }
    }

}
