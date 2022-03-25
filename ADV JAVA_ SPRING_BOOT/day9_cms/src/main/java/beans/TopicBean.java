package beans;

import java.sql.SQLException;
import java.util.List;

import dao.TopicDaoImpl;
import pojos.Topic;

public class TopicBean {
	//state / properties
	//dependency : topic dao
	private TopicDaoImpl topicDao;
	//def ctor
	public TopicBean() throws SQLException{
		System.out.println("in topic bean ctor");
		//create the depndency
		topicDao=new TopicDaoImpl();
	}
	//getter n setter
	public TopicDaoImpl getTopicDao() {
		return topicDao;
	}
	public void setTopicDao(TopicDaoImpl topicDao) {
		this.topicDao = topicDao;
	}
	//add B.L method to return list of all topics to the caller (JSP)
	public List<Topic> getTopics() throws SQLException
	{
		System.out.println("in get all topics ");
		//invoke topic dao's method
		return topicDao.getAllTopics();
	}
	

}
