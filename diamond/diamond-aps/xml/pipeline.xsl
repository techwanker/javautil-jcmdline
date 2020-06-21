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
					<tr>
						<th>?</th>
						<th>Fcst Master #</th>
						<th>Item #</th>
						<th>Item Cd</th>
						<th>Forcast Group</th>
					</tr>
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
				</table>
				<!-- item masters -->
				<h2 id='icItemMasts'>Item Masters</h2>
				<div style="overflow-x:auto;">
					<table>
						<tr align="left">
							<th>Item Nbr</th>
							<th>Part #</th>
							<th>Description</th>
							<th>U/M</th>
							<th align="right">Lead Time - weeks</th>
						</tr>
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
					</table>
				</div>
				<!-- todo create equivalent matrix -->
				<!--- attribute certs -->
				<h2>Attribute Certs</h2>
				<table border="1">
					<tr>
						<th>Cert Code</th>
						<th>Description</th>
						<th>Weight</th>
					</tr>
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
				</table>
				<h2 id="customerItemManufacturers">Customer Approved Manufacturers</h2>
				<table border="1">
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
									<xsl:value-of select="@fcstGrp" />
									<br />
									<xsl:value-of select="$currentItemNbr" />
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
					<h3>Forecasts</h3>
					<div style="overflow-x:auto;">  <!-- TODO can't we apply templates -->
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
/**
 * jquery.filterTable
 *
 * This plugin will add a search filter to tables. When typing in the filter,
 * any rows that do not contain the filter will be hidden.
 *
 * Utilizes bindWithDelay() if available. https://github.com/bgrins/bindWithDelay
 *
 * @version v1.5.7
 * @author Sunny Walker, swalker@hawaii.edu
 * @license MIT
 */
