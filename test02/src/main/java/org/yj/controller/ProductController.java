package org.yj.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yaojun
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/index")
    public String index(Model model) {
        // 获取UserDetail对象
        Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                String username = userDetails.getUsername();
                model.addAttribute("username", username);
            }
        }
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
