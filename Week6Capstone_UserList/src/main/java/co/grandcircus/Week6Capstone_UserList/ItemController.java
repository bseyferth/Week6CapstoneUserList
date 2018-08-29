package co.grandcircus.Week6Capstone_UserList;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/tasklist")
	public ModelAndView viewTaskList(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
			// For this URL, make sure there is a user on the session.
			if (user == null) {
				// if not, send them back to the login page with a message.
				redir.addFlashAttribute("message", "Wait! Please log in.");
				return new ModelAndView("redirect:/index");
			}
			
			// if the user is logged in, proceed as normal.
			ModelAndView mav = new ModelAndView("tasklist");
			mav.addObject("items", itemDao.findAllByUser(user));
			System.out.println(itemDao.findAll().toString());
			return mav;
		}


	@RequestMapping("/taskaddform")
	public ModelAndView addTaskForm() {
		ModelAndView mav = new ModelAndView("taskaddform");
		return mav;
	}
	
	@PostMapping("/addTask")
	public ModelAndView addTask(@SessionAttribute (name="user")User user, @RequestParam("description")String description, @RequestParam("dueDate")String dueDate, @RequestParam("isComplete")boolean isComplete) {
		Item item = new Item(null,user,description,dueDate,isComplete);
		itemDao.save(item);
		ModelAndView mav = new ModelAndView("redirect:/tasklist");
		return mav;
	}
	
	@RequestMapping("/edittask")
	public ModelAndView editTask() {
		ModelAndView mav = new ModelAndView("redirect:/tasklist");
		return mav;
	}
	
}
