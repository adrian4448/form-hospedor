package com.formhospedor.backend.service;

import com.formhospedor.backend.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    UserDetails authenticate(AppUser user);
    
}
