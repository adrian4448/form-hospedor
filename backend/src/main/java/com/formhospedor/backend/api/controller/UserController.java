package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.AppUserDTO;
import com.formhospedor.backend.model.AppUser;
import com.formhospedor.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public AppUserDTO createNewUser(@RequestBody AppUserDTO dto) {
        var user = mapper.map(dto, AppUser.class);

        return userService.createNewUser(user)
                .map(userCreated -> mapper.map(userCreated, AppUserDTO.class))
                .get();
    }
}
