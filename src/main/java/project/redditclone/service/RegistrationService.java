package project.redditclone.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.redditclone.dto.RegistrationRequest;
import project.redditclone.model.User;
import project.redditclone.repository.UserRepository;

import static java.time.Instant.now;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(encodePassword(registrationRequest.getPassword()));
        user.setJoined(now());
        user.setActive(false);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
