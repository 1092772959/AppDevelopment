package com.myapp.demo.cotroller.login;

import com.myapp.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserloginController {
    private IUserService iUserService;

    @Autowired
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }




}
