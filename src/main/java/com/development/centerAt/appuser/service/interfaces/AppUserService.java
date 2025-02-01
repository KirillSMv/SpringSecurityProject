package com.development.centerAt.appuser.service.interfaces;

import com.development.centerAt.appuser.dto.AppUserDto;
import com.development.centerAt.appuser.model.AppUser;

import java.util.Optional;

public interface AppUserService {
    AppUser addAppUser(AppUserDto appUserDto);

    Optional<AppUser> findAppUserByUsername(String username);
}
