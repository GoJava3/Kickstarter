package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.goit.model.Category;
import ua.goit.model.User;
import ua.goit.service.CategoryService;
import ua.goit.service.UserService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

  private static final Logger logger = Logger.getLogger(CategoryController.class);
  private CategoryService categoryService;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  public HomeController(CategoryService categoryService) {
	this.categoryService = categoryService;
  }

  @RequestMapping("/home")
  public String getAllCategories(Model model) {
	List<Category> categories = categoryService.getAll();
	model.addAttribute("categories", categories);
	return "categories";
  }
}