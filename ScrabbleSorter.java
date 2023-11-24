import java.util.Scanner; // Import the Scanner class to read input

public class ScrabbleSorter {

    // Calculate the Scrabble score of a given word
    public static int calculateScore(String word) {
        int score = 0; // Initialize score to 0
        // Iterate over each letter in the word
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toUpperCase(word.charAt(i)); // Convert to uppercase to standardize
            // Add points based on letter
            if ("AEIOULNSTR".indexOf(c) >= 0) {
                score += 1;
            } else if ("DG".indexOf(c) >= 0) {
                score += 2;
            } else if ("BCMP".indexOf(c) >= 0) {
                score += 3;
            } else if ("FHVWY".indexOf(c) >= 0) {
                score += 4;
            } else if (c == 'K') {
                score += 5;
            } else if ("JX".indexOf(c) >= 0) {
                score += 8;
            } else if ("QZ".indexOf(c) >= 0) {
                score += 10;
            }
        }
        return score; // Return the total score for the word
    }

    // Main method - this is where the program starts executing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object for reading input

        // Read the number of words
        System.out.println("Enter the number of words:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        // Create an array to hold the words
        String[] words = new String[n];

        // Read the words from the console
        for (int i = 0; i < n; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            words[i] = scanner.nextLine();
        }

        // Sort the words by score and alphabetically
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Compare words[i] and words[j]
                if (calculateScore(words[i]) > calculateScore(words[j])
                        || (calculateScore(words[i]) == calculateScore(words[j])
                        && words[i].compareToIgnoreCase(words[j]) > 0)) {
                    // Swap words[i] and words[j]
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        // Print the sorted words
        System.out.println("Sorted words:");
        for (String word : words) {
            System.out.println(word);
        }

    }
}