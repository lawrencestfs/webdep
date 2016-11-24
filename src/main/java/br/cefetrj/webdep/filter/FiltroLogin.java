package br.cefetrj.webdep.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter({"/home.jsp","/cadastraUsuario.jsp","/listaUsuario.jsp","/deletaUsuario.jsp"})
 
public class FiltroLogin implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    	// Get init parameter 
        //String testParam = config.getInitParameter("test-param"); 
   
        //Print the init parameter 
        //System.out.println("Test Param: " + testParam); 
     }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	//String name = request.getParameter("name");
    	String id = request.getParameter("id");
        //if(name==null || name.equals("") || id==null || id.equals(""))
    	if(id==null || id.equals(""))
    	{
            //PrintWriter writer = res.getWriter();
            //String message="Name cannot be blank.( This is the response from Protected Servlet )";
            //writer.println(message);
            //return;
        	String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/index.jsp");
        }
        else {
        	System.out.println(id);
            chain.doFilter(request, response); // Logged-in user found, so just continue request.
        }
    	
    	
    	/*
    	// Get the IP address of client machine.   
        String ipAddress = req.getRemoteAddr();
   
        // Log the IP address and current timestamp.
        System.out.println("IP "+ ipAddress + ", Time "
                                         + new Date().toString());
   
        // Pass request back down the filter chain
        chain.doFilter(req,res);
        
        //--------------------------------------------------------------------------------------
    	HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("login") == null) {
            //response.sendRedirect(request.getContextPath() + "/index.jsp"); // No logged-in user found, so redirect to login page.
        	
        	//session.setAttribute("message", "Please Login");
            //response.sendRedirect(response.encodeRedirectURL("/index.jsp"));
        	
        	//response.sendRedirect("/index.jsp");
        } else {
            chain.doFilter(request, response); // Logged-in user found, so just continue request.
        }
        */
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}