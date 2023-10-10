package bg.softuni.mobileleleproject.util;

import bg.softuni.mobileleleproject.model.entity.UserRoleEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;

    private String lastName;

    private UserRoleEntity role;

    private boolean isLogged;

    public CurrentUser() {

    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (this.firstName != null) {
            sb.append(this.firstName).append(" ");
        }

        if (this.lastName != null) {
            sb.append(this.lastName);
        }

        return sb.toString().trim();
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public CurrentUser setRole(UserRoleEntity role) {
        this.role = role;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(Boolean logged) {
        isLogged = logged;
        return this;
    }

    public boolean isAdmin() {
        return isLogged() && this.role.getName().name().equals("ADMIN");
    }

    public void logout() {
        this.firstName = null;
        this.lastName = null;
        this.role = null;
        this.isLogged = false;
    }

}