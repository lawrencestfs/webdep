package br.cefetrj.webdep.view.command;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.webdep.model.entity.Versao;
import br.cefetrj.webdep.services.VersaoServices;

public class ObterVersaoCommand implements Command{
	
	/*
	 * Adicionar validação quando não for digitado nada e adicionar
	 * mensagem quando a busca não houver resultados
	 * 
	 */

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Versao> l = VersaoServices.searchVersion(request.getParameter("arg"));
		request.getSession(true).setAttribute("list", l);
		request.getRequestDispatcher("versionSearch.jsp").forward(request, response);
		
	}
	

}