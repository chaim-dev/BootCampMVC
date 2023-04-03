package com.ams.gestionDeStock.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.gestionDeStock.entities.Product;
import com.ams.gestionDeStock.entities.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
	/**
	 * 
	 * @param id
	 * @return list des produits par fournisseurs
	 */
	@Query("FROM Product a WHERE a.provider.id = ?1")
    List<Product> findProductsByProvider(long id);
	
	/**
	 * 
	 * @param name
	 * @return liste des produits par name(fournisseur)
	 */
	@Query("SELECT p FROM Provider p WHERE p.name LIKE :name")
    List<Product> findProductsByName(String name);

	
	/**
	 * 
	 * @param 
	 * @return nombre des fournissuers
	 */
	@Query("SELECT COUNT(pv) FROM Provider pv")
     long countAllProviders();

}


