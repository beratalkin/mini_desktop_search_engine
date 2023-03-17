/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.minidesktopsearchengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author berat
 */
public class BeratAlkınMainClass {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //I used JFileChooser to choose the file that will be read.
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            Scanner scan = new Scanner(new FileReader(file));

            String ignoreList[] = {"a", "ain't", "am", "an", "and", "are", "aren't", "as", "at", "be", "been", "by", "can", "cannot", "cant", "can't", "co", "co.",
                "com", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "don't", "eg", "else", "et", "etc", "ex", "for", "from", "going", "got", "had", "hadn't", "has", "hasn't",
                "have", "haven't", "he", "he'd", "he'll", "her", "hers", "he's", "hi", "him", "his", "how", "i", "i'd", "ie", "if", "i'll", "i'm", "in", "inc", "instead", "into", "is", "isn't",
                "it", "it'd", "it'll", "its", "it's", "i've", "let", "let's", "ltd", "may", "mayn't", "me", "might", "mightn't", "mine", "mr", "mrs", "ms", "must", "mustn't", "my", "nd", "needn't",
                "no", "non", "none", "nor", "not", "of", "off", "oh", "ok", "okay", "on", "one's", "onto", "or", "ought", "oughtn't", "our", "ours", "out", "over", "per", "que", "qv", "rd",
                "re", "shall", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "sub", "such", "sup", "th", "than", "that", "that'll", "thats", "that's", "that've", "the",
                "their", "theirs", "them", "then", "thence", "there", "there'd", "there'll", "there're", "theres", "there's", "there've", "these", "they",
                "they'd", "they'll", "they're", "they've", "thing", "things", "this", "those", "thus", "to", "too", "un", "up", "us", "via", "viz", "vs", "was", "wasn't", "we", "we'd", "we'll", "were", "we're", "weren't", "we've", "what'll",
                "what's", "what've", "where's", "who'd", "who'll", "who's", "will", "with", "won't", "would", "wouldn't", "yet", "you", "you'd", "you'll", "your", "you're", "yours", "you've"};
            BeratAlkınBST tree = new BeratAlkınBST();

            //I used this regex because i only need the letters of the English Alphabet.
            String REGEX = "[a-zA-Z]+";
            Pattern pat = Pattern.compile(REGEX);
            Matcher mat;
            while (scan.hasNext()) {
                String s = scan.next(); //I scan every word in the file.
                mat = pat.matcher(s);
                if (mat.matches()) {//this means if it only contains letters:
                    if (Arrays.binarySearch(ignoreList, s) < 0) {//this means if it is not in the ignoreList. 
                        //I used binarySearch because my list is already in alphabetical order.
                        tree.insert(s);
                    }
                }
            }
            //firstly, i call my printpreorder method to create the String i will write into my output file.
            tree.printPreorder(tree.root);
            //then i create the output file and write the string in it.
            tree.printWriterMethod();
        }
    }
}
