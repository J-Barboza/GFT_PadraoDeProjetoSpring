package dio.gft.padraodeprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.bouncycastle.its.asn1.EndEntityType.app;

@EnableFeignClients
@SpringBootApplication
public class PadraodeprojetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadraodeprojetoApplication.class, args);
	}
}
