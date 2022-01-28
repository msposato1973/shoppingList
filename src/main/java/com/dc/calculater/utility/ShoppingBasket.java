package com.dc.calculater.utility;

import java.util.List;
import java.util.Map;

import com.dc.calculater.model.BasketItem;
 

public class ShoppingBasket extends AbsShoppingBasket{
	 
    public ShoppingBasket(List<String> list) {
        setBasketContents(groupByItem(list));
    }

    private static double total;
    
 
     @Override
    public double computePrice() {
        
    	total = 0;
    	this.basketContents.entrySet().stream().forEach(e -> {
    		BasketItem itemDetails = getItem(e.getKey())  ;
	    		if (itemDetails == null) {
	                	System.out.println("The item: "+ e + ", not found in our inventory!");
	               		total +=  0 ;
	            	} else {
	            		 total += itemDetails.getPricePerQuantity(e.getValue());
	            	}
		    }
		);
    	
    	 
        System.out.println("total: "+ total);
        return total;
    }


	
	 
}
