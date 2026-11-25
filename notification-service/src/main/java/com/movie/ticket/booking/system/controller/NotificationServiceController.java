package com.movie.ticket.booking.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationServiceController {
    @GetMapping
    public String getNotification() {
        return "notification service";
    }
}

