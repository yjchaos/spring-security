package org.yj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yaojun
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/index")
    public String index() {
        return "product/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "product/productAdd";
    }

    @RequestMapping("/update")
    public String update() {
        return "product/productUpdate";
    }

    @RequestMapping("/list")
    public String list() {
        return "product/productList";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "product/productDelete";
    }
}
