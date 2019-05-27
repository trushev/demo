package com.example.demo.api;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserService> {

    UserController(UserService service) {
        super(service);
    }
}
