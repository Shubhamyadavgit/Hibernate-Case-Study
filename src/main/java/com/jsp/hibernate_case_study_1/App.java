package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.service.CartService;
import com.jsp.hibernate_case_study_1.service.ProductService;


public class App 
{
    public static void main( String[] args )
    {
    	ProductService productService = new ProductService();
    	CartService cartService = new CartService();
    	Scanner sc = new Scanner(System.in);
//    	while(true) {
//    		System.out.println("Press 1 to add product.");
//    		System.out.println("Press 2 to get product details.");
//    		System.out.println("Press 3 to get all the product.");
//    		System.out.println("Press 4 to update product details.");
//    		System.out.println("Press 5 to delete product.");
//    		System.out.println("Press 6 to exit.");
//    		System.out.println("Enter the choice : ");
//    		int choice = sc.nextInt();
//    		switch(choice) {
//    		case 1:{
//    			productService.addProduct();
//    			break;
//    		}
//    		case 2:{
//    			productService.getProductById();
//    			break;
//    		}
//    		case 3:{
//    			productService.getAllProducts();
//    			break;
//    		}
//    		case 4:{
//    			productService.updateProduct();
//    			break;
//    		}
//    		case 5:{
//    			productService.deleteProduct();
//    			break;
//    		}
//    		case 6:{
//    			System.exit(0);
//    			break;
//    		}
//    		default :
//    			System.out.println("Invalid choice");
//    			sc.close();
//    		}
//    	}
    	while(true) {
    		System.out.println("Press 1 to create cart.");
    		System.out.println("Press 2 to add product to cart.");
    		System.out.println("Press 3 to remove product from cart.");
    		System.out.println("Enter the choice : ");
    		int choice=sc.nextInt();
    		switch(choice) {
    		case 1:{
    			cartService.createCart();
    			break;
    		}
    		case 2:{
    			cartService.addProductToCart();
    			break;
    		}
    		case 3:{
    			cartService.removeProductFromCart();
    			break;
    		}
    		default :{
    			System.out.println("Invalid choice.");
    		}
    		sc.close();
    		}
    	}
    }
}
