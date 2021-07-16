package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.DTO.UserDTO;
import ro.societateahermes.backendservice.entities.User;
import ro.societateahermes.backendservice.service.UserServiceInterface;
import ro.societateahermes.backendservice.service.serviceImplementation.UserServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/user")
public class  UserController implements UserControllerInterface {
    private UserServiceInterface service;

    public UserController(UserServiceImplementation service) { this.service = service; }

    @PostMapping
    public void save(@RequestBody User user){
        service.save(user);
    }


    @GetMapping
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @PutMapping("/update")
    public void put(@RequestBody UserDTO user){
        service.update(user);
    }

    @DeleteMapping ("/{userId}")
    public void delete(@PathVariable("userId") Long userId){
        service.delete(userId);
    }
}
