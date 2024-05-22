
package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("login view...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("login form...");
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        RedirectView redirectView = null;
        if (LoginService.login(username, password, dob)) {
            redirectView = new RedirectView("/q1", true);
        } else {
            // Login failed, stay with login page.
            //
            redirectView = new RedirectView("/login", true);
            // Show error message
            //
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
        }

        return redirectView;
    }

    @GetMapping("/q1")
    public String q1View() {
        System.out.println("q1 view...");
        return "view-q1";
    }
    @PostMapping("/q1")
    public RedirectView q1(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("q1 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");
        
        // Validate if any field is empty or contains invalid input
        if (number1 == null || number1.isEmpty() ||
            number2 == null || number2.isEmpty() ||
            resultUser == null || resultUser.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please fill in all fields.");
            return new RedirectView("/q1", true);
        }

        try {
            Double.parseDouble(number1); // Check if number1 can be parsed as a double
            Double.parseDouble(number2); // Check if number2 can be parsed as a double
            Double.parseDouble(resultUser); // Check if resultUser can be parsed as a double
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("message", "Invalid input. Please enter numeric values.");
            return new RedirectView("/q1", true);
        }

        double calculatedResult = MathQuestionService.q1Addition(number1, number2);
        System.out.println(
                "User result: " + resultUser + ", answer: " + calculatedResult);
        
        RedirectView redirectView;
        if (calculatedResult == Double.valueOf(resultUser)) {
            redirectView = new RedirectView("/q2", true);
        } else {
            // Q1 wrong.
            //
            redirectView = new RedirectView("/q1", true);
            // Show error message
            //
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        }        
        return redirectView;
    }   
    
    @GetMapping("/q2")
    public String q2View() {
        System.out.println("q2 view...");
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q1 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");
        
        // Validate if any field is empty or contains invalid input
        if (number1 == null || number1.isEmpty() ||
            number2 == null || number2.isEmpty() ||
            resultUser == null || resultUser.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please fill in all fields.");
            return new RedirectView("/q2", true);
        }

        try {
            Double.parseDouble(number1); // Check if number1 can be parsed as a double
            Double.parseDouble(number2); // Check if number2 can be parsed as a double
            Double.parseDouble(resultUser); // Check if resultUser can be parsed as a double
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("message", "Invalid input. Please enter numeric values.");
            return new RedirectView("/q2", true);
        }

        double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
        
        RedirectView redirectView;
        if (calculatedResult == Double.valueOf(resultUser)) {
            redirectView = new RedirectView("/q3", true);
        } else {
            // Q1 wrong
            //
            redirectView = new RedirectView("/q2", true);
            // Show error message
            //
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        }        
        return redirectView;
    }


    @GetMapping("/q3")
    public String q3View() {
        System.out.println("q3 view...");
        return "view-q3";
    }
}

