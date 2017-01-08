/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiercelieu;

import java.util.Scanner;

/**
 *
 * @author emarq_000
 */
public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LINES_CLEAR = 2;
    
    //simple confirm
        /**
         * Just wait for any entry
         * @line : text to print before input
         */
         public static void waitContinue(String line){
            print(line);
            SCANNER.next();
         }
    
        /**
         * Just wait for any entry
         */
         public static void waitContinue(){
            waitContinue("Input anything to continue :");
         }
    
    //printing
        /**
         * Displays a single line in console
         * @param line : line to display in console
         */
        public static void print(String line) {
            System.out.println(line);
        }
        /**
         * Displays multiple lines in console
         * @param lines : lines to display in console
         */
        public static void print(String[] lines) {
            for (String line : lines) {
                print(line);
            }
        }
        
        public static void clear() {
            for (int i=0; i<LINES_CLEAR; i++) {
                print("");
            }
        }

    //Int
        /**
         * Gets an input number from the console
         * @return : inputed number
         */
        public static int askInt(){
            print("Input a number :");
            return (SCANNER.nextInt());
        }
        /**
         * Gets an input number, between min included and max included, from the console
         * @param min : minimum value accepted
         * @param max : maximum value accepted
         * @param header : text to display before input
         * @return : inputed number
         */
        public static int askInt(int min, int max, String header){
            print(header);
            int inputInt = -1;
            String input;
            while (inputInt < 0){
                input = SCANNER.next();
                for (int i = max; i>=min; i--){
                    if (input.contains(Integer.toString(i))){
                        inputInt = i;
                    }
                }
            }
            return (inputInt);
        }
        /**
         * Display choices and allow chosing among them
         * @param choices : choices to print
         * @return : index of chosen choice
         */
        public static int askIndex(String[] choices) {
            for (int i = 0; i<choices.length; i++){
                print(i+") "+choices[i]);
            }
            int inputInt = -1;
            String input;
            while (inputInt < 0){
                input = SCANNER.next();
                for (int i = choices.length - 1; i>=0; i--){
                    if (input.contains(Integer.toString(i))){
                        inputInt = i;
                    }
                }
            }
            return inputInt;
        }
        /**
         * Display choices and allow chosing among them
         * @param choices : choices to print
         * @param header : text to print before the choices are displayed
         * @return : index of chosen choice
         */
        public static int askIndex(String[] choices, String header) {
            print(header);
            return Console.askIndex(choices);
        }
        public static int askIndex(String[] choices, String[] header) {
            print(header);
            return Console.askIndex(choices);
        }

    //String
        /**
         * Gets a non-void input string from the console
         * @return : inputed string
         */
        public static String askString(){
            print("Input some text :");
            String input = "";
            while (!(input.length() > 0)){
                input = SCANNER.next();
            }
            return (input);
        }
        
    //Strings
        /**
         * Gets an array of non-void input strings from the console
         * @param number : number of strings to get
         * @param header : text to display before geting the inputs
         * @return : array of inputed strings
         */
        public static String[] askString(int number, String header){
            print(header);
            String[] inputs = new String[number];
            for (int i = 0; i<inputs.length; i++) {
                inputs[i] = "";
                while (!(inputs[i].length() > 0)){
                    inputs[i] = SCANNER.next();
                }
            }
            return (inputs);
        }
        /**
         * Gets an array of non-void input strings from the console
         * @param number : number of strings to get
         * @return : array of inputed strings
         */
        public static String[] askString(int number){
            return (askString(number, "Input "+number+" lines :"));
        }

}
