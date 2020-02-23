/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jdbc;

import java.sql.*;

/**
 *
 * @author avi
 */

public class JDBCConnector {
    Connection con;
    public  Connection getConn(){
        try{           
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost/SpringNagarjuna","root","root");
             
        }catch(Exception e){
            System.out.println("dasd error"+e);
        }
        return con;
    }

    public JDBCConnector() {
     
    }
    
}
    
