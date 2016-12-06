/**
 * Created by KW100201 on 2016-11-22.
 */

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * 전문 전송 부
 * ITEM 객체를 전송한다.
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.56.1");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //String message = "Hello World!";

        Item item = null;


        for(int i= 0;i<=5;i++){
            //message = "Hello World!2"+"_"+i;
            //channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            item = new Item(i,"A4","제품설명서 전달_"+i);
            channel.basicPublish("", QUEUE_NAME, null, ObjectToByteArray(item));
        }

            //System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }


    private static byte[] ObjectToByteArray(Object obj)
    {
        if(obj == null)
            return null;
        byte[] data = SerializationUtils.serialize((Serializable) obj);

        return data;
    }
}
