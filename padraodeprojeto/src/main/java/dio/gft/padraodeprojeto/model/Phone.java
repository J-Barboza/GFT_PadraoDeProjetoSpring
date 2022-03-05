package dio.gft.padraodeprojeto.model;

import dio.gft.padraodeprojeto.enums.PhoneType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
