/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minidesktopsearchengine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author berat
 */
public class BeratAlkınBST {

    BeratAlkınNode root;
    String preorderString;

    public BeratAlkınBST() {
        this.root = null;
    }

    //classic insert method for BST, the compareTo method does the job to order it alphabetical.
    void insert(String s) {
        if (root == null) {
            root = new BeratAlkınNode(s);
        } else {
            BeratAlkınNode temp = root;

            while (temp != null) {
                //if there is an equality, the frequency increases by 1.
                if (s.compareTo(temp.data) == 0) {
                    temp.frequency++;
                    break;
                } else if (s.compareTo(temp.data) > 0) {
                    if (temp.rightNode == null) {
                        BeratAlkınNode newNode = new BeratAlkınNode(s);
                        temp.rightNode = newNode;
                        break;
                    }
                    temp = temp.rightNode;
                } else if (s.compareTo(temp.data) < 0) {
                    if (temp.leftNode == null) {
                        BeratAlkınNode newNode = new BeratAlkınNode(s);
                        temp.leftNode = newNode;
                        break;

                    }
                    temp = temp.leftNode;
                }
            }
        }
    }
    
    //This recursive method changes the preorderString property exactly as i want it to be in output.
    void printPreorder(BeratAlkınNode node) {
        if (node != null) {
            preorderString += node.data + "," + node.frequency + System.lineSeparator();
            printPreorder(node.leftNode);
            printPreorder(node.rightNode);
        }
    }

    //After i call the printPreorder method, I will call this method to write my already prepared output string into my output file.
    void printWriterMethod() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("output-file.txt", "UTF-8");
        writer.print(preorderString);
        writer.close();
    }
}
