package model;

public class Game {

    private final Card[] cards = {
            /* 0 */ new Card("Ты потерял память. Принять вызов НЛО?", new Answer[]{new Answer("Принять вызов", 1), new Answer("Отклонить вызов", 4)}, CardState.NORMAL),
            /* 1 */ new Card("Ты принял вызов. Поднимаешься на мостик к капитану?", new Answer[]{new Answer("Подняться на мостик", 2), new Answer("Отказаться подниматься на мостик", 5)}, CardState.NORMAL),
            /* 2 */ new Card("Ты поднялся на мостик. Ты кто?", new Answer[]{new Answer("Рассказать правду о себе", 3), new Answer("Солгать о себе", 6)}, CardState.NORMAL),
            /* 3 */ new Card("Тебя вернули домой. Победа!", new Answer[]{}, CardState.WIN),
            /* 4 */ new Card("Ты отклонил вызов. Поражение!", new Answer[]{}, CardState.LOSE),
            /* 5 */ new Card("Ты не пошёл на переговоры. Поражение!", new Answer[]{}, CardState.LOSE),
            /* 6 */ new Card("Твою ложь разоблачили. Поражение!", new Answer[]{}, CardState.LOSE),
    };

    private int currentCardId = 0;

    public void setCurrentCard(int currentCardId) {
        this.currentCardId = currentCardId;
    }

    public String getQuestion() {
        return cards[currentCardId].getQuestion();
    }

    public int getAnswersCount(){
        return cards[currentCardId].getAnswers().length;
    }

    public Answer getAnswer(int index){
        return cards[currentCardId].getAnswers()[index];
    }

    public String getCssClassName(){
        return cards[currentCardId].getState().getCssClassName();
    }

    public boolean isWin() { return cards[currentCardId].getState() == CardState.WIN; }

    public boolean isEnd() { return cards[currentCardId].getState() != CardState.NORMAL; }
}
