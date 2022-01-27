
Exercise: shoppingList

Using Java, write a simple program that calculates the price of a basket of shopping.
The solution should be accomplished in roughly two hours.


Items are presented one at a time, in a list, identified by name - for example "Apple" or "Banana".
Multiple items are present multiple times in the list,
so for example ["Apple", "Apple", "Banana"] is a basket with two apples and one banana.

Items are priced as follows:
 - Apples are 35p each
 - Bananas are 20p each
 - Melons are 50p each, but are available as ?buy one get one free?
 - Limes are 15p each, but are available in a ?three for the price of two? offer

Given a list of shopping, calculate the total cost of those items.

# Requirements
Assignment should follow Object oriented principles (Encapsulation, inheritance etc.)
- Use java 8 features like lambda, streams etc.
- Each component should be test using unit test cases
- Write less code for solving the problem
- Show a structure to your coding

# Solution shoppingList
- accepts the basket as a java list of String 
- returns item total as pence.
- I used test to equals boolean 
- to keep the test simple to have a less code possible  i didn't use mockito .
