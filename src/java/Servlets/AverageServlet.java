
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author levan
 */
public class AverageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // create session
        HttpSession session = request.getSession();
        
       ArrayList<Integer> numberList = (ArrayList<Integer>) session.getAttribute("numberList");
        
        if(numberList == null) numberList = new ArrayList<>();
        
        // capture number from user when they submit throuht from
        if(request.getParameter("number") == null|| (request.getParameter("number").equals(""))){
                 boolean error = true;
                 request.setAttribute("error", error);
                  getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
                 return;
            }
        
        if(request.getParameter("number") != null){
            int number = Integer.parseInt(request.getParameter("number"));
            numberList.add(number);
            //save to session
            
            session.setAttribute("numberList", numberList);
        }
        
        // math calculator
        
        double average = 0.0;
        
        for (int number : numberList){
            average += number;
        }
        if(numberList.size() > 0){
                    average /= numberList.size();
        }

        
        // put back to request object
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
        return;
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // nothing here
   
    }


}
