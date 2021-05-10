package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static ArrayList<String> get(String table) throws Exception{
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT course_code, course_name FROM " + table);
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("course_code"));
                array.add(result.getString("course_name"));
            }
            return array;
        } catch(Exception e) { System.out.println(e); }
        return null;
    }

    //electives
    public static ArrayList<String> getElectives(String table) throws Exception{
        try {
            if(table.equals("computer_science_general")){
                table = "general_electives";
            }
            else if(table.equals("computer_science_honours")){
                table = "honours_electives";
            }
            else if(table.equals("computer_science_applied_computing")){
                table = "applied_electives";
            }
            else if(table.equals("computer_science_software_engineering")){
                table = "software_electives";
            }
            else if(table.equals("computer_science_information_systems")){
                table = "information_electives";
            }

            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT course, course_name FROM " + table);
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                array.add(result.getString("course"));
                array.add(result.getString("course_name"));
            }
            return array;
        } catch(Exception e) { System.out.println(e); }
        return null;
    }

    public static HashMap getInfoOnCourse(String table) throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            if(table.equals("computer_science_general")){
                table = "course_info_general";
            }
            else if(table.equals("computer_science_honours")){
                table = "course_info_honours";
            }
            else if(table.equals("computer_science_applied_computing")){
                table = "course_info_applied";
            }
            else if(table.equals("computer_science_software_engineering")){
                table = "course_info_software";
            }
            else if(table.equals("computer_science_information_systems")){
                table = "course_info_information";
            }
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT course_code, info FROM " + table);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                map.put(result.getString("course_code"), result.getString("info"));
            }
            return map;
        } catch(Exception e) { System.out.println(e); }
        return null;
    }

    //creates table
    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS duplicate(course_code VARCHAR(20) PRIMARY KEY, course_name VARCHAR(100), year_for_course INT)");
            create.executeUpdate();

        }catch(Exception e) { System.out.println(e); }
        finally {
        }
    }

        //inserts into newly created table
    public static void post(ArrayList<String> array) throws Exception{
        ArrayList<String> temp = new ArrayList<String>();
        int i = 0;
        int r = 1;
        int n = 0;
        while(i!=array.size()) {
            i++;
            if (i % 2 == 0) {
                temp.add(array.get(i));
            }
        }
        try {
            while(array.get(i) != null) {
                r = r + 2;
                n++;
                Connection con = getConnection();
                PreparedStatement posted = con.prepareStatement("INSERT INTO duplicate (course_code, course_name) VALUES ('" + temp.get(n)+ "', '" + array.get(r) + "')");
                posted.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e); }
        finally {
            System.out.println("Insert complete");
        }
    }



    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/newdatabase";
            String username = "root";
            String password = "M5198189565m-";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e) { System.out.println(e); }

        return null;
    }
}
