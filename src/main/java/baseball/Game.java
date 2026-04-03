package baseball;

public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);

        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        }
        else {
            int strikes = 0;
            for (int i = 0; i < question.length(); i++) {
                char charAt= guessNumber.charAt(i);
                int indexOf = question.indexOf(charAt);
                if (indexOf == i) {
                    strikes++;
                }
            }

            return new GuessResult(false, strikes, 0);
        }
    }

    private static void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' ||  number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicateNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicateNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
