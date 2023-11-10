package com.jsp.hibernate_case_study_1.service;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductService {
	Scanner sc = new Scanner(System.in);
	ProductDao productDao = new ProductDao();
	public void addProduct() {
		System.out.println("Enter the id of the product : ");
		int id = sc.nextInt();
		System.out.println("Enter the name of the product : ");
		String name = sc.next();
		System.out.println("Enter the price of the product : ");
		double price = sc.nextDouble();
		System.out.println("Enter the Quantity of the product : ");
		int quant = sc.nextInt();
		Product product = new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quant);
		String message = productDao.addProduct(product);
		System.out.println(message);
	}
	public void getProductById() {
		System.out.println("Enter the id of the product to be fetched : ");
		int id = sc.nextInt();
		Product product = productDao.getProductById(id);
		System.out.println(product);
	}
	public void getAllProducts() {
		List<Product> products = productDao.getAllProducts();
		System.out.println(products);
	}
	public void updateProduct() {
		System.out.println("Enter the id of the product : ");
		int id = sc.nextInt();
		Product product = productDao.getProductById(id);
		if(product != null) {
			System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
			System.out.println("Enter the name of the product : ");
			String name = sc.next();
			System.out.println("Enter the price of the product : ");
			double price = sc.nextDouble();
			System.out.println("Enter the Quantity of the product : ");
			int quant = sc.nextInt();
			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quant);
			
			productDao.updateProduct(product);
		}else {
			System.out.println("No data found with the given id.");
		}
	}
	public void deleteProduct() {
		System.out.println("Enter the product id to delete the product : ");
		int id = sc.nextInt();
		Product product = productDao.getProductById(id);
		if(product != null) {
		String message = productDao.deleteProduct(product);
		System.out.println(message);
		}else {
			System.out.println("No product found with the given id.");
		}
	}
}
