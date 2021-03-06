package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/allUsers")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Iterable<User> getAll()
    {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Optional<User> getUser(@PathVariable Long userId)
    {
        return userService.findById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public User update(@RequestBody User user)
    {
        userService.save(user);

        return user;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long userId)
    {
        userService.deleteById(userId);
    }
}
