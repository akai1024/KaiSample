package kai.sample.websocket;

import com.sun.security.auth.UserPrincipal;
import kai.sample.util.LogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * 連線事件監聽
 */
@Component
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebSocketSessions sessions;

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String user = accessor.getNativeHeader("user").get(0);
        String sessionId = accessor.getSessionId();
        sessions.registerSessionId(user, sessionId);
        LogHelper.logInfo(logger, "user login, user:{}, sessionId:{}", user, sessionId);
        LogHelper.logInfo(logger, sessions.toString());
    }

}
