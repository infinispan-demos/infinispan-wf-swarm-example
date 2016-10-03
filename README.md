Introduction
============

This is a quick and dirty Infinispan + Wildfly Swarm demo

How to run it?
==============

use `mvn clean install wildfly-swarm:run`.

How to test it?
===============

Put data into the cache:

```
curl -d "test" http://localhost:8080/rest/infinispan/cache
```

Get data from cache:

```
curl http://localhost:8080/rest/infinispan/cache
```
