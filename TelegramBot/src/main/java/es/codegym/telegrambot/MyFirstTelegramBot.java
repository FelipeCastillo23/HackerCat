package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "HackerCatFCP_bot";
    public static final String TOKEN = "6733979087:AAEQjIUGJV4NrMkpKvkfwoC-fqXlGktcJsg";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Bienvenido _futuro_ *programador*!");
        }
        if (getMessageText().toLowerCase().contains("hola")) {
            sendTextMessageAsync("Hola! ¿Cual es tu nombre?");
        }
        if (getMessageText().toLowerCase().contains("mi nombre es")) {
            sendTextMessageAsync("Mucho gusto, yo soy *Gato*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}