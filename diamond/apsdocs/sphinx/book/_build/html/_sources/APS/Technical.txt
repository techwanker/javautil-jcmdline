Technical
=========

Queue Populator
---------------

The queue populator inserts items to be planned into the request queue.

The only implementation at this time is a stored procedure
*APS\_RQST\_QUEUE\_POPULATOR*

Queue Manager
-------------

The queue manager is responsible for managing the queue of items for
which planning has been requested.

The request queue is fully read and Planning Groups are established. The
priority for dispatching is established.

A call to

::

    int[] getPlanningItems()

Will return all of the items in a planning group.

Planning Engine
---------------

The planning engine obtains the identifiers for a set of items to be
planned, either through a pull from the engine to the Queue Manager or
through a push by an invocation of

::

     public void planItems(int[] itemIds)

Populate Data
~~~~~~~~~~~~~

All of the data necessary to plan an item are populated in PlanningData
and inter object references are resolved. Various dimension objects are
populated from the Cache Manager [CacheManager] There are two
implementation of Persistence interface, one which is based on generated
and hand tweaked JDBC and one which is backed by Hibernate, using a few
tweaks to optimize performance.

Planning
~~~~~~~~

Architecture
============

Language
--------

Most of the logic in APS is expressed in Java.

Inversion of Control
--------------------

Interface
---------

::

    package com.dbexperts.diamond.planning;

    public interface PlanningOperation {
            public void process(PlanningData planningData);
    }

Some may object to exposing all of the data available for arbitrary
operations but and

Persistence
-----------

APS employs the DAO paradigm with default implementation for persistence
using Hibernate for Object Relational Mapping.

Planning Data and Related Interfaces
------------------------------------

Planning Modes
--------------

Batch
~~~~~

Batch planning is equivalent to fully regenerative MRP.

When no more items are in the request queue the program terminates.

Interactive
~~~~~~~~~~~

Queue Manager
-------------

The queue manager is responsible for monitoring all of the items in the
request queue and creating a queue of groups of planning items to be
dispatched.

See

CommandLineExecution
--------------------

java com.dbexperts.diamond.cli dataSourceName

TODO should create a big fat jar

in /common/home/jjs/workspace/Diamond11 ./run\_planning

note document EJB3PlanningDataPersistence
