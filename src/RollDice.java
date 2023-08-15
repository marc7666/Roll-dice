import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * This application performs the task of rolling two dice and displays the images of the corresponding dice face,
 * the value of the dice face in both text and number and, finally, displays the sum of the values.
 */
public class RollDice {
    private final static Logger LOG = Logger.getLogger(RollDice.class.getName());

    public RollDice() {
        LOG.info("Roll dice object created!");

    }

    /**
     * This method, creates the JFrame, converts the numbers of the dice to words, loads the dice images, and displays all the data.
     *
     * @param integer  The first random number corresponding to a dice face
     * @param integer1 The first random number corresponding to a dice face
     */
    public void displayImages(Integer integer, Integer integer1) {
        try {
            /*---------- UI configuration ----------*/
            JFrame frame = new JFrame("Roll dice");
            frame.setLayout(new FlowLayout());
            LOG.info("displayImages -> JFrame created!");
            /*---------- Load images ----------*/
            String value1 = toWord(integer);
            String value2 = toWord(integer1);
            LOG.info("displayImages -> The numbers are transformed to a word");
            ImageIcon image1 = new ImageIcon("images/" + value1 + ".png");
            ImageIcon image2 = new ImageIcon("images/" + value2 + ".png");
            LOG.info("displayImages -> Images loaded");
            /*---------- Display panels ----------*/
            JPanel dice1Panel = getjPanel(integer, image1, value1);
            LOG.info("displayImages -> JPanel corresponding to the first dice -> OK");
            JPanel dice2Panel = getjPanel(integer1, image2, value2);
            LOG.info("displayImages -> JPanel corresponding to the second dice -> OK");
            JPanel general = getSumJPanel(integer, integer1);
            LOG.info("displayImages -> JPanel corresponding to the sum of the dice -> OK");
            frame.add(dice1Panel);
            LOG.info("displayImages -> First dice JPanel added to the frame");
            frame.add(dice2Panel);
            LOG.info("displayImages -> Second dice JPanel added to the frame");
            frame.add(general);
            LOG.info("displayImages -> Sum of the dice JPanel added to the frame");
            frame.pack(); // Adjust size automatically
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            LOG.info("displayImages -> Exit program on close UI window established");
            frame.setVisible(true);
            LOG.info("displayImages -> JFrame visibility set to true");
        } catch (Exception e) {
            LOG.severe("displayImages -> Something is not working...");
        }

    }

    /**
     * This method obtains the JPanel of the sum of the values of both dice
     *
     * @param integer  The first random number corresponding to a dice face
     * @param integer1 The first random number corresponding to a dice face
     */
    private static JPanel getSumJPanel(Integer integer, Integer integer1) {
        JPanel general = new JPanel();
        int valueSum = integer + integer1;
        general.add(new JLabel("Value sum = " + valueSum));
        return general;
    }

    /**
     * This method adds to the JPanel the corresponding dice image and the text
     *
     * @param integer The sum of the dice numbers
     * @param image1  Dice image
     * @param value1  Word corresponding to the value of the dice face
     * @return JPanel with all the components inside
     */
    private static JPanel getjPanel(Integer integer, ImageIcon image1, String value1) {
        JPanel dice1Panel = new JPanel();
        LOG.info("getjPanel -> JPanel created");
        dice1Panel.setLayout(new BoxLayout(dice1Panel, BoxLayout.Y_AXIS));
        LOG.info("getjPanel -> JPanel layout set");
        JLabel dice1 = new JLabel(image1);
        JLabel text1 = new JLabel("Value (word): " + value1);
        LOG.info("getjPanel -> Word value JLabel created");
        JLabel text11 = new JLabel("Value (number): " + integer);
        LOG.info("getjPanel -> Number JLabel created");
        dice1Panel.add(dice1);
        dice1Panel.add(text1);
        dice1Panel.add(text11);
        LOG.info("getjPanel -> Elements added to the JPanel");
        return dice1Panel;
    }

    /**
     * This method transforms in the range [1, 6] into a word
     *
     * @param number The number to transform
     */
    private static String toWord(Integer number) {
        LOG.info("toWord -> Transforming number into a word");
        String res = "";
        switch (number) {
            case 1:
                res = String.valueOf(NumberToWord.one);
                break;
            case 2:
                res = String.valueOf(NumberToWord.two);
                break;
            case 3:
                res = String.valueOf(NumberToWord.three);
                break;
            case 4:
                res = String.valueOf(NumberToWord.four);
                break;
            case 5:
                res = String.valueOf(NumberToWord.five);
                break;
            case 6:
                res = String.valueOf(NumberToWord.six);
                break;
        }
        LOG.info("toWord -> Transforming number into a word -> SUCCESS");
        return res;
    }

    /**
     * Number enum. Range [1, 6]
     */
    private enum NumberToWord {
        one,
        two,
        three,
        four,
        five,
        six
    }

    /**
     * This method generated two random numbers from 1 to 6 and returns them into an ArrayList
     *
     * @return ArrayList with the random numbers
     */
    public ArrayList<Integer> chooseNumbers() {
        ArrayList<Integer> res = new ArrayList<>();
        int num1 = (int) (Math.random() * 6) + 1;
        LOG.info("chooseNumbers -> Firs random generated");
        int num2 = (int) (Math.random() * 6) + 1;
        LOG.info("chooseNumbers -> Second random generated");
        res.add(num1);
        res.add(num2);
        LOG.info("chooseNumbers -> Randoms added to the ArrayList");
        return res;
    }
}
