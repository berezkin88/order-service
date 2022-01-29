package com.example.orderservice.repository;

import com.example.orderservice.domain.OrderHeader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Test
    void persistOrder() {
        var order = new OrderHeader();
        order.setCustomerName("John Doe");
        orderHeaderRepository.save(order);

        var allOrders = orderHeaderRepository.findAll();

        assertThat(allOrders)
            .hasSize(1)
            .element(0)
            .extracting(OrderHeader::getCreatedDate)
            .isNotNull();
    }
}