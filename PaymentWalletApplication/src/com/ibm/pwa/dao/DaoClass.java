package com.ibm.pwa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.pwa.bean.Customer;
import com.ibm.pwa.bean.Transaction;
import com.ibm.pwa.bean.TransactionHistory;

public class DaoClass implements DaoInterface {
	Connection dbCon;
	PreparedStatement theStatement;
	Transaction transaction = new Transaction();
	List<TransactionHistory> list = new ArrayList<>();

	@Override
	public boolean connectToDb() {
		boolean flag = false;
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// Try establishing the connection
			this.dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmFsdDb", "root", "");

			if (this.dbCon != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public Customer veiwAllCustomer() {

		return null;

	}

	@Override
	public double checkBalance(int custId) {
		String checkQry = "select * from transactionMaster where custId = ?";
		double balance = 0;
		try {
			this.theStatement = this.dbCon.prepareStatement(checkQry);

			this.theStatement.setString(1, String.valueOf(custId));

			ResultSet resultSet = this.theStatement.executeQuery();
			while (resultSet.next()) {
				if (custId == resultSet.getInt("custId")) {
					balance = resultSet.getDouble("balance");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public List<TransactionHistory> transactionHistory(int custId, int receiverId, double balance, String typeOfTransaction) {
		Date date = new Date();
		// write the query to insert
		String insertQry = "insert into transactionHistory(typeOfTransaction, fromUser, toUser"
				+ ", transactionAmount, UID) " + "values(?, ?, ?, ?, ?)";
		
		try {
			this.theStatement = this.dbCon.prepareStatement(insertQry);
			
			this.theStatement.setString(1, typeOfTransaction);
			this.theStatement.setString(2, String.valueOf(custId));
			this.theStatement.setString(3, String.valueOf(receiverId));
			this.theStatement.setString(4, String.valueOf(balance));
			this.theStatement.setString(5, String.valueOf(Math.random() * 23242 + 45343));
			
			// execute the query
			if (this.theStatement.executeUpdate() > 0) {
				TransactionHistory history = new TransactionHistory();
				history.setUID(String.valueOf(Math.random() * 23242 + 45343));
				//history.setTypeOfTransaction(typeOfTransaction);
				//history.setTransactionDate(date);
				
				list.add(history);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertCustDetails(Customer customer) {
		// write the query to insert
		String insertQry = "insert into customerMaster(custName, custAddress, DOB" + ", bankAccNum, password) "
				+ "values(?, ?, ?, ?, ?)";
		String str = "";

		try {
			// get a reference to the prepared statement
			this.theStatement = this.dbCon.prepareStatement(insertQry);

			// set the values for prepared statement
			this.theStatement.setString(1, customer.getCustName());
			this.theStatement.setString(2, customer.getCustAddress());
			this.theStatement.setString(3, customer.getDOB());
			this.theStatement.setString(4, String.valueOf(Math.random() * 250021 + 23242));
			this.theStatement.setString(5, customer.getPassword());

			// execute the query
			if (this.theStatement.executeUpdate() > 0) {
				str = "Customer created successfully!";
			} else {
				str = "Problem creating Customer!";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String updateCustDetails(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustDetails(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean custLogin(int custId, String password) {
		boolean flag = false;
		// check for valid id and password
		String checkQry = "select * from customerMaster where custId = ? and password = ?";
		// get a reference to the prepared statement
		try {
			this.theStatement = this.dbCon.prepareStatement(checkQry);

			// set the values for prepared statement
			this.theStatement.setString(1, String.valueOf(custId));
			this.theStatement.setString(2, password);

			ResultSet resultSet = this.theStatement.executeQuery();
			// execute the query
			while (resultSet.next()) {
				if (custId == resultSet.getInt("custId") && password.equals(resultSet.getString("password"))) {
					flag = true;
					break;
				} else {
					flag = false;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean customerTransaction(int custId) {
		Date date = new Date();
		// write the query to insert
		String insertQry = "insert into transactionMaster(typeOfTransaction, transactionDetails, balance"
				+ ", transactionDate, custId) " + "values(?, ?, ?, ?, ?)";
		boolean flag = false;

		try {
			this.theStatement = this.dbCon.prepareStatement(insertQry);

			// set the values for prepared statement
			this.theStatement.setString(1, "Deposit");
			this.theStatement.setString(2, "Account created and 25000 deposited in the account");
			this.theStatement.setString(3, String.valueOf(25000));
			this.theStatement.setString(4, String.valueOf(date));
			this.theStatement.setString(5, String.valueOf(custId));

			// execute the query
			if (this.theStatement.executeUpdate() > 0) {
				flag = true;
				transaction.setBalance(25000);
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean checkId(int custId) {
		String checkQry = "select * from transactionMaster where custId = ?";
		boolean flag = false;

		try {
			this.theStatement = this.dbCon.prepareStatement(checkQry);

			this.theStatement.setString(1, String.valueOf(custId));

			ResultSet resultSet = this.theStatement.executeQuery();
			while (resultSet.next()) {
				if (custId == resultSet.getInt("custId")) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String depositAmt(int custId, double balance) {
		String updateQry = "update transactionMaster set balance = ?, typeOfTransaction = ?, transactionDetails = ? where custId = ?";
		String str = "";
		double oldBalance = checkBalance(custId);
		// balance += oldBalance;
		try {
			this.theStatement = this.dbCon.prepareStatement(updateQry);

			this.theStatement.setString(1, String.valueOf(balance + oldBalance));
			this.theStatement.setString(2, "Deposit");
			this.theStatement.setString(3, balance + " deposited in the wallet");
			this.theStatement.setString(4, String.valueOf(custId));

			// execute the query
			if (this.theStatement.executeUpdate() > 0) {
				transaction.setBalance(balance);
				str = "Hi " + welComeUser(custId) + " your account balance deposited with " + balance
						+ " successfully, Current Balance = " + (balance + oldBalance) + "";
			} else {
				str = "Problem occured updating the balance";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public String withdrawAmt(int custId, double balance) {

		String updateQry = "update transactionMaster set balance = ?, typeOfTransaction = ?, transactionDetails = ? where custId = ?";
		String str = "";
		double oldBalance = checkBalance(custId);
		try {
			if (oldBalance > 0 && balance < oldBalance) {
				// balance = oldBalance - balance;
				this.theStatement = this.dbCon.prepareStatement(updateQry);

				this.theStatement.setString(1, String.valueOf(oldBalance - balance));
				this.theStatement.setString(2, "Withdraw");
				this.theStatement.setString(3, balance + " withdrawn from the wallet");
				this.theStatement.setString(4, String.valueOf(custId));

				// execute the query
				if (this.theStatement.executeUpdate() > 0) {
					transaction.setBalance(balance);
					str = "Hi " + welComeUser(custId) + " your account balance deducted with " + balance
							+ " successfully, Current Balance = " + (oldBalance - balance) + "";
				} else {
					str = "Problem occured updating the balance";
				}
			} else {
				str = "Insufficient balance, Current Balance = "+oldBalance+"";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public String transferFunds(int custId, int receiverId, double balance) {
		if (balance > 0) {
			String strDeposit = depositAmt(receiverId, balance);
			String strWithDraw = withdrawAmt(custId, balance);

			return strWithDraw + "\n" + strDeposit;
		} else {
			return "Insufficient Funds to transfer";
		}

	}

	@Override
	public String welComeUser(int custId) {
		String showNameQry = "select * from customerMaster where custId = ?";
		String str = "";

		try {
			this.theStatement = this.dbCon.prepareStatement(showNameQry);

			this.theStatement.setString(1, String.valueOf(custId));

			ResultSet resultSet = this.theStatement.executeQuery();
			while (resultSet.next()) {
				if (custId == resultSet.getInt("custId")) {
					str = resultSet.getString("custName");
					break;
				} else {
					str = "User not found";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public List<TransactionHistory> printTransactionSlip(int custId) {
		String checkQry = "select * from transactionHistory where fromUser = ?";
		List<TransactionHistory> histories = new ArrayList<>();
		try {
			this.theStatement = this.dbCon.prepareStatement(checkQry);
			
			this.theStatement.setString(1, String.valueOf(custId));

			ResultSet resultSet = this.theStatement.executeQuery();
			while (resultSet.next()) {
				if (custId == resultSet.getInt("fromUser")) {
					TransactionHistory history = new TransactionHistory();
					history.setFrom(resultSet.getInt("fromUser"));
					history.setTo(resultSet.getInt("toUser"));
					history.setTransactionAmount(resultSet.getDouble("transactionAmount"));
					history.setUID(String.valueOf(resultSet.getInt("UID")));
					history.setTypeOfTransaction(resultSet.getString("typeOfTransaction"));
					history.setTransactionDate(resultSet.getDate("transactionDate"));
					
					histories.add(history);
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return histories;
	}

}
