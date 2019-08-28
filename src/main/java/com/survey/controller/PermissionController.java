package com.survey.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.form.Permission;
import com.survey.service.PermissionService;

@Controller
@RequestMapping("/per")
public class PermissionController {
	
	@Resource(name = "permissionService")
	private PermissionService permissionService;
	
	@RequestMapping("/toPer")
	public String toPer() {
		
		return "sys/per";
	}
	
	@RequestMapping("/showPer")
	@ResponseBody
	public List<Permission> showPer() {
		return permissionService.findAll();
	}
	
	@RequestMapping("/toPerEdit")
	public String toPerEdit(Integer permissionId,Model model) {
		Permission permission = permissionService.findById(permissionId);
		model.addAttribute("entity", permission);
		return "sys/peredit";
	}
	
	@RequestMapping("/perEdit")
	public String perEdit(Permission permission,Model model) throws Exception {
		permissionService.update(permission);
		model.addAttribute("success", "OK");
		return "sys/peredit";
	}
	
	@RequestMapping("/toPerAdd")
	public String toPerAdd() {
		return "sys/peradd";
	}
	
	@RequestMapping("/perAdd")
	public String perAdd(Permission permission,Model model) {
		permissionService.save(permission);
		model.addAttribute("success", "OK");
		return "sys/peradd";
	}
	
	@RequestMapping("/perDele")
	public void perDele(Integer perId,HttpServletResponse response) throws Exception {
		permissionService.delete(perId);
		response.getWriter().append("hh");
		return;
	}
}
