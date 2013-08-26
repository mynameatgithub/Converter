/*
 Author: Teresa Fanchiang 
 Date  : 03/13/13
 Program Name: Converter.java
 Objective: This program changes the number 
            in the text field into its respective form 
            as indicated by the selected radio button.
 URL   : http://hills.ccsf.edu/~tfanchia/Converter.html
*/
 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Converter extends Applet 
                       implements ActionListener, ItemListener
{
  Checkbox cb1,cb2,cb3,cb4;
  CheckboxGroup cbg;
  TextField anyNum, result;

//*********************************init()*********************************
  public void init()
  {
    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(4,1));
    Panel p2 = new Panel();
    p2.setLayout(new GridLayout(2,2));
    cbg = new CheckboxGroup();
    cb1 = new Checkbox("to octal", cbg, false);
    cb2 = new Checkbox("to hex", cbg, false);
    cb3 = new Checkbox("to decimal", cbg, true);
    cb4 = new Checkbox("to binary", cbg, false);
    Label whatDo = new Label("Type your number: ", Label.RIGHT);
    Label whatGet = new Label("Converted value is: ", Label.RIGHT);
    anyNum = new TextField(12);
    result = new TextField(12);
    p2.add(whatDo);p2.add(anyNum);p2.add(whatGet);p2.add(result);
    p1.add(cb1);p1.add(cb2);p1.add(cb3);p1.add(cb4);
    add(p2);add(p1);
    anyNum.addActionListener(this);             //Catches events
    cb1.addItemListener(this);
    cb2.addItemListener(this);
    cb3.addItemListener(this);
    cb4.addItemListener(this);
  }
//***************************actionPerformed()****************************
  public void actionPerformed(ActionEvent ie)
  {
    repaint();
  }
//***************************itemStateChanged()***************************
  public void itemStateChanged(ItemEvent ie)
  { 
    String s = anyNum.getText();
    if(cb1.getState()) 
       result.setText(octal(Integer.parseInt(s)));
    else if(cb2.getState()) 
       result.setText(hex(Integer.parseInt(s)));
    else if(cb3.getState()) 
       result.setText(decimal(Integer.parseInt(s)));
    else 
       result.setText(binary(Integer.parseInt(s)));
       repaint();
  }
  
//********************************octal()*********************************
  public String octal(int num)
  {
     return(Integer.toOctalString(num));
  }
//*********************************hex()**********************************
  public String hex(int num)
  {
     return(Integer.toHexString(num));
  }
//*******************************decimal()********************************
  public String decimal(int num)
  {
     return(Integer.toString(num));
  }
//********************************binary()********************************
  public String binary(int num)
  {
     return(Integer.toBinaryString(num));
  }
}
