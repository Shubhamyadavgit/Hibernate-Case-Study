package com.jsp.hibernate_case_study_1.service;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.CartDao;
import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartService {
	Scanner sc = new Scanner(System.in);
	CartDao cartDao = new CartDao();
	ProductDao productDao = new ProductDao();
public void createCart() {
	System.out.println("Enter the cart id to create : ");
	int id = sc.nextInt();
	Cart cart = new Cart();
	cart.setCartId(id);
	String message = cartDao.createCart(cart);
	System.out.println(message);
}
public void addProductToCart() {
	System.out.println("Enter the product id to add to the cart : ");
	int id = sc.nextInt();
	System.out.println("Enter the cart id to add the product to the cart : ");
	int cId = sc.nextInt();
	Product product = productDao.getProductById(id);
	String message = cartDao.addProductToCart(product,cId);
	System.out.println(message);
}
public void removeProductFromCart() {
	System.out.println("Enter the product id to remove from the cart : ");
	int id = sc.nextInt();
	Product product = productDao.getProductById(id);
	String message = cartDao.removeProductFromCart(product);
	System.out.println(message);
}
}
