package Wallet;

import Card.CardObject;
import Id.IdentificationCard;
import Key.KeyObject;

import java.util.List;

public class Wallet {
    private final Integer cardMaxCapacity = 4;
    private final Integer coinMaxCapacity = 100;
    private final Integer idCardMaxCapacity = 3;
    private final Integer moneyMaxCapacity = 10000;
    private final Integer keyHolderMaxCapacity = 1;
    private boolean isClosed = true;
    private List<CardObject> cards;
    private Integer coins;
    private List<IdentificationCard> idCards;
    private Integer cash;
    private List<KeyObject> keys;

    public Wallet(List<CardObject> cards, Integer coins, List<IdentificationCard> idCards, Integer cash, List<KeyObject> key) {
        this.cards = cards;
        this.coins = coins;
        this.idCards = idCards;
        this.cash = cash;
        this.keys = key;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public Integer getCardMaxCapacity() {
        return cardMaxCapacity;
    }

    public Integer getCoinMaxCapacity() {
        return coinMaxCapacity;
    }

    public Integer getIdCardMaxCapacity() {
        return idCardMaxCapacity;
    }

    public Integer getMoneyMaxCapacity() {
        return moneyMaxCapacity;
    }


    public Integer getKeyHolderMaxCapacity() {
        return keyHolderMaxCapacity;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public List<CardObject> getCards() {
        return cards;
    }

    public List<KeyObject> getKeys() {
        return keys;
    }

    public Integer getCoins() {
        return coins;
    }
    public Integer addCoins(int coin){
        return coins += coin;
    }
    public Integer removeCoins(int coin){
        return coins -= coin;
    }

    public List<IdentificationCard> getIdCards() {
        return idCards;
    }

    public Integer getCash() {
        return cash;
    }
    public Integer addCash(int money){
        return cash += money;
    }
    public Integer removeCash(int money){
        return cash -= money;
    }
}