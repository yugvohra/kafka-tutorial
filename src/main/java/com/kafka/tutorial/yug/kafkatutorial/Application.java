package com.kafka.tutorial.yug.kafkatutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SuppressWarnings("squid:S1118")
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class Application {
  /**
   * Main function for run server.
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    System.out.println("testing deployment");

  }
}