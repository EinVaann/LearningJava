package com.example.pbl.service;

import com.example.pbl.model.loginInfo;
import com.example.pbl.repository.LoginInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginInfoService implements ILoginInfoService{
    @Autowired
    private LoginInfoRepository infoRepository;


    @Override
    public Iterable<loginInfo> findAll() {
        return infoRepository.findAll();
    }

    @Override
    public Optional<loginInfo> findById(Long id) {
        return infoRepository.findById(id);
    }

    @Override
    public loginInfo save(loginInfo info) {
        return infoRepository.save(info);
    }

    @Override
    public void remove(Long id) {
        infoRepository.deleteById(id);
    }
}
