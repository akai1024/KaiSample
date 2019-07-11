package kai.sample.controller.chat;

import kai.sample.websocket.MsgTemplate;
import kai.sample.websocket.WebSocketSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @Autowired
    private WebSocketSessions sessions;

    @MessageMapping("/chat")
    @SendTo(MsgTemplate.BROADCAST_DESTINATION)
    public OutputMessage send(final Message message) throws Exception {
        final String time = new Date().toString();
        return new OutputMessage(time, message);
    }

}
