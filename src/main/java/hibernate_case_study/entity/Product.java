package hibernate_case_study.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private int productId;
private String productName;
private double productPrice;
private int productQuantity;
public int getProductId() {
	return productId;
}

public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}


}

//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class Product 
//{
//
//	@Id
//	private int productId;
//	private String ProductName;
//	private double ProductPrice;
//	private int productQuantity;
//	public int getProductId() {
//		return productId;
//	}
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//	public String getProductName() {
//		return ProductName;
//	}
//	public void setProductName(String productName) {
//		ProductName = productName;
//	}
//	public double getProductPrice() {
//		return ProductPrice;
//	}
//	public void setProductPrice(double productPrice) {
//		ProductPrice = productPrice;
//	}
//	public int getProductQuantity() {
//		return productQuantity;
//	}
//	public void setProductQuantity(int productQuantity) {
//		this.productQuantity = productQuantity;
//	}
//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
//				+ ", productQuantity=" + productQuantity + "]";
//	}
//	
//	
//}
