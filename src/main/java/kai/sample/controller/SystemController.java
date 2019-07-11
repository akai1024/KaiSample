package kai.sample.controller;

import kai.sample.controller.chat.Message;
import kai.sample.controller.chat.OutputMessage;
import kai.sample.websocket.MsgTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/system", method = RequestMethod.POST)
public class SystemController {

    @Autowired
    private MsgTemplate template;

    @RequestMapping("/broadcast")
    public OutputMessage broadcast(@RequestBody Message message) {
        OutputMessage outputMessage = new OutputMessage(new Date().toString(), message);
        template.broadcast(outputMessage);
        return outputMessage;
    }

    @RequestMapping("/send/{user}")
    public OutputMessage broadcast(@PathVariable("user") String user, @RequestBody Message message) {
        OutputMessage outputMessage = new OutputMessage(new Date().toString(), message);
        template.sendMsgToUser(user, outputMessage);
        return outputMessage;
    }

}
