package com.example.users_app.services;

//ДЗ
import com.example.users_app.domain.User;
import com.example.users_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserService userService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    private DataProcessingService dataProcessingService;
    private NotificationService notificationService;


    @Autowired
    public RegistrationService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);

        dataProcessingService.addUserToList(user);

        notificationService.sendNotification("User registration completed: " + user.getName());
    }
}