public class GenerateSuggestionID {

        private static int suggestionIDCounter = 1;
    
        // Static method to generate suggestion ID
        public static int  generateSuggestionID() {
            return suggestionIDCounter++;
        }
    }
    
