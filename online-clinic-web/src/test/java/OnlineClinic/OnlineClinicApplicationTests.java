package OnlineClinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootApplication
@ExtendWith(SpringExtension.class)
@SpringBootTest
class OnlineClinicApplicationTests {

	@Test
	void contextLoads() {
	}

}
//https://www.baeldung.com/spring-boot-unable-to-find-springbootconfiguration-with-datajpatest
//https://www.baeldung.com/junit-5-runwith