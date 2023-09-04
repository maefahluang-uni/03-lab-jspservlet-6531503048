package th.mfu;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet ("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        double bmi = weight/(height*height);
        //TODO: determine the built from BMI
        String built; 
            if (bmi < 18.5) {
                built = "underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                built = "normal";
            } else if (bmi >= 25 && bmi < 30) {
                built = "overweight";
            } else if (bmi >= 30 && bmi < 35) {
                built = "obese";
            } else {
                built = "extremely obese";
            }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("result", Math.round(bmi));
        request.setAttribute("built", built);
        //TODO: forward to jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("bmi_result.jsp");
        dispatcher.forward(request, response);
       
    }
    
}
