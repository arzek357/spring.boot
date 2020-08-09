package com.vtb.zolotarev.spring.boot.controllers;

import com.vtb.zolotarev.spring.boot.model.Product;
import com.vtb.zolotarev.spring.boot.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/showAll")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "all_products";
    }

    @PostMapping(value = "/add")
    public String saveNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product/showAll";
    }

    @GetMapping(value = "/remove/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
        return "redirect:/product/showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditProductPage(Model model,@PathVariable long id){
        model.addAttribute("product",productService.findProductById(id));
        return "product_edit";
    }

    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product/showAll";
    }
}
