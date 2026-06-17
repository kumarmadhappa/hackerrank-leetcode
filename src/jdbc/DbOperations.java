package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.com.util.DbUtil;

public class DbOperations {
	public boolean insertCategory(String type) throws SQLException
	{
		String sql = "insert into category (type) values(?)";
		Connection con = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, type);
			stmt.executeUpdate();
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return true;
	}

	public ArrayList getCategoryById(int id) throws SQLException
	{
		String sql = "select id,type from category where id=?";
		Connection con = null;
		ArrayList<Object> al = new ArrayList<>();
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				al.add(rs.getInt("id"));
				al.add(rs.getString("type"));
			}
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return al;
	}

	public ResultSet getAllCategory() throws SQLException
	{
		String sql = "select id,type from category";
		Connection con = null;
		ResultSet rs = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		}
		finally
		{
			
		}
		return rs;
	}

	public boolean insertProduct(String name, float price, String type) throws SQLException
	{
		String sql = "insert into product (name,price,category_id) values(?,?,(select id from category where type=?))";
		Connection con = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			stmt.setString(3, type);
			stmt.executeUpdate();
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return true;
	}

	public ArrayList getProductById(int id) throws SQLException
	{
		String sql = "select id,name,price,category_id from product where id=?";
		Connection con = null;
		ArrayList<Object> al = new ArrayList<>();
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				al.add(rs.getInt("id"));
				al.add(rs.getString("name"));
				al.add(rs.getFloat("price"));
				al.add(rs.getInt("category_id"));
			}
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return al;
	}

	public ResultSet getAllProduct() throws SQLException
	{
		String sql = "select id,name,price,category_id from product";
		Connection con = null;
		ResultSet rs = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		}
		finally
		{
			
		}
		return rs;
	}

	public boolean insertOrder(String product_name, Date date) throws SQLException
	{
		String sql = "insert into orders (product_id,order_date) values((select id from product where name=?),?)";
		Connection con = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product_name);
			stmt.setDate(2, date);
			stmt.executeUpdate();
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return true;
	}

	public ArrayList getOrderById(int id) throws SQLException
	{
		String sql = "select id,product_id,order_date from orders where id=?";
		Connection con = null;
		ArrayList<Object> al = new ArrayList<>();
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				al.add(rs.getInt("id"));
				al.add(rs.getInt("product_id"));
				al.add(rs.getDate("order_date"));
			}
		}
		finally
		{
			DbUtil.closeConnection(con);
		}
		return al;
	}

	public ResultSet getAllOrder() throws SQLException
	{
		String sql = "select id,product_id,order_date from orders";
		Connection con = null;
		ResultSet rs = null;
		try
		{
			con = DbUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		}
		finally
		{
			
		}
		return rs;
	}
}
