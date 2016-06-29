/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.client.controller;

import br.com.tads.client.model.Aluno;
import br.com.tads.client.model.AlunoRestClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DIULLIAN
 */
@WebServlet(name = "Editar", urlPatterns = {"/Editar"})
public class Editar extends HttpServlet {

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
            
        int id = 0;
        boolean existeMatricula = false;
        if(request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));

            if(id > 0){
                existeMatricula = true;
                aluno = ac.getAlunoById(id);
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            if(existeMatricula){
                Date data2 = new Date();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                String dataString = formatter.format(aluno.getAlunodataNasc());
                try {
                    data2 = formatter.parse(dataString);
                } catch (ParseException ex) {
                    Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                aluno.setAlunodataNasc(data2);
                request.setAttribute("databr", dataString);
                request.setAttribute("aluno", aluno);
            }
            request.getRequestDispatcher("/editar_aluno.jsp").forward(request, response);
            
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
