/**
 * 文件名称: ConsumeTest
 * 系统名称: active-mq
 * 模块名称:
 * 软件版权:
 * 功能说明:
 * 系统版本: 1.0.0.0
 * 开发人员: sangaizhi
 * 开发时间: 2017/5/24 22:13
 * 审核人员:
 * 相关文档:
 * 修改记录:
 * 修改日期:
 * 修改人员：
 * 修改说明：
 */
package org.sangaizhi.activemq.helloworld;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @name ConsumeTest
 * @author sangaizhi
 * @date 2017/5/24  22:13
 * @version 1.0
 */
public class ConsumeTest {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        MessageConsumer consumer = session.createConsumer(destination);
        int i=0;
        while (true){
            ++i;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("receive:" + message.getText());
        }
    }
}
