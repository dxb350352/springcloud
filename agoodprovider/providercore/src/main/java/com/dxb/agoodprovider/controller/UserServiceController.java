package com.dxb.agoodprovider.controller;

import com.dxb.agoodprovider.api.UserService;
import com.dxb.agoodprovider.db.domain.User;
import com.dxb.agoodprovider.db.reposity.UserReposity;
import com.dxb.agoodprovider.dto.UserDTO;
import com.dxb.agoodprovider.dto.UsernameAndPasswordDTO;
import com.dxb.agoodprovider.utils.Beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * Created by dulei on 18/1/8.
 */
@RestController
@RequestMapping("user")
public class UserServiceController implements UserService {


    @Autowired
    private UserReposity userReposity;


    @Override
    public UserDTO getByUsernameAndPasswordDTO(UsernameAndPasswordDTO usernameAndPasswordDTO) {

        User user = new User();
        user.setAge(new Random().nextInt(50));
        user.setName("张" + user.getAge());
        user.setPassword(usernameAndPasswordDTO.getPassword());
        user.setUsername(usernameAndPasswordDTO.getUsername());

        return Beans.transfrom(UserDTO.class, userReposity.save(user));
    }

    @Override
    public UserDTO get(@PathVariable("uid") Long uid) throws Exception {
        return Beans.transfrom(UserDTO.class, userReposity.findById(uid).orElseThrow(() -> new Exception("没有此用户")));
    }
}
