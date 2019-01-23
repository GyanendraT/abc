package com.example.mains;

import java.util.List;

import com.example.entities.ProductEntity;
import com.example.repositories.ProductRepository;

public class MainApplication {

	public static void main(String args[]) {
//		ProductEntity productEntity = new ProductEntity();
//		productEntity.setCode("BASKETBALL");
//		productEntity.setName("new basketball");
//		productEntity.setCategory("Sports");
//		productEntity.setPrice(200d);
//		
//		ProductRepository productRepository = new ProductRepository();
//		productRepository.save(productEntity);
		
		ProductRepository productRepository = new ProductRepository();
		ProductEntity p1 = productRepository.getById(2);
		System.out.println(p1.toString());
		
		System.out.println("---------------------------------------------");
		List<ProductEntity> electronicProducts = productRepository.getByCategory("electronics");
		System.out.println("These are electronics");
		for(ProductEntity p : electronicProducts) {
			System.out.println(p.toString());
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("Updateed product with id 2");
		p1.setName("Latest Iphone");
		productRepository.updateProduct(p1);
		
	}
}
