package com.kafka.tutorial.yug.kafkatutorial.dto;

import lombok.Value;

/**
 * Created by vohray on 6/23/18.
 */
@Value
public class Message {

  private final String id;
  private final String userId;
  private String message;
  private String postedDate;
}
