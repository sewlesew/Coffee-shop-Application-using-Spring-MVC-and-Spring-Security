package edu.mum.coffee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.ProductService;

@Controller
//@Component
public class OrderController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
//	@PostMapping("/home")
//	public String homePage(){
//		return "home";
//	}
//	@GetMapping("/home")
//	public String home(){
//		return "home";
//	}
	
	public Order createOrder(){
		Order order=new Order();
		Person person=new Person();
		Address address=new Address();
		person.setAddress(address);

     order.setPerson(person);
		return order;
	}
	
	public Orderline createOrderLine(Order order){
		
		System.out.println("sewlesew"+order.getPerson().getFirstName());
		Product product=new Product();
		order.setOrderDate(new Date());
	Order ord=new Order();
	//ord.setOrderDate(order.getOrderDate());;
	ord.setOrderDate(new Date());
		Orderline orderLine=new Orderline();
		orderLine.setProduct(product);
		orderLine.setOrder(ord);
		return orderLine;
	}
	
	public List<String> productListByName(){
		List<String> productNames=new ArrayList<String>();
		List<Product> products=productService.getAllProduct();
		for(Product product: products){
			productNames.add(product.getProductName());		}
		return productNames;
	}
	            
	public void addOrderLine(Order order,Orderline orderLine){
		List<Product> orderLineProducts=productService.findByProductType(orderLine.getProduct().getProductType());
	
		   for(Product product:orderLineProducts){
			   if(product.getProductName().equals(orderLine.getProduct().getProductName())){
				   orderLine.getProduct().setPrice(product.getPrice());	
				   break;
			   }
		     }
		   
		order.addOrderLine(orderLine);
		
	}
	
	public void clearOrdeLines(Order order){
		order.clearOrderLines();
	}
	
	public void submitOrder(Order order){
		orderService.save(order);		
	}
	
	
	@InitBinder
	public void initBuild(WebDataBinder binder){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(dateFormat, true));
			
	}


}
