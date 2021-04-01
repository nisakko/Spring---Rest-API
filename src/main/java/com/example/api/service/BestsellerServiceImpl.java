package com.example.api.service;

import com.example.api.models.Bestseller;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class BestsellerServiceImpl implements BestsellerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bestseller getProductRecommendation(String userId) {
        Query specificCategoryQuery = entityManager.createNativeQuery("SELECT product_id FROM specific_category_bestseller WHERE category_id IN (SELECT category_id FROM product_view_history AS " +
                "PVH INNER JOIN products AS P ON PVH.productid = P.product_id WHERE userid = ? LIMIT 3)");
        specificCategoryQuery.setParameter(1,userId);
        @SuppressWarnings("unchecked")
        List<Object> specificBestSellers = specificCategoryQuery.getResultList();
        Bestseller bestSeller = new Bestseller();
        bestSeller.setUserId(userId);

        if(!specificBestSellers.isEmpty()){
            for(Object o : specificBestSellers ){
                System.out.println(o.toString());
                bestSeller.getProductIds().add(o.toString());
            }
            bestSeller.setPersonalizedType("personalized");
        } else{
            Query generalCategoryQuery = entityManager.createNativeQuery("SELECT product_id FROM general_category_bestseller");
            @SuppressWarnings("unchecked")
            List<Object> generalBestSellers = generalCategoryQuery.getResultList();
            bestSeller.setPersonalizedType("non-personalized");
            for(Object o : generalBestSellers ){
                System.out.println(o.toString());
                bestSeller.getProductIds().add(o.toString());
            }
        }

        return bestSeller;
    }
}
