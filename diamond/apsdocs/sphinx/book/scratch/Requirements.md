# Planning Requirements

## Objectives

#. Maximum buyer productivity
#. Eliminate unnecessary purchases
#. Develop a standardized methodology for buyers that is deterministic, with the same input two buyers should come to the same conclusions.
#. Buyers should be able to test the results of a simulation by, for example adding a secondary manufacturer CofC to a lot and replan the part and get the answer back within a second with a new single screen.
#. All scenarios should be stored with the results.
#. Upon acceptance of a scenario the simulation changes should be reported so 
that the source systems can be update.
#. Status of simulation changes
   # Requested
   # Not possible - stops further recommendations to take this action
   # Active - Once a download from the source system reflects this change
#. A report of requested modification not yet completed on source systems
   


## Purchasing Operational Efficiency

### Purchasing Review Board
   Requisitions may be reviewd by the purchasing review board
   * Approval
   * Disapproval  
     * Record disapproval reason for requisitions
       Purchasing review board can select (or create and select) a reason such
as   
       * Review equivalent parts
       * Is onhand under another part
       * insufficient quotations (other vendors may have lower costs)

### Speed up quotations
   * Automatically email vendors request for quotations 
   * Automated quote response
     have the vendors provide a CSV, JSON or XML file with the quote to be
   * automatically uploaded to the system.
   
   For example a vendor could create a spreadsheet with the following columns

   * item_cd
   * quantity
   * manufacturer
   * price 
   * available date
  
   by emailing to quotes@yourco.com these quotes can be automatically loaded
into the system without changes to the legacy system,     

### Buyer information

The buyer should have single screen that shows:

#. Supplies

  #. On hand

  #. Open Purchase Orders

  #. Open Work Orders

#. Demand 

  #. Forecasted
    
    #. Raw

    #. Consumed

    #. Unconsumed

  #. Safety Stock

  #. Work Orders

#. Reserved Inventory

  #. Quarantined

  #. Restricted access (JIT programs, Committed Service Level Agreement Plans)

#. All part numbers in the planning group  

  #. Every part and all equivalents, transitively, that is the equivalents to those equivalents until exhausted.

  #. Customer specific substitutions

#. Approved manufacturer matrix
  Customers down the left, manufacturers across the top 

#. Requisitions

#. Supplier on-time historical metrics

#. Supply ineligibility drill-down

#. Vendor Quotes

#. Time phased inventory position, Pipeline (Global, by Facility, by planner)

#. On hand inventory in aggregate with the ability to open details with a single click

#. Sales history for the last three years in multiple dimensions

  #. Time Dimensions include annual, quarterly and monthly

  #. Ability to see by customer 

#. Existing purchase orders

#. Existing facility transfers in process

#. Detailed reason why supplies are not eligible for a demand that is allocated late or short 

#. A matrix of approved manufactures and customers

#. See the part and all transitive equivalent parts

#. Late or short demands


In Diamond this is all done locally in the web browser with no network requests so it is virtually instaneous.

### Recommendations
#. Purchase orders that can be cancelled
#. Get a manufacturer Certificate of Compliance for existing inventory to satisfy a 
requisition with existing inventory
#. Supply prioritization
   Use buyback inventory before using our inventory for appropriate customers
#. Allocation based pricing
#. Items with a shelf life have oldest allocated first
#. Less valuable items are allocated first
   #. Based on Certifications (dual certed parts have more value)
#. Facility Transfer
#. Supply Pool Transfer
#. Expedite or de-expedite a purchase order

### Alerts
  * Obsolete Inventory
  * Expiring Inventory
  * Purchase Exceeding x% of previous maximum unit price
  * Purchase Exceeding x% of previous minimum unit price
  * Purchase of specified dollars not yet approved
   
## Extensibility

   Any component must be easily plugged in with an alternative implementation
   that is compliant with the corresponding interface,

   * Demand Priority
   * Eligibility Requirements
   * Supply Prioritization
     * Lot value determination 
   * Recommendation Handlers for propagating accepted recommendations to source system
   

# Implementation
  
  * Extract necessary data from legacy systems
  * Load into Advanced Planning
  * Augment with necessary but unavailable information 
  * Run a full plan
  * Review recommendations
    * Accept recommendation (must define Action Handlers)
    Reject recommendation (select reason to be persisted across full reloads)

# Modifications
  * All code is in Java supported by Spring with Hibernate for Object Relation Management, these are widely adoped open source solutions
  * Presentation uses the Model, View Controller approach and the model may be exposed as a JavaBean or XML if one prefers to use XSL.
  * Diamond dependencies are all vastly popular open source but it extremely unlikely anyone will have any need to modify anyy of the open source code
  * I have trained non-programmers to modify Diamond in less than a month.
     
## Questions

#. Inventory Restriction 
   #. How do you restrict availability of inventory for special purposes such as
      * JIT contracts
      * Committed Service Level Agreements
      * Kitting and Assembly
   #. Do you have automated approved manufacturer eligibility?
   #. Do you have prioritization for lots with expiry dates?
   #. How do you calculate the residual cost of goods for broker buys for the
   #. Are you exclusively FIFO or do you consider lots that have lower cost that
satisfies the demand (taking into consideration multiple
certifications, incremental cost of Quality Assurance testing and destructive
tests?), etc.?
quantity that exceeds the customer demand?
#.  Quality Assurance
   Do you have a quality assurance program that supports skip lot testing and 
pre-approved lots ( lots that have already passed the QA requirements for a customer should 
receive higher priority for that customer and lower priority 
for others)    
#. What supply eligibility rules do you have?
#. How do you pin an allocation to a demand ?
#. Does your system recommend when alternate availability is preferable to a
pinned allocation?

# Difference from SAP
  #. Diamond client interface is natively HTML5 and all functionality is available in a simple browser, 
whereas SAP has a cludgy interface, the native interface is client-server, a technology that is embarassingly 
old fashioned and the implementation is poor, at best https://help.sap.com/doc/saphelp_nw70ehp1/7.01.16/en-US/4d/aeae42cd7fb611e10000000a155106/content.htm?no_cache=true
 #. There are no exposed transaction codes in Diamond, everything is menu driven, reducing training time and simplifying operation efficiency.
 #. SAP has a proprietary database, HANA
 #. Diamond is not complicated it uses International Standards for everything, and the most widely adopted technologies, there is no dependency on anything proprietary unless the
oracle database is used.



# SAP on the web

* https://www.brightworkresearch.com/sap/2017/11/best-understand-saps-negative-innovation/

* https://boards.straightdope.com/sdmb/archive/index.php/t-509111.html

* https://www.linkedin.com/pulse/who-knew-sap-could-so-complicated-heather-peyton/
* "We are nowhere near best-in-class, but we are making progress," says Steve Rogers, UK managing director of SAP to an audience of his customers at the German applications firm's annual user gathering at the end of last year. It's not the kind of comment that you expect from a senior executive at a leading software firm. 

* https://www.thirdstage-consulting.com/lessons-from-an-sap-failure-at-lidl/

* https://www.360cloudsolutions.com/top-six-erp-implementation-failures/

* https://www.brightworkresearch.com/saphana/2017/06/22/hana-big-data-equals-big-failure/

