package daoTopics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.getConnection;

import pojos.Topic;

public class TopicDaoImpl implements ITopicDao {
	private Connection cn;
	private PreparedStatement pst1;

	public TopicDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from topics");
	}

	@Override
	public List<Topic> getAllTopics() throws SQLException {
		List<Topic> topic = new ArrayList<Topic>();

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				topic.add(new Topic(rst.getInt(1), rst.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topic;
	}

}
