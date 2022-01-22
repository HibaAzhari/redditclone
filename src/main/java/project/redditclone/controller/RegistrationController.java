package project.redditclone.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.redditclone.dto.RegistrationRequest;
import project.redditclone.service.RegistrationService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity signup(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.signup(registrationRequest);
        return new ResponseEntity(OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        registrationService.verifyAccount(token);
        return new ResponseEntity<>("Account has been successfully activated", OK);
    }
}
