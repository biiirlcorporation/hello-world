/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.client.controller;

import br.com.tads.client.model.Aluno;
import br.com.tads.client.model.AlunoRestClient;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.xml.ws.api.message.Packet;
import static com.sun.xml.ws.api.message.Packet.State.ClientResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


/**
 *
 * @author diullian
 */
@WebServlet(name = "Buscar", urlPatterns = {"/listarAlunos"})
@Stateless
public class Buscar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        AlunoRestClient ac = new AlunoRestClient();
        Aluno aluno = new Aluno();
        List<Aluno> listAlunos = new ArrayList<>();

        //aluno = ac.getAlunoById(15);        
        listAlunos = ac.getAlunos();
        
//        URI uri;
//        uri = UriBuilder
//        .fromUri("http://localhost:8080/RestCRUD/resources/aluno")
//        .port(8080).build();    
//        Client client = ClientBuilder.newClient();
//        aluno = client.target(uri)
//                //.queryParam("id", 10)
//                .path("31")
//                .request(MediaType.APPLICATION_JSON)
//                .get(Aluno.class);
//        
//       listAlunos.add(aluno);

//       Atendimento a = new Atendimento();
//a.setXXX(...);
//...
//Client client = ClientBuilder.newClient();
//Atendimento x = client.target("url do ws")
//.request(MediaType.APPLICATION_JSON)
//.put(Entity.json(a), Atendimento.class);

        try (PrintWriter out = response.getWriter()) {
            
            request.setAttribute("lista_alunos", listAlunos);
            request.getRequestDispatcher("/listar_alunos.jsp").forward(request, response);
            
            
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
