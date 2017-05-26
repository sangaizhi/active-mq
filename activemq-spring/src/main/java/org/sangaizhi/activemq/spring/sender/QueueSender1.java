package org.sangaizhi.activemq.spring.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author sangaizhi
 * @date 2017/5/25
 */
@Component
public class QueueSender1 {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;


    public void send(String queueName, final String message){
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
