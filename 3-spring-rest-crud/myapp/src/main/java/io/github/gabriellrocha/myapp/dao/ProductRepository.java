package io.github.gabriellrocha.myapp.dao;

import io.github.gabriellrocha.myapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
