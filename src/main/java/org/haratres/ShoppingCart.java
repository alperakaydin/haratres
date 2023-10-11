package org.haratres;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class ShoppingCart {

    public Integer calculateTotalDiscount(int[] shoppingCart) {
        validateShoppingCart(shoppingCart);
        int totalDiscount = 0;

        for (int i = 1; i < shoppingCart.length; i++) {
            if (shoppingCart[i - 1] > shoppingCart[i]) {
                totalDiscount += shoppingCart[i];
            }
        }
        return totalDiscount;
    }

    public int[] nonDiscountedShoppingCart(int[] shoppingCart) {
        validateShoppingCart(shoppingCart);
        List<Integer> nonDiscountedItems = new ArrayList<>();

        for (int i = 1; i < shoppingCart.length; i++) {
            if (shoppingCart[i - 1] < shoppingCart[i]) {
                nonDiscountedItems.add(i - 1);
            }
        }
        // last item is always added to the list because no items next it
        nonDiscountedItems.add(shoppingCart[shoppingCart.length - 1]);

        int[] nonDiscountedItemsToArray = nonDiscountedItems.stream().mapToInt(i -> i + 1).toArray();

        Arrays.sort(nonDiscountedItemsToArray);
        return nonDiscountedItemsToArray;
    }

    private void validateShoppingCart(int[] shoppingCart) {
        if (shoppingCart.length < 1 | shoppingCart.length > 100) {
            throw new IllegalArgumentException("Shopping Cart must contain between 1 and 100 products");
        }
        for (int item : shoppingCart) {
            if (item < 0 | item > 2000) {
                throw new IllegalArgumentException("Index of shopping cart item must between 0 and 2000");
            }
        }
    }
}
