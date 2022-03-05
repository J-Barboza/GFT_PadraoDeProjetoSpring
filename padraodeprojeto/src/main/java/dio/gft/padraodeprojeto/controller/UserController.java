package dio.gft.padraodeprojeto.controller;

import dio.gft.padraodeprojeto.model.User;
import dio.gft.padraodeprojeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> searchAll(){
        return ResponseEntity.ok(userService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> searchById(@PathVariable Long id){
        return ResponseEntity.ok(userService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        userService.update(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
