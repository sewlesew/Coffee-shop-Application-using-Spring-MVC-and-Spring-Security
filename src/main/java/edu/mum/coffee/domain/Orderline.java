package edu.mum.coffee.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Orderline")
//@Component
public class Orderline implements Serializable {

	private static final long serialVersionUID = 7187645190789626221L;
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
//	@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
//	@ManyToOne
	//JoinColumn is a new feaure addded
	
	@ManyToOne(cascade = CascadeType.ALL)  //instructor code
//	@Id //new
//	@JoinColumn(name="id_1") //new
	private Order order;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getSubtotal() {
		return quantity * product.getPrice();
	}

	public double getPrice() {
		return product.getPrice();
	}

}
