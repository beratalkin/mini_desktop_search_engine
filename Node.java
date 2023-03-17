/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minidesktopsearchengine;

/**
 *
 * @author berat
 */
public class BeratAlkınNode {
    //Classic Node properties for BST, apart from that frequency is added
    String data;
    BeratAlkınNode rightNode;
    BeratAlkınNode leftNode;
    int frequency;
    
    public BeratAlkınNode(String data){
        this.data=data;
        this.rightNode=null;
        this.leftNode=null;
        this.frequency=1;
    }
}
