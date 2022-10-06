
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        
        // validation
        if(username == null || username.equals("")){
              getServletContext().getRequestDispatcher("/WEB-INF/loginForm").forward(request, response);
              return;
        }
        
        // create session
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        
        // send to right place
        
        response.sendRedirect("test2");
        return; // don't want web confused
        
        
    }

    

}
