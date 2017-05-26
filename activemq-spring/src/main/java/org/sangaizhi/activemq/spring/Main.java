package org.sangaizhi.activemq.spring;

import org.sangaizhi.activemq.spring.sender.QueueSender1;
import org.sangaizhi.activemq.spring.sender.TopicSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sangaizhi
 * @date 2017/5/26
 */
public class Main {


	private ApplicationContext context;

	public void initApplicationContext(){
	    context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    public static void main(String[] args) {
	    Main main = new Main();
	    main.initApplicationContext();
        main.topicSender();

    }


    public void queueSender() {
        QueueSender1 queueSender = (QueueSender1) context.getBean("queueSender1");
		try {
			queueSender.send("test.queue", "test.queue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void topicSender(){
		TopicSender1 topicSender1 = (TopicSender1) context.getBean("topicSender1");
		topicSender1.send("test.topic","test.topic");
	}
}
