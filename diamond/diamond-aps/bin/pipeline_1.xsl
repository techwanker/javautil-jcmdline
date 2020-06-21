<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <HTML>
      <head>
        <link rel="stylesheet" href="../stylesheets/screen.css"/>
<style>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">

.tblelite {  font-family: Arial, Helvetica, sans-serif; font-size: 12px; color: #999999}
.dktext {  font-family: "Comic Sans MS", "Trebuchet MS", Verdana, Arial, sans-serif; font-size: 12px; color: #333333}

a                  { color: blue; font-family: arial;          }
a:link 	           { color: #333333; text-decoration: underline}
a:active           { color: #333333; text-decoration: underline}
a:visited          { color: #333333; text-decoration: underline}
a:hover   	   { color: #FF9900; text-decoration: underline}
a.tblelite:link    { color: #887830; text-decoration: underline}
a.tblelite:visited { color: #999999; text-decoration: none     }
a.tblelite:hover {  color: #CCCCCC}

.tblheader       { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 14px; color: #FF9900}
.laybrdr         { border-color: #999999 black; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
.datatbltx       { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: #AB9987}
.netscape        { font-size: 10px; color: #666666}
.txtfld          { background-color: #FFFFFF; border: #333333; border-style: groove; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px}
.button          { font-family: Verdana, Arial, Helvetica, sans-serif; color: #333333; background-color: #9999CC; font-size: 1h2px}
  .data        { color: black; font-family: Helvetica; font-size: 14px; font-weight: 800}
  
  h1             { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 16px; color: #666666}
  h2             { color: blue; font-family: arial; font-size: 14pt }
  h3             { color: blue; font-family: arial; font-size: 12pt }
  p              { font-family: arial; }
  p.internalLink { COLOR: blue; TEXT-DECORATION: underline }  

  td.label       { color: blue ; font-family: Helvetica; font-size: 10pt}
  td.data        { color: black; font-family: Helvetica; font-size: 10pt}
  th             { BACKGROUND-COLOR: #C0C0F0; color: black; font-family: arial; font-size: 10pt}
  tr.odd         { BACKGROUND-COLOR: "#cecece"; color: black; font-family: arial; }
  tr.even        { BACKGROUND-COLOR: white; color: black; font-family: arial;}
  .modernTable          {  border-color: #999999 black; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
  .tblheader {  font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 14px; color: #FFFFFF}
  .laybrdr {  border-color: #999999 black; border-style: solid; border-top-width: 1px; border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px}
  .datatbltx {  font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: #AB9987}
  .parentbl {  background-color: #9999CC}
  .detailrow {  background-color: #FFFFFF}
  .coolTable          { border: solid; border-width: 1px 2px 2px 1px;} 
  table.coolTable td { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 11px; border: 1px solid #AAAAAA}
  table.coolTable th { BACKGROUND-COLOR: #C0C0F0; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; border: 1px #AAAAAA solid}
  table {border: solid; border-width: 1px 2px 2px 1px;}
  td             { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 11px;  border: 1px solid #AAAAAA}
  body           { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;}
  .highlight     { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;}
.pageHeaderApplication {  font-family: Geneva, Arial, Helvetica, san-serif; font-size: 18px; font-style: oblique}
</style>
<!-- Table goes in the document BODY -->
<table class="gridtable">
<tr>
    <th>Info Header 1</th><th>Info Header 2</th><th>Info Header 3</th>
</tr>
<tr>
    <td>Text 1A</td><td>Text 1B</td><td>Text 1C</td>
</tr>
<tr>
    <td>Text 2A</td><td>Text 2B</td><td>Text 2C</td>
</tr>
</table>

table {
  border-collapse: collapse;
  border: 1px solid blue;
}
</style>
      </head>
      <BODY>
        <!-- 
           item masters
          -->
        <h2>Item Masters</h2>
        <table border="1">
          <tr>
            <th>Part #</th>
            <th>Description</th>
	        <th>U/M</th>
	        <th>Lead Time - weeks</th>
          </tr>
          <xsl:for-each select="/PlanGroup/itemMasters/itemMast">
            <tr>
              <td><xsl:value-of select="@itemCd"/></td>
              <td><xsl:value-of select="@descr"/></td>
              <td><xsl:value-of select="@stkUm"/></td>
              <td><xsl:value-of select="@leadTm"/></td>
            </tr>
          </xsl:for-each>
        </table>
        <!-- todo create equivalent matrix -->
        <!--- 
           attribute certs
          -->
        <h2>Attribute Certs</h2>
        <table border="1">
          <tr>
            <th>Cert Code</th>
            <th>Description</th>
            <th>Weight</th>
          </tr>
          <xsl:for-each select="/PlanGroup/attributeCerts/attributeCert">
            <tr>
              <td><xsl:value-of select="@cd"/></td>
              <td><xsl:value-of select="@descr"/></td>
              <td><xsl:value-of select="@value"/></td>
            </tr>
          </xsl:for-each>
        </table>
	<!-- buckets -->
    <h2>Pipeline</h2>	
        <table>
<!-- buckets -->
	<tr align="right">
	<th>Dates yy/mm/dd</th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<th><xsl:value-of select="@nm"/></th>
        </xsl:for-each>
        </tr>
<!-- supply -->
	<tr><th colspan="15" align="left">Supply</th></tr>
<!-- purchase orders -->
	<tr align="right">
	<th>Purchase Orders</th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Work orders -->
	<tr align="right">
	<th>Work Orders</th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='WO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Onhand  -->
	<tr align="right">
	<th>Onhand </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='OH' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Demand -->
	<tr><th colspan="15" align="left">Demand</th></tr>
<!-- Customer Orders  -->
	<tr align="right">
	<th>Customer Orders </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/prioritizedDemands/demand[@type='OO' and @rqstDateBucket=current()/@nm]//@qtyOrd)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Safety Stock  -->
	<tr align="right">
	<th>Safety Stock </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/prioritizedDemands/supply[@type='SS' and @rqstDateBucket=current()/@nm]//@qtyOrd)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Forecast   -->
	<tr align="right">
	<th>Forecast </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/prioritizedDemands/demand[@type='FC' and @rqstDateBucket=current()/@nm]//@qtyOrd)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Work Orders   -->
	<tr align="right">
	<th>Work Orders </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/prioritizedDemands/demand[@type='WO' and @rqstDateBucket=current()/@nm]//@qtyOrd)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Total Demand  -->
	<tr align="right">
	   <th>Total Demand </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/prioritizedDemands/demand[@rqstDateBucket=current()/@nm]//@qtyOrd)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Rolling Aggregate  -->
	<tr align="right">
	<th>Rolling Aggregate </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Summary  -->
	<tr><th colspan="15" align="left">Planning Summary</th></tr>
<!-- Unallocated  -->
	<tr align="right">
	<th>Unallocated </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Projected Position  -->
	<tr><th colspan="15" align="left">Projected Position</th></tr>
<!-- Total  -->
<!--
  <projectedPositions>
    <projectedPosition positionBucket="Past Due" dmdSum="13772.0" splySum="0.0" projPos="-13772.0"/>
-->
<tr align="right">
	<th>Total </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/projectedPositions/projectedPosition[@positionBucket=current()/@nm]//@projPos)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- General  -->
<tr align="right">
	<th>General </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Consignment  -->
	<tr align="right">
	<th>Consignment </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Buyback  -->
	<tr align="right">
	<th>Buyback </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
<!-- Po Resched  -->
	<tr align="right">
	<th>Po Resched </th>
	<xsl:for-each select="/PlanGroup/buckets/bucket" >
	<td>
	  <xsl:value-of select="sum(/PlanGroup/supplies/supply[@type='PO' and @availDtBucket=current()/@nm]//@grossQty)" />
	</td>
        </xsl:for-each>
	</tr>
	<!-- -->
        </table>
<h2>Supplies</h2>
<table border="1">
<tr>
   <th colspan="8">Onhand</th>
</tr>
<tr>
   <th>ID</th>
   <th>Facility</th>
   <th>Subpool</th>
   <th>Gross Qty</th>
   <th>Qty Allocated</th>
   <th>Unallocated</th>
   <th>Country</th>
   <th>Cert Value</th>
</tr>
	<xsl:for-each select="/PlanGroup/supplies/supply" >
    <tr>
      <td><xsl:value-of select="@splyXmlId"/></td>
      <td><xsl:value-of select="@facility"/></td>
      <td><xsl:value-of select="@subpool"/></td>
      <td align="right"><xsl:value-of select= 'format-number(@grossQty, "###,###.00")'/></td>
      <td align="right"><xsl:value-of select= 'format-number(@qtyAllocated, "###,###.00")'/></td>
      <td align="right"><xsl:value-of select="@qtyAllocated"/></td>
      <td align="right"><xsl:value-of select="@qtyUnallocated"/></td>
      <td><xsl:value-of select="@cntryCdOrigin"/></td>
      <td align="right"><xsl:value-of select="@certValue"/></td>
	</tr>
        </xsl:for-each>
<tr>
   <th colspan="8">Onhand</th>
</tr>
</table>
<h2>Demands</h2>
<table border="1">
<tr>
   <th colspan="8">Customer Orders</th>
</tr>
<!--
<tr>
   <th>Cust Code</th>
   <th>Requested<br/>Date</th>
   <th>Order Qty</th>
   <th>Qty Allocated</th>
   <th>Unallocated</th>
   <th>Country</th>
   <th>Cert Value</th>
</tr>
	<xsl:for-each select="/PlanGroup/demands/demand" >
    <tr>
      <td><xsl:value-of select="@splyXmlId"/></td>
      <td><xsl:value-of select="@facility"/></td>
      <td><xsl:value-of select="@subpool"/></td>
      <td align="right"><xsl:value-of select= 'format-number(@grossQty, "###,###.00")'/></td>
      <td align="right"><xsl:value-of select= 'format-number(@qtyAllocated, "###,###.00")'/></td>
      <td align="right"><xsl:value-of select="@qtyAllocated"/></td>
      <td align="right"><xsl:value-of select="@qtyUnallocated"/></td>
      <td><xsl:value-of select="@cntryCdOrigin"/></td>
      <td align="right"><xsl:value-of select="@certValue"/></td>
	</tr>
        </xsl:for-each>
<tr>
   <th colspan="8">Onhand</th>
</tr>
</table>
-->
<h2>Allocations</h2>
Allocations go here
      </BODY>
    </HTML>
  </xsl:template>


</xsl:stylesheet>
