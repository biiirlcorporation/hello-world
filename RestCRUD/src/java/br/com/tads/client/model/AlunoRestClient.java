/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.client.model;

import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author diullian
 */
public class AlunoRestClient {
    private URI uri;
    private Client client;
    
    public AlunoRestClient(){
        uri = UriBuilder
        .fromUri("http://localhost:8080/RestCRUD/resources/aluno")
        .port(8080).build();              
        client = ClientBuilder.newClient();   
    }
    
    public int saveAluno(Aluno aluno){
        
        try{
            Aluno newAluno = client.target(uri)
                                .request()
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON+ ";charset=UTF-8")
                                .post(Entity.entity(aluno, MediaType.APPLICATION_JSON), Aluno.class);

            return 1;
        
        }catch(Exception e){
            return 0;
        }
        
    }
    
    public void removerAluno(int id) {        
         
        client.target(uri)
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .delete(Aluno.class);
    }
    
      public int alterarAluno(Aluno aluno){
            Aluno newAluno = client.target(uri)
                                .path("{id}")
                                .resolveTemplate("id", aluno.getAlunoId())
                                .request()
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON+ ";charset=UTF-8")
                                .put(Entity.entity(aluno, MediaType.APPLICATION_JSON), Aluno.class);

            return 1;
        
        
    }
    
    public Aluno getAlunoById(int id){
        Aluno aluno = client.target(uri)
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Aluno.class);
                
        return aluno;
    }
    
    public List<Aluno> getAlunos(){
        List<Aluno> alunos = client.target(uri)
                .request()
                .get(new GenericType<List<Aluno>>(){});
        return alunos;
    }
    
    public int getTotalAlunos(){
//        String total = client.target(uri)
//                .path("count")
//                .request(MediaType.TEXT_PLAIN)
//                .get();
        
       return 5;
    }
    
    public void close(){
        client.close();
    }

}
