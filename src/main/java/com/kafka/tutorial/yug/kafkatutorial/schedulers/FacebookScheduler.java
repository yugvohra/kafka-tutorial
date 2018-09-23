package com.kafka.tutorial.yug.kafkatutorial.schedulers;

import com.kafka.tutorial.yug.kafkatutorial.service.FacebookService;
import com.kafka.tutorial.yug.kafkatutorial.service.PublisherService;
import com.kafka.tutorial.yug.kafkatutorial.tasks.DigestFacebookFeedTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by vohray on 6/26/18.
 */
@Component
@Slf4j
public class FacebookScheduler {

  private final FacebookService facebookService;
  private final PublisherService publisherService;

  @Autowired
  public FacebookScheduler(FacebookService facebookService, PublisherService publisherService) {
    this.facebookService = facebookService;
    this.publisherService = publisherService;
  }


  @Scheduled(fixedDelay = 50000)
  public void digestFacebookFeed() {
    log.info("running scheduler");
    long oneMinutesAgo=System.currentTimeMillis()/1000-1*60;
    new DigestFacebookFeedTask(facebookService, publisherService,oneMinutesAgo).execute();
  }

}
