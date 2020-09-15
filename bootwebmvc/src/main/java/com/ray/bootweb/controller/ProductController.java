package com.ray.bootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ray.bootweb.bean.Product;
import com.ray.bootweb.service.ProductService;

@Controller
@SessionAttributes("name")
public class ProductController {
	@Autowired
    private ProductService service;

	@GetMapping("/product")
	public String product() {
		return "redirect:products";
	}
    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addProduct(@ModelAttribute("HelloWeb") Product product) {
        service.saveProduct(product);
        return "redirect:products";
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public String findAllProducts(ModelMap model) {
    	List<Product> list = service.getProducts();
        model.addAttribute("productList", list);
        return "product";
    }

    @GetMapping("/productById/{id}")
    public String findProductById(ModelMap model, @PathVariable int id) {
    	model.addAttribute("productList", service.getProducts());
    	model.addAttribute("prod", service.getProductById(id));
        return "product";
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
