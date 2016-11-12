/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.webdep.view.command;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.cefetrj.webdep.model.dao.PersistenceManager;
import br.cefetrj.webdep.model.entity.PadraoURL;

/**
 *
 * @author Luan
 */
public class NovoPadraoURL extends HttpServlet {

    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gerenciadorsistema.jsp");
        dispatcher.forward(request,response);
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String action = request.getParameter("action");
        String nome = request.getParameter("nome");
        String regex = request.getParameter("regex");
        if ("salvarPadrao".equals(action)) {
            String erro_json = "{ \"Erro\": [";
            boolean erro = false;
            if (regex.trim().isEmpty()){
                erro_json += "\"regex\",";
                erro = true;
                pw.write("");
            }
            if (nome.trim().isEmpty()){
                erro_json += "\"nome\",";
                erro = true;
                pw.write("");
            }
            erro_json += "]}";
            erro_json = erro_json.replace(",]}","]}");
            if (erro) pw.write(erro_json);
            else {
                /*Inser��o no banco*/
                //PadraoURLsDAO urlDAO = new PadraoURLsDAO();
                PadraoURL padraoURL = new PadraoURL();
                padraoURL.setNome(nome);
                padraoURL.setExpressaoRegular(regex);
                //urlDAO.addPadrao(padraoURL);
                pw.write("success");
            }
        } else if ("buscaRegex".equals(action)) {
            
            String json = "";
            response.setContentType("text/plain");
            try{
                /*  Pattern p = Pattern.compile(regex);
                    Aqui utiliza-se o DAO do outro grupo que est� respons�vel por guardar as URLs no banco.
                    A inten��o � pegar todas as URLs do banco:
                    
                    URLsDAO urlDAO = new URLsDAO();
                    List<String> urlsFiltradas = new ArrayList<>();
                    List<String> urls = urlDAO.getAll();
                    for (String url: urls){
                        Matcher m = p.matcher(url);
                        if (m.matches()){
                            urlsFiltradas.add(url);
                        }
                    }
                    //Transformar as URLs filtradas em JSON pra mandar de volta 
                    //pra p�gina
                    json = "{\"url\": [";
                    for (String url: urlsFiltradas){
                        json += "\"";
                        json += url; //talvez tenha que add um "/" no inicio
                        json += "\", "
                    }
                    json += "]}";
                    json = json.replace(",]}", "]}");
                */
                json = "{\"url\": [\"/index.php\", \"/home.php\", \"/cadastro.php\"]}";
                pw.write(json);
            }catch(Exception e){
                
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
