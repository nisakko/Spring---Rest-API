package com.example.api.apis;

import com.example.api.models.Bestseller;
import com.example.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

@Component
@ComponentScan("com.example.api.service")
public class ApiController {

    @Autowired
    ProductViewHistoryService productViewHistoryService;

    @Autowired
    BestsellerService bestsellerService;

    @GetMapping("/api/products-viewed")
    public List<String> getLastViewedProducts(@RequestParam(value = "userId") String id) {
        List<String> productIds = productViewHistoryService.getLastViewedProducts(id);
        System.out.println("Product View: " + productIds);
        return productIds;
    }

    @DeleteMapping("/api/delete-product-view-history")
    public boolean deleteProductViewHistory(@RequestParam(value = "userId") String userId, @RequestParam(value = "productId") String productId){
        return productViewHistoryService.deleteProductViewHistory(userId, productId);
    }

    @GetMapping("/api/get-product-recommendation")
    public Bestseller getProductRecommendation(@RequestParam(value = "userId") String id){
        return bestsellerService.getProductRecommendation(id);
    }
}
