package org.infinispan.wfswarm.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

@ApplicationScoped
public class InfinispanConfiguration {

   @Produces
   @ApplicationScoped
   public EmbeddedCacheManager cacheManager() {
      GlobalConfigurationBuilder cacheManagerConfiguration = new GlobalConfigurationBuilder();
      cacheManagerConfiguration.globalJmxStatistics().allowDuplicateDomains(true).enable();
      cacheManagerConfiguration.transport().defaultTransport();

      ConfigurationBuilder cacheConfiguration = new ConfigurationBuilder();
      cacheConfiguration.clustering().cacheMode(CacheMode.DIST_SYNC);

      return new DefaultCacheManager(cacheManagerConfiguration.build(), cacheConfiguration.build());
   }

}
