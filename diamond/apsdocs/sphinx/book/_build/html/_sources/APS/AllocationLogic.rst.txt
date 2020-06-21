Allocation Logic
================

Modes
-----
Allocation has different behavior based on the allocation mode. The
aerospace planning implementation supports four phases each with a
different mode.

Phases
-----

Pick Restore
************

Existing allocations to onhand inventory from work orders or customer
orders that are in pick status are preserved.

This Mode is also used in binding allocations.

An allocation is bound by updating the alloc\_type\_id to ’R’ and
requesting the engine to bind the allocation. The alloc\_type\_id is
then set to ’B’ for Bound.

First Pass
**********

Customer Prioritized
********************

Overship
********

The request for Overship is used when variations in the requested ship
quantity are supported. For example a customer orders 1000 washers,
after the picker picks the order there are only 10 washers left in the
box. If the customer allows over shipping then 1010 washers will be
picked for his order as it is not worth the time to put 10 washers back
in the box and put them away.

The overship phase ensures that the 10 washers are not needed by another
demand and changes the

Restore Onhand Pick Allocations
-------------------------------

Bound Allocations
-----------------
