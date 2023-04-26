package jp.co.internous.samurai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.samurai.model.domain.MstProduct;
import jp.co.internous.samurai.model.mapper.MstProductMapper;
import jp.co.internous.samurai.model.session.LoginSession;

@Controller
@RequestMapping("/samurai/product")
public class ProductController {
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@GetMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {

		MstProduct products = productMapper.findById(id);		
		m.addAttribute("product",products);
		
		m.addAttribute("loginSession", loginSession);
		return "product_detail";
	}
}
