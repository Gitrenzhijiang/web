package com.survey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.survey.form.Permission;
import com.survey.form.Role;
import com.survey.form.RolePermission;
import com.survey.form.TreePermissionEle;
import com.survey.service.PermissionService;
import com.survey.service.RolePermissionService;
import com.survey.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@Resource(name = "permissionService")
	private PermissionService permissionService;
	
	@Resource(name = "rolePermissionService")
	private RolePermissionService rolePermissionService;
	@RequestMapping("/toRole")
	public String toRole() {
		return "sys/role";
	}
	
	@RequestMapping("/showRole")
	@ResponseBody
	public List<Role> showRole() {
		return roleService.findAll();
	}
	
	@RequestMapping("/toRolePermission")
	public String showRolePermission(Integer roleId,HttpServletRequest request) {
		Role role = roleService.findById(roleId);
		request.setAttribute("entity", role);
		return "sys/role_per";
	}
	
	@RequestMapping("/showRolePermission")
	@ResponseBody
	public List<TreePermissionEle> showRolePermission(Integer roleId ) {
		List<Permission> permissions = permissionService.findAll();
		List<TreePermissionEle> treePermissionEles = new ArrayList<TreePermissionEle>();
		List<RolePermission> rolePermissions = rolePermissionService.findById(roleId);
		for (Permission permission : permissions) {
			TreePermissionEle treePermissionEle = new TreePermissionEle(permission, false);
			treePermissionEles.add(treePermissionEle);
		}
		for (TreePermissionEle treePermissionEle : treePermissionEles) {
			for (RolePermission rolePermission : rolePermissions) {
				if (treePermissionEle.getId()==rolePermission.getPermission_id()) {
					treePermissionEle.setChecked(true);
					break;
				}
			}
		}
		System.out.println(treePermissionEles);
		return treePermissionEles;
	}
	
	@RequestMapping("/updateRolePermission")
	public void updateRolePermission(HttpServletResponse response,Integer roleId,String perparm) throws IOException {
		String[] splitperparm = perparm.split(",");
		rolePermissionService.delete(roleId);
		for (String string : splitperparm) {
			Integer per_id=Integer.valueOf(string);
			rolePermissionService.save(new RolePermission(roleId, per_id));
		}
		response.getWriter().println("ddd");
		return;
	}
	
	@RequestMapping("/toRoleAdd")
	public String toRoleAdd() {
		return "sys/roleadd";
	}
	
	@RequestMapping("/addRole")
	public String addRole(Role role,Model model) {
		roleService.save(role);
		model.addAttribute("success", "OK");
		return "sys/roleadd";
	}
	
	@RequestMapping("/toRoleEdit")
	public String toRoleEdit(Integer roleId,Model model) {
		Role role = roleService.findById(roleId);
		model.addAttribute("entity", role);
		return "sys/roleedit";
	}
	
	@RequestMapping("/roleEdit")
	public String roleEdit(Role role,Model model) {
		roleService.update(role);
		model.addAttribute("success", "OK");
		return "sys/roleedit";
	}
	
	@RequestMapping("/roleDele")
	public String roleDele(Integer roleId,HttpServletResponse response) throws Exception {
		roleService.delete(roleId);
		response.getWriter().println("ddd");
		return "sys/roleedit";
	}
}
