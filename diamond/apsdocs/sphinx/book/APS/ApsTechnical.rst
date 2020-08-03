APS Technical
=============

try using aps inventoryForecasting

Requests for Planning
---------------------

Synchronous Requests
~~~~~~~~~~~~~~~~~~~~

Synchronous requests are from the warehousing, work order, customer
order and purchasing systems.

Asynchronous Requests
~~~~~~~~~~~~~~~~~~~~~

Asynchronous requests are for a fully regenerative plan or after
forecasting and forecasting adjustments

Components
----------

Planning Machine
~~~~~~~~~~~~~~~~

Planning Engine
~~~~~~~~~~~~~~~

A thread that performs the actual planning.

It calls the dispatcher to get the items to be planned, invokes the
persistence service to get the data and then calls the persistence
service to store the results.

A Planning Engine generates allocations, which are associations of
demand and supply

Get Items to Plan
'''''''''''''''''

May be in a planning group, but retrieving items that are not is also a
lot faster.

Populate Planning Data
''''''''''''''''''''''

Retrieve Data from Database
'''''''''''''''''''''''''''

Index the data
''''''''''''''

Preserve Allocations
^^^^^^^^^^^^^^^^^^^^

Allocations that are in pick may not be updated.

Bound allocations must be preserved.

First Pass
^^^^^^^^^^

Plan Demands within Lead Time
'''''''''''''''''''''''''''''

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
''''''''''''''''''

Filter Supply
'''''''''''''

Prioritize Supply
'''''''''''''''''

TODO

Execution Mode
''''''''''''''

Supply will be allocated to the latest anticipated receipt prior to
customer request date if the supplier performance warrants it. This
leaves onhand supply available for customers with earlier request dates.

Schedule Optimization Mode
''''''''''''''''''''''''''

Onhand Supply is prioritized over replenishments in order to evaluate
the potential to "push out" replenishments.

Generate Work Orders
''''''''''''''''''''

Generate Reschedules
''''''''''''''''''''

Reschedules are based on the earliest demand date for a non onhand
supply.

If cross facility or cross pool allocations are made, logical or
physical inventory transfer suggestions are made.

Update Data
'''''''''''

Notes
~~~~~

Safety Stock must be allocated

Forecast must be consumed.

Consideration must be given to the fact that work orders may have
customer demand and priority given to allocation to them.

Support for overshipping

Generates Reschedules

Generate log trace xml

Demands within a customer must be prioritized

Work Order Generator
~~~~~~~~~~~~~~~~~~~~

Dispatcher
~~~~~~~~~~

The dispatcher provides the items to be planned in a planning group

Data Services
~~~~~~~~~~~~~

Data services retrieve and update the planning database

Properties and Command Line Arguments
-------------------------------------

leadTimePaddingFactor
~~~~~~~~~~~~~~~~~~~~~

Equivalent Items
~~~~~~~~~~~~~~~~

Two items are equivalent if they have the same form, fit and function
and can be certified to the other.

This is in the case of engineered parts.

Customer Substitutes
~~~~~~~~~~~~~~~~~~~~

Customer substitutes are used when one part may be used in place of
another.

The parts may have identical specifications or just be satisfactory.

For example a police department may need "D" Cell batteries for their
flashlights.

In lieu of customer substitutes a pseudo part can be created.

Global Substitutes
~~~~~~~~~~~~~~~~~~

iimes - (IcItemMastEquivS) cache.get(IcItemMastEquivS.class.getName());
iicss - (ApsCustItemSubstS)
cache.get(ApsCustItemSubstS.class.getName()); aigs
-(ApsItemGlobalSubstS) cache.get(ApsItemGlobalSubstS.class .getName());
