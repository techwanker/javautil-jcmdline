Components and Services
=======================

Planning Machine
----------------
The **Planning Machine** is the high level component that creates and manages all other components.

Populate Planning Data
**********************
Populates the request queue for all parts with supply or demand.

May invoke :ref:`_ComponentsAndServices_PlanningGrouper`

.. _ComponentsAndServices_PlanningGrouper:



Planning Grouper
----------------
The **Planning Grouper** creates planning groups, items that must be planned simultaneously due
to the fact that these parts are

- equivalent
    If one part can be certified to be another part, they are equivalent, but this is not necessarily
    bi-directional. That is part-a may be certifiable to be a part-b but part-b may not necessarily 
    be certifiable to be a part-a
    
- substitutes
    - customer substitutes
    - global substitutes
- 


Dispatcher
----------
    The **dispatcher** returns a list of items that comprise a planning group.  The dispatcher may      create a planning engine or be invoked from a planning engine.

Planning Engine
---------------

A Planning Engine generates allocations, which are associations of
demand and supply

Get Items to Plan
*****************

May be in a planning group, but retrieving items that are not is also a
lot faster.



Plan Phases
***********

Preserve Allocations
&&&&&&&&&&&&&&&&&&&&

Allocations that are in pick may not be updated.

Bound allocations must be preserved.

First Pass
&&&&&&&&&&

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
