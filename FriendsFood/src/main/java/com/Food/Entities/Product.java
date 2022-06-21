package com.Food.Entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="menu")

public class Product {
        @Id
        int id;
        String item_name;
        public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Product(int id, String item_name, String category, double price) {
			super();
			this.id = id;
			this.item_name = item_name;
			this.category = category;
			this.price = price;
		}
		String category;
        double price;
		@Override
		public String toString() {
			return "Product "+" p_id=" + id + ", item_name=" + item_name + ", price=" + price;
		}
		public int getId() {
			return id;
		}
		public void setP_id(int id) {
			this.id = id;
		}
		public String getItem_name() {
			return item_name;
		}
		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
}