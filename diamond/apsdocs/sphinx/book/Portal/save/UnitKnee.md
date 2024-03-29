
How do you compute the optimal purchase quantity, and manufacturer?

## Alerts 

* De-expedite

* Expedite

* Cancel Purchase Order

* Obtain a secondary CofC for existing inventory

* Transfer inventory

## Financial

#. How are cost of goods registered in the General Ledger?

* Actual Lot Cost

* FIFO

* LIFO

* Weighted Average Cost

#. How is inventory valued?

* Actual Lot Cost

* Weighted Average Cost

* Replacement Cost


## Questions

#. How many buyers are there?

#. How many purchase orders are created per year?

#. How much time does it take to create a purchase order?

   #. Gather the information

      * Onhand Inventory
     
      * Sales History

      * Sales Forecast

      * Forecast Consumption

      * Approved Manufacturers

      * Vendor Quotes

      * Existing Purchase Orders

    #. Vendor Quotes

       * Get quotes for the parts

       * Compute Optimal Replenishment Quantity (Not Economic Order Quantity)

       * Create a requisition

   #. What are the requisition review requirements?
   
      * When is a requisition subject to review?

      * What are the needs additional work conditions?

        * Need more vendor quotes

        * Need work on equivalent parts

        * Incorrect buy quantity

        * Get existing inventory certified.

## Metrics

   #. How are buyers evaluated

   #. How is vendor online performance evaluated

   #. How is Align SLA performance evaluated?

# Requirements

There is a huge amount that can be done but a specification has not been articulated.

Concepts must be articulated.

## Simple Example

During one of my calls with Peter he told me that he was reviewing purchase orders a simple line such as 
"Buyers don''t buy the correct quantities to get a good price" was extended to:

### Compute Optimal Purchase Quantity

Compute a projected per unit cost by solving the equation

unit_cost = (setup_cost / qty) + incremental cost

For two different known qty and prices (vendor quotes) using linear algebra

### Graph this relationsihip

Find the "price knee" the first derivative of the function, the slope of the tangent 
starts to level off (it asymptotically approaches 0, meaning the limit is the unit cost
doesn''t decrease at all. Depending on setup cost, incremental cost and annual consumption 
a three year supply may be ten percent more than a one year supply, it may also be 
three times the acquisition cost and additional carrying costs must be considered.

Vendor quotes should include this range of quantities, purchasing quantities should
be in this range, buys can be made and even scheduled so that lower per unit costs
can be realized.

## Purchasing Procedures

When a part needs to be replenished

#. Vendor quotes for the price range should be required.
#. Purchase amounts over a defined limit should be reviewed and approved.
#. Requisitions should be created in the new purchase decision application and once approved, be 
created as purchase orders in the execution system (Dymax and SAP).
#. Checks for any constraints including approved manufacturers should be simulated
#. Existing inventory carried under equivalent part numbers should be considered.

The opportunities for process improvement are best addressed by evaluating your current processes
and the issues your experts realize and developing a system to address those issues.

## Constraints

Your new process should:

#. Be external to SAP and Dymax, requiring no modifications to either system.  This eliminates risk and
complexity.
#. Should include data from both operations for inventory, purchases and demands
#. Incorporate new procedures and policies to reflect best practices
#. Reduce the effort of sales staff and purchasing staff to perform their functions
#. Define metrics to evaluate performance and progress
#. Have an alert system of reports of issues that need to be addressed.
#. Require no hardware or other infrastructure or the installation of any software on any Align computer.

# Questions

What is the current cost of:

#. Not buying the correct quantities
#. Not taking into consideration multiple certifications
#. Buying inventory in one operation that is excess inventory in the other operation
#. Time wasted gathering information to create a purchase order

# Conclusion

Align has the expertise in house to participate in the design of a business process and software
to optimize the purchasing and sales operations, there is no need to wait for an IT person who
has much less experience than your director of purchasing and other operations personnel.

A one hour phone call every two weeks is not going to ever get you a design.

I have no doubt that several times every day a sub-optimal purchase results in a expense greater than
the cost of developing a design.

A design is best done by whiteboard meetings, starting with a blank whiteboard.  Even with 25 years 
experience in Aerospace, it would be presumptious, and flat out wrong for me to give a powerpoint 
presentation and say "This is the universal answer to all problems, it will fit your situation"; this
is the approach of someone hawking software.

# Proposal 

## Extract the following inforation from Dymax and SAP

### Planning Control Data

### Planning Group Data

  * Supply

    * Types
    
        * Onhand

        * Purchase orders

        * Work Orders

    * Certifications 

    * Item Certifications

  * Demands
 
    * Sales History

    * Open Demands

      * Types

          * Forecast
  
          * Safety Stock

          * Customer Orders 

          * Work Orders

      * Demand Certs

   * Item information
 
     * Item Master

     * Substitutes and Equivalents

     * Forecasting entitities

   * Customer Information

     * Customer Master
 
     * Forecast group

     * Approved Manufacturers

   * Rules

     * Sourcing Rules

     * Supply Pools

# System will produce

  * Projected Position

  * Expedite
 
  * De-expedite

  * Requsitions

  * Unallocated Demand

  * Unallocated Supply

  * Allocations

  * Detailed explanation of why a supply was ineligible for a demand

  * Allocation based pricing

  * Work order generation

  * Exception Reports


  Allow simulations

