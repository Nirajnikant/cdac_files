package daoTutorials;

import java.util.List;

import pojos.Tutorials;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import static utils.DBUtils.getConnection;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public TutorialDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select name from tutorials order by visits desc");
		pst2 = cn.prepareStatement("select * from tutorials where name = ?");
		pst3 = cn.prepareStatement("update tutorials set visits = visits+? where id = ? ");
	}

	@Override
	public List<String> getAllTutorials() throws SQLException {
		List<String> tutorialName = new ArrayList<String>();
		
		try(ResultSet rst = pst1.executeQuery()) {
			while(rst.next())
			tutorialName.add(rst.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tutorialName;
	}

	@Override
	public Tutorials getTutorialDetail(String tutorialName) throws SQLException {
		System.out.println(tutorialName);
		Tutorials t = new Tutorials();
		pst2.setString(1, tutorialName);
		
		try(ResultSet rst = pst2.executeQuery()) {
			while(rst.next()) {
				t.setId(rst.getInt(1));
				t.setName(rst.getString(2));
				t.setAuthor(rst.getString(3));
				t.setPublishDate(rst.getDate(4));
				t.setVisits(rst.getInt(5));
				t.setContents(rst.getString(6));
				t.setTopicId(rst.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public String updateVisits(int id) throws SQLException {
		pst3.setInt(1, 1);
		pst3.setInt(2, id);
		
//		try(ResultSet rst2 = pst2.executeQuery()) {
//			if(authenticateUser(email, new_password).getPassword() == new_password)
//				return "PassWord updated";
//			else 
//				return "Operation Failed";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Updated visit count";
		return "Updat visit count failed!!!!!";
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up....");
	}
}
