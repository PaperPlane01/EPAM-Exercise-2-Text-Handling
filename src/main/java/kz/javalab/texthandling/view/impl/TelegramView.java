package kz.javalab.texthandling.view.impl;

import kz.javalab.texthandling.telegram.entity.Telegram;
import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
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
        System.out.println("Telegram's content:");
        (new TextView(telegram.getContent())).show();
        System.out.println("\n");
        System.out.println("Telegram's full price:");
        System.out.println(telegram.getPrice());
        System.out.println("Telegram's price per word:");
        System.out.println(telegram.getPricePerWord());
        System.out.println("Words contained in telegram:");
        System.out.println(new TextAnalyzer(telegram.getContent()).getNumberOfWords());
    }

    
}
