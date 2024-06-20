package com.treinetick.controller;

import com.treinetick.model.User;
import com.treinetick.model.UserDTO;
import com.treinetick.security.JwtTokenProvider;
import com.treinetick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        // Check if the username already exists
        if (userService.existsByUsername(user.getUserName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        userService.save(user);

        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = generateToken(user.getUserName(), user.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer " + token); // Adding token to the response header

        Map<String, Object> response = new HashMap<>();
        response.put("role", userDetails.getAuthorities());


        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }


    private String generateToken(String username, String password) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return jwtTokenProvider.createToken(authentication);
    }

    @GetMapping("/{username}")
    public User getLogin(@PathVariable String username) {
        return userService.findByUsername(username).orElse(null);
    }

    @GetMapping("get-by/{id}")
    public UserDTO getUserById(@PathVariable String id) {

        User user = userService.getUserById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUserName());
        userDTO.setEmail(user.getEmailAddress());
        userDTO.setContactNumber(user.getContactNumber());
        userDTO.setRole(user.getRole().getRole());

        return userDTO;
    }



    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/report")
    public ResponseEntity<InputStreamResource> generatePdfReport() throws Exception {
        List<User> users = userService.getAllUsers();
        Context context = new Context();
        context.setVariable("users", users);

        String htmlContent = templateEngine.process("pdf_template", context);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(out);

        ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=users_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}



