package com.cts.product.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.entities.Product;
import com.cts.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;

	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}

	@RequestMapping("loadProductForm")
	public String loadProductForm(Model model) {
		Product prod=new Product();
		model.addAttribute("prod", prod);
		return "productform";
	}

	@RequestMapping("saveProduct")
	public String saveProduct(@RequestParam("prodId") String prodId, @RequestParam("prodName") String prodName,
			@RequestParam("price") double price, Model model) {

		com.cts.product.entities.Product prod = new Product();
		prod.setProdId(prodId);
		prod.setProdName(prodName);
		prod.setPrice(price);

		model.addAttribute("product", prod);

		// System.out.println("PID: " + prodId);
		// System.out.println("PNAME: " + prodName);
		// System.out.println("Price: " + price);

		return "display";
	}

	@RequestMapping("saveProduct_v1")
	public ModelAndView saveProduct_V1(@ModelAttribute Product prod) {

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("display");
		mav.addObject("product", prod);

		ps.saveProduct(prod);

		return mav;
	}

	@RequestMapping("findProduct")
	public String findProduct(Model model, @ModelAttribute Product prod) {

		List<Product> prods = ps.findAll();

		List<String> ids = new ArrayList<>();

		for (Product p : prods) {
			BeanUtils.copyProperties(ids, p);
			ids.add(p.getProdId());

		}

		prod.setIds(ids);

		model.addAttribute("prod", prod);

		model.addAttribute("product", null);
		return "findproduct";
	}
	
	@RequestMapping("loadProduct")
	public ModelAndView getProduct(@RequestParam("prodId")String prodId) {
		ModelAndView mav=new ModelAndView();
		
		Product prod=ps.findByproductId(prodId);
		mav.setViewName("findproduct");
		mav.addObject("product", prod);
		mav.addObject("prod", prod);
		
		List<Product> prods = ps.findAll();

		List<String> ids = new ArrayList<>();

		for (Product p : prods) {
			BeanUtils.copyProperties(ids, p);
			ids.add(p.getProdId());

		}

		prod.setIds(ids);

		mav.addObject("prod", prod);

		//mav.addObject("product", null);
		
		return mav;
	}
	
	
	@RequestMapping("s1")
	public String test(@RequestParam("prodId") String prodId,Model model) {
		
		
		Product prod=ps.findByproductId(prodId);
		
		if(prod!=null) {
			model.addAttribute("prod", prod);
			model.addAttribute("msg", "Product Id "+prodId+" Already Exists in DB");
		}else {
			model.addAttribute("prodId", prodId);
			model.addAttribute("prod", prod);

		}
		
		
		
		return "productform";
	}
	
	
	
	

}
