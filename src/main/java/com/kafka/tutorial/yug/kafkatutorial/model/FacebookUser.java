package com.kafka.tutorial.yug.kafkatutorial.model;

import lombok.Value;

/**
 * Created by vohray on 6/26/18.
 */
@Value
public class FacebookUser {
  private String userId;
  private String userName;

  public static FacebookUser getDefaultUser() {
    return new FacebookUser("yug.vohra.9", "yug.vohra");
  }
}
