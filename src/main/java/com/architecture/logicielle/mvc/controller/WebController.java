package com.architecture.logicielle.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.architecture.logicielle.mvc.data.UserView;
import com.architecture.logicielle.repository.UserRepository;
import com.architecture.logicielle.repository.entities.UserEntity;
import com.architecture.logicielle.service.UserService;
import com.architecture.logicielle.service.UserServiceImpl;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	private UserService userService = new UserServiceImpl();
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

	/*@GetMapping("/consult/{userId}")
	public String showForm(Model model, @PathVariable Long userId) {
		UserEntity userEnt = userService.GetUserById(userId, userRepository);
		UserView user = userService.parseUserEntityToUserView(userEnt);
		model.addAttribute("userView", user);
		return "results";
	}*/
	
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Long id = Long.parseLong(auth.getName());
		UserEntity userEnt = userService.GetUserById( id, userRepository);
		UserView userView = userService.parseUserEntityToUserView(userEnt);
		model.addAttribute("userView", userView);
		return "consultUser";
	}
	
	@GetMapping("/inscription")
	public String showFromInscription(Model model) {
		model.addAttribute("user", new UserView());
		return "inscription";
	}

	@PostMapping("/inscription")
	public String InscriptionSubmit(Model model, @ModelAttribute @Valid UserView user, BindingResult bindingResult) {
		model.addAttribute("user", user);

		if (bindingResult.hasErrors()) {
			model.addAttribute("ErrorMessage","Inalid from !");
			return "inscription";
		} else {
			UserEntity userEnt = userService.parseUserViewToUserEntity(user);
			UserEntity userEntCheck = userService.checkUser(userEnt, userRepository);
			if (userEntCheck == null) {
				userService.saveUser(userEnt, userRepository);
			} else {
				model.addAttribute("ErrorMessage","User Exist !");
				return "inscription";
			}

			String name = user.getPhoto().getName();
			String path = user.getPhoto().getPath();
			System.out.println("name: " + name + " path: " + path);

			
			return "redirect:/";
		}
	}

	@GetMapping("/EditProfile/{userId}")
	public String EditProfile(@PathVariable Long userId, Model model) {

		UserEntity userEnt = userService.GetUserById(userId, userRepository);
		UserView user = userService.parseUserEntityToUserView(userEnt);
		
		model.addAttribute("user", user);
		return "EditUser";
	}

	@PostMapping("/EditProfile/{userId}")
	public String EditProfileSubmit(@PathVariable Long userId, Model model, @ModelAttribute @Valid UserView user,
			BindingResult bindingResult) {
		
		model.addAttribute("user", user);
		UserEntity userEnt = userService.parseUserViewToUserEntity(user);
		userService.saveUser(userEnt, userRepository);
		
		return "consultUser";
		//return "redirect:/consult/"+userId;
	}

	@GetMapping("/DeleteProfile/{userId}")
	public String DeleteUsert(@PathVariable Long userId, Model model, @ModelAttribute UserView user) {

		UserEntity userEnt = userService.GetUserById(userId, userRepository);
		userService.deleteUser(userEnt, userRepository);
		
		return "redirect:/login";
	}
	
}
