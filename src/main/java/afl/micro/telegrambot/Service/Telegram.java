package afl.micro.telegrambot.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.games.Animation;

@Service
public class Telegram extends TelegramLongPollingBot {

    private final String username = "jasperSpringBot";

    private final String token = "5510373867:AAFcFeM_eZ33PBYq8Z9qgYoZQUgGgHqZ8bE";

    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }


    @Override
    public void onUpdateReceived(Update update) {
        final String received = update.getMessage().getText();
        final long chatId = update.getMessage().getChatId();

        SendMessage response = new SendMessage();

        Animation reveivedImg = update.getMessage().getAnimation();

        SendAnimation sendImg = new SendAnimation();

        response.setChatId(String.valueOf(chatId));

        if (received.equals("5")) {
            response.setText("Ya sabes la rima");
        } else {

            try {
                execute(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
