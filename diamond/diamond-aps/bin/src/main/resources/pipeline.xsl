<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:template match="/">
		<html>
			<!-- https://www.w3schools.com/Css/tryit.asp?filename=trycss_table_responsive -->
			<!-- https://www.w3schools.com/Css/tryit.asp?filename=trycss_table_fancy -->
			<style>
				h1 { 
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 16px; 
				color: #666666
				}
				
				h2 { 
				color: blue; 
				font-family: arial;
				font-size: 14pt 
				}
				
				h3 { 
				color: blue; 
				font-family: arial;
				font-size: 12pt 
				}

				table {
				border-collapse: collapse;
				}
				
				tr:hover {
					background-color: #ddd;
				}
				
				th {
					padding-top: 12px;
					padding-bottom: 12px;
					text-align: left;
					background-color: #4CAF50;
					color: white;
				}
				
				
				th,
				td {
					font-family:
					Helvetica; font-size: 10pt;
					border: 1px solid #ddd;
					padding: 2px;
				}

				tr:nth-child(even) {
					background-color: #f2fff2;
				}

				table.srcRuleSets {
					float:left
				}
				
				table.srcRules {
					float:right
				}
				
				.accordion {
					background-color: #eee;
					color: #444;
					cursor: pointer;
					padding: 18px;
					width: 100%;
					border: none;
					text-align: left;
					outline: none;
					font-size: 15px;
					transition: 0.4s;
				}

				table.defaultNonDisplay {
					display: none;
				}


				.active, .accordion:hover {
					background-color:
					#ccc;
				}

				.panel {
					padding: 0 18px;
					display: none;
					background-color: white;
					overflow: hidden;
				}
			</style>
			<!-- style for dropdown menu -->
			<style>
				/* Add a black background color to the top navigation */
				.topnav {
				background-color: #333;
				overflow: hidden;
				}

				/* Style the links
				inside the navigation bar */
				.topnav a {
					float: left;
					display: block;
					color: #f2f2f2;
					text-align: center;
					padding: 14px 16px;
					text-decoration: none;
					font-size: 17px;
				}

				/* Add an active class to
				highlight the current page */
				.active {
					background-color: #4CAF50;
					color: white;
				}

				/* Hide the link that should open and close the topnav
				on small
				screens */
					.topnav .icon {
					display: none;
				}

				/* Dropdown
				container - needed to position the dropdown content */
				.dropdown {
				float: left;
				overflow: hidden;
				}

				/* Style the dropdown button to fit
				inside the topnav */
				.dropdown .dropbtn {
					font-size: 17px;
					border:
					none;
					outline: none;
					color: white;
					padding: 14px 16px;
					background-color: inherit;
					font-family: inherit;
					margin: 0;
				}

				/* Style
				the dropdown content (hidden by default) */
				.dropdown-content {
					display: none;
					position: absolute;
					background-color: #f9f9f9;
					min-width: 160px;
					box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
					z-index: 1;
				}

				/* Style the links inside the dropdown */
				.dropdown-content a {
					float: none;
					color: black;
					padding: 12px 16px;
					text-decoration: none;
					display: block;
					text-align: left;
				}

				/* Add a dark
				background on topnav links and the dropdown button on
					hover */
					.topnav a:hover, .dropdown:hover .dropbtn {
					background-color: #555;
					color: white;
				}

				/* Add a grey background to dropdown links on hover */
				.dropdown-content a:hover {
					background-color: #ddd;
					color: black;
				}

				/*
				Show the dropdown menu when the user moves the mouse over the
				dropdown button */
				.dropdown:hover .dropdown-content {
				display: block;
				}

				/* When the screen is less than 600 pixels wide, hide all links,
				except for the first one ("Home"). Show the link that contains
				should open and close the topnav (.icon) */
				@media screen and
				(max-width: 600px) {
				.topnav a:not(:first-child), .dropdown .dropbtn
				{
				display: none;
				}
				.topnav a.icon {
				float: right;
				display: block;
				}
				}

				/* The
				"responsive" class is added to the topnav with JavaScript when
				the
				user clicks on the icon. This class makes the topnav look good
				on
				small screens (display the links vertically instead of
				horizontally)
				*/
				@media screen and (max-width: 600px) {
				.topnav.responsive
				{position: relative;}
				.topnav.responsive a.icon {
				position: absolute;
				right: 0;
				top: 0;
				}
				.topnav.responsive a {
				float: none;
				display: block;
				text-align: left;
				}
				.topnav.responsive .dropdown {float: none;}
				.topnav.responsive .dropdown-content {position: relative;}
				.topnav.responsive .dropdown .dropbtn {
				display: block;
				width: 100%;
				text-align: left;
				}
				}

			</style>
			<style>
				.left { float:left; }
				.right { float:right; }
				.eligibleSupply
				{float:right; display:none;}
			</style>
			<script>
				/* Toggle between adding and removing the "responsive" class
				to topnav
				when the user clicks on the icon */
				function myFunction() {
					var x = document.getElementById("myTopnav");
					if (x.className === "topnav") {
						x.className += " responsive";
					} else {
						x.className = "topnav";
					}	
				}
			</script>
			<script>
				function showEligibleSupplyFor(esid) {
					document.getElementById(esid).className = "show";
				}
			</script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<meta name="viewport"
				content="width=device-width, initial-scale=1" />
			<link rel="stylesheet" href="file://w3.css" />
			<!-- TODO this should be frozen to the top of the screen -->

