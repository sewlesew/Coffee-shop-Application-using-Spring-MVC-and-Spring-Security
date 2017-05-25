package edu.mum.coffee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "OrderTable")
//@Component
public class Order implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
//	new annotation
//	@Column(name="id_1")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
//	orphanRemoval = true is added at the end
	
//   @Column(name = "id_1")  //newwwwwww
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Orderline> orderLines = new ArrayList<Orderline>();
		
	//new feature is added
	public void setOrderLines(List<Orderline> orderLines) {
					this.orderLines = orderLines;
				}

	//	@OneToOne
	@OneToOne(cascade = CascadeType.ALL)   //new feature is added
	private Person person;

	public int getId() {
		return id;
	}

	public List<Orderline> getOrderLines() {
		return Collections.unmodifiableList(orderLines);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		int quantity = 0;
		for (Orderline ol : this.orderLines) {
			quantity += ol.getQuantity();
		}
		return quantity;
	}

	public double getTotalAmount() {
		double totalAmount = 0;

		for (Orderline ol : this.orderLines) {
			totalAmount += ol.getSubtotal();
		}
		return totalAmount;
	}

	public void addOrderLine(Orderline orderLine) {
		orderLine.setOrder(this);
		this.orderLines.add(orderLine);
	}

	public void removeOrderLine(Orderline orderLine) {
		this.orderLines.remove(orderLine);
		orderLine.setOrder(null);
	}

	public void clearOrderLines() {
		for (Orderline orderline : orderLines) {
			orderline.setOrder(null);
		}
		orderLines.clear();
	}

}
