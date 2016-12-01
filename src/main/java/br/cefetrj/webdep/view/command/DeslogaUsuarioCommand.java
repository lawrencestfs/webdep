package br.cefetrj.webdep.view.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe responsavel por deslogar usuarios do sistema.
 * 
 * @author Lawrence Fernandes
 * @version 0.1
 * @since   18-11-2016 
 */

public class DeslogaUsuarioCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invalida sessão e redireciona para login
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
 
}
