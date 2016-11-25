package br.cefetrj.webdep.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//import javax.faces.application.ResourceHandler;
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

@WebFilter("/app/*")
//@WebFilter("/*")
public class FiltroLogin implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURL = request.getContextPath() + "/index.jsp";

        boolean loggedIn = session != null && session.getAttribute("id") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        
        /*
    	// Get the IP address of client machine.   
        String ipAddress = req.getRemoteAddr();
   
        // Log the IP address and current timestamp.
        System.out.println("IP "+ ipAddress + ", Time "
		*/
        
        //boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
        
        System.out.println(request.getAttribute("id"));
        
        if (loggedIn || loginRequest){ //|| resourceRequest) {
        	/*
        	if (!resourceRequest) { // Prevent browser from caching restricted resources. See also http://stackoverflow.com/q/4194207/157882
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
            }*/
        	
        	// Pass request back down the filter chain
            chain.doFilter(request, response);
        } 
        
        else {
            response.sendRedirect(loginURL);
        }
    }
    
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
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}