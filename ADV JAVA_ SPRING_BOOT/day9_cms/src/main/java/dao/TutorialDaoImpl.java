package dao;

import static utils.DBUtils.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3,pst4;

	public TutorialDaoImpl() throws  SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select name from tutorials where topic_id=? order by visits desc");
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where name=?");
		pst4=cn.prepareStatement("insert into tutorials values(default,?,?,?,?,?,?)");
		System.out.println("tut dao created");
	}

	@Override
	public List<String> getTutorialsByTopicId(int topicId) throws SQLException {
		List<String> tutNames = new ArrayList<>();
		pst1.setInt(1, topicId);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				tutNames.add(rst.getString(1));
		}
		return tutNames;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		pst2.setString(1, tutName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getString(6), rst.getInt(7));
		}
		return null;
	}

	@Override
	public String updateVisits(String tutName) throws SQLException {
		// set IN param
		pst3.setString(1, tutName);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "visits updated...";
		return "sists updation failed...";
	}
	

	@Override
	public String addNewTutorial(Tutorial tutorial) throws SQLException {
		//name        | author | publish_date | visits | contents                                  | topic_id
		//set IN params
		pst4.setString(1, tutorial.getTutorialName());
		pst4.setString(2, tutorial.getAuthor());
		pst4.setDate(3, tutorial.getPublishDate());
		pst4.setInt(4,tutorial.getVisits());
		pst4.setString(5, tutorial.getContents());
		pst4.setInt(6, tutorial.getTopicId());
		int updateCount = pst4.executeUpdate();
		if (updateCount == 1)
			return "new tutorial added";
		return "Adding new tutorial failed...";	
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		System.out.println("tut dao cleaned up...");
	}

}
