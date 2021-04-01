package com.example.api.repository;

import com.example.api.models.ProductViewHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductViewHistoryRepository extends CrudRepository<ProductViewHistory, String> {

    @Query(value = "SELECT productid FROM public.product_view_history WHERE userid = ?1 ORDER BY clicktimestamp DESC LIMIT 10", nativeQuery = true)
    List<String> getLastViewedProducts(String userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM product_view_history WHERE userid = ?1 AND productid = ?2", nativeQuery = true)
    void deleteProductViewHistory(String userId, String productId);
}
