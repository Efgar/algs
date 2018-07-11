package com.efgh.dnd.cards.entities.business;

public class CardOptions {
    private String cardColor = "robe";
    private String cardIcon = "maroon";

    public CardOptions(Classes charClass){
        setCardColor(charClass.getColor());
        setCardIcon(charClass.getIcon());
    }

    public CardOptions(String cardColor, String cardIcon){
        setCardColor(cardColor);
        setCardIcon(cardIcon);
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(String cardIcon) {
        this.cardIcon = cardIcon;
    }
}
