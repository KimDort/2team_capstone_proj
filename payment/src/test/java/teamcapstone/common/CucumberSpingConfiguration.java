package teamcapstone.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import teamcapstone.PaymentApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { PaymentApplication.class })
public class CucumberSpingConfiguration {}
