<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>TADS - Matrículas</title>
    <meta charset="UTF-8" />
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
               <li class="active"><a href="/RestCRUD/listarAlunos">Buscar Todos Alunos</a></li>
               <li><a href="/RestCRUD/buscarAluno">Buscar Aluno</a></li>
             </ul>
           </div><!--/.nav-collapse -->
         </div>
       </div>

       <div class="container" style="margin-top: 80px;">
            <h1>Alunos cadastrados</h1>
            
            <div class="row">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${lista_alunos}" var="alunos">
                        <tr>
                            <td><c:out value="${alunos.alunoId}" /></td>
                            <td><c:out value="${alunos.alunoNome}" /></td>
                            <td><c:out value="${alunos.alunoCpf}" /></td>
                            <td>
                                <a href="/RestCRUD/Editar?id=${alunos.alunoId}">Editar</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="/RestCRUD/deletarAluno?id=${alunos.alunoId}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
               </table>
            </div>
       </div><!-- /.container -->

        <div class="footer">
            <div class="container">
              <p class="text-muted">Especialização em Engenharia de Software - Universidade Federal do Paraná - 2014.</p>
            </div>
        </div> 
        
    </body>
</html>
