package br.cefetrj.webdep.view.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.webdep.model.entity.Usuario;
import br.cefetrj.webdep.services.UsuarioServices;

/**
 * Classe responsavel por remover usuarios do sistema.
 * 
 * @author Lawrence Fernandes
 * @author Iury
 * @author Leonardo
 * @version 0.1
 * @since   22-11-2016 
 */

public class ListaUsuarioCommand implements Command {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			List<Usuario> usu = null;	
			usu = UsuarioServices.listarTodos();
		
			request.setAttribute("usuario", usu);				
			request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = null;
		if(request.getParameter("search") != null){
			search = request.getParameter("search");
		}
		
		if(search != null && search.trim().length() != 0){
			List<Usuario> usu = null;	
		
			try {
				usu = UsuarioServices.buscaTodos(search.trim());
				request.setAttribute("usuario", usu);				
				request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);	
			} catch (Exception e) {
				doGet(request, response);
			}
		}else{
			doGet(request, response);
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Boolean get;
		if(request.getParameter("get") != null){
			get = Boolean.valueOf(request.getParameter("get"));
		}else{
			get = false;
		}
		
		if(get == null || get == true){
			doGet(request, response);
		}else{
			doPost(request, response);
		}		
	}
}