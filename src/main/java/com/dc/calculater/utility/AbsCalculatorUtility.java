package com.dc.calculater.utility;

public abstract class  AbsCalculatorUtility {
	 
	protected AbsCalculatorUtility() { }
	
	//BUY_ONE_GET_ONE_FREE
	protected double getOneFre(Long quantity, int x, double price) {
    	return (quantity/x * price) + ((quantity % x) * price);
    }
    
    //THREE_FOR_TWO
    protected double getTreForTow(Long quantity, int x, double price) {
    	return (quantity/x * 2 * price) + ((quantity % x) * price);
    }
    
    protected double getDefault(final Long quantity, final double price) {
    	return quantity * price;
    }
    
    abstract public double getPricePerQuantity(Long quantity);
}
