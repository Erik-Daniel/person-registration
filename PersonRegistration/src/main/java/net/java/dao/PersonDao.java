package net.java.dao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.java.model.Person;
//import net.java.registration.*;


public class PersonDao {

	public int registerPerson(Person person) throws ClassNotFoundException {
		
		String INSERT_PERSON_SQL = "INSERT INTO person" + " (Name, Age, Message) VALUES (?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		try { 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/people?useSSL=false", "root", "password");
			System.out.println("database connected");	
			PreparedStatement prepState = connection.prepareStatement(INSERT_PERSON_SQL);
			prepState.setString(1, person.getName());
			prepState.setInt(2, person.getAge());
			prepState.setString(3, person.getMessage());
			
			
			result = prepState.executeUpdate();
			
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
