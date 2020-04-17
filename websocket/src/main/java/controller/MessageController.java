package controller;

import modalpack.Messages;
import modalpack.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/messages")
    @SendTo("/topic/messages")
    public OutputMessage send (Messages msg){
     String time = new SimpleDateFormat("HH:mm").format(new Date());
     return new OutputMessage(msg,time);
    }
}
