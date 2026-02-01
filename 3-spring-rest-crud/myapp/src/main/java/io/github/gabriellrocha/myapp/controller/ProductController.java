package io.github.gabriellrocha.myapp.controller;

import io.github.gabriellrocha.myapp.entity.Product;
import io.github.gabriellrocha.myapp.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok()
                .body(productService.createProduct(product));
    }

    // pagination + sorting
    // spring analisa os params (page, size, sort) da URL e injeta um Pageable com esses valores
    // @PageableDefault - Define valores padrão, caso a request não envie
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return ResponseEntity.ok()
                .body(productService.findAllProducts(pageable));
    }
}
