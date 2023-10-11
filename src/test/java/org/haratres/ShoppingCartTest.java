package org.haratres;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private final ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void testShoppingCartTotalDiscount() {
        int[] shoppingCartArr = {5, 6, 4, 3, 4};
        int expectedTotalDiscount = 7;

        assertEquals(expectedTotalDiscount, shoppingCart.calculateTotalDiscount(shoppingCartArr));
    }

    @Test
    public void testShoppingCartNonDiscountedItems() {
        int[] shoppingCartArr = {5, 2, 1, 3, 4};
        int[] NonDiscountShoppingCart = shoppingCart.nonDiscountedShoppingCart(shoppingCartArr);
        int[] expectedResult = {3, 4, 5};
        assertArrayEquals(expectedResult, NonDiscountShoppingCart);
    }

    @Test
    public void testShoppingCartTotalDiscountWithInvalidInput() {
        int[] shoppingCartArr = {2001, 0};
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.calculateTotalDiscount(shoppingCartArr));
    }

    @Test
    public void testShoppingCartNonDiscountedItemsWithInvalidInput() {
        int[] shoppingCartArr = {};
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.nonDiscountedShoppingCart(shoppingCartArr));
    }


}