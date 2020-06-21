# Rightangle

## Site Overview

### Home Page
The initial page will be a portal, with summary information and links to
detailed reports.

*Various alert conditions*

* Items with shortage within lead time
* Items that need certifications to an alernate part number
* Items that have imbalanced supply pools
* Item that have over 3 years supply
* Items that need Vendor Quotes
* Requisitions that need approval
* Item Lead Time Not consistent with Quoted Lead Times
* Item Standard Cost not consistent with Quoted Costs
* Significant rise in quoted cost

etc

## Functionality
The user, with the appropriate roles (permissions) can:

#. Quote Prices to Customers
#. Request Vendor Quotes
#. Convert Vendor Quote to Requisition
#. Review Requisitions
#. Approve Requisitions
#. Review prior customer quotes
#. Simulate changes
* Sourcing Rules
* Supply Pool Movements
*  Multiple Certifications
####  Facility Transfers

## Planning Page

The planning page is in three accordion sections:

Clicking on an *accordian* section header will toggle the display of the underlying associated division.

### Filter
Specify the filters for items to be viewed.

One also specifies the initial perspective for the detail view.  Perspectives
include:

* Purchasing
* Planning
* Sales

### List of Filtered Items
Listing of items that meet the filter criteria

### Detail
The detail for a given item selected from *List of Filtered Items*



## TODO

There should be one commit per task.  

Get accordians working, make a commit, unrelated changes 
should not be in this commit.


### Accordian 

http://training.fabiobiondi.io/2017/07/10/create-an-accordion-component-in-angular-parent-children-communication/

The accordian script runs before the dom is populated so it is not setting
anything. This is not angular compatible.

Should use Angular material design for accordians

### List of Values


There is a list-of-values component and a
services/ApsDataServices.  

A call to ApsDataServices.getListOfValues(queryName:string) 
will return mock data I have a REST service that returns this data

Component aps-query LOV buttons should create a modal ListOfValues from which a value is selected.

This should pop up a modal, populated by the result of the 
appropriate call to *getListOfValues*.  This model should have 
a filter text box to narrow down the choices and one row should be
selected and returned, with the invoking object value 
populated by the ListOfValues.code 

Precision determine scale factor for a part and show accordingly.  For example eaches should not have a decimal portionr_filters.asp

## TODO - JJS

### Appropriate precision for quantities
Precision determine scale factor for a part and show accordingly.  For example
eaches should not have a decimal portion

###  Forecast Group Filters
Only unconsumed forecast should be shown

Others should be revealed when the appropriate box is checked

### Missing Sections

#### Supplies
##### Onhand 
##### Purchase Orders

#### Demands 
1#### Customer Orders
2. Forecasts
3. Work Ord
4. Supply P
5. Projected Inventory Position
6. Attribute Certs
7. Approved Manufacturers
8. Substitutes
9. Sourcing Rules
10. Supply Pools
11. Projected Inventory Position
#. Allocations To Demand
#. Unapproved Supply Reasons
#. Recommendatios
#. Transfers
#. Customer Quotes
#. Vendor Quotes


## Hierarchy

app
    aps-portal
    aps-query
    aps-plan-group
        app-ic-item-masts
        app-aps-pipeline
        app-aps-forecast-group

list-of-values
./src/app/aps-pipeline/plan.html
./src/app/aps-vendor-quote/aps-vendor-quote.component.html
./src/app/aps-buy-price-qty/aps-buy-price-qty.component.html

