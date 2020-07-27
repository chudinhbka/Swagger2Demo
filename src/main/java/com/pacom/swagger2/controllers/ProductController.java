package com.pacom.swagger2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;

import com.pacom.swagger2.domain.Product;
import com.pacom.swagger2.dto.response.BodyResponse;
import com.pacom.swagger2.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(final ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity list(final Model model){
        final Iterable<Product> productList = productService.listAllProducts();
        final BodyResponse bodyResponse = new BodyResponse();
        bodyResponse.setData(productList);
        return ResponseEntity.ok().body(bodyResponse);
    }
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity showProduct(@PathVariable final Integer id, final Model model){
       final Product product = productService.getProductById(id);
       final BodyResponse bodyResponse = new BodyResponse();
       bodyResponse.setData(product);
        return ResponseEntity.ok().body(bodyResponse);
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody final Product product){
        productService.saveProduct(product);
        final BodyResponse bodyResponse = new BodyResponse();
        bodyResponse.setData("Product added successfully");
        return ResponseEntity.ok().body(bodyResponse);
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable final Integer id, @RequestBody final Product product){
        final Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable final Integer id){
        productService.deleteProduct(id);
        final BodyResponse bodyResponse = new BodyResponse();
        bodyResponse.setData("Product deleted successfully");
        return ResponseEntity.ok().body(bodyResponse);

    }

}