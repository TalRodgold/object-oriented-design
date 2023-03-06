package Seasons;

public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    Color get_color_for_Season(Season s, String type) {
        Color answer = null;
        if (type == "bear"){
            answer = Color.BROWN;
        }
        else if (type == "caribou"){
            if (s == Season.WINTER){
                answer = Color.WHITE;
            }
             else
                 answer = Color.BROWN;
        }
        else if (type == "olive"){
            answer = Color.GREEN;
        }
        else if (type == "fig"){
            if (s == Season.FALL){
                answer = Color.YELLOW;
            }
            else if (s == Season.WINTER){
                answer = null;
            }
            if (s == Season.SPRING){
                answer = Color.GREEN;
            }
            if (s == Season.SUMMER){
                answer = Color.GREEN;
            }
        }
        return answer;
    }
    boolean get_fruit_for_season(Season s, String type) {
        if (type == "fig") {
            if (s == Season.SUMMER){
                return true;
            }
            else return false;
        }
        if (type == "olive"){
            if (s == Season.FALL){
                return true;
            }
            else return false;
        }
        return false;
    }
}


