package com.example.orderservice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderHeaderTest {

    @Test
    void testEquals() {
        var orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        var orderHeader2 = new OrderHeader();
        orderHeader2.setId(1L);

        assertEquals(orderHeader1, orderHeader2);
    }

    @Test
    void testNotEquals() {
        var orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        var orderHeader2 = new OrderHeader();
        orderHeader2.setId(2L);

        assertNotEquals(orderHeader1, orderHeader2);
    }
}