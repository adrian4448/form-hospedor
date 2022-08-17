package com.formhospedor.backend.service.impl;

import com.formhospedor.backend.exceptions.BusinessException;
import com.formhospedor.backend.model.AppUser;
import com.formhospedor.backend.repository.UserRepository;
import com.formhospedor.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repository
                .findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado na base de dados"));

        return User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities("ADMIN")
                .build();
    }

    public UserDetails authenticate(AppUser user) {
        UserDetails userDetails = loadUserByUsername(user.getUserName());
        boolean passwordOk = passwordEncoder.matches(user.getPassword(), userDetails.getPassword());

        if (passwordOk) {
            return userDetails;
        }

        throw new BusinessException("Senha invalida, verifique novamente.");
    }
}
