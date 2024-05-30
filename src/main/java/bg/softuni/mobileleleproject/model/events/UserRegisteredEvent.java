package bg.softuni.mobileleleproject.model.events;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {

    private final String userEmail;
    private final String userName;
    private final String appURL;

    public UserRegisteredEvent(Object source, String userEmail, String userName, String appURL) {
        super(source);
        this.userEmail = userEmail;
        this.userName = userName;
        this.appURL = appURL;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getAppURL() {
        return appURL;
    }
}