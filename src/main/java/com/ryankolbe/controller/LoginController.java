package com.ryankolbe.controller;

import com.ryankolbe.domain.Login;
import com.ryankolbe.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(@Qualifier("LoginServiceImpl") LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Login create(@RequestBody Login login) {
        return loginService.create(login);
    }

    @PutMapping("/update")
    @ResponseBody
    public Login update(@RequestBody Login login) {
        return loginService.update(login);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Login read(@PathVariable String id) {
        return loginService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        loginService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Login> getAll() {
        return loginService.getAll();
    }
}