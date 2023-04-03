package com.ams.gestionDeStock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.gestionDeStock.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.label LIKE :label")
	List<Product> findProductsByLabel(String label);
	
	/**
	 * 
	 * @param 
	 * @return nombre des produits
	 */
	@Query("SELECT COUNT(pd) FROM Product pd")
     long countAllProducts();
	
	/**
	 * 
	 * @param 
	 * @return nombre des produits
	 */
	@Query("SELECT COUNT(pd) FROM Product pd WHERE pd.inventoryQuantity <= 0")
     long countProductsEp();
}
