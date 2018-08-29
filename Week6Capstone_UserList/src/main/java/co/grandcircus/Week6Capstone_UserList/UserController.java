package co.grandcircus.Week6Capstone_UserList;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping("/")
	public ModelAndView viewTaskList() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@PostMapping("/login")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, RedirectAttributes redir) {
		// Find the matching user.
		User user = userDao.findByEmail(email);
		if (user == null || !password.equals(user.getPassword())) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("index");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
		}
		
		// On successful login, add the user to the session.
		session.setAttribute("user", user);
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged in.");
		return new ModelAndView("redirect:/tasklist");
	}
	
	
	@RequestMapping("/newuser")
	public ModelAndView newUserForm() {
		ModelAndView mav = new ModelAndView("useraddform");
		return mav;
	}

	@PostMapping("/adduser")
	public ModelAndView addUser(HttpSession session,RedirectAttributes redir,@RequestParam("email")String email, @RequestParam("password")String password) {
		User user = new User(null,email,password);
		userDao.save(user);
		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Logged in.");
		ModelAndView mav = new ModelAndView("redirect:/tasklist");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
