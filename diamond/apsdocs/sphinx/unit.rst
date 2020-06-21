Compute Optimal Purchase Quantity
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

During one of my calls I was told was reviewing
purchase orders a simple line such as "Buyers don''t buy the correct
quantities to get a good price" was extended to:


Compute a projected per unit cost by solving the equation

unit\_cost = (setup\_cost / qty) + incremental cost

For two different known qty and prices (vendor quotes) using linear
algebra

Graph this relationsihip
~~~~~~~~~~~~~~~~~~~~~~~~

Find the "price knee" the first derivative of the function, the slope of
the tangent starts to level off (it asymptotically approaches 0, meaning
the limit is the unit cost doesn''t decrease at all. Depending on setup
cost, incremental cost and annual consumption a three year supply may be
ten percent more than a one year supply, it may also be three times the
acquisition cost and additional carrying costs must be considered.

Vendor quotes should include this range of quantities, purchasing
quantities should be in this range, buys can be made and even scheduled
so that lower per unit costs can be realized.

Purchasing Procedures
---------------------

When a part needs to be replenished

#. Vendor quotes for the price range should be required.
#. Purchase amounts over a defined limit should be reviewed and
   approved.
#. Requisitions should be created in the new purchase decision
   application and once approved, be created as purchase orders in the
   execution system (Dymax and SAP).
#. Checks for any constraints including approved manufacturers should be
   simulated
#. Existing inventory carried under equivalent part numbers should be
   considered.

The opportunities for process improvement are best addressed by
evaluating your current processes and the issues your experts realize
and developing a system to address those issues.

