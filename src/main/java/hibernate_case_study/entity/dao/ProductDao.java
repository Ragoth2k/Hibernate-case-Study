package hibernate_case_study.entity.dao;

//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.NativeQuery;
//
//import hibernate_case_study.entity.Product;
//
//
//
//public class ProductDao {
//	Configuration cfg =new Configuration().configure().addAnnotatedClass(Product.class);
//	public void addById(Product product) {	
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.save(product);
//		transaction.commit();
//		session.close();
//	}
//
//	public Product getProdcutById(int id) {
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		Product product = session.get(Product.class, id);
//		transaction.commit();
//		session.close();
//		return product;
//
//	}
//	public List<Product> getAllProduct() {
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		NativeQuery <Product>query = session.createNativeQuery("Select * from Product",Product.class);
//		List <Product>product = query.list();
//		return product;
//
//	}
//	public void updateProductById(Product product) {
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.update(product);
//
//		transaction.commit();
//		session.close();
//
//	}
//	public void deleteProductById(Product product) {
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.delete(product);
//
//		transaction.commit();
//		session.close();
//	}
//
//}



import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study.entity.Cart;
import com.jsp.hibernate_case_study.entity.Product;

public final class CartDa {

	Configuration con=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sessionFactory=con.buildSessionFactory();
	Scanner input=new Scanner(System.in);
//	add cart
	
	public String addCart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "cart added";
	}
//	delete cart
	
//	add product to cart
	public String addProductToCart(Cart cart,Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		cart.getProducts().add(product);
		session.update(cart);
		transaction.commit();
		session.close();
		return "Product added to cart";
	}

	public Cart getCartById(int cartId) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Cart cart=session.get(Cart.class, cartId);
		transaction.commit();
		session.close();
		return cart;
	}
	
//	delete cart by id
	public String deleteCartById(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(Cart.class);
		transaction.commit();
		session.close();
		return "Deleted successfully";
	}
	
	
	
}
