package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /********** Answer ***********/

    @Test
    void answer_getText_returnsCorrectText() {
        Answer answer = new Answer("Принять вызов", 1);
        assertEquals("Принять вызов", answer.getText());
    }

    @Test
    void answer_getCardId_returnsCorrectId() {
        Answer answer = new Answer("Принять вызов", 1);
        assertEquals(1, answer.getCardId());
    }

    /********** CardState ***********/

    @Test
    void cardState_cssClassName_normal() {
        assertEquals("quest-normal", CardState.NORMAL.getCssClassName());
    }

    @Test
    void cardState_cssClassName_win() {
        assertEquals("quest-win", CardState.WIN.getCssClassName());
    }

    @Test
    void cardState_cssClassName_lose() {
        assertEquals("quest-lose", CardState.LOSE.getCssClassName());
    }

    /********** Game — начальное состояние ***********/

    @Test
    void game_initialCard_isNotEnd() {
        Game game = new Game();
        assertFalse(game.isEnd());
    }

    @Test
    void game_initialCard_isNotWin() {
        Game game = new Game();
        assertFalse(game.isWin());
    }

    @Test
    void game_initialCard_hasTwoAnswers() {
        Game game = new Game();
        assertEquals(2, game.getAnswersCount());
    }

    @Test
    void game_initialCard_cssClassIsNormal() {
        Game game = new Game();
        assertEquals("quest-normal", game.getCssClassName());
    }

    /************ Game — ответы стартовой карточки ***********/

    @Test
    void game_initialCard_firstAnswerText() {
        Game game = new Game();
        assertEquals("Принять вызов", game.getAnswer(0).getText());
    }

    @Test
    void game_initialCard_firstAnswerLeadsToCard1() {
        Game game = new Game();
        assertEquals(1, game.getAnswer(0).getCardId());
    }

    @Test
    void game_initialCard_secondAnswerText() {
        Game game = new Game();
        assertEquals("Отклонить вызов", game.getAnswer(1).getText());
    }

    @Test
    void game_initialCard_secondAnswerLeadsToCard4() {
        Game game = new Game();
        assertEquals(4, game.getAnswer(1).getCardId());
    }

    /************** Game — победа (карточка 3) ***************/

    @Test
    void game_winCard_isEnd() {
        Game game = new Game();
        game.setCurrentCard(3);
        assertTrue(game.isEnd());
    }

    @Test
    void game_winCard_isWin() {
        Game game = new Game();
        game.setCurrentCard(3);
        assertTrue(game.isWin());
    }

    @Test
    void game_winCard_hasNoAnswers() {
        Game game = new Game();
        game.setCurrentCard(3);
        assertEquals(0, game.getAnswersCount());
    }

    @Test
    void game_winCard_cssClassIsWin() {
        Game game = new Game();
        game.setCurrentCard(3);
        assertEquals("quest-win", game.getCssClassName());
    }

    /************* Game — поражение (карточки 4, 5, 6) *************/

    @Test
    void game_loseCard4_isEnd() {
        Game game = new Game();
        game.setCurrentCard(4);
        assertTrue(game.isEnd());
    }

    @Test
    void game_loseCard4_isNotWin() {
        Game game = new Game();
        game.setCurrentCard(4);
        assertFalse(game.isWin());
    }

    @Test
    void game_loseCard5_isNotWin() {
        Game game = new Game();
        game.setCurrentCard(5);
        assertTrue(game.isEnd());
        assertFalse(game.isWin());
    }

    @Test
    void game_loseCard6_isNotWin() {
        Game game = new Game();
        game.setCurrentCard(6);
        assertTrue(game.isEnd());
        assertFalse(game.isWin());
    }

    @Test
    void game_loseCard_cssClassIsLose() {
        Game game = new Game();
        game.setCurrentCard(4);
        assertEquals("quest-lose", game.getCssClassName());
    }

    /********* Game — навигация *************/

    @Test
    void game_setCurrentCard_changesState() {
        Game game = new Game();
        assertFalse(game.isEnd());

        game.setCurrentCard(3);
        assertTrue(game.isWin());
    }

    @Test
    void game_normalCard1_hasTwoAnswers() {
        Game game = new Game();
        game.setCurrentCard(1);
        assertEquals(2, game.getAnswersCount());
        assertFalse(game.isEnd());
    }

    @Test
    void game_normalCard2_hasTwoAnswers() {
        Game game = new Game();
        game.setCurrentCard(2);
        assertEquals(2, game.getAnswersCount());
        assertFalse(game.isEnd());
    }
}