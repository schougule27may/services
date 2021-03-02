package com.itline24.ecm.controller;

import com.itline24.ecm.misc.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.summingDouble;

@RestController
@RequestMapping("product")
public class MiscController {


    @RequestMapping(value="total", method = RequestMethod.POST)
    public double totalProductPrice(@RequestBody List<Product> productList) {
        double totalProductPrices3 =0d;
        if(productList != null) {
             totalProductPrices3 = productList.stream()
                    .collect(summingDouble(product -> product.price));

        }
        return totalProductPrices3;
    }

    @RequestMapping(value="max", method = RequestMethod.POST)
    public Product getMaxProduct(@RequestBody List<Product> productList){
      return  productList.stream().
                max((product1, product2) -> product1.price > product2.price ? 1 : -1 )
                .get();
    }


    @GetMapping("products")
    // It maps the HTTP GET requests on the specfic handler
    // fetches
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        Product product =  new Product();
        product.setId(1);
        product.setName("Dell");
        products.add(product);
        products.add(product);
        products.add(product);
        return products;
    }

}
