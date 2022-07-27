package afl.micro.telegrambot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@Slf4j
public class Telegram extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "jasperSpringBot";
    }

    @Override
    public String getBotToken() {
        return "5510373867:AAFcFeM_eZ33PBYq8Z9qgYoZQUgGgHqZ8bE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        final String received = update.getMessage().getText();
        log.info("MENSAJE: " + received);
        final long chatId = update.getMessage().getChatId();

        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));

        if(received.equals("5")){
            log.info("ES 5");
            response.setText("Ya sabes la rima");
        }else{
            response.setText("Respuesta de mensaje de bot:" + received);
        }

        try{
            execute(response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
