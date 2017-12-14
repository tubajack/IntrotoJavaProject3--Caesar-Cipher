import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Module 3 Project, Crypto");

        System.out.println("Please enter your string.");
        String HomerSimpson = input.nextLine();

        System.out.println("Enter a number for encryption.");
        int count = input.nextInt();

        System.out.println("Enter the length of your segment.");
        int length = input.nextInt();

        String compress = encryptString(HomerSimpson, count, length);
        System.out.println("Your encrypted value is: '" + compress + "'");
        String norules = ungroupify(compress);
        System.out.println("The decryption algorithm produced: "  + decrypt(norules, count));

        System.out.println("Thank you!");
    }

    public static void pretty(String p, String text){
        if(p.equals("print")){
            System.out.print(text);
        }
        else{
            System.out.println(text);
        }
    }

    //Part 1- Time to normalize the text
    public static String normalizeText(String input){

        //1st order of business in this part is to remove all spaces
        input = input.replace(" ", "");

        //Now we remove all of the punctuation
        String[] punctuation = new String[]{".", ",", ":", ";", "'", "\"", "!", "?", "(", ")"};
        for(int bakermayfield = 0; bakermayfield < punctuation.length; bakermayfield++){
            input = input.replace(punctuation[bakermayfield], "");
        }

        //Now we turn everything to uppercase
        input = input.toUpperCase();
        return input;

    }

    //Part 2- Caesar Cipher
    //The input represents your input. n represents the number of places to shift
    public static String caesarify(String input, int n){

        String letterindex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String returntheString = "";

        for(int count = 0; count < input.length(); count++){
            char letter = input.charAt(count);
            int index = letterindex.indexOf(letter);
            int newindex = index + n;

            if(newindex >= 0){
                if(newindex > 25){
                    while(newindex > 25){
                        newindex -= 26;
                    }
                }
            }
            else{
                while(newindex < 0){
                    newindex += 26;
                }
            }
            returntheString = returntheString + letterindex.charAt(newindex);
        }
        return returntheString;
    }

    //Part 3- Codegroups
    //The method is going to break up a string into parts whose length is determined by a pre-selected integer.
    //The last parse will be filled with x
    public static String groupify(String jackson, int jacksonsgrandpa){

        //The top variable is lthe total length of the string you are entering.
        //jacksonsgrandpa represents the group size.
        //xlength represents the remainder of stringlength divided by your group size.
        int top = jackson.length();
        String parts = "";
        int xlength = jacksonsgrandpa - (top % jacksonsgrandpa);

        //Now we are evaluating and making the groups. If the sum of rudys and jacksonsgrandpa
        //are less than the top, then they are added on. However, id rudys and jacksonsgrandpa
        //are bigger than the top, the string from rudys to top is added. Then xs are added to
        //fill in that group.
        for(int rudys = 0; rudys < top; rudys += jacksonsgrandpa){
            if((rudys + jacksonsgrandpa) > top){
                parts = parts + jackson.substring(rudys, top);

                for(int chiru = 0; chiru < xlength; chiru++){
                    parts = parts + "x";
                }
            }
            else{
                parts = parts + jackson.substring(rudys, rudys + jacksonsgrandpa) + " ";
            }
        }
        //If segments are an even amount, remove the space at the end.
        if(xlength == 0){
            parts = parts + jackson.substring(0, jackson.length()-1);
        }
        return parts;
    }

    //Part 4- Lets get everything together
    public static String encryptString(String craig, int bela, int robert){
        return groupify(caesarify(normalizeText(craig),bela),robert);
    }

    //Part 5- Decrypt. Write methods to ungroupify and decrypt
    //Ungroupify method is going to ungroup the previously grouped methods.
    public static String ungroupify(String coded){
        coded = coded.replace("x","");
        coded = coded.replace(" ", "");
        return coded;
    }

    //Decrypt method is going to decrypt your algorithm.
    public static String decrypt(String Auburn, int Alabama){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Alabama = Alabama * -1;
        String more = "";

        for(int i = 0; i < Auburn.length(); i++){
            int old = alphabet.indexOf(Auburn.charAt(i));
            int newone = old + Alabama;

            if(newone < 0){
                while(newone < 0) {
                    newone += 26;
                }
            }
            else if(newone > 25){
                while(newone > 25){
                    newone -= 26;
                }
            }
            more = more + alphabet.charAt(newone);
        }
        return more;
    }
}
