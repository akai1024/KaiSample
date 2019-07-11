package kai.sample.websocket;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketSessions {

    private ConcurrentHashMap<String, String> sessionUsers = new ConcurrentHashMap<>();

    @Override
    public String toString() {
        return "[WebSocketSessions] sessionUsers: " + sessionUsers.size();
    }

    public synchronized void registerSessionId(String user, String sessionId) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(sessionId, "sessionId must not be null");

        sessionUsers.put(sessionId, user);
    }

    public synchronized void removeSessionId(String sessionId) {
        Assert.notNull(sessionId, "sessionId must not be null");

        if (sessionUsers.containsKey(sessionId)) {
            sessionUsers.remove(sessionId);
        }
    }

    public ArrayList<String> getAllUsers() {
        return new ArrayList<>(sessionUsers.values());
    }

    public ArrayList<String> getAllSessionIds() {
        return new ArrayList<>(sessionUsers.keySet());
    }

    /**
     * 取得相同使用者的所有sessionIds
     */
    public ArrayList<String> getSessionIds(String user) {
        ArrayList<String> sessionIds = new ArrayList<>();
        for (Map.Entry<String, String> entry : sessionUsers.entrySet()) {
            String userInMap = entry.getValue();
            if (userInMap.equals(user)) {
                sessionIds.add(entry.getKey());
            }
        }
        return sessionIds;
    }

}
