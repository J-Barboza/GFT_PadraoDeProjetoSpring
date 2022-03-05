package dio.gft.padraodeprojeto.service;

import dio.gft.padraodeprojeto.model.User;

public interface UserService {

    Iterable<User> searchAll();

    User searchById(Long id);

    void insert(User user);

    void update(Long id, User user);

    void delete(Long id);
}
