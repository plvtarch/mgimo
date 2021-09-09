import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

public class UpdateReceiver extends TelegramLongPollingBot
{
    @Override
    public String getBotUsername() {
        return "MGIMOgurtzi_bot";
    }

    @Override
    public String getBotToken() {
        return "1984711248:AAF2Xm4fitfbSU_zIP03y9N_0WWJozE9vWo";
    }

    public SendMessage getMessage(Update update)
    {
        SendMessage message = new SendMessage();
        message.setText("Hello");
        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        return message;
    }

    public SendMessage aifpHandler(Update update)
    {

    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText())
        {
            if(update.getMessage().getText().equals("/start"))
            {
                SendMessage message = getMessage(update);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(update.getMessage().getText().equals("АиФП"))
                aifpHandler(update);
        }
    }
}
