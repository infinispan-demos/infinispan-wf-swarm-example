package com.example.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.infinispan.Cache;

@ApplicationScoped
public class CacheService {

   @Inject
   Cache<String, String> testCache;

   public void addToCache(String text) {
      testCache.put(text, text);
   }

   public Object getContent() {
      return testCache.toString();
   }
}
