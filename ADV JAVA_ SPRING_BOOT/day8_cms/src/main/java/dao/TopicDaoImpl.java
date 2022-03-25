package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.getConnection;

import pojos.Topic;

public class TopicDaoImpl implements ITopicDao {
	//state
	private Connection cn;
	private PreparedStatement pst1;
	
	public TopicDaoImpl() throws SQLException{
		cn=getConnection();
		pst1=cn.prepareStatement("select * from topics");
		System.out.println("topic dao created....");
		
	}

	@Override
	public List<Topic> getAllTopics() throws SQLException {
		List<Topic> topics=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				topics.add(new Topic(rst.getInt(1), rst.getString(2)));
		}
		return topics;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		System.out.println("topic dao cleaned up");
	}

}
