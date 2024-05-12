public void main() {
}

public class NotificationServiceImpl {
    public void sendEmail(String message) {
        // отправка email
    }

    public void sendSms(String message) {
        // отправка смс
    }

    public void sendPush(String message) {
        // отправка пуша
    }
}

public interface OpenClosedNotificationService {
    void send(String message);
}

public class EmailNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        // отправка email
    }
}

public class SmsNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        // отправка sms
    }
}

public class PushNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        // отправка push
    }
}

public class PigeonMailNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        // отправка почтового голубя
    }
}