<style>
.filter-table .quick { margin-left: 0.5em; font-size: 0.8em; text-decoration: none; }
.filter-table .quick:hover { text-decoration: underline; }
td.alt { background-color: #ffc; background-color: rgba(255, 255, 0, 0.2); }
</style>
			<BODY>
				<div class="topnav" id="myTopnav">
					<a href="#home" class="active">Home</a>
					<a href="#news">News</a>
					<a href="#contact">Contact</a>
					<div class="dropdown">
						<button class="dropbtn">
							Jump
							<i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<a href="#icItemMasts">Item Masters</a>
							<a href="#pipeline">Pipeline</a>
							<a href="#customerItemManufacturers">Approved Mfrs</a>
							<a href="#apsSrcRuleSets">Sourcing Rules</a>
						</div>
					</div>
					<a href="#about">About</a>
					<a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
				</div>
				<h1>New Pipeline</h1>
				<h2>Forecast Groups</h2>
				<table>
					<tr>
						<th>Forecast Group</th>
						<th>Description</th>
					</tr>
					<xsl:for-each select="/PlanGroup/fcstGrps/fcstGrp">
						<tr>
							<td>
								<xsl:value-of select="./@fcstGrpCd" />
							</td>
							<td>
								<xsl:value-of select="./@fcstGrpDescr" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<h2>Forecast Entities</h2>
				<table>
                    <thead>
					<tr>
						<th>?</th>
						<th>Fcst Master #</th>
						<th>Item #</th>
						<th>Item Cd</th>
						<th>Forcast Group</th>
					</tr>
                    </thead>
                    <tbody>
					<xsl:for-each
						select="/PlanGroup/fcItemMasts/fcItemMast">
						<tr>
							<td>
								<input type="checkbox" />
							</td>
							<td>
								<xsl:value-of select="./@fcItemMastNbr" />
							</td>
							<td>
								<xsl:value-of select="./@itemNbr" />
							</td>
							<td>
								<xsl:value-of
									select="/PlanGroup/icItemMasts/icItemMast[@itemNbr = current()/@itemNbr]/@itemCd" />
							</td>
							<td>
								<xsl:value-of select="./@fcstGrp" />
							</td>
						</tr>
					</xsl:for-each>
                    </tbody>
				</table>
				<!-- item masters -->
				<h2 id='icItemMasts'>Item Masters</h2>
				<div style="overflow-x:auto;">
					<table>
                        <thead>
						<tr align="left">
							<th>Item Nbr</th>
							<th>Part #</th>
							<th>Description</th>
							<th>U/M</th>
							<th align="right">Lead Time - weeks</th>
						</tr>
                        </thead>
                        <tbody> 
						<xsl:for-each
							select="/PlanGroup/icItemMasts/icItemMast">
							<tr>
								<td>
									<xsl:value-of select="@itemNbr" />
								</td>
								<td>
									<xsl:value-of select="@itemCd" />
								</td>
								<td>
									<xsl:value-of select="@descr" />
								</td>
								<td>
									<xsl:value-of select="@stkUm" />
								</td>
								<td align="right">
									<xsl:value-of select="@leadTm" />
								</td>
							</tr>
						</xsl:for-each>
                        </tbody>
					</table>
				</div>
				<!-- todo create equivalent matrix -->
				<!--- attribute certs -->
				<h2>Attribute Certs</h2>
				<table border="1">

                    <thead>
					<tr>
						<th>Cert Code</th>
						<th>Description</th>
						<th>Weight</th>
					</tr>
                    </thead>
                    <tbody>
					<xsl:for-each
						select="/PlanGroup/attributeCerts/attributeCert">
						<tr>
							<td>
								<xsl:value-of select="@cd" />
							</td>
							<td>
								<xsl:value-of select="@descr" />
							</td>
							<td>
								<xsl:value-of select="@value" />
							</td>
						</tr>
					</xsl:for-each>
                    </tbody>
				</table>
				<h2 id="customerItemManufacturers">Customer Approved Manufacturers</h2>
				<table border="1">

                    <thead>
					<tr>
						<th>Customer</th>
						<xsl:for-each
							select="/PlanGroup/customerItemManufacturerRules/cimMfrCds/mfrCd">
							<th>
								<xsl:value-of select="@mfrCd" />
							</th>
							<xsl:variable name="mfrCd" select="@mfrCd" />
						</xsl:for-each>
					</tr>
                    </thead>
                    <tbody>
					<xsl:for-each
						select="/PlanGroup/customerItemManufacturerRules/cimCustCds/custCd">
						<tr>
							<th>
								<xsl:value-of select="@custCd" />
							</th>
							<xsl:variable name="custCd" select="@custCd" />
						<xsl:for-each
							select="/PlanGroup/customerItemManufacturerRules/cimMfrCds/mfrCd">
							<td>
						<xsl:value-of
							select="/PlanGroup/customerItemManufacturerRules/customerItemMfr[@mfrCd=current()/@mfrCd and @custCd=$custCd]/@ruleType"/>
							</td>
							</xsl:for-each>
						</tr>
					</xsl:for-each>
                </tbody>
				</table>
				<!-- buckets -->
				<h2>Pipeline</h2>
				<div style="overflow-x:auto;">
					<table>
						<!-- buckets -->
						<tr align="right">
							<th>Dates yy/mm/dd</th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<th>
									<xsl:value-of select="@nm" />
								</th>
							</xsl:for-each>
						</tr>
						<!-- supply -->
						<tr>
							<th colspan="16" align="left">Supply</th>
						</tr>
						<!-- purchase orders -->
						<tr align="right">
							<th>&#160;&#160;Purchase&#160;Orders</th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Work orders -->
						<tr align="right">
							<th>&#160;&#160;Work Orders</th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='WO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Onhand -->
						<tr align="right">
							<th>&#160;&#160;Onhand </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='OH' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Demand -->
						<tr>
							<th colspan="16" align="left">Demand</th>
						</tr>
						<!-- Customer Orders -->
						<tr align="right">
							<th>&#160;&#160;Customer Orders </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/prioritizedDemands/demand[@type='OO' and @rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Safety Stock -->
						<tr align="right">
							<th>&#160;&#160;Safety Stock </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/prioritizedDemands/supply[@type='SS' and @rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!--Forecast -->
						<tr align="right">
							<th>&#160;&#160;Forecasts</th>
						</tr>
						<xsl:for-each
							select="/PlanGroup/fcItemMasts/fcItemMast">
							<xsl:variable name="currentFcstGrp"
								select="@fcstGrp" />
							<xsl:variable name="currentItemNbr"
								select="@itemNbr" />
							<tr>
								<th>
									&#160;&#160;&#160;
									<xsl:value-of select="@fcstGrp" />&#160; <xsl:value-of select="$currentItemNbr" />
								</th>
								<xsl:for-each select="/PlanGroup/buckets/bucket">
									<td align="right">  <!-- need to check itemNbr TODO -->
										<xsl:value-of
											select="format-number(sum(/PlanGroup/prioritizedDemands/demand[@fcstGrp=$currentFcstGrp and 
										@itemOrdered = $currentItemNbr and
										@type='FC' and @rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
									</td>
								</xsl:for-each>
							</tr>
						</xsl:for-each>
						<!--Forecast -->
						<tr align="right">
							<th>&#160;&#160;Forecast </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/prioritizedDemands/demand[@type='FC' and @rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Work Orders -->
						<tr align="right">
							<th>&#160;&#160;Work Orders </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/prioritizedDemands/demand[@type='WO' and @rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Total Demand -->
						<tr align="right">
							<th>Total Demand </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/prioritizedDemands/demand[@rqstDateBucket=current()/@nm]//@qtyOrd),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Rolling Aggregate -->
						<tr align="right">
							<th>Rolling Aggregate </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Summary -->
						<tr>
							<th colspan="16" align="left">Planning Summary</th>
						</tr>
						<!-- Unallocated -->
						<tr align="right">
							<th>Unallocated </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Projected Position -->
						<tr>
							<th colspan="16" align="left">Projected Position</th>
						</tr>
						<!-- Total -->
						<!-- <projectedPositions> <projectedPosition positionBucket="Past Due" 
							dmdSum="13772.0" splySum="0.0" projPos="-13772.0"/> -->
						<tr align="right">
							<th>Total </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/projectedPositions/projectedPosition[@positionBucket=current()/@nm]//@projPos),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- General -->
						<tr align="right">
							<th>General </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Consignment -->
						<tr align="right">
							<th>Consignment </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Buyback -->
						<tr align="right">
							<th>Buyback </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- Po Resched -->
						<tr align="right">
							<th>Po Resched </th>
							<xsl:for-each select="/PlanGroup/buckets/bucket">
								<td>
									<xsl:value-of
										select="format-number(sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty),'###,###')" />
								</td>
							</xsl:for-each>
						</tr>
						<!-- -->
					</table>
				</div>
				<!-- end of pipelines -->
				<!-- https://stackoverflow.com/questions/6799400/xslt-total-and-subtotal -->
				<h2>Supplies</h2>

				<h3>Onhand</h3>
				<div style="overflow-x:auto;">
					<table>
						<tr>
							<th align="left">ID</th>
							<th>Item Nbr</th>
							<th>Item Code</th>
							<th>Subpool #</th>
							<th>Facility</th>
							<th>Pool</th>
							<th>Subpool</th>
							<th>Lot Cost</th>
							<th>Gross Qty</th>
							<th>Qty Allocated</th>
							<th>Unallocated</th>
							<th>Country</th>
							<th>Cert Value</th>
						</tr>
						<xsl:for-each
							select="/PlanGroup/supplies/supply[@type='OH']">
							<xsl:sort select="@facility" />
							<xsl:sort select="@poolCd" />
							<xsl:sort select="@subPoolCd" />
							<tr>
								<td align="left">
									<xsl:value-of select="@splyXmlId" />
								</td>
								<td align="right">
									<xsl:value-of select="@itemNbr" />
								</td>
								<td align="left">
									<xsl:value-of select="@itemCd" />
								</td>
								<td align="right">
									<xsl:value-of select="@apsSplySubPoolNbr" />
								</td>
								<td align="left">
									<xsl:value-of select="@facility" />
								</td>
								<td align="left">
									<xsl:value-of select="@poolCd" />
								</td>
								<td align="left">
									<xsl:value-of select="@subPoolCd" />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@lotCost, "###,###.00000")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@grossQty, "###,###.00")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@qtyAllocated, "###,###.00")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@qtyUnallocated, "###,###.00")' />
								</td>
								<td align="left">
									<xsl:value-of select="@cntryCdOrigin" />
								</td>
								<td align="right">
									<xsl:value-of select="@certValue" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<h3>Purchase Orders</h3>
				<div style="overflow-x:auto;">
					<table>
						<tr>
							<th align="left">ID</th>
							<th>Facility</th>
							<th>Subpool</th>
							<th>Available Date</th>
							<th>Lot Cost</th>
							<th>Gross Qty</th>
							<th>Qty Allocated</th>
							<th>Unallocated</th>
							<th>Country</th>
							<th>Cert Value</th>
						</tr>
						<xsl:for-each
							select="/PlanGroup/supplies/supply[@type='PO']">
							<tr>
								<td align="left">
									<xsl:value-of select="@splyXmlId" />
								</td>
								<td align="left">
									<xsl:value-of select="@facility" />
								</td>
								<td align="left">
									<xsl:value-of select="@subPoolCd" />
								</td>
								<td align="left">
									<xsl:value-of select="@availDt" />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@lotCost, "###,###.00000")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@grossQty, "###,###.00")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@qtyAllocated, "###,###.00")' />
								</td>
								<td align="right">
									<xsl:value-of
										select='format-number(@qtyUnallocated, "###,###.00")' />
								</td>
								<td align="left">
									<xsl:value-of select="@cntryCdOrigin" />
								</td>
								<td align="right">
									<xsl:value-of select="@certValue" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<!-- Div Demands -->
				<div class="left">
					<h2>Demands</h2>
					Click on a demand to see the eligible supply and allocations.
					<h3>Customer Orders</h3>
					<div style=" overflow-x:auto;">
						<table>
							<tr>
								<th>ID</th>
								<th>Cust Code</th>
								<th>Item Code</th>
								<th>Forecast Group</th>
								<th>
									Requested
									<br />
									Date
								</th>
								<th>Order Qty</th>
								<th>Qty Allocated</th>
								<th>Unallocated</th>
								<th>Country</th>
								<th>Mfr Cd</th>
							</tr>
							<xsl:for-each
								select="/PlanGroup/prioritizedDemands/demand[@qtyOrd != 0 and @type='OO' ]">
								<tr>
									<xsl:attribute name="onClick">showEligibleSupplyFor(&apos;es<xsl:value-of
										select="@dmdXmlId" />&apos;)</xsl:attribute>
									<td>
										<xsl:value-of select="@dmdXmlId" />
									</td>
									<td>
										<xsl:value-of select="@custCd" />
									</td>
									<td>
										<xsl:value-of select="@itemCd" />
									</td>
									<td>
										<xsl:value-of select="@fcstGrp" />
									</td>
									<td>
										<xsl:value-of select="@rqstDate" />
									</td>
									<td align="right">
										<xsl:value-of
											select='format-number(@qtyOrd, "###,###.00")' />
									</td>
									<td align="right">
										<xsl:value-of
											select="sum(eligibleSupply/supply/@allocatedQty)" />
									</td>
									<td align="right">
										<xsl:value-of select="@qtyUnallocated" />
									</td>
									<td>
										<xsl:value-of select="@cntryCdOrigin" />
									</td>
									<td>
										<xsl:value-of select="@mfrCd" />
									</td>
								</tr>
							</xsl:for-each>
							<tr>
								<th colspan="8">Onhand</th>
							</tr>
						</table>
					</div>
					<!-- 
					<h3>Forecasts</h3>
					<div style="overflow-x:auto;"> 
						<table>
							<tr>
								<th>ID</th>
								<th>Cust Code</th>
								<th>Forecast Group</th>
								<th>
									Requested
									<br />
									Date
								</th>
								<th>Order Qty</th>
								<th>Qty Allocated</th>
								<th>Unallocated</th>
								<th>Country</th>
								<th>Mfr Cd</th>
							</tr>
							<xsl:for-each
								select="/PlanGroup/prioritizedDemands/demand[@qtyOrd != 0 and @type='FC' ]">
								<tr><xsl:attribute name="onClick">showEligibleSupplyFor(&apos;es<xsl:value-of
										select="@dmdXmlId" />&apos;)</xsl:attribute>
									<td>
										<xsl:value-of select="@dmdXmlId" />
									</td>
									<td>
										<xsl:value-of select="@custCd" />
									</td>
									<td>
										<xsl:value-of select="@fcstGrp" />
									</td>
									<td>
										<xsl:value-of select="@rqstDate" />
									</td>
									<td align="right">
										<xsl:value-of
											select='format-number(@qtyOrd, "###,###.00")' />
									</td>
									<td align="right">
										<xsl:value-of
											select="sum(eligibleSupply/supply/@allocatedQty)" />
									</td>
									<td align="right">
										<xsl:value-of select="@qtyUnallocated" />
									</td>
									<td>
										<xsl:value-of select="@cntryCdOrigin" />
									</td>
									<td>
										<xsl:value-of select="@mfrCd" />
									</td>
								</tr>
							</xsl:for-each>
							<tr>
								<th colspan="8">Onhand</th>
							</tr>
						</table>
					</div>
					--> 
				</div> <!-- Demands Div -->
				<!-- TODO these should show up next the corresponding demand -->
				<h2>Eligible Supplies</h2>  <!--  TODO add a hide button, could start with a text link -->
				<div style="overflow-x:auto;">
					<xsl:for-each
						select="/PlanGroup/prioritizedDemands/demand[@qtyOrd != 0]">
						<table class="eligibleSupply">
							<xsl:attribute name="id">es<xsl:value-of
								select="@dmdXmlId" />
    					</xsl:attribute>
							<tr>
								<th colspan="11">
									Dmd id:
									<xsl:value-of select="@dmdXmlId" />
									Item:
									<xsl:value-of select="@itemCd" />
								</th>
							</tr>
							<tr>
								<th>ID</th>
								<th>Type</th>
								<th>Facility</th>
								<th>Avail Date</th>
								<th>Gross Qty</th>
								<th>Qty Allocated This </th>
								<th>Unallocated</th>
								<th>Country</th>
								<th>Mfr Cd</th>
							</tr>
							<xsl:for-each select="eligibleSupply/supply">
								<tr>
									<xsl:variable name="allocThisDmd"
										select="@allocatedQty" />
									<xsl:for-each
										select="/PlanGroup/supplies/supply[@splyXmlId = current()/@splyXmlId]">
										<td>
											<xsl:value-of select="@splyXmlId" />
										</td>
										<td>
											<xsl:value-of select="@type" />
										</td>
										<td>
											<xsl:value-of select="@facility" />
										</td>
										<td>
											<xsl:value-of select="@availDate" />
										</td>
										<td align="right">
											<xsl:value-of select="@grossQty" />
										</td>
										<td>
											<xsl:value-of select="$allocThisDmd" />
										</td>
										<!-- <td align="right"> <xsl:value-of select="current()/@allocatedQty" 
											/> </td> -->
										<td align="right">
											<xsl:value-of select="@qtyUnallocated" />
										</td>
										<td>
											<xsl:value-of select="@cntryCdOrigin" />
										</td>
										<td>
											<xsl:value-of select="@mfrCd" />
										</td>
									</xsl:for-each>
								</tr>
							</xsl:for-each>
						</table>
					</xsl:for-each>
				</div>
			<div style="clear:both;"></div>
				<div>
				<h2>Vendor Quotes</h2>
					<table>
						<thead>
							<tr>
								<th>Vendor</th>
								<th>Item Cd</th>
								<th>Quote Date</th>
								<th>
									Quote Qty
									<br />
									Stock U/M
								</th>
								<th>Denominated Price</th>
								<th>System Price</th>
							</tr>
						</thead>
						<tbody>
							<xsl:for-each select="/PlanGroup/vqQteVws/vqQteVw[@qteCostDenom > 0]">
								<tr>
									<td>
										<xsl:value-of select="@orgNm" />
									</td>
									<td>
										<xsl:value-of select="@itemCdQte" />
									</td>
									<td>
										<xsl:value-of select="@vqQteEffDt" />
									</td>
									<td align="right">
										<xsl:value-of select="format-number(@qteQtyStkUm,'###,###')" />
									</td>
									<td align="right">
										<xsl:value-of select="format-number(@qteCostDenom,'##,###.00000')" />
									</td>
									<td align="right">
										<xsl:value-of select="format-number(@qteCost,'##,###.00000')" />
									</td>
								</tr>
							</xsl:for-each>
						</tbody>
					</table>
				</div>
			<div style="clear:both;"></div>
				<div>
				<h2>Sales By Month, Forecast Group</h2>
					<table>
						<thead>
							<tr>
								<th>Item Cd</th>
								<th>Forecast Group</th>
								<th>Month</th>
								<th>Qty</th>>
							</tr>
						</thead>
						<tbody>
							<xsl:for-each select="/PlanGroup/oeItemHistFcstGrps/oeItemHistFcstGrp">
								<tr>
									<td>
										<xsl:value-of select="@itemCd" />
									</td>
									<td>
										<xsl:value-of select="@fcstGrp"/>
									</td>
									<td>
										<xsl:value-of select="@ordDtMm"/>
									</td>
									<td align="right">
										<xsl:value-of select="format-number(@qtyOrdSum,'###,###')" />
									</td>
								</tr>
							</xsl:for-each>
						</tbody>
					</table>
				</div>
				<div style="clear:both;"></div>
				<div style="clear:left;clear:right" class="left"> <!-- sourcing rules h2 -->
					<h2 id="apsSrcRuleSets">Sourcing Rules</h2>
					<div class="left"> <!-- source rule set -->
						<h3>Source Rule Set</h3>
						<table class="srcRuleSets">
							<tr>
								<th>Sourcing Rule Set</th>
								<th>Description</th>
							</tr>
							<xsl:for-each
								select="/PlanGroup/apsSrcRuleSets/apsSrcRuleSet">
								<tr>
									<td>
										<xsl:value-of select="@srcRuleSetCd" />
									</td>
									<td>
										<xsl:value-of select="@descr" />
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</div> <!-- end: Sourcing Rulesets -->
				</div>
				<div class="right">
					<h3>Sourcing Rules 964</h3>
					<xsl:for-each
						select="/PlanGroup/apsSrcRuleSets/apsSrcRuleSet">
						<table class='srcRules'>
							<xsl:attribute name="id">
        						<xsl:value-of select="generate-id(.)" />
      							</xsl:attribute>
							<tr>
								<th colspan="6">
									Ruleset:
									<xsl:value-of select="@srcRuleSetCd" />
								</th>
							</tr>
							<tr>
								<th align="right">Priority</th>
								<th>Facility</th>
								<th>Pool</th>
								<th>Sub Pool</th>
								<th>SupplyType</th>
								<th>apsSrcRuleNbr</th>

							</tr>
							<xsl:for-each select="apsSrcRule">
								<tr>
									<td align="right">
										<xsl:value-of select="@priority" />
									</td>
									<td>
										<xsl:value-of select="@facility" />
									</td>
									<td>
										<xsl:value-of select="@poolCd" />
									</td>
									<td>
										<xsl:value-of select="@subPoolCd" />
									</td>
									<td>
										<xsl:value-of select="@supplyType" />
									</td>
									<td>
										<xsl:value-of select="@apsSrcRuleNbr" />
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</xsl:for-each>
							</div> <!-- Sourcing rules -->

				<h2>Terminology</h2>

				<button class="accordion">Forecast Group </button>
				<div class="panel">

					<p>A forecast group defines the set of demands that are associated
						with a forecast. Forecasts are "consumed", reduced by the amouunt
						of firm orders for the corresponding "bucket" (time period).

						Consumption policy if demand exceeds forecast can be no cascade,
						cascade back, cascade forward.</p>
				</div>

				<button class="accordion">Supply Pool</button>
				<div class="panel">
					<p>Inventory may logically be separated into supply pools to
						restrict availability.

						For example, a JIT program may be serviced
						out of a special supply
						pool with appropriate inventory
						and safety
						stock to satisfy the
						target service level.</p>
				</div>

				<button class="accordion">Sourcing Rules</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Multiple Certification</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Certification Weight</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Eligibility</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Forecast Consumption</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Bound Allocations</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

				<button class="accordion">Allocation Based Pricing</button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						do
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<button class="accordion">Planning Group </button>
				<div class="panel">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<script>
					var acc = document.getElementsByClassName("accordion");
					var
					i;

					for (i = 0; i &lt; acc.length; i++) {
					acc[i].addEventListener("click", function() {
					this.classList.toggle("active");
					var panel =
					this.nextElementSibling;
					if (panel.style.display === "block") {
					panel.style.display = "none";
					} else {
					panel.style.display = "block";
					}
					});
					}
				</script>

   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script>
    $(document).ready(function() {
        // apply filterTable to all tables on this page
        $('table').filterTable({filterExpression: 'filterTableFindAny'});
    });
    </script>
			</BODY>
		</html>
	</xsl:template>
</xsl:stylesheet>
