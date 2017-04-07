package com.company.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mapper.BookMapper;


@Controller
public class AdminsController {
	@Autowired		
	private UserMapper userMapper;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(Model model) {
        List<User> users = userMapper.selectUsers();
        model.addAttribute("users", users);
        return "admin/index";
    }
	

	
	
	@RequestMapping(value ="/admin/newBoard")
	public String newBoard(){
		return "admins/newBoard";
	}

}
