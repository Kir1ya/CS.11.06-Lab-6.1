import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] compareVal = readFile(fileName);

        int counter = 0;

        for (int i = 1; i < compareVal.length; i++) {
            if (compareVal[i] > compareVal[i-1]) {
                counter ++;
            }
        }
        return counter;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] compareVal = readFile(fileName);

        int counter = 0;

        for (int i = 3; i < compareVal.length; i++) {
            int currentSum = compareVal[i] + compareVal[i - 1] + compareVal[i - 2];
            int previousSum = compareVal[i - 1] + compareVal[i - 2] + compareVal[i - 3];

            if (currentSum > previousSum) {
                counter++;
            }
        }

        return counter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] checkPos = readFile2(fileName);
        int horizontalPos = 0;
        int verticalPos = 0;

        for (int i = 0; i < checkPos.length; i++) {
            if (checkPos[i].contains("forward")) {
                int hValue = Integer.parseInt(checkPos[i].split(" ")[1]);
                horizontalPos += hValue;
            }
            if (checkPos[i].contains("down")) {
                int vValue = Integer.parseInt(checkPos[i].split(" ")[1]);
                verticalPos += vValue;
            }
            if (checkPos[i].contains("up")) {
                int vValue = Integer.parseInt(checkPos[i].split(" ")[1]);
                verticalPos -= vValue;
            }
        }
        return horizontalPos * verticalPos;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] checkPos = readFile2(fileName);
        int horizontalPos = 0;
        int verticalPos = 0;
        int aimNum = 0;


        for (int i = 0; i < checkPos.length; i++) {
            if (checkPos[i].contains("down")) {
                int aim = Integer.parseInt(checkPos[i].split(" ")[1]);
                aimNum += aim;

            }
            if (checkPos[i].contains("up")) {
                int aim = Integer.parseInt(checkPos[i].split(" ")[1]);
                aimNum -= aim;
            }
            if (checkPos[i].contains("forward")) {
                int hValue = Integer.parseInt(checkPos[i].split(" ")[1]);
                horizontalPos += hValue;
                verticalPos = verticalPos + aimNum*hValue;
            }
        }
        return horizontalPos * verticalPos;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}