package Bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AntoraGoodDayBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(AntoraGoodDayBot.class);

    private static final String TOKEN = System.getenv("TOKEN");
    private static final String BOT_USERNAME = System.getenv("BOT_USERNAME");

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText("Хорошего дня!");
        try {
            execute(sendMessage);
            LOGGER.debug("Sended: {}", sendMessage);
        } catch (TelegramApiException e) {
            LOGGER.error("Exception: {}", e.toString());
        }
    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}