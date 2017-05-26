package org.sangaizhi.activemq.spring.reveiver;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author sangaizhi
 * @date 2017/5/25
 */
@Component
public class QueueReceiver1 implements MessageListener {
    public void onMessage(Message message) {
        try{
            String text = ((TextMessage)message).getText();
            System.out.println("QueueReceiver1 接收到消息：" + text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
