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
    <script src="<c:url value="/assets/js/jquery.maskedinput.js" />"></script>
    
    
    <script type="text/javascript">
        jQuery(document).ready(function(){
           jQuery("#alunoCpf").mask("999.999.999-99");
           jQuery("#alunodataNasc").mask("99/99/9999");
           jQuery("#cep").mask("99.999-999");
        });
    </script>
</head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
         <div class="container">
           <div class="navbar-header">  
             <a class="navbar-brand" href="index.jsp">TADS</a>
           </div>
             
           <div class="collapse navbar-collapse">
             <ul class="nav navbar-nav">
               <li class="active"><a href="javascript:;">Cadastrar Aluno</a></li>
                <li><a href="/RestCRUD/listarAlunos">Buscar Todos Alunos</a></li>
               <li><a href="/RestCRUD/buscarAluno">Buscar Aluno</a></li>
             </ul>
           </div><!--/.nav-collapse -->
         </div>
       </div>

       <div class="container" style="">

        <div class="row">
            <div class="starter-template">
              <h1>Editar aluno</h1>
            </div>
        </div>
           <hr />
           
           <c:if test="${not empty sucesso}" >
               <div class="bs-callout bs-callout-info">
                <h4>Aluno alterado com sucesso.</h4>
              </div>
           </c:if>
           
            <c:if test="${not empty erro}" >
               <div class="bs-callout bs-callout-danger">
                <h4>Ocorreu um erro ao alterar este Aluno.</h4>
              </div>
           </c:if>
           
           <div class="row col-sm-6" >
                <div class="">
                
                    <form action="/RestCRUD/EditarSalvar" method="post" role="form">
                        <input type="hidden" name="alunoId" id="alunoId" value="${aluno.alunoId}" />
                        <input type="hidden" name="enderecoId" id="enderecoId" value="${aluno.endereco.enderecoId}" />
                        
                         <div class="form-group" role="form">
                           <label for="alunoCpf">CPF</label>
                           <input type="text" class="form-control" id="alunoCpf" name="alunoCpf"  value="${aluno.alunoCpf}" placeholder="CPF">
                         </div>

                         <div class="form-group">
                           <label for="alunoNome">Nome</label>
                           <input type="text" class="form-control" id="alunoNome" name="alunoNome" value="${aluno.alunoNome}" placeholder="Nome Completo">
                         </div>

                         <div class="form-group">
                           <label for="alunodataNasc">Data Nascimento</label>
                           <input type="text" class="form-control" id="alunodataNasc" name="alunodataNasc" value="${databr}" placeholder="Data de Nascimento">
                         </div>


                        <div class="form-group">
                           <label for="cep">CEP</label>
                           <input type="text" class="form-control" id="cep" name="cep" value="${aluno.endereco.enderecoCep}" placeholder="cep">
                        </div>

                         <div class="form-group">
                           <label for="estado">Estado</label>
                           <input type="text" class="form-control" id="estado" name="estado" value="${aluno.endereco.enderecoEstado}" placeholder="Estado" >
                         </div>


                         <div class="form-group">
                           <label for="cidade">Cidade</label>
                           <input type="text" class="form-control" id="cidade"  value="${aluno.endereco.enderecoCidade}" name="cidade" placeholder="Cidade">
                         </div>

                        <div class="row">
                             <div class="form-group col-sm-8">
                               <label for="logradouro">Logradouro</label>
                               <input type="text" class="form-control" id="logradouro"  value="${aluno.endereco.enderecoLogradouro}" name="logradouro" placeholder="Logradouro">
                             </div>

                             <div class="form-group col-sm-4">
                               <label for="numero">Número</label>
                               <input type="text" class="form-control" id="numero" value="${aluno.endereco.enderecoNumero}" name="numero" placeholder="Número">
                             </div>
                        </div>

                        <div class="form-group">
                           <label for="complemento">Complemento</label>
                           <input type="text" class="form-control" id="complemento"  value="${aluno.endereco.enderecoComplemento}"  name="complemento" placeholder="Complemento">
                        </div>

                        <div class="form-group">
                           <label for="bairro">Bairro</label>
                           <input type="text" class="form-control" id="bairro" name="bairro" value="${aluno.endereco.enderecoBairro}" placeholder="Bairro">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Editar aluno</button>
                    </form>

                </div>
           </div>       
       </div><!-- /.container -->

      <div class="footer">
        <div class="container">
          <p class="text-muted">Especialização em Engenharia de Software - Universidade Federal do Paraná - 2014.</p>
        </div>
      </div> 
    
       
    </body>
</html>
