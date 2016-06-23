package com.fandor.challenge;

import java.util.ArrayList;

/**
 * Created by alexandragill on 6/21/16.
 */
public class Carousel {

    private ArrayList<String> texts;
    private int currentView;

    public Carousel() {
        texts = new ArrayList<String>();
        currentView = -1;
    }

    public int getSize() {
        return texts.size();
    }

    public String getText() {
        if (currentView < 0) {
            return null;
        }
        return texts.get(currentView);
    }

    public void addText(String input) {
        texts.add(input);
        if(currentView < 0) {
            currentView = 0;
        }
    }

    public String showNext() {
        if (currentView == texts.size() - 1) {
            currentView = 0;
        } else if (currentView >= 0) {
            currentView++;
        }
        return getText();
    }

    public String showPrevious() {
        if (currentView == 0) {
            currentView = texts.size() - 1;
        } else if (currentView >= 0){
            currentView--;
        }
        return getText();
    }
}
