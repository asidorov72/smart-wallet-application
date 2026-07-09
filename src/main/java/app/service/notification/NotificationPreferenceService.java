package app.service.notification;

import app.service.notification.client.NotificationPreferenceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationPreferenceService {

    public final NotificationPreferenceClient notificationClient;

    //@Value("${notification.service.api-key}");

}
