package com.example.api.service;

import com.example.api.models.ProductViewHistory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ProductViewHistoryService {

    List<ProductViewHistory> findAllProductViewHistories();
    ProductViewHistory findById(String messageId);
    ProductViewHistory insert(ProductViewHistory p);
    boolean delete(String messageId);
    boolean update(ProductViewHistory p);
    List<String> getLastViewedProducts(String userId);
    boolean deleteProductViewHistory(String userId, String productId);
}
