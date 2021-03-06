package com.cts.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.product.entities.Product;

public interface ProductDao extends JpaRepository<Product, String>{
	
	
	public List<Product> findByProdNameIsLike(String prodName);
	
	@Query("from Product prod where prod.prodName like '%Ipad%'")
	List<Product>  findAllIpads();
	

}
