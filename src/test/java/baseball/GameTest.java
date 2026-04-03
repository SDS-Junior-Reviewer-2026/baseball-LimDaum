package baseball;

import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        }
        catch (IllegalArgumentException e) {

        }
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.getSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    @Test
    public void returnSolvedReesultIfAllNumberMatch() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    public void returnUnSolvedResultIfNoMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    @Test
    public void returnUnSolvedResultIfSomeMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("120"), false, 2, 0);
        assertMatchedNumber(game.guess("061"), false, 0, 1);
        assertMatchedNumber(game.guess("136"), false, 1, 1);
    }
}
