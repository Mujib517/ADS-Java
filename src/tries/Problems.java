package tries;

import java.util.ArrayList;
import java.util.List;

public class Problems {

    //given a string find whether a string can be broken into words
    //ex: catdog:true
    //ex: catfi: false
    public static boolean canSeparateWords(TRIE t, String str) {
        boolean wordFound = false;
        String strToFind = "";

        for (int i = 0; i < str.length(); i++) {
            strToFind += str.charAt(i);
            wordFound = t.find(strToFind);
            if(wordFound) strToFind="";
            if (i == str.length() - 1) return wordFound;
        }

        return wordFound;
    }
}
