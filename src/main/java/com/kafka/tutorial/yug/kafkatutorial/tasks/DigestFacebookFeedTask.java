package com.kafka.tutorial.yug.kafkatutorial.tasks;

import com.kafka.tutorial.yug.kafkatutorial.model.KafkaFacebookMessage;
import com.kafka.tutorial.yug.kafkatutorial.service.FacebookService;
import com.kafka.tutorial.yug.kafkatutorial.service.PublisherService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by vohray on 6/26/18.
 */
@Slf4j
@Value
public class DigestFacebookFeedTask implements Task {

  private final FacebookService facebookService;
  private final PublisherService publisherService;
  private final long sinceInSeconds;

  @Override
  public void execute() {
    PagedList<Post> pagedPosts = facebookService.getFeed(5,sinceInSeconds);
     List<KafkaFacebookMessage> kafkaMessages = pagedPosts.stream().map(KafkaFacebookMessage::fromAPost).collect(toList());
    kafkaMessages.stream().forEach(publisherService::publish);
  }
}

