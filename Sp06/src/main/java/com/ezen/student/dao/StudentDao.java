package com.ezen.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.student.dto.DataBaseConnectionInfo;
import com.ezen.student.dto.Student;

public class StudentDao {
	String driver = null;
	String url = null;
	String id = null;
	String pw = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudentDao(DataBaseConnectionInfo dbconinfo) {	
		this.driver = dbconinfo.getDriver();
		this.url = dbconinfo.getJdbcUrl();
		this.id = dbconinfo.getUserId();
		this.pw = dbconinfo.getUserPw();
	}
	
	/*
	 * public String getDriver() { return driver; }
	 * 
	 * public void setDriver(String driver) { this.driver = driver; }
	 * 
	 * public String getUrl() { return url; }
	 * 
	 * public void setUrl(String url) { this.url = url; }
	 * 
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 * 
	 * public String getPw() { return pw; }
	 * 
	 * public void setPw(String pw) { this.pw = pw; }
	 */

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
		try {
			if(con != null ) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) { e.printStackTrace();
		}
	}

	public void insertStudent(Student std) {
		String sql = "insert into student(snum, sid, spw, sname, sage,"
				+ "sgender, smajor) values(?,?,?,?,?,?,?)";
		con =  getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsNum());
			pstmt.setString(2, std.getsId());
			pstmt.setString(3, std.getsPw());
			pstmt.setString(4, std.getsName());
			pstmt.setInt(5, std.getsAge());
			pstmt.setString(6, std.getsGender());
			pstmt.setString(7, std.getsMajor());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}

	public ArrayList<Student> selectAllStudent() {
		ArrayList<Student> list = new ArrayList<>();
		String sql = "select * from student";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student std = new Student(
						rs.getString("sNum"), rs.getString("sId"), rs.getString("sPw"),
						rs.getString("sName"), rs.getInt("sAge"), rs.getString("sGender"),
						rs.getString("sMajor")
				);
				list.add(std);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {close();
		}
		return list;
	}

	public Student selectOneStudent(String sNum) {
		Student std = null;
		String sql = "select * from student where sNum=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				std = new Student(
						rs.getString("sNum"), rs.getString("sId"), rs.getString("sPw"),
						rs.getString("sName"), rs.getInt("sAge"), rs.getString("sGender"),
						rs.getString("sMajor")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return std;
	}

	public void updateStudent(Student std) {
		String sql = "update student set sId=?, sPw=?, sName=?,"
				+ " sAge=?, sGender=?, sMajor=? where sNum=?";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsId());
			pstmt.setString(2, std.getsPw());
			pstmt.setString(3, std.getsName());
			pstmt.setInt(4, std.getsAge());
			pstmt.setString(5, std.getsGender());
			pstmt.setString(6, std.getsMajor());
			pstmt.setString(7, std.getsNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	
	
}
