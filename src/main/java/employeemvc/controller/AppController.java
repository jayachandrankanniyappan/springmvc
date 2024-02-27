package employeemvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employeemvc.dao.EmployeeDao;
import employeemvc.dto.Employee;




@Controller
public class AppController {
	@Autowired
	EmployeeDao dao;
	
//	@RequestMapping("/test")
//	public void test(HttpServletResponse resp) throws IOException {
//		PrintWriter pw=resp.getWriter();
//		pw.print("hello world");
//	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView view=new ModelAndView();
		view.addObject("employee",new Employee());
		view.setViewName("signup.jsp");
		return view;
	}
	@RequestMapping("/save")
	public ModelAndView SaveEmployee(@ModelAttribute Employee employee) {
		dao.saveEmployee(employee);
		ModelAndView view=new ModelAndView();
		view.addObject("employee", new Employee());
		view.setViewName("login.jsp");
		return view;
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email,@RequestParam String name) {
		Employee exiEmp=dao.findByEmail(email);
		if(exiEmp!=null) {
			if(exiEmp.getEmpName().equals(name)) {
				ModelAndView view=new ModelAndView();
				view.setViewName("home.jsp");
				view.addObject("emps", dao.getAllEmployee());
				return view;
			}
			return new ModelAndView("login.jsp");
		}
		return new ModelAndView("login.jsp");
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int empId) {
		dao.deleteById(empId);
		ModelAndView view=new ModelAndView();
		view.setViewName("home.jsp");
		view.addObject("emps", dao.getAllEmployee());
		return view;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int empId) {
		Employee exEmp=dao.findById(empId);
		ModelAndView view=new ModelAndView();
		view.setViewName("edit.jsp");
		view.addObject("emp",exEmp);
		return view;
	}
	@RequestMapping("/update")
	public ModelAndView updateEmployee(@ModelAttribute Employee emp) {
		dao.updateEmployee(emp, emp.getEmpId());
		ModelAndView view=new ModelAndView();
		view.setViewName("home.jsp");
		view.addObject("emps", dao.getAllEmployee());
		return view;
	}

}
