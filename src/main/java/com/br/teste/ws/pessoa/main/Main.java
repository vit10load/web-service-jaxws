/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.teste.ws.pessoa.main;

import com.br.teste.ws.service.PessoaService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author vitcl
 */
public class Main {
    
    public static void main(String[] args) {
        PessoaService service = new PessoaService();
        Endpoint.publish("http://localhost:8080/pessoaws", service);
        System.out.println("start in.. http://localhost:8080/pessoaws");
    }
}
