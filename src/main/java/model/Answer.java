package model;

public class Answer {
    private final String answer;
    private final int cardId;

    public Answer(String answer, int cardId) {
        this.answer = answer;
        this.cardId = cardId;
    }

    public String getText() {
        return answer;
    }

    public int getCardId() {
        return cardId;
    }
}
