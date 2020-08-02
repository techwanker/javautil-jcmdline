# Planning Requirements

## Objectives

#. Maximum buyer productivity
#. Eliminate unnecessary purchase
#. Develop a standardized methodology for buyers that is deterministic, with the same input two buyers should come to the same conclusions.

## Buyer information

### Planning Item Screen
The buyer should have single screen that shows

* On hand inventory in aggregate with the ability to open details with a single click
* Sales history for the last three years in multiplee dimensions
  * Time Dimensions include annual, quarterly and monthly
  * Ability to see by customer 
* Existing purchase orders
* Existing facility transfers in process
* Detailed reason why supplies are not eligible for a demand that is allocated late or short 
* A matrix of approved manufactures and customers
* See the part and all transitive equivalent parts
* Late or short demands

## Actions Screen
**************

 

### Support Equivalencies
Must simulataneously 

* plan a part number
* all parts that could be certed to that part
* customer substitutes
* global substitutes

All of these associations must be transitive, if a customer accepts a substitute
for a part all of the equivalents of that part must be planned, etc.

### Support Logical Partitioning of Inventory
Inventory must be able to be logically separated for use for different purposes 
without physically moving any inventory.

Global
------

Must include all requirements for U.S. and French operationns

### Recommendations
#. Purchase orders that can be cancelled
#. Get a manufacturer Certificate of Compliance for existing inventory to satisfy a requisition with existing inventory
#. Supply prioritization
   Use buyback inventory before using our inventory for appropriate customers
#. Allocation based pricing
#. Items with a shelf life have oldest allocated first
#. Less valuable items are allocated first
   #. Based on Certifications (dual certed parts have more value)

###  Foreast

## Conce[ts

### Eqivalent Parts

Two parts are equvilant if either part could received a Certificate of Compliance to be the other part.

There may be demand under one part number and supply under an equivalent part nuber.  Rather than procure additonal of the first part it is may be possible 
to purcase a Certificate of Compliance for the second part, obvioating
the need for additional expenditure.

APS creates a plammimg group and all equivalent parts, transitive equivalencies and customer/global substitutes are simultaneously planned.

### Supply Pools

Inventory is logically separated to be made available to groups of demand
as specified in sourcing rules.

Types include:

   * Regular
   * Buyback
   * Consignment

Different priorities are specified in the sourcing rules.  Supply pools are not location (warehouse, plant, etc) specific.

### Forecast Groups

Each demand is associated with a forecast group.  Forecasts are consumed
accordingly.

### Sourcing Rules

An ordered set of supply pools avaible to a demand.

### Eligibility

In addition to supply pool other constraints include:



### Prioritization

### Simulatiom

