package com.example.sem3HomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserService userService;
    private NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String username, String email, String password) {
        // Создание пользователя
        User user = new User(username, email, password);

        // Добавление пользователя в репозиторий
        userService.addUser(user);

        // Вывод сообщения в консоль
        notificationService.sendNotification("Пользователь " + username + " зарегистрирован");
    }
}