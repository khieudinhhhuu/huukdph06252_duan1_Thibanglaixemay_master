package com.khieuthichien.thibanglaixemay.model;

public class Answer {

    // Lưu trạng thái được chọn hay không ?
    private boolean bit;
    // Lưu nội dung
    private String text;
    // Chon đặt màu nền không
    private boolean colorBackground;

    public Answer(String text, boolean setColorBg){
        this.text = text;
        this.colorBackground = setColorBg;
    }

    public boolean isBit() {
        return bit;
    }

    public void setBit(boolean bit) {
        this.bit = bit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isColorBackground() {
        return colorBackground;
    }
}
