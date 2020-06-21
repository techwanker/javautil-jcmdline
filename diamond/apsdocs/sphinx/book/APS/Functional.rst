Functional
==========

Introduction
------------

Diamond Advanced Planning is a module that associates demand for product
with inventory that satisfies the demand according to pluggable
(“extensible”) filters and

Although it was designed explicitly to accomodate the requirements of
aerospace subsets of its features will readily support virtually any
distribution, MRO or discrete manufacturing environment.

Diamond Advanced Planning was first written in 1983 by the author of
this document and served well in planning for Fine China and giftware.
Same was employed for a clothing manufacturer and subsequently for
Tri-Star Aerospace. In 2001 a total rewrite was effected written in Java
accommodating Aerospace requirements in version 10 of Diamond
Distribution.




Features
--------

-  Simultaneously supports interactive and batch mode planning

-  Generates work orders for kits, assemblies and ???

-  Supports Engineered Parts, a single item may simultaneously have
   multiple part numbers

-  Allocation Based Pricing

-  Complex MRO Kitting TODO link 

Demand Types
------------

Customer Orders
***************

A customer may be an external organization not within the legal
hierarchy of legal entities encompassed by the organization that
provides the planning service or be subordinate to the penultimate
holding company of the organization providing planning. These
relationships have no bearing on the requirement of the planning
organization to fulfill demand in accordance with the contractual rules.

Stated more simply, a customer in the sense of planning is an
organization with a specified set of requirements for the fulfillment of
inventory.

Safety Stock
************

Forecasted Demand
*****************

Diamond provides a statistical forecasting model that forecasts demand
based on historical consumption. The planning module is agnostic with
respect to the source of the forecast and any forecast system may be
used.

Work Orders
***********

Work orders may take the form of kits, assemblies or rework.

Supply Types
------------

On hand inventory
*****************

Onhand inventory includes inventory in transit to another warehouse and
considers the availability date the time it will take to ship, receive
and putaway the inventory.

Replenishments
**************

A replenishment is additional inventory coming from an external source.
This may be the result of a purchase order or anticipated receipt of
buyback ??? or consignment inventory.

Work Orders
***********

A work order is used to designate a part which has components, such as
kits, assemblies and parts that require transformation to convert them
to another part.

A zinc plated bolt may be converted to a nickel plated bolt by stripping
the zinc, copper plating and then nickel plating. Each such operation
may have a yield of less than 100

Rules
-----

Configuration Data
******************

Customer Item Substitutes
&&&&&&&&&&&&&&&&&&&&&&&&&

Global Substitutes
&&&&&&&&&&&&&&&&&&

Replenishment Policies
&&&&&&&&&&&&&&&&&&&&&&

Supply Pool
&&&&&&&&&&&

Inventory may be logically separated by supply pool.

Supply pools may transcend facilities.

Supply Sub Pool
&&&&&&&&&&&&&&&

A sub-pool is subordinate to a supply pool.

Sourcing Rules
&&&&&&&&&&&&&&

A sourcing rule is associated with a supply sub-pool and a facility.

It describes:

- facility
- sub-pool
- supply type
- sourcing priority

Examples
^^^^^^^^
Just In Time
%%%%%%%%%%%%

Kitting MRO
%%%%%%%%%%%

Buy Back
%%%%%%%%

Customeer Item Manufacturer
&&&&&&&&&&&&&&&&&&&&&&&&&&&

Planning Group
--------------

It is posited that no aerospace planning can be of much value in the
absence of planning demand for parts that constitute a planning group,
that is all parts which have the same form fit and function are
interchangeable and those parts which have been previously been approved
by the consumer of said parts as acceptable substitutes for the
specified part.

Interchangeability is defined as the parts being equivalent. A single
part may comply with multiple engineering diagrams and when produced by
a manufacturer of repute acceptable to the consumer and accompanied by a
manufacturer Certificate of Compliance with said diagram, these parts
are considered equivalent even in the absence of aforesaid Certificate,
for often such certification may be purchased from the manufacturer, or
waived by the knowing consumer.

Sourcing Rules
--------------

Eligibility Tests
-----------------

Generally elibility tests may be considered as filters, that is, the
order of the tests is inconsequential and each test may exclude the
supply as being applicable for the demand. On occassion two or more
tests may exhibit characteristics such that the qualification of either
test is sufficient. Consider the case of buyback inventory in which
inventory has been purchased from an airframe manufacturer but
traceability to the ultimate source is not available. The airframe
manufacturer may state that if the inventory was procured from the
manufacturer under certain conditions those parts may bypass
requirements that would otherwise be in place. It is the responsibility
of the kitting or JIT provider to provide traceability back to the
airframe manufacturer without any bearing any responsibility for
ultimate traceability.



Sourcing Rule
-------------

Sourcing rules

Planning Groups
---------------

Aerospace Features
------------------

-  Show which items could obtain certification rather than procure

-  Generate Warehouse Transfers

-  Generate Work Orders

-  Overship Capability

Planning Mode
-------------

Execution Planning Mode
-----------------------

In this mode demand the supply prioritizer gives higher precedence to
the supply associated with delivery most prior to ???

Inventory Planning Mode
-----------------------

Inventory Planning Mode attempts to allocate demand such that on hand
inventory is exhausted, deferring allocation to purchase orders or work
orders to the first available by date. The result of this is that a
reschedule date can be derived from the first requirement date.

Bound Allocations
-----------------

A demand may be bound to a supply. These allocations are restored
foremost in the first pass of allocation. Bound states include

-  R Request

-  B Bound

Logging
-------

All of the decision paths for a planning group are incorporated into a
single logging entity reflecting each of the decisions and
prioritization. This data is persisted in XML, generally in a relational
database.
