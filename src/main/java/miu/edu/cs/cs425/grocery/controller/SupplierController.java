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

import miu.edu.cs.cs425.grocery.model.Supplier;
import miu.edu.cs.cs425.grocery.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supllierService;

	@RequestMapping(value = "/srm/secured/supplier/list", method = RequestMethod.GET)
	public ModelAndView suppliers() {
		List<Supplier> suppliers = supllierService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("suppliers", suppliers);// set the attributes to view files
		modelAndView.setViewName("supplier/list");
		return modelAndView;
	}
	
	
    @GetMapping(value = {"srm/secured/supplier/new"})
    public String displayNewsupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/new";
    }

    @PostMapping(value = {"srm/secured/supplier/new"})
    public String addNewBook(@Valid @ModelAttribute("supplier") Supplier supplier,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/new";
        }
        supplier = supllierService.save(supplier);
        return "redirect:/srm/secured/supplier/list";
    }

	@GetMapping(value = { "/srm/secured/supplier/edit/{supplierId}" })
	public String editsupplier(@PathVariable Integer supplierId, Model model) {
		Supplier supplier = supllierService.findOne((supplierId));
		if (supplier != null) {
			model.addAttribute("supplier", supplier);
			return "supplier/edit";
		}
		return "supplier/list";
	}

	@PostMapping(value = { "srm/secured/supplier/edit" })
	public String updatesupplier(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "supplier/edit";
		}
		supplier = supllierService.save(supplier);
		return "redirect:/srm/secured/supplier/list";
	}

	@RequestMapping(value = "/srm/secured/supplier/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model) {
		supllierService.delete(id);
		return "redirect:/srm/secured/supplier/list";
	}

}
