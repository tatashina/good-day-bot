import Bot.AntoraGoodDayBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new AntoraGoodDayBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        System.out.println(123);
    }
}
