package dio.gft.padraodeprojeto.service.implementation;

import dio.gft.padraodeprojeto.model.Address;
import dio.gft.padraodeprojeto.model.AddressRepository;
import dio.gft.padraodeprojeto.model.User;
import dio.gft.padraodeprojeto.model.UserRepository;
import dio.gft.padraodeprojeto.service.UserService;
import dio.gft.padraodeprojeto.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final int CPF_LENGTH = 11;
    private static final int CNPJ_LENGTH = 14;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<User> searchAll() {
        return userRepository.findAll();
    }

    @Override
    public User searchById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void insert(User user) {
        saveUserWithCep(user);
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isPresent()){
            saveUserWithCep(user);
        } else return;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void saveUserWithCep(User user){
        String cep = user.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        user.setAddress(address);
        userRepository.save(user);
    }

}
