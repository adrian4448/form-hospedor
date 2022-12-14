package com.formhospedor.backend.api.controller;

import com.formhospedor.backend.api.dto.AppUserDTO;
import com.formhospedor.backend.api.dto.AuthenticationDTO;
import com.formhospedor.backend.api.dto.NewAppUserDTO;
import com.formhospedor.backend.api.dto.TokenDTO;
import com.formhospedor.backend.config.security.jwt.JwtService;
import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.model.AppUser;
import com.formhospedor.backend.service.UserDetailsService;
import com.formhospedor.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@Api("Users API")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cria um usuário no sistema")
    private NewAppUserDTO createNewUser(@RequestBody NewAppUserDTO dto) {
        var user = mapper.map(dto, AppUser.class);

        return userService.createNewUser(user)
                .map(userCreated -> mapper.map(userCreated, NewAppUserDTO.class))
                .orElseThrow(() -> new BusinessException("Não foi possivel criar o usuário, verifique as informações"));
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Realiza a autenticação de um usuário")
    private TokenDTO getToken(@RequestBody AuthenticationDTO dto) {
        try {
            var user = mapper.map(dto, AppUser.class);

            UserDetails userAuthenticated = userDetailsService.authenticate(user);

            String token = jwtService.generateToken(user);
            return new TokenDTO(token, userAuthenticated.getUsername());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiIgnore
    public Page<AppUserDTO> findUsersByParams(Pageable page, AppUserDTO params) {
        var userParams = mapper.map(params, AppUser.class);
        var result = userService.findUserByParams(page, userParams);

        List<AppUserDTO> content = result
                .stream()
                .map(user -> mapper.map(user, AppUserDTO.class))
                .collect(Collectors.toList());

        return new PageImpl(content, PageRequest.of(page.getPageNumber(), page.getPageSize()), result.getTotalElements());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiIgnore
    public AppUserDTO findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id)
                .map(user -> mapper.map(user, AppUserDTO.class))
                .get();
    }

}
