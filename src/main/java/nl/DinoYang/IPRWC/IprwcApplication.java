package nl.DinoYang.IPRWC;

import nl.DinoYang.IPRWC.Config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class IprwcApplication {

    public static void main(String[] args) {
        SpringApplication.run(IprwcApplication.class, args);
    }

}
