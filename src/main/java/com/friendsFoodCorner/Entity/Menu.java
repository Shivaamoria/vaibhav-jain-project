package com.friendsFoodCorner.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="menu")
public class Menu {
 @Id
        public int id;
        @NotNull

         public String item;
        @NotNull
        public String image;
        @NotNull
		public String category;
        @NotNull
        public double price;
		
        public Menu() {
			}

		public Menu(int id, String item, String image, String category, double price) {
			super();
			this.id = id;
			this.item = item;
			this.image = image;
			this.category = category;
			this.price = price;
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

		@Override
		public String toString() {
			return "Menu [id=" + id + ", item=" + item + ", image=" + image + ", category=" + category + ", price="
					+ price + "]";
		}
			
		
}
