package com.kafka.tutorial.yug.kafkatutorial.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * Created by vohray on 8/9/18.
 */
@Component
@Aspect
public class TracerService {


  private HttpHeaders httpHeaders;


  public String getContextHeaders()
  {
    return httpHeaders.toString();
  }

}
