package com.example.Shooopie.Cart.Responses;


import com.example.Shooopie.Cart.ProductPack;

import java.util.ArrayList;

public class CartViewResponse {
	private double totalprice;
	private ArrayList<ProductPack> productPacks;

	public CartViewResponse(ArrayList<ProductPack> productPacks){
		this.productPacks = productPacks;
		double price = 0;
		for (ProductPack pack : productPacks) {
			price += pack.getPrice() * pack.getQuantity();
		}
		this.totalprice = price;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public ArrayList<ProductPack> getProductPacks() {
		return productPacks;
	}

	public void setProductPacks(ArrayList<ProductPack> productPacks) {
		this.productPacks = productPacks;
	}
}
