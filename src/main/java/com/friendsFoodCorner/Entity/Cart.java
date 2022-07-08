package com.friendsFoodCorner.Entity;



import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public
	int id;
	 public String item;
	 public String image;
	 @Column(name = "Ordered_On")
	 @Temporal(TemporalType.DATE)
	 @CreationTimestamp
	    public Date Ordered_On;

		public double quantity;
	public	double total;
	public double price;

//	@Pattern (regexp= "1234567890^#@$%^&*$")
	public String name;
public Cart(int id, String item, String image, Date ordered_On, double quantity, double total, double price,
			String name) {
		super();
		this.id = id;
		this.item = item;
		this.image = image;
		Ordered_On = ordered_On;
		this.quantity = quantity;
		this.total = total;
		this.price = price;
		this.name = name;
	}
public Date getOrdered_On() {
		return Ordered_On;
	}
	public void setOrdered_On(Date ordered_On) {
		Ordered_On = ordered_On;
	}
public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

@Override
public String toString() {
	return "Cart [id=" + id + ", item=" + item + ", image=" + image + ", Ordered_On=" + Ordered_On + ", quantity="
			+ quantity + ", total=" + total + ", price=" + price + ", name=" + name + "]";
}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
