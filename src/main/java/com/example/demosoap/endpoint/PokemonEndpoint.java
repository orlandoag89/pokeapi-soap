package com.example.demosoap.endpoint;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demosoap.business.IPokemonBusiness;
import com.example.demosoap.business.dto.enums.MethodIntEnum;
import com.example.demosoap.business.impl.PokemonBusinessImpl;
import com.example.demosoap.converter.ProductConverter;
import com.example.demosoap.endpoint.mapper.GetPokemonRequestMapper;
import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.gen.GetProductRequest;
import com.example.demosoap.gen.GetProductResponse;
import com.example.demosoap.gen.GetProductsRequest;
import com.example.demosoap.gen.GetProductsResponse;
import com.example.demosoap.gen.PostProductRequest;
import com.example.demosoap.gen.PostProductResponse;
import com.example.demosoap.gen.Product;
import com.example.demosoap.model.ProductModel;
import com.example.demosoap.repository.ProductRepository;

@Endpoint
public class PokemonEndpoint {
	
	private static final Logger logger = LogManager.getLogger(PokemonEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";
    
    @Autowired
    private IPokemonBusiness business;
    
    @Autowired
    private GetPokemonRequestMapper getPokemonRequestMapper;
    
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductConverter productConverter;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemonRequest(@RequestPayload GetPokemonRequest request) {
    	logger.info("retrieving pokemon");
    	business.getPokemon(getPokemonRequestMapper.toInner(request));
//    	GetProductResponse response = new GetProductResponse();
//        ProductModel productModel = productRepository.findByName(request.getName());
//        response.setProduct(productConverter.convertProductModelToProduct(productModel));
    	return null;
    }

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
//    @ResponsePayload
//    public GetPokemonResponse getProduct(@RequestPayload GetPokemonRequest request) {
//    	logger.info("retrieving products");
////        GetProductResponse response = new GetProductResponse();
////        ProductModel productModel = productRepository.findByName(request.getName());
////        response.setProduct(productConverter.convertProductModelToProduct(productModel));
//        return null;
//    }
//    
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
//    @ResponsePayload
//    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
//        GetProductsResponse response = new GetProductsResponse();
//        List<ProductModel> productModels = productRepository.findAll();
//        List<Product> products = productConverter.convertProductModelsToProducts(productModels);
//        response.getProducts().addAll(products);
//        return response;
//    }
//    
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductRequest")
//    @ResponsePayload
//    public PostProductResponse postProducts(@RequestPayload PostProductRequest request) {
//        PostProductResponse response = new PostProductResponse();
//        ProductModel productModel = productConverter.convertProductToProductModel(request.getProduct());
//        Product product = productConverter.convertProductModelToProduct(productRepository.save(productModel));
//        response.setProduct(product);
//        return response;
//    }
}
