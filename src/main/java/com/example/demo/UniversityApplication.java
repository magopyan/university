package com.example.demo;

import com.example.demo.gui.StartPage;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SpringBootApplication
public class UniversityApplication {
	public static void main(String[] args) {
	SpringApplication.run(StartPage.class, args);
	}
}
