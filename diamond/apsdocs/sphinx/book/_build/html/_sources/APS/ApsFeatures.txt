ApsFeaturesBook
===============

-  Describe Boeing Airworthy certificate.

Challenges
----------

Certification of Compliance
---------------------------

Many aerospace parts are specified by engineering drawings and may be
manufactured by a wide variety of companies. These companies may issue a
*Certificate of Compliance* that attests that the parts satisfy the
requirements set forth by the drawing issuer.

Examples of drawing issuers are

-  AN - Army/Navy

-  MS - Millspec

-  NAS -

Drawing Issuers
~~~~~~~~~~~~~~~

A given physical piece may actually satisfy requirements for many
different parts. An example is a cadmium plated steel flat washer for a
3/16 inch screw.

-  Material: Steel

-  Screw Size: 3/16 / #10

-  Outside Diameter: .438 Inches

-  Inside Diameter: .203 inches

-  Thickness: .063 inches

Part Names
----------

A part may be known by more names than the drawings specify. Diamond is
able to identify the part by any of these naming conventions.

#. Vendors may have their own names

#. Customers may have there own names

#. Your organization may have yet another name

#. Engineered part name

::

    NAS1149F0363P
    910C331-10
    AN960-10

-----------------------


- Part Traceability

- Approved Manufacturers by Part

- Approved Manufacturers by Customer

- Lot Level Costing

- Customer Specific Inspection

- Revision Levels

Part Names
----------

A part may be known by more names than the drawings specify. Diamond is
able to store and identify the parts by any of these naming conventions

Certifications
--------------

Complete support for item certifications


Expiration Date, Cure Date
--------------------------

Support for Cure Date, Expiration Date and


Simplify
--------

Supply Pools
------------

Supply pools support logical separation of inventory to facilitate
availability to demand Supply Pools are location independent A pool may
be consignment or buyback inventory Pools and locations form the basis
of “Supply Prioritization”

Sub Pools
---------

Sub pool types: 

-  Consignment 
-  Buyback 
-  Vendor Stock 
-  General

Sourcing Rules
--------------

Sourcing Rules are used to determine which supply is given to a given
demand and in what order to prioritize the supplies Supplies include
On-Hand Inventory, Purchase Orders and Work Orders Each Supply Type for
every Supply Pool where it may exists is given a priority within a
sourcing rule Can be used to segregate consignment and buyback inventory
by including them only in the sourcing rules for customers who are
eligible to consume it. Is also used to identify the facility and the
supply pool where work orders should be automatically created if needed
to satisfy any open demand

Multiple Certifications
-----------------------

The manufacturer Certificate of Compliance to which a given receiver is
qualified is explicitly tracked The part is visible through all parts to
which it is certified or equivalent Purchasing supports explication of
each part to which the inventory should be certified Inspection
validates that purchasing requirements are fulfilled



Bound Allocations
-----------------

Allocations may be “bound.” This ensures that demand supply
prioritizations are not changed Allocations may be bound to incoming
facility transfers Allocations may be bound to Purchase Order Schedules
which is then transferred over to On-Hand Inventory when it is received

Introduction
------------


Features
--------

-  Simultaneously supports interactive and batch mode planning

-  Generates work orders for kits, assemblies and ???

-  Supports Engineered Parts, a single item may simultaneously have
   multiple part numbers

-  Allocation Based Pricing

Demand Types
------------

Customer Orders
---------------

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
------------

Forecasted Demand
-----------------

Diamond provides a statistical forecasting model that forecasts demand
based on historical consumption. The planning module is agnostic with
respect to the source of the forecast and any forecast system may be
used.

Work Orders
-----------

Work orders may take the form of kits, assemblies or rework.

Supply Types
------------

On hand inventory
-----------------

Onhand inventory includes inventory in transit to another warehouse and
considers the availability date the time it will take to ship, receive
and putaway the inventory.

Replenishments
--------------

A replenishment is additional inventory coming from an external source.
This may be the result of a purchase order or anticipated receipt of
buyback ??? or consignment inventory.

Work Orders
-----------

A work order is used to designate a part which has components, such as
kits, assemblies and parts that require transformation to convert them
to another part.

A zinc plated bolt may be converted to a nickel plated bolt by stripping
the zinc, copper plating and then nickel plating. Each such operation
may have a yield of less than 100

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





Certification of Compliance
---------------------------

Many aerospace parts are specified by engineering drawings and may be
manufactured by a wide variety of companies. These companies may issue a
*Certificate of Compliance* that attests that the parts satisfy the
requirements set forth by the drawing issuer.

Examples of drawing issuers are

-  AN - Army/Navy

-  MS - Millspec

-  NAS -


Attribute Certification
-----------------------



Approved Manufacturers by Part
------------------------------

Approved Manufacturers by Customer
----------------------------------


Revision Levels
---------------


Certifications
--------------

Complete support for item certifications

Revision Levels
---------------

Complete support for Revision Level Hierarchy

Expiration Date, Cure Date
--------------------------

Support for Cure Date, Expiration Date and

Cure Date

Country of Origin
-----------------

Revision Levels
---------------

Revision Levels may be specified on the demand Supports superceding
revision levels, if a higher level revision satisfies lower level
revision requirements, the higher level revision is automatically
eligible


Sourcing Rules
--------------

