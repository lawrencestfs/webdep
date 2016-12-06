package br.cefetrj.webdep.view.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.webdep.model.entity.Versao;
import br.cefetrj.webdep.services.VersaoServices;

public class ObterVersaoCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Long id = Long.parseLong(request.getParameter("id"));
		Versao v = VersaoServices.obterPorId(id);
		
		request.setAttribute("version", v);
		request.getRequestDispatcher("versionModify.jsp").forward(request, response);
	}

}