PlanningComponentsPaper
=======================
Planning Machine
----------------

Planning Engine
---------------

A Planning Engine generates allocations, which are associations of
demand and supply

Get Items to Plan
-----------------

May be in a planning group, but retrieving items that are not is also a
lot faster.

Populate Planning Data
----------------------

Retrieve Data from Database
~~~~~~~~~~~~~~~~~~~~~~~~~~~

Index the data
~~~~~~~~~~~~~~

Preserve Allocations
--------------------

Allocations that are in pick may not be updated.

Bound allocations must be preserved.

First Pass
----------

Plan Demands within Lead Time
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

::

    public void allocate() {
    		clear();
    		isDemandsByCustomerValid - false;
    		demandsByCustomer.clear();
    		setPreviousAllocations();
    		restoreOnhandPickAllocations();
    		restoreBoundAllocations();
    		firstPass();
    		
    		computeCustomerSupply();
    		demandS.setCustomerEligibleSupplies();
    		customerPrioritized();
    		if (requestToOverShip()) {
    			overship();
    		}

    	}

Prioritize Demands
------------------

Filter Supply
-------------

Prioritize Supply
-----------------

Generate Work Orders
--------------------

Generate Reschedules
--------------------

Update Data
-----------

Notes
-----

Safety Stock must be allocated

Forecast must be consumed.

Consideration must be given to the fact that work orders may have
customer demand and priority given to allocation to them.

Support for overshipping

Generates Reschedules

Generate log trace xml

Demands within a customer must be prioritized

Planning Dispatcher
-------------------

Planning Grouper
----------------

The planning grouper computes all of the items which need to be planned
concurrently taking into consideration

-  Customer Substitutes

-  Global Substititutes

-  Part Equivalencies
