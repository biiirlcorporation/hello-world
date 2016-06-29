<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>TADS - Matrículas</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/assets/css/docbootstrap.min.css" />">
    <script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/assets/js/my-script.js" />"></script>
</head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
         <div class="container">
           <div class="navbar-header">  
             <a class="navbar-brand" href="index.jsp">TADS</a>
           </div>
             
           <div class="collapse navbar-collapse">
             <ul class="nav navbar-nav">
               <li class=""><a href="novo_aluno.jsp">Cadastrar Aluno</a></li>
               <li><a href="/RestCRUD/listarAlunos">Buscar Todos Alunos</a></li>
               <li><a href="/RestCRUD/buscarAluno">Buscar Aluno</a></li>
             </ul>
           </div><!--/.nav-collapse -->
         </div>
       </div>

       <div class="container" style="margin-top: 80px;">

         <div class="starter-template">
           <h1>Consulta de matrículas</h1>
           <p class="lead">Insira, remova e busque alunos do sistema.</p>
         </div>
           
       </div><!-- /.container -->

        
        <div class="footer">
        <div class="container">
          <p class="text-muted">Especialização em Engenharia de Software - Universidade Federal do Paraná - 2014.</p>
        </div>
      </div> 
       
    </body>
</html>
