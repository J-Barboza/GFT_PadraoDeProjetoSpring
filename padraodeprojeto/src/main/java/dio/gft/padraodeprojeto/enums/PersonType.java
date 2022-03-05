package dio.gft.padraodeprojeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PersonType {

    FISICA("Física"),
    JURIDICA("Jurídica");

    @Getter
    private String description;

}
