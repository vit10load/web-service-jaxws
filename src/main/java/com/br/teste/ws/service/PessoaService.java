
package com.br.teste.ws.service;

import com.br.teste.ws.dao.PessoaDAO;
import com.br.teste.ws.utils.ValidaCpfException;
import datamodel.Pessoa;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author vitcl
 */
@WebService
public class PessoaService {
    
    private PessoaDAO dao;
    
    public PessoaService(){
        dao = new PessoaDAO();
    }
    
    @WebMethod(operationName = "create")
    @WebResult(name = "UmaPessoa")
    public String create(@WebParam(name = "Pessoa")Pessoa pessoa){
        if (ValidaCpfException.isCPF(pessoa.getCpf())) {
            dao.inserir(pessoa);
            return "CPF é valido";
        }else {
            return new ValidaCpfException().getMessage();
        }
    }
    
    @WebMethod(operationName = "remove")
    @WebResult(name = "UmaPessoaRemovida")
    public void remove(@WebParam(name="index") Long index){
        dao.remover(index);
    }
    
    @WebMethod(operationName = "update")
    @WebResult(name = "UmaPessoaAtualizada")
    public String update(@WebParam(name="index") Long index, @WebParam(name = "Pessoa") Pessoa pessoa){
        if (ValidaCpfException.isCPF(pessoa.getCpf())) {
            dao.atualizar(index, pessoa);
            return "CPF é valido";
        }else {
            return new ValidaCpfException().getMessage();
        }
    }
    
    @WebMethod(operationName = "list")
    @WebResult(name="listaPessoas")
    public List<Pessoa> list(){
        return dao.getPessoas();
    } 
    
    @WebMethod(operationName = "ReturnOnePerson")
    @WebResult(name = "UmaPessoaRetornada")
    public Pessoa aluno(@WebParam(name="index") Long index){
        return dao.buscarPorIndex(index);
    }
    
}
