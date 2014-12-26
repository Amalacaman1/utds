package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Item;
import sql.ConnectionSingleton;

public class ItemDao {

	private static Connection con; 
	private static PreparedStatement pstm;
	private static ResultSet rs;

	Item item;
	
	public ItemDao(){
		item = new Item();
		init();
	}
	
	public ItemDao(Object obj){
		this();
		item = (Item) obj;
	}
	
	public int delete(int id){
		String query = "DELETE from item WHERE iditem = ?";
		
		try{
			
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			return pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int update(int id){
	
		String query = "UPDATE item SET name = ?, category = ?, objectVersion = objectVersion + 1, date_modified = ? "
				+ "WHERE iditem = ?";
		
		try{
			
			pstm = con.prepareStatement(query);
			pstm.setString(1, item.getName());
			pstm.setString(2, item.getCategory());
			pstm.setString(3, new Date()+"");
			pstm.setInt(4, id);
			return pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static List getList(){
		return getList(null);
	}
	
	public static List getList(String query){
		init();
		query = (query == null) ? "SELECT * from item" : "SELECT * from item" + query;
		List list = new ArrayList();
		
		try{
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Item item = new Item();
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setCategory(rs.getString(3));
				item.setDateModified(rs.getString(4));
				item.setObjectVersion(rs.getInt(5)+"");
				list.add(item);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert(){
	
		String query = "INSERT INTO item(name, category, date_modified) VALUES(?,?,?)";
		
		try{
			
			pstm = con.prepareStatement(query);
			pstm.setString(1, item.getName());
			pstm.setString(2, item.getCategory());
			pstm.setString(3, new Date()+"");
			
			return pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void destroy(){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void init(){
		con = ConnectionSingleton.getConnectionMgrInstance().getConnection();
		
		if(con == null)
			System.out.println("Unable to connect to db");
	}
}
