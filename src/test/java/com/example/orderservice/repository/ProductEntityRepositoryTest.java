package com.example.orderservice.repository;

import com.example.orderservice.domain.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductEntityRepositoryTest {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Test
    void persistOrder() {
        var product = new ProductEntity();
        product.setDescription("Ipsum Lorem");
        productEntityRepository.save(product);

        var allProducts = productEntityRepository.findAll();

        assertThat(allProducts)
            .hasSize(1)
            .element(0)
            .matches(el -> el.getCreatedDate() != null)
            .matches(el -> el.getLastModifiedDate() != null);
    }
}