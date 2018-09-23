package com.kafka.tutorial.yug.kafkatutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by vohray on 6/25/18.
 */
@Service
public class FacebookService {
  private final FacebookTemplate facebookTemplate;
  private final ConnectionRepository connectionRepository;

  @Autowired
  public FacebookService(FacebookTemplate facebookTemplate, ConnectionRepository connectionRepository) {
    this.facebookTemplate = facebookTemplate;
    this.connectionRepository = connectionRepository;
  }

  public PagedList<Post> getFeed(int maxNoOfFeeds,long sinceInSeconds) {
    PagedList<Post> feed = facebookTemplate.feedOperations().getFeed(new PagingParameters(maxNoOfFeeds, 0, sinceInSeconds, null));
    return feed;
  }
}