(function ($) {
    var jversion = $.fn.jquery.split('.'),
        jmajor = parseFloat(jversion[0]),
        jminor = parseFloat(jversion[1]);
    // build the pseudo selector for jQuery < 1.8
    if (jmajor < 2 && jminor < 8) {
        // build the case insensitive filtering functionality as a pseudo-selector expression
        $.expr[':'].filterTableFind = function (a, i, m) {
            return $(a).text().toUpperCase().indexOf(m[3].toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0;
        };
        // build the case insensitive all-words filtering functionality as a pseudo-selector expression
        $.expr[':'].filterTableFindAny = function (a, i, m) {
            // build an array of each non-falsey value passed
            var raw_args = m[3].split(/[\s,]/),
                args = [];
            $.each(raw_args, function (j, v) {
                var t = v.replace(/^\s+|\s$/g, '');
                if (t) {
                    args.push(t);
                }
            });
            // if there aren't any non-falsey values to search for, abort
            if (!args.length) {
                return false;
            }
            return function (a) {
                var found = false;
                $.each(args, function (j, v) {
                    if ($(a).text().toUpperCase().indexOf(v.toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0) {
                        found = true;
                        return false;
                    }
                });
                return found;
            };
        };
        // build the case insensitive all-words filtering functionality as a pseudo-selector expression
        $.expr[':'].filterTableFindAll = function (a, i, m) {
            // build an array of each non-falsey value passed
            var raw_args = m[3].split(/[\s,]/),
                args = [];
            $.each(raw_args, function (j, v) {
                var t = v.replace(/^\s+|\s$/g, '');
                if (t) {
                    args.push(t);
                }
            });
            // if there aren't any non-falsey values to search for, abort
            if (!args.length) {
                return false;
            }
            return function (a) {
                // how many terms were found?
                var found = 0;
                $.each(args, function (j, v) {
                    if ($(a).text().toUpperCase().indexOf(v.toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0) {
                        // found another term
                        found++;
                    }
                });
                return found === args.length; // did we find all of them in this cell?
            };
        };
    } else {
        // build the pseudo selector for jQuery >= 1.8
        $.expr[':'].filterTableFind = jQuery.expr.createPseudo(function (arg) {
            return function (el) {
                return $(el).text().toUpperCase().indexOf(arg.toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0;
            };
        });
        $.expr[':'].filterTableFindAny = jQuery.expr.createPseudo(function (arg) {
            // build an array of each non-falsey value passed
            var raw_args = arg.split(/[\s,]/),
                args = [];
            $.each(raw_args, function (i, v) {
                // trim the string
                var t = v.replace(/^\s+|\s$/g, '');
                if (t) {
                    args.push(t);
                }
            });
            // if there aren't any non-falsey values to search for, abort
            if (!args.length) {
                return false;
            }
            return function (el) {
                var found = false;
                $.each(args, function (i, v) {
                    if ($(el).text().toUpperCase().indexOf(v.toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0) {
                        found = true;
                        // short-circuit the searching since this cell has one of the terms
                        return false;
                    }
                });
                return found;
            };
        });
        $.expr[':'].filterTableFindAll = jQuery.expr.createPseudo(function (arg) {
            // build an array of each non-falsey value passed
            var raw_args = arg.split(/[\s,]/),
                args = [];
            $.each(raw_args, function (i, v) {
                // trim the string
                var t = v.replace(/^\s+|\s$/g, '');
                if (t) {
                    args.push(t);
                }
            });
            // if there aren't any non-falsey values to search for, abort
            if (!args.length) {
                return false;
            }
            return function (el) {
                // how many terms were found?
                var found = 0;
                $.each(args, function (i, v) {
                    if ($(el).text().toUpperCase().indexOf(v.toUpperCase().replace(/"""/g, '"').replace(/"\\"/g, "\\")) >= 0) {
                        // found another term
                        found++;
                    }
                });
                // did we find all of them in this cell?
                return found === args.length;
            };
        });
    }
    // define the filterTable plugin
    $.fn.filterTable = function (options) {
        // start off with some default settings
        var defaults = {
                // make the filter input field autofocused (not recommended for accessibility)
                autofocus: false,

                // callback function: function (term, table){}
                callback: null,

                // class to apply to the container
                containerClass: 'filter-table',

                // tag name of the container
                containerTag: 'p',

                // jQuery expression method to use for filtering
                filterExpression: 'filterTableFind',

                // if true, the table's tfoot(s) will be hidden when the table is filtered
                hideTFootOnFilter: false,

                // class applied to cells containing the filter term
                highlightClass: 'alt',

                // don't filter the contents of cells with this class
                ignoreClass: '',

                // don't filter the contents of these columns
                ignoreColumns: [],

                // use the element with this selector for the filter input field instead of creating one
                inputSelector: null,

                // name of filter input field
                inputName: '',

                // tag name of the filter input tag
                inputType: 'search',

                // text to precede the filter input tag
                label: 'Filter:',

                // filter only when at least this number of characters are in the filter input field
                minChars: 1,

                // don't show the filter on tables with at least this number of rows
                minRows: 8,

                // HTML5 placeholder text for the filter field
                placeholder: 'search this table',

                // prevent the return key in the filter input field from trigger form submits
                preventReturnKey: true,

                // list of phrases to quick fill the search
                quickList: [],

                // class of each quick list item
                quickListClass: 'quick',

                // quick list item label to clear the filter (e.g., '&times; Clear filter')
                quickListClear: '',

                // tag surrounding quick list items (e.g., ul)
                quickListGroupTag: '',

                // tag type of each quick list item (e.g., a or li)
                quickListTag: 'a',

                // class applied to visible rows
                visibleClass: 'visible'
            },
            // mimic PHP's htmlspecialchars() function
            hsc = function (text) {
                return text.replace(/&/g, '&amp;').replace(/"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
            },
            // merge the user's settings into the defaults
            settings = $.extend({}, defaults, options);

        // handle the actual table filtering
        var doFiltering = function (table, q) {
                // cache the tbody element
                var tbody = table.find('tbody');
                // if the filtering query is blank or the number of chars is less than the minChars option
                if (q === '' || q.length < settings.minChars) {
                    // show all rows
                    tbody.find('tr').show().addClass(settings.visibleClass);
                    // remove the row highlight from all cells
                    tbody.find('td').removeClass(settings.highlightClass);
                    // show footer if the setting was specified
                    if (settings.hideTFootOnFilter) {
                        table.find('tfoot').show();
                    }
                } else {
                    // if the filter query is not blank
                    var all_tds = tbody.find('td');
                    // hide all rows, assuming none were found
                    tbody.find('tr').hide().removeClass(settings.visibleClass);
                    // remove previous highlights
                    all_tds.removeClass(settings.highlightClass);
                    // hide footer if the setting was specified
                    if (settings.hideTFootOnFilter) {
                        table.find('tfoot').hide();
                    }
                    if (settings.ignoreColumns.length) {
                        var tds = [];
                        if (settings.ignoreClass) {
                            all_tds = all_tds.not('.' + settings.ignoreClass);
                        }
                        tds = all_tds.filter(':' + settings.filterExpression + '("' + q + '")');
                        tds.each(function () {
                            var t = $(this),
                                col = t.parent().children().index(t);
                            if ($.inArray(col, settings.ignoreColumns) === -1) {
                                t.addClass(settings.highlightClass).closest('tr').show().addClass(settings.visibleClass);
                            }
                        });
                    } else {
                        if (settings.ignoreClass) {
                            all_tds = all_tds.not('.' + settings.ignoreClass);
                        }
                        // highlight (class=alt) only the cells that match the query and show their rows
                        all_tds.filter(':' + settings.filterExpression + '("' + q + '")').addClass(settings.highlightClass).closest('tr').show().addClass(settings.visibleClass);
                    }
                }
                // call the callback function
                if (settings.callback) {
                    settings.callback(q, table);
                }
            }; // doFiltering()

        return this.each(function () {
            // cache the table
            var t = $(this),
                // cache the tbody
                tbody = t.find('tbody'),
                // placeholder for the filter field container DOM node
                container = null,
                // placeholder for the quick list items
                quicks = null,
                // placeholder for the field field DOM node
                filter = null,
                // was the filter created or chosen from an existing element?
                created_filter = true;

            // only if object is a table and there's a tbody and at least minRows trs and hasn't already had a filter added
            if (t[0].nodeName === 'TABLE' && tbody.length > 0 && (settings.minRows === 0 || (settings.minRows > 0 && tbody.find('tr').length >= settings.minRows)) && !t.prev().hasClass(settings.containerClass)) {
                // use a single existing field as the filter input field
                if (settings.inputSelector && $(settings.inputSelector).length === 1) {
                    filter = $(settings.inputSelector);
                    // container to hold the quick list options
                    container = filter.parent();
                    created_filter = false;
                } else {
                    // create the filter input field (and container)
                    // build the container tag for the filter field
                    container = $('<' + settings.containerTag + ' />');
                    // add any classes that need to be added
                    if (settings.containerClass !== '') {
                        container.addClass(settings.containerClass);
                    }
                    // add the label for the filter field
                    container.prepend(settings.label + ' ');
                    // build the filter field
                    filter = $('<input type="' + settings.inputType + '" placeholder="' + settings.placeholder + '" name="' + settings.inputName + '" />');
                    // prevent return in the filter field from submitting any forms
                    if (settings.preventReturnKey) {
                        filter.on('keydown', function (ev) {
                            if ((ev.keyCode || ev.which) === 13) {
                                ev.preventDefault();
                                return false;
                            }
                        });
                    }
                }

                // add the autofocus attribute if requested
                if (settings.autofocus) {
                    filter.attr('autofocus', true);
                }

                // does bindWithDelay() exist?
                if ($.fn.bindWithDelay) {
                    // bind doFiltering() to keyup (delayed)
                    filter.bindWithDelay('keyup', function () {
                        doFiltering(t, $(this).val());
                    }, 200);
                } else {
                    // just bind to onKeyUp
                    // bind doFiltering() to keyup
                    filter.bind('keyup', function () {
                        doFiltering(t, $(this).val());
                    });
                }

                // bind doFiltering() to additional events
                filter.bind('click search input paste blur', function () {
                    doFiltering(t, $(this).val());
                });

                // add the filter field to the container if it was created by the plugin
                if (created_filter) {
                    container.append(filter);
                }

                // are there any quick list items to add?
                if (settings.quickList.length > 0 || settings.quickListClear) {
                    quicks = settings.quickListGroupTag ? $('<' + settings.quickListGroupTag + ' />') : container;
                    // for each quick list item...
                    $.each(settings.quickList, function (index, value) {
                        // build the quick list item link
                        var q = $('<' + settings.quickListTag + ' class="' + settings.quickListClass + '" />');
                        // add the item's text
                        q.text(hsc(value));
                        if (q[0].nodeName === 'A') {
                            // add a (worthless) href to the item if it's an anchor tag so that it gets the browser's link treatment
                            q.attr('href', '#');
                        }
                        // bind the click event to it
                        q.bind('click', function (e) {
                            // stop the normal anchor tag behavior from happening
                            e.preventDefault();
                            // send the quick list value over to the filter field and trigger the event
                            filter.val(value).focus().trigger('click');
                        });
                        // add the quick list link to the quick list groups container
                        quicks.append(q);
                    });

                    // add the quick list clear item if a label has been specified
                    if (settings.quickListClear) {
                        // build the clear item
                        var q = $('<' + settings.quickListTag + ' class="' + settings.quickListClass + '" />');
                        // add the label text
                        q.html(settings.quickListClear);
                        if (q[0].nodeName === 'A') {
                            // add a (worthless) href to the item if it's an anchor tag so that it gets the browser's link treatment
                            q.attr('href', '#');
                        }
                        // bind the click event to it
                        q.bind('click', function (e) {
                            e.preventDefault();
                            // clear the quick list value and trigger the event
                            filter.val('').focus().trigger('click');
                        });
                        // add the clear item to the quick list groups container
                        quicks.append(q);
                    }

                    // add the quick list groups container to the DOM if it isn't already there
                    if (quicks !== container) {
                        container.append(quicks);
                    }
                }

                // add the filter field and quick list container to just before the table if it was created by the plugin
                if (created_filter) {
                    t.before(container);
                }
            }
        }); // return this.each
    }; // $.fn.filterTable
})(jQuery);
 </script>
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
