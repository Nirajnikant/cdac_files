package tester;

import daoTopics.TopicDaoImpl;

public class TestTopicDao {

	public static void main(String[] args) {
		try {
			TopicDaoImpl dao = new TopicDaoImpl();
			dao.getAllTopics().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
