package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.domain.ProductGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDataProvider implements ProductGateway {

    ProductRepository productRepository;

    public ProductDataProvider(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
