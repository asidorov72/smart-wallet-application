package app.web;

import app.model.dto.notification.NotificationResponse;
import app.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping()
    public ModelAndView getNotifications() {
        ResponseEntity<List<NotificationResponse>> notificationsHistory = notificationService
                .getNotificationsHistory("550e8400-e29b-41d4-a716-446655440000");

        ModelAndView modelAndView = new ModelAndView("notifications") ;
        return modelAndView;
    }

//    @GetMapping("/test-history")
//    public ResponseEntity<List<NotificationResponse>> getNotifications(
//            @RequestParam String userId) {
//        return notificationService.getNotificationsHistory(userId);
//    }
}
