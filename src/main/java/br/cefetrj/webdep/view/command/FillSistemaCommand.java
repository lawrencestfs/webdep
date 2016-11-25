package br.cefetrj.webdep.view.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.webdep.model.entity.Sistema;
import br.cefetrj.webdep.services.ServidorServices;
import br.cefetrj.webdep.services.SistemaServices;

public class FillSistemaCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Sistema s = new Sistema();
		String id = request.getParameter("filtro");
		String json = "{\"sistema\":";
		try {
			s = SistemaServices.searchSistema(id).get(0);
			json += "{";
			json += "\"id\":\"" + s.getId() + "\",";
			json += "\"nome\":\"" + s.getNome() + "\",";
			json += "\"servidor\":\"" + s.getServidor().getNome() + "\",";
			json += "\"formatolog\":\"" + s.getServidor().getFormatoLog().getNome() + "\",";
			json += "\"periodicidade\":\"" + s.getPeriodicidadeLeitura().toString() + "\",";
			json += "\"ptLogs\":\"" + s.getPastaLogAcesso().toString() + "\",";
			json += "\"pxLogs\":\"" + s.getPrefixoLogAcesso().toString() + "\",";
			json += "\"ptLogs2\":\"" + s.getPastaLogErro().toString() + "\",";
			json += "\"pxLogs2\":\"" + s.getPrefixoLogErro().toString() + "\",";
			json += "\"periodicidade\":\"" + s.getPeriodicidadeLeitura().toString() + "\",";
			json += "\"proximaleitura\":\"" + "Ultima leitura + periodicidade" + "\"";
			json += "}";
			json += "}";
			response.setContentType("application/json");

		} catch (Exception e) {
			json = "";
			e.printStackTrace();
		} finally {
			pw.write(json);
		}
	}
}
