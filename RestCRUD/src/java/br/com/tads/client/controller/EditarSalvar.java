/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.client.controller;

import br.com.tads.client.model.Aluno;
import br.com.tads.client.model.AlunoRestClient;
import br.com.tads.client.model.Endereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "EditarSalvar", urlPatterns = {"/EditarSalvar"})
public class EditarSalvar extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        
        AlunoRestClient ac = new AlunoRestClient();
        
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            
            int alunoId = Integer.parseInt(request.getParameter("alunoId"));
            int enderecoId = Integer.parseInt(request.getParameter("enderecoId"));
            
            String cpf = request.getParameter("alunoCpf");
            String nome = request.getParameter("alunoNome");
            String dataNasc = request.getParameter("alunodataNasc");
            String cep = request.getParameter("cep");
            String estado =  request.getParameter("estado");
            String cidade =  request.getParameter("cidade");
            String logradouro = request.getParameter("logradouro");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
                        
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            Date date = null;  
            try {
                date = (Date)formatter.parse(dataNasc);
            } catch (ParseException ex) {
                Logger.getLogger(EditarSalvar.class.getName()).log(Level.SEVERE, null, ex);
            }

            //popula aluno
            Aluno aluno = new Aluno();
            aluno.setAlunoId(alunoId);
            aluno.setAlunoNome(nome);
            aluno.setAlunoCpf(cpf);
            aluno.setAlunodataNasc(date);
            
            //popula endereço
            Endereco endereco = new Endereco();
            
            endereco.setEnderecoId(enderecoId);
            endereco.setEnderecoCep(cep);
            endereco.setEnderecoEstado(estado);
            endereco.setEnderecoCidade(cidade);
            endereco.setEnderecoLogradouro(logradouro);
            endereco.setEnderecoNumero(numero);
            endereco.setEnderecoComplemento(complemento);
            endereco.setEnderecoBairro(bairro);
            
            //seta o endereço para o Aluno
            aluno.setEndereco(endereco);
            
            int retorno = ac.alterarAluno(aluno);
            
            if(retorno == 1){
                request.setAttribute("sucesso", 1);
                //request.getRequestDispatcher("/RestCRUD/Editar?id=" + aluno.getAlunoId()).forward(request, response);
                response.sendRedirect("/RestCRUD/Editar?id=" + aluno.getAlunoId());
            }else{
                request.setAttribute("erro", 1);
                response.sendRedirect("/RestCRUD/Editar?id=" + aluno.getAlunoId());
            }
//            out.println("O retorno do Salvamento é = " + retorno);
//            
//            out.println("nome do babaca " + nome);
//            
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Salvar</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Salvar at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            
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
