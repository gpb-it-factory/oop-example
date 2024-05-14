import java.util.List;

// Open closed Principle - принцип открытости-закрытости.
// Классы должны быть открыты для расширения, но закрыты для изменения.
public void main() {
    String operationMessage = "Совершена операция по счёту";
    var notificationService = new NotificationService();
    // клиент совершил операцию и у него включены все виды уведомлений
    notificationService.sendEmail(operationMessage);
    notificationService.sendSms(operationMessage);
    notificationService.sendPush(operationMessage);

    // ввели новый тип уведомлений - нужно изменять сервис уведомлений
    var notificationServiceV2 = new NotificationServiceV2();
    notificationServiceV2.sendEmail(operationMessage);
    notificationServiceV2.sendSms(operationMessage);
    notificationServiceV2.sendPush(operationMessage);
    notificationServiceV2.sendPigeonMail(operationMessage);

    // OCP-compatible
    List<OpenClosedNotificationService> notificationServices = List.of(
            new EmailNotificationService(),
            new SmsNotificationService(),
            new PushNotificationService());

    for (var service : notificationServices) {
        service.send(operationMessage);
    }

    List<OpenClosedNotificationService> notificationServicesV2 = List.of(
            new EmailNotificationService(),
            new SmsNotificationService(),
            new PushNotificationService(),
            new PigeonMailNotificationService());

    for (var service : notificationServicesV2) {
        service.send(operationMessage);
    }
}

public class NotificationService {
    public void sendEmail(String message) {
        System.out.println(STR."На email отправлено уведомление \"\{message}\"");
    }

    public void sendSms(String message) {
        System.out.println(STR."ПО SMS отправлено уведомление \"\{message}\"");

    }

    public void sendPush(String message) {
        System.out.println(STR."Отправлено push-уведомление \"\{message}\"");
    }
}

// решили добавить голубиную почту как канал уведомлений
public class NotificationServiceV2 {
    public void sendEmail(String message) {
        System.out.println(STR."На email отправлено уведомление \"\{message}\"");
    }

    public void sendSms(String message) {
        System.out.println(STR."ПО SMS отправлено уведомление \"\{message}\"");

    }

    public void sendPush(String message) {
        System.out.println(STR."Отправлено push-уведомление \"\{message}\"");
    }

    public void sendPigeonMail(String message) {
        System.out.println(STR."Отправлен почтовый голуб с уведомлением \"\{message}\"");
    }
}

public interface OpenClosedNotificationService {
    void send(String message);
}

public class EmailNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        System.out.println(STR."На email отправлено уведомление \"\{message}\"");
    }
}

public class SmsNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        System.out.println(STR."ПО SMS отправлено уведомление \"\{message}\"");
    }
}

public class PushNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        System.out.println(STR."Отправлено push-уведомление \"\{message}\"");
    }
}

public class PigeonMailNotificationService implements OpenClosedNotificationService {
    @Override
    public void send(String message) {
        System.out.println(STR."Отправлен почтовый голуб с уведомлением \"\{message}\"");
    }
}