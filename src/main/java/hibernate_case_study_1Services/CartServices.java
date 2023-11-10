package hibernate_case_study_1Services;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

import hibernate_case_study.entity.Cart;
import hibernate_case_study.entity.dao.CartDao;


public class CartServices{

Scanner sc = new Scanner(System.in);
CartDao cartDao=new CartDao();

public  void deleteCart() {
	System.out.println("Enter the Cart Id for delete");
	int cid = sc.nextInt();
	Cart cart = cartDao.getCartById(cid);
	if (cart != null)
		cartDao.deleteCart(cart);
	else
		System.out.println("Invalid Cart id");
}

public  void updateCart() {
	System.out.println("Enter the Cart Id for Updation");
	int cid = sc.nextInt();
	Cart cart = cartDao.getCartById(cid);
	if (cart != null) {
		cartDao.updateCart(cart);
	} else {
		System.out.println("Invalid Cart id");
	}
}

public void createCart() {
	Cart cart=new Cart();
	String message=cartDao.addCart(cart);
	System.out.println(message);
}
//to add product to cart

public void addProductToCart() {
	System.out.println("enter the cart id");
	int cartId=sc.nextInt();
	System.out.println("enter the Product id");
	int productId=sc.nextInt();
	Cart cart=new CartDao().getCartById(cartId);
	Product product=new ProductDao().getProductById(productId);
	if(cart != null && product != null) {
		String message=cartDao.addProductToCart(cart, product);
		System.out.println(message);
	}
	else {
		System.err.println("cart or product not found");
	}	
}
//get cart by id
public void getCartById() {
	System.out.println("enter cart id");
	int cartId=sc.nextInt();
	Cart cart=cartDao.getCartById(cartId);
	System.out.println(cart.getCartId());
}
}


//import java.util.Scanner;
//
//import hibernate_case_study.entity.Cart;
//import hibernate_case_study.entity.Product;
//import hibernate_case_study.entity.dao.CartDa;
//import hibernate_case_study.entity.dao.CartDa;
//
//
//
//public class CartServices {
//	static Scanner input = new Scanner(System.in);
//	CartDa cartda=new CartDa();
//	
////	To create cart
//	
//	public void createCart() {
//		Cart cart=new Cart();
//		String message=cartda.addCart(cart);
//		System.out.println(message);
//	}
////	to add product to cart
//	
//	public void addProductToCart() {
//		System.out.println("enter the cart id");
//		int cartId=input.nextInt();
//		System.out.println("enter the Product id");
//		int productId=input.nextInt();
//		Cart cart=new CartDa().getCartById(cartId);
//		Product product=new Product().getProductById(productId);
//		if(cart != null && product != null) {
//			String message=cartda.addProductToCart(cart, product);
//			System.out.println(message);
//		}
//		else {
//			System.err.println("cart or product not found");
//		}
//	
//	}
////	get cart by id
//	public void getCartById() {
//		System.out.println("enter cart id");
//		int cartId=input.nextInt();
//		Cart cart=cartda.getCartById(cartId);
//		System.out.println(cart.getCartId());
//	}
////	delete cart by id
//	
//	public void deleteCartById() {
//		System.out.println("enter cart id");
//		int cartId=input.nextInt();
//		Cart cart=cartda.getCartById(cartId);
//		if(cart != null) {
//			
//			cartda.deleteCartById(cart);
//		}
//		else {
//			System.err.println("No cart found");
//		}
//	}
//}
//
