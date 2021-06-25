package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
       model.addAttribute("products", productService.getAll());
       return "products/index";
    }

    @GetMapping("/add")
    public String showAddForm(RedirectAttributes redirectAttributes, Model model) {
        Product product = (Product) redirectAttributes.getAttribute("product");
        model.addAttribute("products", product);
        return "products/add_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam int cost, RedirectAttributes redirectAttributes) {
        Product product = productService.add(title, cost);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/products/add";
    }
}
