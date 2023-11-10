package hibernate_case_study_1Services;
//import java.util.List;
//import java.util.Scanner;
//
//import hibernate_case_study.entity.Product;
//import hibernate_case_study.entity.dao.ProductDao;
//
//public class ProductServices {
//	ProductDao productDao=new ProductDao();
//	Scanner input=new Scanner(System.in);
//
//	public String addProduct() {
//		Product product=new Product();
//		System.out.println("enter the product  name");
//		String productName=input.next();
//		System.out.println("Enter the product price");
//		double productPrice=input.nextDouble();
//		System.out.println("Enter the product Quantity");
//		int productQuantity=input.nextInt();
//		product.setProductName(productName);
//		product.setProductPrice(productPrice);
//		product.setProductQuantity(productQuantity);
//		productDao.addById(product);
//		return "Successfully a product is added ";
//	}
//	public void getById() {
//		System.out.println("Enter the product id which you fetch details");
//		int productId=input.nextInt();
//		Product product=productDao.getProdcutById(productId);
//		if(product!=null) {
//			System.out.print(product.getProductName()+" ");
//			System.out.print(product.getProductPrice()+" ");
//			System.out.print(product.getProductQuantity()+" ");
//		}
//		else {
//			System.err.println("We dont have any record in database that you entered");
//		}
//	}
//	public void getAll() {
//		List<Product> allProduct = productDao.getAllProduct();
//		for(Product product:allProduct) {
//			if(product!=null) {
//				System.out.print(product.getProductName()+" ");
//				System.out.print(product.getProductPrice()+" ");
//				System.out.print(product.getProductQuantity()+" ");
//				System.out.println();
//			}
//			else {
//				System.err.println("We dont have any record in database ");
//			}
//		}
//	}
//	public void updateProduct() {
//		System.out.println("Enter the product id which should be updated");
//		int productId=input.nextInt();
//		Product product = productDao.getProdcutById(productId);
//		getById();
//		if(product!=null) {
//
//			System.out.println("Enter product name which should be updated");
//			String productName=input.next();
//			System.out.println("enter product price which should be updated");
//			double productPrice=input.nextDouble();
//			System.out.println("enter the product quantity that you need to change");
//			int productQuaantity=input.nextInt();
//			product.setProductName(productName);
//			product.setProductPrice(productPrice);
//			product.setProductQuantity(productQuaantity);	
//			productDao.updateProductById(product);
//
//		}
//		else {
//			System.err.println("We dont have any record in database that you entered");
//		}
//	}
//	public void deleteProduct() {
//		System.out.println("Enter the product id which should be updated");
//		int productId=input.nextInt();
//		Product product = productDao.getProdcutById(productId);
//		getById();
//		if(product!=null) {
//			productDao.deleteProductById(product);
//
//		}
//		else {
//			System.err.println("We dont have any record in database that you entered");
//		}
//
//	}
//}



import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study.dao.ProductDa;
import com.jsp.hibernate_case_study.entity.Product;

public class ProductServices {

	Scanner input=new Scanner(System.in);
	ProductDa productda=new ProductDao();
	
//	To add product
	
	public void addProduct() {
		
		System.out.println("Enter the ProductName");
		String pname=input.next();
		
		System.out.println("Eneter the Product Price");
		double price=input.nextDouble();
		
		System.out.println("Enter the product Quantity");
		int quantity=input.nextInt();
		Product product=new Product();
		
		
		product.setProductName(pname);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);
		
		String message=productda.addProduct(product);
		System.out.println(message);
	}
	
//	To Get all product
	
	public void getProduct() {
		List<Product> products = productda.getAllProduct();
		for(Product product:products) {
			System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
		}
	}
//	get by id
	
	public void getProductById() {
		System.out.println("Enter the id");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
	}
	
//	Update record using id
	public void updateProduct() {
		System.out.println("Enter Id to be Updated");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		if(product != null) {
			System.out.println("Enter product name");
			String productName=input.next();
			product.setProductName(productName);
			productda.updateProductById(product);
			System.out.println("Update Successfull");
		}
		else {
			System.err.println("No id Found");
		}
	}
	
//	Delete by id
	
	public void deleteById() {
		System.out.println("Enter Id to be Deleted");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		if(product != null) {
			productda.deleteById(product);
			System.out.println("Deleted Successfully");
		}
		else {
			System.err.println("No id Found");
		}
	}
}