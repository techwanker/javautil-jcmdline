//package com.pacificdataservices.diamond.planning.filter;
//
//
///**
// * The information necessary to determine
// * if a manufacturer is approved by a given customer for a given item .
// * @author Jim Schmidt
// * @version 1.0
// */
//public class CustomerItemManufacturerRule {
//    private String customerCode = null;
//    private String itemCode = null;
//    private Integer itemNbr = null;
//    private String manufacturerCode = null;
//    private Integer mfrNbr = null;
//    private Integer rule = null;
//
//    /**
//     * RestrictBlacklisted is a value that can be assumed by iRule.
//     *
//     * If an item is RestrictBlacklisted the customer will approve this item from any manufacturer
//     * except those that are specifically listed.
//     */
//    private static final Integer RestrictToApproved = new Integer(1);
//    private static final Integer RestrictBlackListed = new Integer(2);
//
//    public CustomerItemManufacturerRule() {
//    }
//
//
//    public CustomerItemManufacturerRule
//            (
//            		
//            String customerCode,
//            String itemCode,
//            Integer itemNbr,
//            String manufacturerCode,
//            Integer mfrNbr,
//            Integer rule
//            ) {
//        this.setCustomerCode(customerCode);
//        this.setItemCode(itemCode);
//        this.setItemNbr(itemNbr);
//        this.setManufacturerCode(manufacturerCode);
//        this.setMfrNbr(mfrNbr);
//        this.setRule(rule);
//        if (customerCode == null) {
//            throw new java.lang.IllegalArgumentException("customerCode may not be null");
//        }
//        if (itemCode == null) {
//            throw new java.lang.IllegalArgumentException("itemCode may not be null");
//        }
//        if (itemNbr == null || itemNbr.intValue() < 1) {
//            throw new java.lang.IllegalArgumentException("itemNbr may not be null");
//        }
//        if (manufacturerCode == null) {
//            throw new java.lang.IllegalArgumentException("manufacturerCode may not be null");
//        }
//        if (mfrNbr == null || mfrNbr.intValue() < 1) {
//            throw new java.lang.IllegalArgumentException("mfrNbr may not be null");
//        }
//    }
//
//    public boolean isBlackListed() {
//        return this.getRule().equals(getRestrictBlackListed());
//    }
//
//    public boolean isWhiteListed() {
//        return this.getRule().equals(getRestrictToApproved());
//    }
//
//    public String getItemCode() {
//        return itemCode;
//    }
//
//    public Integer getItemNbr() {
//        return itemNbr;
//    }
//
//    public Integer getMfrNbr() {
//        return mfrNbr;
//    }
//
//    public String getManufacturerCode() {
//        return manufacturerCode;
//    }
//
//    public String getCustomerCode() {
//        return customerCode;
//    }
//
//    public static String htmlHead() {
//        return ("<th>Customer</th><th>Item</th><th>Mfr</th><th>Approved?</th>");
//    }
//
//    public String toHtml() {
//        boolean approved = !isBlackListed() || isWhiteListed();
//        return ("<td>" + getCustomerCode() + "</td><td>" + getItemCode() + "</td><td>" + getManufacturerCode() + "</td><td>" + approved + "</td>");
//    }
//
//    public void setCustomerCode(String customerCode) {
//        this.customerCode = customerCode;
//    }
//
//    public void setItemCode(String itemCode) {
//        this.itemCode = itemCode;
//    }
//
//    public void setItemNbr(Integer itemNbr) {
//        this.itemNbr = itemNbr;
//    }
//
//    public void setManufacturerCode(String manufacturerCode) {
//        this.manufacturerCode = manufacturerCode;
//    }
//
//    public void setMfrNbr(Integer mfrNbr) {
//        this.mfrNbr = mfrNbr;
//    }
//
//    public Integer getRule() {
//        return rule;
//    }
//
//    public void setRule(Integer rule) {
//        this.rule = rule;
//    }
//
//    public static Integer getRestrictToApproved() {
//        return RestrictToApproved;
//    }
//
//    public static Integer getRestrictBlackListed() {
//        return RestrictBlackListed;
//    }
//}