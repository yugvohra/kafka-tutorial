package com.kafka.tutorial.yug.kafkatutorial.model;

import lombok.Value;
import org.springframework.social.facebook.api.Post;

import java.util.Date;

/**
 * Created by vohray on 6/23/18.
 */
@Value
public class KafkaFacebookMessage {

  private String userId;
  private String userName;
  private Date postedDate;
  private String message;

  public static KafkaFacebookMessage fromAPost(Post aPost) {
    if (aPost.getAdminCreator() == null)
      return fromAnAuthenticatedUserPost(aPost, FacebookUser.getDefaultUser());
    return new KafkaFacebookMessage(aPost.getAdminCreator().getId(), aPost.getAdminCreator().getName(), aPost.getCreatedTime(), aPost.getMessage());
  }

  private static KafkaFacebookMessage fromAnAuthenticatedUserPost(Post aPost, FacebookUser anAuthenticatedUser) {
    return new KafkaFacebookMessage(anAuthenticatedUser.getUserId(), anAuthenticatedUser.getUserName(), aPost.getCreatedTime(), aPost.getMessage());
  }

}
