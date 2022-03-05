package dio.gft.padraodeprojeto.model;

import dio.gft.padraodeprojeto.enums.PersonType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    private Address address;

    @CPF@CNPJ
    @Column(nullable = false, unique = true)
    private String document;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
