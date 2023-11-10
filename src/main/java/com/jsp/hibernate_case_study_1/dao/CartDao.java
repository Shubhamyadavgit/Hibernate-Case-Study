package com.jsp.hibernate_case_study_1.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartDao {
	Scanner sc = new Scanner(System.in);
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Cart cart = new Cart();
	public String createCart(Cart cart) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "Cart created successfully";
	}
	public String addProductToCart(Product product,  int id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = session.get(Cart.class, id);
		if(cart != null) {
		cart.getProducts().add(product);
		session.update(cart);
		}
		transaction.commit();
		return "Product added successfully.";
	}
	public String removeProductFromCart(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
		return "Product removed from the cart";
	}
	public List viewCart(int id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = session.get(Cart.class, id);
		Query<Cart> query = session.createQuery("from cart");
		List<Cart> list = query.getResultList();
		transaction.commit();
		session.close();
		return list;
	}
}
