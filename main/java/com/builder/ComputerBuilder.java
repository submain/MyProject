package com.builder;

/**
 * 建造者模式
 * @author Administrator
 *
 */
public class ComputerBuilder {
		private double price;
		private String type;
		private String address;
		private String leavel;
		private String logo;

	
	public static class Builder{
		private double price;
		private String type;
		private String address;
		private String leavel;
		private String logo;
		
		public Builder price(double price ) {
			this.price=price;
			return this;
		}
		public Builder type(String  type ) {
			this.type=type;
			return this;
		}
		public Builder address(String  address ) {
			this.address=address;
			return this;
		}
		public Builder leavel(String  leavel ) {
			this.leavel=leavel;
			return this;
		}
		public Builder logo(String  logo ) {
			this.logo=logo;
			return this;
		}
		
		public ComputerBuilder builder() {
			return new ComputerBuilder(this);
		}
	}
	private ComputerBuilder(Builder builder) {
		this.address = builder.address;
		this.price = builder.price;
		this.leavel = builder.leavel;
		this.logo = builder.logo;
		this.type = builder.type;
	}
	
	
	
	@Override
	public String toString() {
		return "ComputerBuilder [price=" + price + ", type=" + type + ", address=" + address + ", leavel=" + leavel
				+ ", logo=" + logo + "]";
	}



	public  static void main (String [] args) {
		ComputerBuilder computerBuilder = new ComputerBuilder.Builder().address("北京").builder();
		System.out.println(computerBuilder);
	}
	

}
