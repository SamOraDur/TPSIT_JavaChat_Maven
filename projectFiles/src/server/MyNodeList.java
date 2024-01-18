/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author 5Bi
 */
public class MyNodeList implements NodeList{
    ArrayList<Element> list;
    
    MyNodeList(){
        list = new ArrayList<Element>();
    }
    
    @Override
    public Node item(int index){
        return (Node)list.get(index);
    }
    
    @Override
    public int getLength(){
        return list.size();
    }
    
    public void add(Element e){
        list.add(e);
    }
}
