package com.example.api.service;

import com.example.api.models.Bestseller;
import org.springframework.stereotype.Component;

@Component
public interface BestsellerService {

    Bestseller getProductRecommendation(String userId);
}
