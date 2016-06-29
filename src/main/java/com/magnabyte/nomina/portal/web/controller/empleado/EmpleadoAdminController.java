package com.magnabyte.nomina.portal.web.controller.empleado;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.magnabyte.nomina.portal.model.empleado.Empleado;
import com.magnabyte.nomina.portal.model.empresa.Empresa;
import com.magnabyte.nomina.portal.model.recibonomina.ReciboNomina;
import com.magnabyte.nomina.portal.service.empleado.EmpleadoService;
import com.magnabyte.nomina.portal.service.empresa.EmpresaService;
import com.magnabyte.nomina.portal.service.recibonomina.ReciboNominaService;

@Controller
public class EmpleadoAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoAdminController.class);
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ReciboNominaService reciboNominaService;
	
	@Autowired
	private MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping("/nomina/admin/employees")
	public String listEmployees(ModelMap model) {
		logger.debug("Recuperando empleados por id rol user");
		model.put("employees", empleadoService.findByUsuarioRolId());
		return "/empleado/listEmployees";
	}
	
	@RequestMapping("/nomina/admin/newEmployee")
	public String newEmployee(ModelMap model) {
		model.put("empleado", new Empleado());
		model.put("empresas", empresaService.findAll());
		return "/empleado/empleadoForm";
	}
	
	@RequestMapping(value = {"/nomina/admin/saveEmployee"}, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Empleado empleado, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		if (empleado.getId() != null) {
			empleadoService.update(empleado);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.update", null, null));
		} else {
			empleadoService.save(empleado);
			redirectAttributes.addFlashAttribute("messageSuccess", 
					messageSource.getMessage("messages.success.save", null, null));
		}
		return "redirect:/nomina/admin/employees";
	}
	
	@RequestMapping("/nomina/admin/modifyEmployee/{id}")
	public String modifyEmployee(ModelMap model, @PathVariable("id") Long id) {
		Empleado empleado = new Empleado(id);
		empleado = empleadoService.findOne(empleado);
		List<Empresa> empresa = new ArrayList<Empresa>();
		empresa.add(empleado.getEmpresa());
		model.put("empleado", empleado);
		model.put("empresas", empresa);
		return "/empleado/empleadoForm";
	}
	
	@RequestMapping("/nomina/admin/searchPaySlips")
	public String searchPaySlips(ModelMap model, @PageableDefault(size = 5) Pageable pageRequest) {
		model.put("recibo", new ReciboNomina());
		model.put("recibos", reciboNominaService.findAll(pageRequest));
		return "/empleado/searchPaySlips";
	}
	
	@RequestMapping("/nomina/admin/filterPaySlips")
	public String filterPaySlips(ModelMap model, @ModelAttribute ReciboNomina reciboNomina, 
			@ModelAttribute Empleado empleado, @PageableDefault(size = 5) Pageable pageRequest) {
		Page<ReciboNomina> recibos = reciboNominaService.findAllBy(reciboNomina, empleado, pageRequest);
		model.put("recibos", recibos);
		return "/empleado/listPaySlipsAdmin";
	}
}
