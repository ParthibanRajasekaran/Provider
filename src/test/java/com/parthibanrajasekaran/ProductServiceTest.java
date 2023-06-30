// ProductServiceTest.java
package com.parthibanrajasekaran.service;

import com.parthibanrajasekaran.model.Product;
import com.parthibanrajasekaran.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product("1", "Product1");
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);
        assertEquals(product, createdProduct);
    }

    @Test
    public void testGetProductById() {
        Product product = new Product("1", "Product1");
        Mockito.when(productRepository.findById("1")).thenReturn(Optional.of(product));

        Optional<Product> retrievedProduct = productService.getProductById("1");
        assertEquals(product, retrievedProduct.orElse(null));
    }
}
