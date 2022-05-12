package Memo.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class MemoServiceImpl implements MemoService {
private DataSource dataSource = DataSource.getInstance();
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public List<MemoVO> selectAllList() {
		List<MemoVO> list = new ArrayList<MemoVO>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM Memo_list";
			psmt.getConnection().prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemoVO memo = new MemoVO();
				memo.setTitle(rs.getString("title"));
				memo.setWriter(rs.getString("writer"));
				memo.setContent(rs.getString("content"));
				
				
				list.add(memo);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	@Override
	public MemoVO selectMemoInfo(String title) {
		List<MemoVO> list = new ArrayList<MemoVO>();
		MemoVO memo = new MemoVO();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM Memo_list WHERE title = ?";
			psmt.getConnection().prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				memo.setTitle(rs.getString("title"));
				memo.setWriter(rs.getString("writer"));
				memo.setContent(rs.getString("content"));
			
				
				
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		
		return memo;
	}
	@Override
	public int MemoModify(MemoVO vo) {
		int result = 0;
		String sql = "UPDATE MEMO CONTENT = ?, WHERE NUMB = 1";
				
	    try {
	    	psmt = conn.prepareStatement(sql);
	    	
	    	 psmt.setString(1, vo.getNumb());
	    	 psmt.setString(2, vo.getContent());
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	@Override
	public int MemoInsert(MemoVO vo) {
		int result = 0;
	      String sql = "INSERT INTO MEMO VALUES(?, ?, ?, ?)";
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	        
	         psmt.setString(1, vo.getNumb());
	         psmt.setString(2, vo.getTitle());
	         psmt.setString(3, vo.getWriter());
	         psmt.setString(4, vo.getContent());
	        
	        
	         
	         result = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return result;
	   }



	@Override
	public int MemoDelete(MemoVO vo) {
		int result = 0;
		String sql = "DELETE FROM MEMO WHERE NUMB = ?";
				
				try {
			         psmt = conn.prepareStatement(sql);
			        
			         psmt.setString(1, vo.getNumb());
			         psmt.setString(2, vo.getTitle());
			         psmt.setString(3, vo.getWriter());
			         psmt.setString(4, vo.getContent());
			        
			        
			         
			         result = psmt.executeUpdate();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      }
			      
			      return result;
			   }



	public static Memo getInstance() {
	
		return null;
	}

}
