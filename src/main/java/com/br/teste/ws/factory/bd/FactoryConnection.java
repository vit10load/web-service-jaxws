/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.teste.ws.factory.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitcl
 */
public class FactoryConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/exemplo_ws_aluno?useTimezone=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    public FactoryConnection() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }catch(ClassNotFoundException e){
            System.out.println("err.."+e.getMessage());
        }
        
    }
    
    public static Connection getConnection(){
        
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("err..."+ex.getMessage());
        }
        
        return null;
    }
    
    
    
    
}
