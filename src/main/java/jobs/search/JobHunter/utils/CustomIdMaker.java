package jobs.search.JobHunter.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomIdMaker {
    private static final String NUMBER_POOL = "0123456789";
    private static final String LETTER_POOL = "abcdefghijklmnopqrstuvwxyz";

    public String generateId(int letterLength, int numberLength) {
        return generateRandomLetterIdentifier(letterLength)
                + generateRandomNumberIdentifier(numberLength);
    }


    private static String generateRandomNumberIdentifier(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(NUMBER_POOL.length());
            char randomChar = NUMBER_POOL.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    private static String generateRandomLetterIdentifier(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(LETTER_POOL.length());
            char randomChar = LETTER_POOL.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
