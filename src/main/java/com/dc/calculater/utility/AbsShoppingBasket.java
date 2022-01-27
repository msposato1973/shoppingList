package com.dc.calculater.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.dc.calculater.model.BasketItem;
import com.dc.calculater.model.Offer;

public abstract class AbsShoppingBasket {

	protected Map<String, Long> basketContents = new HashMap<String, Long>();
	protected final List<BasketItem>  inventory =  List.of(new BasketItem("Apples", 0.35, Offer.NONE), 
												  new BasketItem("Bananas", 0.20, Offer.NONE),
												  new BasketItem("Melons", 0.50, Offer.BUY_ONE_GET_ONE_FREE),
												  new BasketItem("Limes", 0.15, Offer.THREE_FOR_TWO)
	);
	
	protected Map<String, Long> groupByItem(List<String> list) {
   	 return list.stream().collect(
               Collectors.groupingBy(Function.identity(), Collectors.counting())
       );
      
   }
						
	protected Map<String, Long> getBasketContents() {
	        return basketContents;
	}

	protected void setBasketContents(Map<String, Long> basketContents) {
	        this.basketContents = basketContents;
	}
	    
	protected BasketItem getItem(String itemName) {
		return inventory.stream()                        
                .filter(x -> itemName.equalsIgnoreCase(x.getName()))         
                .findAny()                                       
                .orElse(null); 
	}
	
	 abstract public double computePrice();
}
