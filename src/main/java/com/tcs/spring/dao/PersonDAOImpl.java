package com.tcs.spring.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;


//import java.util.List;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tcs.spring.model.BaseResponse;
import com.tcs.spring.model.Person;
import com.tcs.spring.model.WorkOrder;

@Repository
public class PersonDAOImpl implements PersonDAO {
	public Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:sqlserver://172.25.74.112:1433;database=SCE-Devops-DB;user=sa;password=Edison2018;";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if (connection == null)

				connection = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}

	@Override
	public List<Person> select() {
		Connection connection = getConnection();
		List<Person> persons = new LinkedList<Person>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM person");

			Person person = null;
			while (resultSet.next()) {
				person = new Person();
				person.setId(Integer.parseInt(resultSet.getString("id")));
				person.setName(resultSet.getString("name"));
				person.setCountry(resultSet.getString("country"));

				persons.add(person);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(persons);
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// do nothing
		}
		// this.closeConnection();
		return persons;

	}

	@Override
	public List<WorkOrder> getWordOrderDetails(String userid) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		List<WorkOrder> workorders = new LinkedList<WorkOrder>();
		// fetching details
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from workorder where name='" + userid + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			WorkOrder workorder = null;
			while (resultSet.next()) {
				workorder = new WorkOrder();
				// workorder.setWid(Integer.parseInt(resultSet.getString("woid")));
				workorder.setName(resultSet.getString("name"));
				workorder.setWoarea(resultSet.getString("woarea"));
				workorder.setArea(resultSet.getString("area"));
				workorder.setWoorderno(Integer.parseInt(resultSet
						.getString("woorderno")));

				if (workorder != null) {
					workorders.add(workorder);
				}

			}

			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

		} catch (Exception e) {
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("Connection is Closed");
		}
		return workorders;
	}

	@Override
	public BaseResponse authenticate(String email, String password) {
		// Connection to database
		BaseResponse response = new BaseResponse();
		List<WorkOrder> workorders = null;
		Connection connection = getConnection();
		// authenticating user
		try {
			Statement statement = connection.createStatement();
			System.out.println("it actually ready this set of code!");
			String un = email.trim();
			String pw = password.trim();
			String sql = "select * from Users where username='" + un + "'";
			ResultSet resultSet = statement.executeQuery(sql);
			// Users user = null;
			workorders = new LinkedList<WorkOrder>();
			while (resultSet.next()) {
				// user = new Users();
				if (pw.equals(resultSet.getString("password").trim())) {
					workorders = getWordOrderDetails(un);
					if (workorders != null) {
						response.setSuccess(true);
						response.setErrorMessage("Success");
						response.setWorkorders(workorders);
						response.setErrorCode("202");
					} else {
						response.setSuccess(false);
					}
				}
				resultSet.close();
				statement.close();
			}
		} catch (Exception e) {
			System.out.println("Connection is Closed");
		}

		// Closing the connection
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("Connection is Closed");
		}
		return response;
	}

	@Override
	public boolean acknowledgeUser(String user, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}