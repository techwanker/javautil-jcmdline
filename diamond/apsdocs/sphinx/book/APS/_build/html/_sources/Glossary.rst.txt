Glossary
========

Allocation
^^^^^^^^^^

Allocation Based Pricing
^^^^^^^^^^^^^^^^^^^^^^^^

It is a common practice in the aerospace industry for a distributor to
provide Just-In-Time fulfillment of products under contractual
arrangements. Often the distributor will purchase an airframe supplier’s
inventory and sell it back for cost plus a service fee although other
arrangements are certainly not rare. After the inventory that was
purchased is exhausted additional demand is satisfied by inventory of
the distributor. It is not known at the time the order is placed the
source of the inventory that will be used to satisfy the demand.
Allocation based pricing updates the order line with the appropriate
price and creates sublines if necessary in the case of mixed supply at
different prices.

Approved Manufacturer
^^^^^^^^^^^^^^^^^^^^^
Customers may either "whitelist" or "blacklist" manufacturers.

Bound Allocation
^^^^^^^^^^^^^^^^
An allocation which


Certificate of Compliance
^^^^^^^^^^^^^^^^^^^^^^^^^
See Manufacturer Certificate of Compliance

Country of Origin
^^^^^^^^^^^^^^^^^

Dispatch Group
^^^^^^^^^^^^^^
A set of items that are planned concurrently.

Planning Set
%%%%%%%%%%%%

A planning set is a set of items that must be planned simultaneously

It includes, transitively, 

- Equivalent Parts
- Customer Substitutes
- Global Substitutes



Dispatch Set
%%%%%%%%%%%%

A set of items that are retrieved concurrently from the underlying
datastore for the purpose of improving performance of the persistent
data store. 

Eligible Supply
^^^^^^^^^^^^^^^
For each demand any supply that passes all filters is considered
eligible supply.

Engineered Parts
^^^^^^^^^^^^^^^^

An engineered part is an item produced in compliance with an engineering
drawing. Most everyone is familiar with Stock Keeping Unit or SKU,
usually identified by a UPC (Universal Product Code) or an EAN (European
???).

An engineered part may be produced by a wide variety of manufacturers.

Equivalent Part
^^^^^^^^^^^^^^^

Two parts are equivalent if they could be cross certified.

For example AN960-10 and NAS1149 are very common flat washers and the
former diagrams where drawn by the Army Navy coalition and the latter by
???

These parts are identical, the only difference being whether the
manufacturer has provided a *Manufacturer Certificate of Compliance*.

One of the byproducts of APS is the ability to query for lots which may
be made suitable for the demand by simply buying a *Manufacturer
Certificate of Compliance*, another query will show unsatisified demand
that could be satisfied by changing the requested part to be the
equivalent part which frequently is readily accommodated by the party
that gave rise to the demand.

Forecast Consumption
^^^^^^^^^^^^^^^^^^^^

The process of decreasing Forecasted Demand by the amount of firm
orders.

This is necessary to eliminate “double dipping” requirements for supply.

Forecasting Granularity
^^^^^^^^^^^^^^^^^^^^^^^
Bucketed by week in TMP\_APS\_DMD\_FC\_PRD

Forecast Group
^^^^^^^^^^^^^^

Hard Alloc Fc Within Lead Time
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

APS\_DMD\_FC

In Pick
^^^^^^^

Manufacturer Certificate of Compliance
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

A physical or electronic document issued by the manufacturer of an
engineered part specifying a specific lot or set of lots with assurances
backed solely by the credibility of the manufacturer that the items in
the lot comply with the specifications set forth on the engineering
diagrams for the part.

Manufacturer Lot Code
^^^^^^^^^^^^^^^^^^^^^

A designator assigned by the manufacturer for items produced, generally
on the same machines after setup and demarcated by policies set forth by
the manufacturer which may include quantity produced and machine setup,
internal quality tests and so forth.

Multicerted Item
^^^^^^^^^^^^^^^^

Pre-approved Lot
^^^^^^^^^^^^^^^^

A lot which has been pre-approved by the organization ordering.

This may be the result of quality assurance tests or buyback inventory.

Planning Data
^^^^^^^^^^^^^

Planning Data is the domain of all information necessary to generate a
planning result for a [PlanningGroup] planning group. [PlanningGroup]

Planning Group
^^^^^^^^^^^^^^

A planning group consists of all related items whether by equivalence,
or substitution to arbitrary depths until such relationships are
exhausted. This is performed procedurally in memory as all attempts to
effect this declaratively have resulted in quantitative run times three
or four orders of magnitude greater than object traversal.

Quality Assurance Tests
^^^^^^^^^^^^^^^^^^^^^^^
Lowest cost to incrementally pass quality.

Receiver Number
^^^^^^^^^^^^^^^
A receiver number is created by Diamond Distribution for each unique
manufacturer lot on a shipping manifest.

Therefor it is quite possible that

Safety Stock Consumption
^^^^^^^^^^^^^^^^^^^^^^^^

Substitute Part
^^^^^^^^^^^^^^^

A customer may agree for a substitute for a part when form, fit and
function are satisfied irrespective of whether the part is an engineered
part.

For example ’D’ batteries from Everready and Ray-O-Vac with the same
number of ampere hours.

UPC
^^^


Quality Assurance Tests
^^^^^^^^^^^^^^^^^^^^^^^

