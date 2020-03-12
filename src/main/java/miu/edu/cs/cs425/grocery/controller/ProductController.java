package miu.edu.cs.cs425.grocery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import miu.edu.cs.cs425.grocery.model.Product;
import miu.edu.cs.cs425.grocery.model.Supplier;
import miu.edu.cs.cs425.grocery.service.ProductService;
import miu.edu.cs.cs425.grocery.service.SupplierService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value = "/srm/secured/product/list", method = RequestMethod.GET)
	public ModelAndView products() {
		List<Product> products = productService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", products);// set the attributes to view files
		modelAndView.setViewName("product/list");
		return modelAndView;
	}
	
	
    @GetMapping(value = {"srm/secured/product/new"})
    public String displayNewproductForm(Model model) {
    	List<Supplier> suppliers = supplierService.findAll();
		model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());
        return "product/new";
    }

    @PostMapping(value = {"srm/secured/product/new"})
    public String addNewBook(@Valid @ModelAttribute("product") Product product,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	List<Supplier> suppliers = supplierService.findAll();
    		model.addAttribute("suppliers", suppliers);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/new";
        }
        
        
        product = productService.save(product);
        return "redirect:/srm/secured/product/list";
    }

	@GetMapping(value = { "srm/secured/product/edit/{productId}" })
	public String editproduct(@PathVariable Long productId, Model model) {
		Product product = productService.findOne((productId));
		if (product != null) {
			List<Supplier> suppliers = supplierService.findAll();
    		model.addAttribute("suppliers", suppliers);
			model.addAttribute("product", product);
			return "product/edit";
		}
		return "product/list";
	}

	@PostMapping(value = { "/srm/secured/product/edit" })
	public String updateproduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			List<Supplier> suppliers = supplierService.findAll();
    		model.addAttribute("suppliers", suppliers);
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "product/edit";
		}
		product = productService.save(product);
		return "redirect:/srm/secured/product/list";
	}

	@RequestMapping(value = "/srm/secured/product/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		productService.delete(id);
		return "redirect:/srm/secured/product/list";
	}

}
