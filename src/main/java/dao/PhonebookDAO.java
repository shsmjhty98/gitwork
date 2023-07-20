package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.PhonebookVO;

@Repository
public class PhonebookDAO implements PhonebookDAOInter{
	
	Connection conn;
	PreparedStatement ps;
	
	public PhonebookDAO() {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
		 }catch(Exception e) {e.printStackTrace();}
	}
	
	@Override
	public int insert(PhonebookVO pb) {
		try {
			String sql="insert into phonebook values(phonebook_idx_seq.nextval,?,?,?)";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getMemo());
			
			int result=ps.executeUpdate();
			ps.close();
			return result;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public List<PhonebookVO> findAll() {
		try {
			String sql="select * from phonebook order by idx desc";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			List<PhonebookVO> list=new ArrayList<PhonebookVO>();
			
			while(rs.next()) {
				list.add(new PhonebookVO(rs.getInt("idx"), rs.getString("name"), rs.getString("hp"), rs.getString("memo")));
			}
			rs.close();
			ps.close();
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}

	@Override
	public PhonebookVO findOneById(int idx) {
		try {
			String sql="select * from phonebook where idx=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ResultSet rs=ps.executeQuery();
			PhonebookVO pb=null;
			if(rs.next()) {
				pb=new PhonebookVO(rs.getInt("idx"), rs.getString("name"), rs.getString("hp"), rs.getString("memo"));
			}
			rs.close();
			ps.close();
			return pb;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	@Override
	public List<PhonebookVO> searchFind(String search) {
		try {
			String sql="select * from book where name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			ResultSet rs = ps.executeQuery();
			List<PhonebookVO> list=new ArrayList<PhonebookVO>();
			PhonebookVO pb=null;
			while(rs.next()) {
				pb = new PhonebookVO(rs.getString("name"),rs.getString("hp"),rs.getString("memo"));
				list.add(pb);
			}
			ps.close();
			return list;
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}

	@Override
	public int update(int idx, PhonebookVO pb) {
		try {
			String sql="update phonebook set name=?, hp=?, memo=? where idx=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getMemo());
			ps.setInt(4, pb.getIdx());
			
			int result=ps.executeUpdate();
			ps.close();
			return result;			
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}

	@Override
	public int delete(int idx) {
		try {
			String sql="delete from phonebook where idx=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
}