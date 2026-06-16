package model;

public class Card {
    private String question;
    private Answer[] answers;
    private CardState state;

    public Card(String question, Answer[] answers, CardState state) {
        this.question = question;
        this.answers = answers;
        this.state = state;
    }

    public String getQuestion() {
        return question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public CardState getState() {
        return state;
    }
}
