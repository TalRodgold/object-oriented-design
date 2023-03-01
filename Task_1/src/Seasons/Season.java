package Seasons;

public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    Color get_color_for_Season(Season s, String type) {
        Color answer = null;
        switch (type) {
            case "bear" -> {
                switch (s) {
                    case FALL -> {answer = Color.BROWN;}
                    case WINTER -> {answer = Color.BROWN;}
                    case SPRING -> {answer = Color.BROWN;}
                    case SUMMER -> {answer = Color.BROWN;}
                }
            }
            case "caribou" -> {
                switch (s) {
                    case FALL -> {answer = Color.BROWN;}
                    case WINTER -> {answer = Color.BROWN;}
                    case SPRING -> {answer = Color.BROWN;}
                    case SUMMER -> {answer = Color.BROWN;}
                }
            }
            case "olive" -> {
                switch (s) {
                    case FALL -> {answer = Color.GREEN;}
                    case WINTER -> {answer = Color.GREEN;}
                    case SPRING -> {answer = Color.GREEN;}
                    case SUMMER -> {answer = Color.GREEN;}
                }
            }
            case "fig" -> {
                switch (s) {
                    case FALL -> {answer = Color.YELLOW;}
                    case WINTER -> {answer = Color.YELLOW;}
                    case SPRING -> {answer = Color.GREEN;}
                    case SUMMER -> {answer = Color.GREEN;}
                }
            }
        }
        return answer;
    }

}


