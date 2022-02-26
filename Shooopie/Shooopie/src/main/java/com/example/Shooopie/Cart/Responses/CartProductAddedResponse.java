package com.example.Shooopie.Cart.Responses;

public class CartProductAddedResponse{
	private String message;

	public CartProductAddedResponse(String message){
		this.message = message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}