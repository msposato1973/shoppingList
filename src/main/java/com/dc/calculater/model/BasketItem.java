package com.dc.calculater.model;

import com.dc.calculater.utility.AbsCalculatorUtility;

public class BasketItem extends AbsCalculatorUtility{
	
	    private String name;
	    private double price;
	    private Offer deal;
	    
	    public BasketItem(String name, double price) {
	        super();
	        this.name = name;
	        this.price = price;
	        this.deal = Offer.NONE;
	    }

	    public BasketItem(String name, double price, Offer deal) {
	        super();
	        this.name = name;
	        this.price = price;
	        this.deal = deal;
	    }

		public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public Offer getDeal() {
	        return deal;
	    }

	    public void setDeal(Offer deal) {
	        this.deal = deal;
	    }

        @Override
	    public double getPricePerQuantity(Long quantity) {
	        switch (this.deal) {
	            case BUY_ONE_GET_ONE_FREE:
	                return getOneFre(quantity, 2,  price) ;
	            case THREE_FOR_TWO:
	                return getTreForTow(quantity, 3, price);
	            default:
	                return getDefault(quantity, price);
	        }
	    }

		
		 
	
}
