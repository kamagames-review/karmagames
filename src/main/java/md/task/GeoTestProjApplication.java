package md.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration

public class GeoTestProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoTestProjApplication.class, args);
	}
}
