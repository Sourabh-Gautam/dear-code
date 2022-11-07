/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.dao;

import go.util.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sourabh Gautam
 */
public class ProfileDao {

    private static PreparedStatement ps, ps1, ps2, ps3, ps4 = null;

    static {
        try {
            ps = DbConnection.getConnection().prepareStatement(" update authenticatedusers set address1=? where username = ?");
            ps2 = DbConnection.getConnection().prepareStatement(" update authenticatedusers set address2=? where username = ?");
            ps3 = DbConnection.getConnection().prepareStatement(" update authenticatedusers set address3=? where username = ?");
            ps1 = DbConnection.getConnection().prepareStatement("select address1,address2,address3 from authenticatedusers where username = ?");
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public static ArrayList<String> getAddress(String username) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        ps1.setString(1, username);
        ResultSet rs = ps1.executeQuery();
        rs.next();
        if(rs.getString(1)!=null){
            list.add(rs.getString(1));
        }
        if(rs.getString(2)!=null){
            list.add(rs.getString(2));
        }
        if(rs.getString(3)!=null){
            list.add(rs.getString(3));
        }
        return list;
    }

    public static boolean removeAddress(String target, String username) throws SQLException {
        int result = -1;
        if (target.equals("address1")) {
            System.out.println("helk");
            ps.setString(1, null);
            ps.setString(2, username);
            result = ps.executeUpdate();
        } else if (target.equals("address2")) {
            ps2.setString(1, null);
            ps2.setString(2, username);
            result = ps2.executeUpdate();
        } else if (target.equals("address3")) {
            ps3.setString(1, null);
            ps3.setString(2, username);
            result = ps3.executeUpdate();
        }
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    public static int addAddress(String address, String username) throws SQLException {
        ResultSet rs = ps1.executeQuery();
        rs.next();
        if (rs.getString(1) == null) {
            ps.setString(1, address);
            ps.setString(2, username);
            return ps.executeUpdate();
        } else if (rs.getString(2) == null) {
            ps2.setString(1, address);
            ps2.setString(2, username);
            return ps2.executeUpdate();
        } else if (rs.getString(3) == null) {
            ps3.setString(1, address);
            ps3.setString(2, username);
            return ps3.executeUpdate();
        } else {
            return 11;
        }
    }
}
