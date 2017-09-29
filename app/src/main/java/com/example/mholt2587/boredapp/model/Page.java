package com.example.mholt2587.boredapp.model;


public class Page {
    private int imageId;
    private int TextId;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;
    public Page(int imageId, int textId) {
        this.imageId = imageId;
        TextId = textId;
    }

    public Page(int imageId, int textId, Choice choice1, Choice choice2) {
        this.imageId = imageId;
        TextId = textId;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.isFinalPage = true;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTextId() {
        return TextId;
    }

    public void setTextId(int textId) {
        TextId = textId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

}
