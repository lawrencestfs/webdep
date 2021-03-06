package br.cefetrj.webdep.view.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.webdep.view.command.Command;

import br.cefetrj.webdep.view.command.AutenticaUsuarioCommand;
import br.cefetrj.webdep.view.command.DeslogaUsuarioCommand;
import br.cefetrj.webdep.view.command.CadastraUsuarioCommand;
import br.cefetrj.webdep.view.command.ListaUsuarioCommand;
import br.cefetrj.webdep.view.command.ListaPermissaoUsuarioCommand;
import br.cefetrj.webdep.view.command.AtualizaUsuarioCommand;
import br.cefetrj.webdep.view.command.DeletaUsuarioCommand;

import br.cefetrj.webdep.view.command.InsereSistemaCommand;
import br.cefetrj.webdep.view.command.FillSistemaCommand;
import br.cefetrj.webdep.view.command.ListaSistemaCommand;
import br.cefetrj.webdep.view.command.AtualizaSistemaCommand;
import br.cefetrj.webdep.view.command.DeletaSistemaCommand;

import br.cefetrj.webdep.view.command.InsereVersaoCommand;
import br.cefetrj.webdep.view.command.BuscarVersaoCommand;
import br.cefetrj.webdep.view.command.AtualizaVersaoCommand;
import br.cefetrj.webdep.view.command.DeletaVersaoCommand;

import br.cefetrj.webdep.view.command.InserePadraoURLCommand;
import br.cefetrj.webdep.view.command.InsereSelectIdSistemaCommand;
import br.cefetrj.webdep.view.command.ValidaHttpReportCommand;
import br.cefetrj.webdep.view.command.ObterHttpReportListsCommand;
import br.cefetrj.webdep.view.command.ObterVersaoCommand;
import br.cefetrj.webdep.view.command.RegexPadraoURLCommand;

import br.cefetrj.webdep.view.command.ValidaBanco;
import br.cefetrj.webdep.view.command.ValidaConfig;
import br.cefetrj.webdep.view.command.ValidaEmail;

import br.cefetrj.webdep.view.command.ImportarLogCommand;
import br.cefetrj.webdep.view.command.ValidaLogErroCommand;
import br.cefetrj.webdep.view.command.ValidaLogAcessoCommand;
import br.cefetrj.webdep.view.command.BuscarLogAcessoCommand;
import br.cefetrj.webdep.view.command.BuscarLogErroCommand;
import br.cefetrj.webdep.view.command.ExcluirLogErroCommand;
import br.cefetrj.webdep.view.command.ExcluirLogAcessoCommand;

/**
 * Servlet implementation class FrontControllerServlet
 */

@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Map<String, Command> commands = new HashMap<>();
	
	static{
		commands.put("autenticaUsuario", new AutenticaUsuarioCommand());
		commands.put("deslogaUsuario", new DeslogaUsuarioCommand());
		commands.put("cadastraUsuario", new CadastraUsuarioCommand());
		commands.put("listaUsuario", new ListaUsuarioCommand());
		commands.put("alteraUsuario", new AtualizaUsuarioCommand());
		commands.put("deletaUsuario", new DeletaUsuarioCommand());
		commands.put("listarPemissaoUsuario", new ListaPermissaoUsuarioCommand());
		
		commands.put("insertSistema", new InsereSistemaCommand());
		commands.put("insertselectidsistema", new InsereSelectIdSistemaCommand());
		commands.put("fillSistema", new FillSistemaCommand());
		commands.put("updateSistema", new AtualizaSistemaCommand());
		commands.put("listSistema", new ListaSistemaCommand());
		commands.put("deleteSistema", new DeletaSistemaCommand());
		
		commands.put("insertVersion", new InsereVersaoCommand());
		commands.put("changeVersion", new AtualizaVersaoCommand());
		commands.put("searchVersion", new BuscarVersaoCommand());
		commands.put("getVersion", new ObterVersaoCommand());
		commands.put("deleteVersion", new DeletaVersaoCommand());
		
		commands.put("insertPadraoURL", new InserePadraoURLCommand());
		commands.put("errorParameter", new ValidaHttpReportCommand());
		commands.put("getListsParameter", new ObterHttpReportListsCommand());
		commands.put("regexPadraoURL", new RegexPadraoURLCommand());
		
		commands.put("ValidaBanco", new ValidaBanco());
		commands.put("ValidaConfig", new ValidaConfig());
		commands.put("ValidaEmail", new ValidaEmail());
		
		commands.put("importaLog", new ImportarLogCommand());
		commands.put("validaLogErro", new ValidaLogErroCommand());
		commands.put("validaLogAcesso", new ValidaLogAcessoCommand());
		commands.put("buscarLogErro", new BuscarLogErroCommand());
		commands.put("buscarLogAcesso", new BuscarLogAcessoCommand());
		commands.put("excluirLogErro", new ExcluirLogErroCommand());
		commands.put("excluirLogAcesso", new ExcluirLogAcessoCommand());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			/*
			Enumeration<String> params = request.getParameterNames();
			System.out.println();
			while(params.hasMoreElements()){
			 String paramName = (String)params.nextElement();
			 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
			*/
			commands.get(action).execute(request, response);
			
		} catch(Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			//e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
