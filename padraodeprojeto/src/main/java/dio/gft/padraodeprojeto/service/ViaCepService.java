package dio.gft.padraodeprojeto.service;

import dio.gft.padraodeprojeto.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    //@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")  // OU
    @GetMapping("/{cep}/json/")
    Address consultarCep(@PathVariable("cep") String cep);
}
