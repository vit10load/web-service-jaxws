
package com.br.teste.ws.service;

import com.br.teste.ws.dao.AlunoDao;
import datamodel.Aluno;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author vitcl
 */
@WebService
public class AlunoService {
    
    private AlunoDao dao;
    
    public AlunoService(){
        
        dao = new AlunoDao();
    }
    
    @WebMethod(operationName = "create")
    public void create(@WebParam(name="nome") String nome, @WebParam(name="telefone") String telefone){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        dao.inserir(aluno);
    }
    
    @WebMethod(operationName = "remove")
    public void remove(@WebParam(name="index") int index){
        dao.remover(index);
    }
    
    @WebMethod(operationName = "update")
    public void update(@WebParam(name="index") int index, @WebParam(name="nome") String nome, @WebParam(name="telefone") String telefone){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        dao.atualizar(index, aluno);
    }
    
    @WebMethod(operationName = "list")
    public List<String> list(){
        return dao.getAlunos();
    }
    
    @WebMethod(operationName = "ReturnOnePerson")
    public String aluno(@WebParam(name="index") Integer index){
        return dao.buscarPorIndex(index);
    }
    
}
