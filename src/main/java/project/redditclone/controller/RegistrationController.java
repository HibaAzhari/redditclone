package project.redditclone.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.redditclone.dto.RegistrationRequest;
import project.redditclone.service.RegistrationService;

@RestController
@RequestMapping
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity signup(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.signup(registrationRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