Sourcing Rules are used to determine which supply is given to a given
demand and in what order to prioritize the supplies Supplies include
On-Hand Inventory, Purchase Orders and Work Orders Each Supply Type for
every Supply Pool where it may exists is given a priority within a
sourcing rule Can be used to segregate consignment and buyback inventory
by including them only in the sourcing rules for customers who are
eligible to consume it. Is also used to identify the facility and the
supply pool where work orders should be automatically created if needed
to satisfy any open demand

Multiple Certifications
-----------------------

The manufacturer Certificate of Compliance to which a given receiver is
qualified is explicitly tracked The part is visible through all parts to
which it is certified or equivalent Purchasing supports explication of
each part to which the inventory should be certified Inspection
validates that purchasing requirements are fulfilled

Revision Levels
---------------

Revision Levels may be specified on the demand Supports superceding
revision levels, if a higher level revision satisfies lower level
revision requirements, the higher level revision is automatically
eligible

Eligible Supply
---------------

Approved Sources Equivalent Parts Buyback and Consigned Inventory
Inventory Pooling Manufacturer Certificate of Compliance Customer
Substitutes Global Substitutes Geographic Inventory Locations Revision
Levels


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

Approved Manufacturer
---------------------

A customer may define a *white list* or *black list* of manufacturers by
part.

Buyback
-------

Buyback inventory is purchased by a distributor from a customer and may
be sold back to that customer even in the absence of complete
traceability in the hands of the distributor.

Certifications
--------------

Certifications can assume arbitrary meanings.

Examples of Certifications include for example only

-  Manufacturer Certificate of Compliance

-  ??? list additional

-  Manufacturer Certificate of Compliance

Consignment Inventory
---------------------

Consignment inventory

Contract Aerospace
------------------

Country of Origin
-----------------

A demand may specify that the supply must be from a specified country. A
filter exists to enforce this requirement.

Equivalency
-----------

Equivalency is defined as a part number that complies with the
engineering specification for another part. Although an equivalent part
will not be automatically allocated by the planning engine, suggestions
may be made that a Certificate of Compliance for the lot in question.

Expiry Date
-----------

A demand may explicate the latest date of expiry for the supply. This
filter ensures that the supply complies with the demand minimum
expiration date.

Manufacturer
------------

Explicit Manufacturer
~~~~~~~~~~~~~~~~~~~~~

A given demand may specify that a part must be made by one manufacturer.

Approved Manufacturer
~~~~~~~~~~~~~~~~~~~~~

Customers may be set up with rules for approved manufacturers
inclusively or exclusively.

Lot Date
--------

A demand may have an associated maximum date of manufacture.

Revision Level
--------------
Complete support for Revision Level Hierarchy


Substitutes
-----------

Sourcing Rule
-------------

Sourcing rules

Approved Manufacturer
---------------------

A customer may define a *white list* or *black list* of manufacturers by
part.

Buyback
-------

Buyback inventory is purchased by a distributor from a customer and may
be sold back to that customer even in the absence of complete
traceability in the hands of the distributor.

Certifications
--------------

Certifications can assume arbitrary meanings.

Examples of Certifications include for example only

-  Manufacturer Certificate of Compliance

-  ??? list additional

-  Manufacturer Certificate of Compliance

Consignment Inventory
---------------------

Consignment inventory

Contract Aerospace
------------------

Country of Origin
-----------------

A demand may specify that the supply must be from a specified country. A
filter exists to enforce this requirement.

Equivalency
-----------

Equivalency is defined as a part number that complies with the
engineering specification for another part. Although an equivalent part
will not be automatically allocated by the planning engine, suggestions
may be made that a Certificate of Compliance for the lot in question.

Expiry Date
-----------

A demand may explicate the latest date of expiry for the supply. This
filter ensures that the supply complies with the demand minimum
expiration date.

Manufacturer
------------

Explicit Manufacturer
~~~~~~~~~~~~~~~~~~~~~

A given demand may specify that a part must be made by one manufacturer.

Approved Manufacturer
~~~~~~~~~~~~~~~~~~~~~

Customers may be set up with rules for approved manufacturers
inclusively or exclusively.

Lot Date
--------

A demand may have an associated maximum date of manufacture.

Revision Level
--------------

Substitutes
-----------

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

Certifications
--------------

::

    8130/MCC BOEING 8130 OR MCC
    AIRLREL  AIRLINE RELEASE CERTIFICATE
    AIRWORT  AIRWORTHINESS CERTIFICATE
    ANODRIVT ANODIZED BOEING RIVETS
    CERTBAC  CERTIFIED BY BOEING CORP
    CHEMTEST CHEMICAL TEST REPORTS
    CLASS3IN CLASS3 INSPECTION REQUIRED
    CPT      Certificate Of Proof Test
    D590BAC  D590 Parts
    DFARS    Material Compliance With Military Requirements (DFARS)
    DSQAR    Delegated Supplier QA Representative
    LINKCERT LINKED ALL CERTIFICATES
    MATRCERT RAW MATERIAL TEST REPORTS
    MFGCOFC  Manufacturer Certificate Of Conformance
    MFR-FAI  Manufacturer's FAI
    MILSPEC  MIL SPEC DOCUMENTATION
    MISSTEST missing performance test
    PHYTEST  PHYSICAL TEST REPORTS
    PLATCERT PLATING CERTIFICATE
    PPAPCERT PPAP CERTIFICATION
    PROCESS  PROCESS CERT FOR PATCH
    REPAIRPN Item that is repaired
    ROHS     RoHs Compliant
    VENDCERT VENDOR CERTIFICATE
    
Kitting
-------
