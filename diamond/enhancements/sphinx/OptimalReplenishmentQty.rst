Optimal Replenishment Quantity
==============================

Overview
--------

Optimal Replenishment Quantity has two contradictory goals

* Larger replenishment quantities may reduce cost per unit if the item is manufactured on 
demand due to the setup cost being apportioned over a smaller number of units.  However,
popular items may be continually produced by a manufacturer or produced in sufficient 
quantities to TODO ameliorate or minimize this.

Larger replenishment quantities reduce safety stock requirements as variations in demand
may be satisfied by working inventory.

Larger replenishment quantities reduce inventory turns.  Inventory turns are defined as
average months supply on hand   / (average monthly consumption * 12).

Higher replenishment quantities may negatively effect cash flow.  If inventory can
be acquired on consignment or larger purchase quantities can be scheduled over several
months with minimal additional per unit cost this effect can be mitigated.  Vendor 
negotiations are required to achieve either objective, vendor incentive may be a commitment
to buy a larger number of parts.

Not to be dismissed lightly is the strange pricing as a part is quoted as a different
part number and a vendor willingness to issue a certificate of compliance for the 
equivalent part or customer willingness to accept an alternate part number.  

Ignorance of equivalent part numbers is common in the industry.  

Although part numbers are specified in engineering drawings vendors and customers may
give different names, including varying use of dashes.  This is addressed in Diamond and
is called *nomenclature*.  Prior deployments have had in excess of one million alternate
names for various parts.  Acquiring this data may be labor intensive with benefits for
Pareto part class ("ABC_CODE") of class "A", the top 20 percent of items based on annual
sales currency.


Let us assume in the interest of simplification a scenario that ignores Approved Manufacturer
constraints, lead times and cash-flow mitigation strategies, such as



Optimal Cash Flow
-----------------

Approaches

Consignment inventory
Scheduled Delivery

Stock outs
----------

Lowest cost
-----------

Compute Optimal Replenishment 
-----------------------------

UC = Unit Cost  : Setup Cost / unit qty + incremental cost

Replenishment Cost = Unit Cost * Unit Qty
AMC Average Monthly Consumption 
AMOH : Average Monthly Onhand  Replen Qty - sum AMC for i (1 : n) < Replen Qt
Replen Qty
Carrying cost = AMOH * COF 
COF : Cost of Funds
Receiving Cost:  Cost to place a purchase order line, receive, putaway and pay an AP line
Risk of Obsolescence :  Fewer customers increases risk amonth other factors, varies over time

Compusting optimal replenishent quantity is straight forward math at this point.

Throw in a maximum outstanding value of new inventory accross ABC Codes and there are judgment calls required.


