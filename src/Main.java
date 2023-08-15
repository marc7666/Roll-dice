public class Main {
    public static void main(String[] args){
        RollDice dice = new RollDice();
        var numbers = dice.chooseNumbers();
        dice.displayImages(numbers.get(0), numbers.get(1));
    }
}
