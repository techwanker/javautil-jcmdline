package com.pacificdataservices.diamond.planninglogic;

public class AbstractPlanTestExpectedValues {
	private   String expectedFirstDemand = "TYPE:-2-OO-LEADTIME:1-DMDPRTY:0007-NEEDBY:2019-03-21-1DMDCD:JIT255644-790";
	private   int expectedCustomerDemandSize;
	private   int expectedEligibleSize;
	private   int expectedSuppliesSize;
	private   int expectedIcItemMastSize;
	private   int expectedApsAvailOnhandsSize;
	
	public String getExpectedFirstDemand() {
		return expectedFirstDemand;
	}
	public void setExpectedFirstDemand(String expectedFirstDemand) {
		this.expectedFirstDemand = expectedFirstDemand;
	}
	public int getExpectedCustomerDemandSize() {
		return expectedCustomerDemandSize;
	}
	public void setExpectedCustomerDemandSize(int expectedCustomerDemandSize) {
		this.expectedCustomerDemandSize = expectedCustomerDemandSize;
	}
	public int getExpectedEligibleSize() {
		return expectedEligibleSize;
	}
	public void setExpectedEligibleSize(int expectedEligibleSize) {
		this.expectedEligibleSize = expectedEligibleSize;
	}
	public int getExpectedSuppliesSize() {
		return expectedSuppliesSize;
	}
	public void setExpectedSuppliesSize(int expectedSuppliesSize) {
		this.expectedSuppliesSize = expectedSuppliesSize;
	}
	public int getExpectedIcItemMastSize() {
		return expectedIcItemMastSize;
	}
	public void setExpectedIcItemMastSize(int expectedIcItemMastSize) {
		this.expectedIcItemMastSize = expectedIcItemMastSize;
	}
	public int getExpectedApsAvailOnhandsSize() {
		return expectedApsAvailOnhandsSize;
	}
	public void setExpectedApsAvailOnhandsSize(int expectedApsAvailOnhandsSize) {
		this.expectedApsAvailOnhandsSize = expectedApsAvailOnhandsSize;
	}
	
	
}
