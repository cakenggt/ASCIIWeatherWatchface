package com.aleclownes.asciiweatherwatchface;

/**
 * Created by alownes on 7/7/2016.
 */

public class ColorText {

    private int color;
    private String text;

    public ColorText(int color, String text){
        this.color = color;
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
