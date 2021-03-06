package org.sangaizhi.activemq.spring.reveiver;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/5/25
 */
@Component
public class QueueReceiver2 implements MessageListener {
    public void onMessage(Message message) {
        try{
            String text = ((TextMessage)message).getText();
            System.out.println("QueueReceiver2 接收到消息：" + text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
