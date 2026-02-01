package io.github.gabriellrocha.myapp.service;

import io.github.gabriellrocha.myapp.dao.ProductRepository;
import io.github.gabriellrocha.myapp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
