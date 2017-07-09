package kz.javalab.texthandling.view.impl;

import kz.javalab.texthandling.telegram.entity.Telegram;
import kz.javalab.texthandling.view.View;

/**
 * Created by Администратор on 10.07.2017.
 */
public class TelegramView implements View {

    private Telegram telegram = new Telegram();

    public TelegramView() {
    }

    public TelegramView(Telegram telegram) {
        this.telegram = telegram;
    }

    public Telegram getTelegram() {
        return telegram;
    }

    public void setTelegram(Telegram telegram) {
        this.telegram = telegram;
    }

    @Override
    public void show() {
        showMessage("Telegram's content:\n");
        (new TextView(telegram.getContent())).show();
        showMessage("Telegram's full price:\n");
        showMessage(Integer.toString(telegram.getPrice()) + "\n");
        showMessage("Telegram's price per word:\n");
        showMessage(Integer.toString(telegram.getPricePerWord()));
    }

    private void showMessage(String message) {
        System.out.println(message);
    }
}
