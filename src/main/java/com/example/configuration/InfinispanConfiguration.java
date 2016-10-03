package com.example.configuration;

import javax.enterprise.context.ApplicationScoped;

import org.infinispan.cdi.embedded.ConfigureCache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

@ApplicationScoped
public class InfinispanConfiguration {

   @ConfigureCache
   @ApplicationScoped
   public Configuration configuration() {
      return new ConfigurationBuilder().build();
   }

}
