package kai.sample.controller.chat;

public class OutputMessage {
    private String dateStr;
    private Message message;

    public OutputMessage(String dateStr, Message message) {
        this.dateStr = dateStr;
        this.message = message;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
