package Lesson2.Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User admin = new Admin(chat);
        User userOne = new SimpleUser(chat);
        User userTwo = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(userOne);
        chat.addUser(userTwo);

        userOne.sendMessage("Hi, I'm UserOne");
        userTwo.sendMessage("Hi, I'm UserTwo");
        admin.sendMessage("Anmin in da house!!");
    }
}

interface User {
    void sendMessage(String message);
    void getMessage (String message);
}

interface Chat{   // Client
    void sendMessage(String message, User user);
}

class Admin implements User{  // client
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin reseved a message '" + message + "'");
    }
}

class SimpleUser implements User{
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User reseved a message '" + message + "'");
    }
}

class TextChat implements Chat{  //mediator
    User admin;
    List <User> users = new ArrayList<>();

    public void setAdmin (User admin) {
        this.admin = admin;
    }

    public void addUser (User u){
        users.add(u);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u: users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}