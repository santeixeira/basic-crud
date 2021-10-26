package com.san.webappsan.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.san.webappsan.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Silvana", "silvana@gmail.com");
        User joao = new User("2", "Joao", "joao@example.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);
    }
}
