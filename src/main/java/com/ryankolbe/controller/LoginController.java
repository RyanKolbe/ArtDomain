package com.ryankolbe.controller;

import com.ryankolbe.domain.Login;
import com.ryankolbe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

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
    public List<Login> getAll() {
        return loginService.getAll();
    }
}