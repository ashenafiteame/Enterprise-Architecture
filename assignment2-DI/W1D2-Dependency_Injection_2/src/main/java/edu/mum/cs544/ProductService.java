package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductService implements IProductService {
	private IInventoryService inventoryService;
	private Collection<Product> productList = new ArrayList<Product>();

	@Autowired
	public ProductService(IInventoryService inventoryService) {
		productList.add(new Product(234, "LCD TV", 895.50));
		productList.add(new Product(239, "DVD player", 315.00));
		productList.add(new Product(423, "Plasma TV", 992.55));
		//this.inventoryService = inventoryService;
		this.inventoryService = inventoryService;
	}

	public Product getProduct(int productNumber) {
		for (Product product : productList) {
			if (product.getProductNumber() == productNumber)
				return product;
		}
		return null;
	}


	public int getNumberInStock(int productNumber) {
		return inventoryService.getNumberInStock(productNumber);
	}
	@Autowired
	public void setInventoryService(IInventoryService inventoryService){
		this.inventoryService=inventoryService;
	}

}
