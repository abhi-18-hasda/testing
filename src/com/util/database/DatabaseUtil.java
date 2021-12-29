package com.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.util.factory.OracleConnectionFactory;

public class DatabaseUtil {
	static Connection con;

	public static boolean saveResult(Map<String, Double> data,String input_value) {
		if (con == null) {
			con = OracleConnectionFactory.getConnection();
		}
		String sql = "insert into length_converter(input_value,mm,cm,m,km) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_value);
			pstmt.setDouble(2, data.get("mm"));
			pstmt.setDouble(3, data.get("cm"));
			pstmt.setDouble(4, data.get("m"));
			pstmt.setDouble(5, data.get("km"));
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	public static List<Map<String ,Object>> getTenResults(){
		List<Map<String,Object>> data=new ArrayList();
		if (con == null) {
			con = OracleConnectionFactory.getConnection();
		}
		try {
			Statement stmt=con.createStatement();
			String sql="select * from (select c.*,rownum rn from (select * from length_converter ) c) where rn<11";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Map<String,Object> map=new LinkedHashMap<String,Object>();
				map.put("input_value",rs.getString("input_value"));
				map.put("mm",rs.getDouble("mm"));
				map.put("cm",rs.getDouble("cm"));
				map.put("m",rs.getDouble("m"));
				map.put("km",rs.getDouble("km"));
				data.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
