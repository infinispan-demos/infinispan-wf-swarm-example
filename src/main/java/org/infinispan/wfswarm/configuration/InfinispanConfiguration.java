package org.infinispan.wfswarm.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.infinispan.cdi.embedded.ConfigureCache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
public class InfinispanConfiguration {

   @ConfigureCache
   @Produces
   @ApplicationScoped
   public Configuration configuration() {
      return new ConfigurationBuilder()
            .clustering()
            .cacheMode(CacheMode.DIST_SYNC)
            .build();
   }

   @Produces
   @ApplicationScoped
   public EmbeddedCacheManager cacheManager() {
      GlobalConfigurationBuilder cacheManagerConfiguration = new GlobalConfigurationBuilder();
      cacheManagerConfiguration.globalJmxStatistics().allowDuplicateDomains(true).enable();
      cacheManagerConfiguration.transport().defaultTransport();
      return new DefaultCacheManager(cacheManagerConfiguration.build());
   }

}
