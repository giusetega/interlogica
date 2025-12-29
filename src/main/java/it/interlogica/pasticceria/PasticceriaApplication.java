package it.interlogica.pasticceria;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@SpringBootApplication
@Slf4j
public class PasticceriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasticceriaApplication.class, args);
	}

	@Bean
	public String saveImages() throws IOException {

		File dir = new File("static/images");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				log.info("Child: " + child.getName());
				File targetFile = new File("static/tmp/" + child.getName());
				Files.copy(child.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				log.info("Finish to copy : " + child.getName());
			}
		} else {
			log.info("Some problems with copying images");

		}
		return null;
	}

}
