package com.example.demo.controller;

import com.example.demo.model.Product;

import com.example.demo.requestBodies.Comment;
import com.example.demo.requestBodies.CommentReq;
import com.example.demo.requestBodies.OwnerReq;
import com.example.demo.requestBodies.ProductRequest;
import com.example.demo.requestBodies.ProductUpdateRequest;
import com.example.demo.requestBodies.RatingReq;
import com.example.demo.requestBodies.SerachBody;
import com.example.demo.requestBodies.categoryreq;
import com.example.demo.requestBodies.discountReq;
import com.example.demo.requestBodies.productid;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;
	
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST )
	public String addproduct(@RequestBody ProductRequest request) {
		
		return service.addProduct(request);
	}
	
	@RequestMapping(path = "/updateproduct", method = RequestMethod.POST)
	public void updateProduct(@RequestBody ProductUpdateRequest updateRequest) {
		
		service.updateProduct(updateRequest);
		
	}
	
	@RequestMapping(path = "/getallproducts", method = RequestMethod.GET)
	public List<Product> getallProducts() {
		
		return service.getAllProducts();
	}
	
	@RequestMapping("/getOneProduct")
	public List<Product> getOneProduct(@RequestBody productid pid){
		System.out.println("get One Product" +pid);
		return service.getProductsById(pid);
	}
	
	@RequestMapping("/addcomment")
	public void addComment(@RequestBody CommentReq req) {
		
		System.out.println("add comment called");
		
		service.addComment(req);
		
	}
	
	@RequestMapping("/addrating")
	public void addRating(@RequestBody RatingReq req) {
		
		System.out.println("rating called");
		service.addRating(req);
		
	}
	
	@RequestMapping("/getrating")
	public double getRating(@RequestBody productid p) {
		
		return service.getRating(p.pid);
	}
	
	
	@RequestMapping("/setdiscount")
	public void setDiscount(@RequestBody discountReq req) {
		
		service.setDiscount(req);
		
	}
	
	@RequestMapping("/getproductsbyowner")
	public List<Product> getProductsByOwner(@RequestBody OwnerReq req ){
		return service.getProductsByOwner(req);
	}
	
	@RequestMapping("/uploadimages")
	public String saveImages(@RequestParam("file") MultipartFile files, @RequestParam String productid) throws IOException {
	System.out.println(files.getClass().getName());
	return service.uploadImages(files, productid);
		
	}
	
	
	@RequestMapping(path = "/filterbycat", method = RequestMethod.POST)
	public List<Product> getProductBycategory(@RequestBody categoryreq req) {
		
		return service.getproductBycategory(req);
	}
	
	@RequestMapping("/deleteproduct")
	public void deleteProduct(@RequestParam String id) {
		
		service.removeProduct(id);
		
	}
	
	
	@RequestMapping("/productsearch")
	public List<Product> serachProduct(@RequestBody SerachBody request){
		
		return service.searchProducts(request.query);
	}

	
	
	@RequestMapping("/getcomments")
	public List<Comment> getComment(@RequestBody productid pid){
		
		return service.getComments(pid.pid);
		
	}

}
