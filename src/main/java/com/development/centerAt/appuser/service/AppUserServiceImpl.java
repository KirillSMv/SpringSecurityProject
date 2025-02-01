package com.development.centerAt.appuser.service;

import com.development.centerAt.appuser.dto.AppUserDto;
import com.development.centerAt.appuser.dto.mapper.UserDtoMapper;
import com.development.centerAt.appuser.model.AppUser;
import com.development.centerAt.appuser.storage.AppUserRepository;
import com.development.centerAt.appuser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final UserDtoMapper userDtoMapper;

    @Transactional
    @Override
    public AppUser addAppUser(AppUserDto appUserDto) {
        //доп валидация что нет таких имен, почты и так далее
        AppUser appUser = userDtoMapper.userDtoToAppUser(appUserDto);
        return appUserRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> findAppUserByUsername(String username) {
        return appUserRepository.findUserByUsername(username);
    }
}
