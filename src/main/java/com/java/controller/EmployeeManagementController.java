package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.EmployeeManufacture;
import com.java.services.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeManagementController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/empform")
	public ModelAndView registerForm() {
		return new ModelAndView("empform", "employeeManufacture", new EmployeeManufacture());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employeeManufacture") @Valid EmployeeManufacture emp,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("empform");
		} else {
			employeeService.saveEmployee(emp);
			return new ModelAndView("redirect:/employee/viewemp");
		}
	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<EmployeeManufacture> employeeManufactures = employeeService.findAllEmployees();
		return new ModelAndView("viewEmp", "list", employeeManufactures);
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		EmployeeManufacture employeeManufacture = (EmployeeManufacture) employeeService.getEmployee(id);
		return new ModelAndView("empeditform", "employeeManufacture", employeeManufacture);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employeeManufacture") EmployeeManufacture employeeManufacture) {
		employeeService.updateEmployee(employeeManufacture);
		return new ModelAndView("redirect:/employee/viewemp");
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		EmployeeManufacture employeeManufacture = (EmployeeManufacture) employeeService.getEmployee(id);
		employeeService.deleteEmployee(employeeManufacture);
		return new ModelAndView("redirect:/employee/viewemp");
	}

}
