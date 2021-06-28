package com.wipro.mongoController.controller;
import java.security.Principal;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wipro.mongoController.dao.UsersDao;
import com.wipro.mongoController.model.Users;
import com.wipro.mongoController.service.emailService;

@Controller
public class myController {
	
	
	Random random =	new Random();
	
	@Autowired
	emailService service;
	
	@Autowired
	UsersDao dao;
	@RequestMapping(value = {"/login"})
	public ModelAndView logIn() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/logoutSuccessful")
	public ModelAndView logout() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value="/")
	public ModelAndView showafterLogin() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value ="/signUp")
	public ModelAndView signUp() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Users user) {
		dao.save(user);
		ModelAndView mv= new ModelAndView();
		mv.addObject("username", user.getUsername());
		mv.addObject("email", user.getEmail());
		mv.setViewName("afterSignup");
		return mv;
	}
	
	@RequestMapping(value ="/findUserdetails", method = RequestMethod.GET)
	public ModelAndView fetchUser(Principal principal) {
		ModelAndView mv = new ModelAndView();
		String username= principal.getName();
		Users user= dao.findByUsername(username);
		mv.addObject("username",user.getUsername());
		mv.addObject("email",user.getEmail());
	//	mv.addObject("password", user.getPassword()); //getter setter is working fine....
		mv.setViewName("details");
		return mv;
	}
	@RequestMapping(value ="/fetchByEmail", method = RequestMethod.GET)
	public ModelAndView fetchUserByEmail(@RequestParam("email") String email) {
		ModelAndView mv = new ModelAndView();
		Users user = dao.findByEmail(email); // working fine this method...
		mv.addObject("username",user.getUsername());
		mv.addObject("email",user.getEmail());
		//mv.addObject("password", user.getPassword()); //getter setter is working fine....
		mv.setViewName("detailsUsingEmail");
		return mv;
	}
	@RequestMapping(value = {"/deleteUser"}, method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@RequestParam String username) {
		ModelAndView mv = new ModelAndView();
		dao.deleteById(username);
		mv.setViewName("delete");
		return mv;
	}
	
	//change password login form..
	@RequestMapping("/changemyPassword")
	public ModelAndView passwordpage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("changePassword");
		return mv;
	}
	
	//changing old password after login
	@RequestMapping(value = "/changeMyPassword",method = RequestMethod.POST)
	public ModelAndView passwordchange(@RequestParam("oldPass")String oldpass, @RequestParam("newPass")String newPass, Principal principal) {
		ModelAndView mv = new ModelAndView();
		String username=principal.getName();
		Users currentUser=dao.findByUsername(username);
		String currentPassword= currentUser.getPassword();
		if(oldpass.equals(currentPassword)) {
			currentUser.setPassword(newPass);
			dao.save(currentUser);
			mv.addObject("success","password updated successfully!");
			mv.setViewName("redirect:/");
		}
		else {
			mv.addObject("error","your entered password is wrong");
		}
		return mv;
	}
	
	//forgot password email opener
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("forgotPassword");
		return mv;
	}
	
	//email service to send OTP after user provides successful email..
	@RequestMapping(value = "/sendOtp", method = RequestMethod.POST)
	public ModelAndView sendOtp(@RequestParam("email") String email,HttpSession session) {
		ModelAndView mv= new ModelAndView();
		//generating random OTP
		int OTP= random.nextInt(1099999);
		session.setAttribute("OTP",OTP); //saving OTP and mail to session...
		session.setAttribute("email",email); // because we need to verify...
		mv.addObject("email",email);
		String message= "your otp is: "+ OTP;
		String subject= "<h1>OTP to reset the password</h1>";
		String to= email;
		String from= "trishitd42@gmail.com";	
		emailService.sendEmail(message,subject,to,from);
		mv.setViewName("verifyOtp");
		return mv;
	}
	
	//verifying OTP and giving the new password form..
	@RequestMapping(value = "/verifyOtp", method = RequestMethod.POST)
	public ModelAndView checkOtp(@RequestParam("OTP") int OTP,HttpSession session) {
		ModelAndView mv= new ModelAndView();
		int myotp= (int)session.getAttribute("OTP"); //fetching OTP and mail from session...
		String email= (String)session.getAttribute("email");
		mv.addObject("email",email);
		if(myotp==OTP) {
			mv.setViewName("changemyPassword");
		}
		else {
			mv.addObject("error", "invalid OTP, check your otp again");
			mv.setViewName("verifyOtp");
		}
		
		return mv;
	}
	//change password after submitting new password..
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam("newPass") String newPass, HttpSession session) {
		ModelAndView mv= new ModelAndView();
//		String username = (String)session.getAttribute("username");
		String email= (String) session.getAttribute("email"); //finding user by given email
		Users user=dao.findByEmail(email);//fetching user by email
		user.setPassword(newPass);
		dao.save(user);
		System.out.println(user);
		mv.setViewName("redirect:/");
		return mv;
	}
//	@RequestMapping("/sendMail")
//	public ModelAndView mailform() {
//		ModelAndView mv= new ModelAndView();
//		mv.setViewName("sendMail");
//		return mv;
//	}
	
	@RequestMapping("/sendmail")
	public ModelAndView sendemail(@RequestParam("email") String email) {
		ModelAndView mv= new ModelAndView();
		String message= "We are delighted to welcome you at wipro";
		String subject= "Welcome to Wipro";
		String to= email;
		String from= "trishitd42@gmail.com";
		emailService.sendEmail(message,subject,to,from);
		mv.setViewName("successsent");
		return mv;
	}
//	@RequestMapping("/findUser")
//	public ModelAndView findUser(@RequestParam("username") String username,HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		Users user= dao.findById(username).orElse(null);
//		mv.addObject(user);
//		session.setAttribute("username",username);
//		mv.setViewName("changePassword");
//		return mv;
//	}
}
