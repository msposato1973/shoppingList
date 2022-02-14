package com.dc.calculater.utility;

import java.util.List;
import java.util.Map;

import com.dc.calculater.model.BasketItem;
 

public class ShoppingBasket extends AbsShoppingBasket{
	 
    public ShoppingBasket(List<String> list) {
        setBasketContents(groupByItem(list));
    }

    
    
 
    @Override
    public double computePrice() {
        
    	double total = 0;
    	
    	for (Map.Entry<String, Long> purchasedItem : this.basketContents.entrySet()) {
        	BasketItem itemDetails = getItem(purchasedItem.getKey())  ;  
        	if (itemDetails == null) {
                System.out.println("The item: "+ purchasedItem+ ", not found in our inventory!");
                total += 0;
            } else {
            	 total += itemDetails.getPricePerQuantity(purchasedItem.getValue());
            }
        }
        
        System.out.println("total: "+ total);
        return total;
    }


	
	 
}
