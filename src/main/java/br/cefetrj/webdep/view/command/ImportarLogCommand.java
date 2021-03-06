package br.cefetrj.webdep.view.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by renatoor on 11/25/16.
 */
public class ImportarLogCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sistema = request.getParameter("sistema");
        String servidor = request.getParameter("servidor");
        String formatoLog = request.getParameter("log");
        String logAcesso = request.getParameter("logAcesso");
        String logErro = request.getParameter("logErro");

        request.setAttribute("sistema", sistema);
        request.setAttribute("servidor", servidor);
        request.setAttribute("log", formatoLog);
        request.setAttribute("logAcesso", logAcesso);
        request.setAttribute("logErro", logErro);

        File dirLogAcesso, dirLogErro;
        boolean erro = false;

        if(logAcesso.equals("")) {
            request.setAttribute("logAcessoVazio", "1");
            erro = true;
        }

        if(logErro.equals("")) {
            request.setAttribute("logErroVazio", "1");
            erro = true;
        }

        dirLogAcesso = new File(logAcesso);
        dirLogErro = new File(logErro);

        if(dirLogAcesso.isFile() && dirLogErro.isFile() && !(erro)) {
            //insere log no banco de dados
            request.setAttribute("logAdicionado", "1");
        }
        else {
            request.setAttribute("testarAcesso", "1");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        if(erro) {
            request.setAttribute("erro", "1");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}