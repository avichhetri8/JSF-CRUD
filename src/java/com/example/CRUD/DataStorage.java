/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CRUD;

import com.example.User;
import com.example.jdbc.*;
import java.sql.*;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author avi
 */
@ManagedBean(name="data")
public class DataStorage {
    JDBCConnector jdbc =new JDBCConnector();
    ResultSet rst;
   
    public void storeStudent(User user) throws SQLException{
        Connection con=jdbc.getConn();
        String sql="INSERT into user(name,address,phone,course,shift) "
                    + "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getAddress()); 
            pstm.setInt(3,user.getPhone());
            pstm.setString(4,user.getCourse());
            pstm.setString(5,user.getShift());
            pstm.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(""+ex);
        }
        
    }
    
     public ResultSet getStudent() throws SQLException{
        Connection con=jdbc.getConn();
        String sql="Select * from user";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            rst= pstm.executeQuery();
                
            
        }catch(Exception ex){
            System.out.println(""+ex);
        }
        return rst;
    }
     
     //Edit 
     public String editStudent(int id) {
        User editRecord = null;
        System.out.println("editStudentRecordInDB() : Student Id: " + id);
        Connection con=jdbc.getConn();

        /* Setting The Particular Student Details In Session */
        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
 
        try {
            Statement stmt = con.createStatement();
            rst = stmt.executeQuery("select * from user where id = "+id);    
            while(rst.next()){
                editRecord = new User(); 
                editRecord.setId(rst.getInt(1));
                editRecord.setName(rst.getString(2));
                editRecord.setAddress(rst.getString(3));
                editRecord.setPhone(rst.getInt(4));
                editRecord.setCourse(rst.getString(5));
                editRecord.setShift(rst.getString(6)); 
            }
            sessionMapObj.put("editRecordObj", editRecord);
            con.close();
        } catch(Exception sqlEx) {
            System.out.println(""+sqlEx);
        }
        return "/editStudent.xhtml?faces-redirect=true";
    }
     
    public String updateStudent(User user) throws SQLException {
            
        Connection con=jdbc.getConn();
        
        System.out.println(""+user.getAddress()+""+user.getName()+""+user.getCourse());

        /* Setting The Particular Student Details In Session */
            PreparedStatement pst = con.prepareStatement("Update user set name=? , "
                + "address= ?, phone=?,course=?, shift=? where id=?");
            pst.setString(1,user.getName());
            pst.setString(2,user.getAddress());
            pst.setInt(3,user.getPhone());
            pst.setString(4,user.getCourse());
            pst.setString(5,user.getShift());
            pst.setInt(6,user.getId());
            pst.executeUpdate();
            con.close();
        
        return "/index.xhtml?faces-redirect=true";
    }
}