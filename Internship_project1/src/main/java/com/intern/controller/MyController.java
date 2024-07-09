package com.intern.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intern.GetApplicationContext;
import com.intern.dao.ContactDao;

@Controller
public class MyController {
	@RequestMapping("savecontact")
	public void saveContact(HttpServletRequest request, HttpServletResponse response,Model m) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		System.out.println(name+""+email+""+message);
		
		ApplicationContext ac = GetApplicationContext.getApplicationContext();
		ContactDao bean = ac.getBean(ContactDao.class);
		int row = bean.insertContact(name, email, message,LocalDateTime.now().toString());
		System.out.println(row);
		HttpSession session = request.getSession();
		
		if (row ==1 ) {
			response.sendRedirect("contact.jsp");
			session.setAttribute("msg", "message sent successfully");}
			
		}
		
		
		@RequestMapping("deletecontact")
		public void deleteContact(HttpServletRequest request, HttpServletResponse response,Model m) throws IOException {
			String sn = request.getParameter("sn");
			
			ApplicationContext ac = GetApplicationContext.getApplicationContext();
			ContactDao bean = ac.getBean(ContactDao.class);
			int row = bean.deleteContact(Integer.parseInt(sn));
			System.out.println(row);
			HttpSession session = request.getSession();
			
			if (row ==1 ) {
				response.sendRedirect("readcontact.jsp");
				session.setAttribute("msg", "message deleted successfully");
			}
		
	}

}
