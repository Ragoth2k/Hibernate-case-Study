package hibernate_case_study.entity.dao;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import hibernate_case_study.entity.Cart;
//
//
//
//public class CartDao 
//{
//	static Configuration con = new Configuration().configure().addAnnotatedClass(CartDao.class);
//	static SessionFactory sf = con.buildSessionFactory();
//
//	public static void deleteCart(CartDao cart) {// delete()
//		Session session = sf.openSession();
//		Transaction tr=session.beginTransaction();
//		session.delete(cart);
//		tr.commit();
//	}
//	public static void updateCart(CartDao cart) 
//	{
//		Session session=sf.openSession();
//		Transaction transaction =session.beginTransaction();
//		session.update(cart);
//		transaction.commit();
//		session.close();
//	}
//	public static Cart getCartById(int id) 
//	{
//		Session session=sf.openSession();
//		Transaction transaction =session.beginTransaction();
//		Cart cart=session.get(CartDao.class, id);
//		session.close();
//		transaction.commit();
//		return cart;
//		
//	}
//	
//}
//
//






import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study.entity.Cart;
import com.jsp.hibernate_case_study.entity.Product;

public final class CartDao {

	Configuration con=new Configuration().configure().addAnnotatedClass(CartDao.class).addAnnotatedClass(Product.class);
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