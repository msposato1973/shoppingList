package com.dc.calculater.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ShoppingBasketTest {
 

	/**
     * testing 1 buy "one get one free" offer
     */
  	 
	@Test
    public final void testBuyOneGetOneFree() {
    	
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList("Melons"));
        double price = basket.computePrice();
        
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.5==price);
        
        basket = new ShoppingBasket(Arrays.asList("Melons","noItem"));
        price = basket.computePrice();
        
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.5==price);
        

        basket = new ShoppingBasket(Arrays.asList("Melons", "Melons"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.5==price);
        
        basket = new ShoppingBasket(Arrays.asList("Melons", "Melons", "Melons"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        
        basket = new ShoppingBasket(Arrays.asList("Melons", "Melons", "Melons","noItem"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        
        assertTrue(1.0d==price);
    }
	
	/**
     * testing 3x2 offer
     */
    @Test
    public final void testThreeForTwo() {
    	AbsShoppingBasket basket = new ShoppingBasket(Arrays.asList("Limes"));
        double price = basket.computePrice();
        
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.15d==price);

        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.30d==price);

        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        //assertTrue(0.30d==price);

        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.45d, price, 0.01);

        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(0.60d==price);
       

        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes", "Limes", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.60d, price, 0.01);

    }
    
    /**
     * text for non existing items will be ignored
     */
    @Test
    public final void testOmitItemsMissingFromInventory() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList("Melons", "Melons", "Bananas", "noItem"));
        double price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.70d, price, 0.01);

        basket = new ShoppingBasket(Arrays.asList("Item1", "Item2", "Item3"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0d, price, 0.01);
        
        basket = new ShoppingBasket(Arrays.asList("Item1", "Item2", "Item3","Item1", "Item2", "Item3"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0d, price, 0.01);
        
        basket = new ShoppingBasket(Arrays.asList("Item1"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0d, price, 0.01);
    }
    
    // test mix assertTrue(out.toString().contains("Lime=3, Apple=1, Melon=3, Banana=1"));
    
    /**
     * text for non existing items will be ignored
     */
    @Test
    public final void testNotExistingFromInventory() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList("noItem", "Melons", "Melons", "Bananas", "noItem"));
        double price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.70d, price, 0.01);

        basket = new ShoppingBasket(Arrays.asList("nonexisting"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0d, price, 0.01);
   }
    
    
    @Test
    public final void testBuyMixOffer() {
    	
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList("Apples", "Bananas","Melons", "Melons", "Limes", "Limes", "Limes"));
        double price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(1.35d==price);
        
        basket = new ShoppingBasket(Arrays.asList("Apples", "Bananas","Melons", "Melons", "Limes", "Limes", "Limes", "noItem"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(1.35d==price);
        
        basket = new ShoppingBasket(Arrays.asList("Apples", "Apples", "Bananas","Melons", "Melons", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(1.70d==price);
        
        basket = new ShoppingBasket(Arrays.asList("Apples", "Apples", "Bananas","Melons", "Melons", "Limes", "Limes", "Limes", "noItem"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertTrue(1.70d==price);
       
    }
    
    @Test
    public final void testBuyAllTripleOffer() {
    	
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList("Melons", "Melons", "Melons", "Melons","Melons", "Melons"));
        double price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(1.5d, price, 0.01);
        
        basket = new ShoppingBasket(Arrays.asList("NoItem","Melons", "Melons", "Melons", "Melons","Melons", "Melons"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(1.5d, price, 0.01);
       
        basket = new ShoppingBasket(Arrays.asList("Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.90d, price, 0.01);
        
        basket = new ShoppingBasket(Arrays.asList("NoItem","Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes", "Limes"));
        price = basket.computePrice();
        System.out.format("%s -> Price: %.2f%n", basket.toString(), price);
        assertEquals(0.90d, price, 0.01);
    }
	

}
