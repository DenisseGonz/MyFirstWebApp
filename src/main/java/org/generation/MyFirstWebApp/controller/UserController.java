package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController
{
    final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        userService.add( new User( 1, "Santiago", "Carrillo" ) );
        userService.add( new User( 2, "Gabriel", "Cascada" ) );
        userService.add( new User( 3, "Etan", "Casandrade" ) );
        userService.add( new User( 4, "Salchichon", "Cedillo" ) );
        userService.add( new User( 5, "Hermosillo", "Cornucopia" ) );
    }

    @GetMapping( "/user" )
    public User getUser()
    {
        return userService.getUser( 0 );
    }

    @GetMapping( "/users/all" )
    public List<User> totalUsers(){
        return userService.getAll();
    }
}
