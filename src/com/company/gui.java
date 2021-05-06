package com.company;

import javafx.scene.layout.Background;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class gui extends Main implements ActionListener, MouseListener {
    private static JFrame frame;
    private static JLabel label, label2, enter, errorMessage, css,css1,css2, generalDegree, honoursDegree, picLabel, picLabel1, picLabel2, picLabel3, picLabel4, picLabel5;
    private static ArrayList<JLabel> array;
    private static JPanel panel1, panel2, panel3;
    private static JButton button;
    JTextField textField;
    private static String major = "";
    private static ArrayList<String> degrees = new ArrayList<String>();
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private BufferedImage myPicture, myPicture1, myPicture2, myPicture3, myPicture4, myPicture5;


    public gui()  {
        frame = new JFrame("Uwindsor courses");
        //frame
        ImageIcon image = new ImageIcon("css-logo-square.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);
        frame.addMouseListener(this);
        try {
            makePanel1();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }

    public void makePanel1() throws IOException {
        //initialize panel1
        honoursDegree = null;
        generalDegree = null;
        errorMessage = null;
        panel1 = new JPanel();
        panel1.setBackground(new Color(17,44,80));
        panel1.setBounds(0, 0, WIDTH, HEIGHT);
        panel1.setLayout(null);

        //css logo
        myPicture = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\css-logo-square100px.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(43,200,100,100);
        panel1.add(picLabel);

        //yellow_bar
        myPicture1 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\yellowbar.jpg"));
        picLabel1 = new JLabel(new ImageIcon(myPicture1));
        picLabel1.setBounds(0,600,1000,200);
        panel1.add(picLabel1);

        //css logo
        myPicture2 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\doneborder.png"));
        picLabel2 = new JLabel(new ImageIcon(myPicture2));
        picLabel2.setBounds(538,0,450,435);
        panel1.add(picLabel2);

        myPicture3 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\bottomleft.png"));
        picLabel3 = new JLabel(new ImageIcon(myPicture3));
        picLabel3.setBounds(-4,165,450,435);
        panel1.add(picLabel3);

        myPicture4 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\bottomright.png"));
        picLabel4 = new JLabel(new ImageIcon(myPicture4));
        picLabel4.setBounds(538,165,450,435);
        panel1.add(picLabel4);

        myPicture5 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\topleft.png"));
        picLabel5 = new JLabel(new ImageIcon(myPicture5));
        picLabel5.setBounds(-4,0,450,435);
        panel1.add(picLabel5);

        //Initialize label
        label = new JLabel("Enter major:");
        label.setBounds(230, 300, 300, 40);
        label.setForeground(new Color(255, 203, 0));
        label.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(label);

        css = new JLabel("Computer");
        css.setBounds(50,300,200,30);
        css.setForeground(Color.WHITE);
        css.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css);

        css1 = new JLabel("Science");
        css1.setBounds(50,320,200,30);
        css1.setForeground(Color.WHITE);
        css1.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css1);

        css2 = new JLabel("Society");
        css2.setBounds(50,340,200,30);
        css2.setForeground(Color.WHITE);
        css2.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css2);


        //Initialize textfield
        textField = new JTextField(20);
        textField.setBounds(380, 308, 300, 25);
        textField.addActionListener(this);
        panel1.add(textField);
        enter = new JLabel("Enter one of the following degrees:");
        enter.setBounds(320, 50, 450, 40);
        enter.setForeground(new Color(255,199,0));
        enter.setFont(new Font("Arial", Font.BOLD, 25));
        panel1.add(enter);

        //panel1 for major listing and enter
        //panel for textfield and enter major
        addDegree();
        int y = 130;
        array = new ArrayList<JLabel>();

        for (int i = 2; i <5; i++) {
            y = y + 25;
            label2 = new JLabel(degrees.get(i));
            label2.setForeground(new Color(255,199,0));
            label2.setBounds(330, y, 400, 40);
            label2.setFont(new Font("Arial", Font.BOLD, 18));
            array.add(label2);
        }

        generalDegree = new JLabel(degrees.get(0));
        generalDegree.setForeground(new Color(255,199,0));
        generalDegree.setBounds(390,105, 400,40);
        generalDegree.setFont(new Font("Arial", Font.BOLD, 18));

        honoursDegree = new JLabel(degrees.get(1));
        honoursDegree.setBounds(390,130,400,40);
        honoursDegree.setForeground(new Color(255,199,0));
        honoursDegree.setFont(new Font("Arial", Font.BOLD, 18));

        array.add(generalDegree);
        array.add(honoursDegree);

        for(int i = 0; i<array.size(); i++){
            panel1.add(array.get(i));
        }
        frame.add(panel1);
    }

    public void makePanel2(String major) throws Exception {
        panel2 = new JPanel();
        panel2.setBounds(0, 0, WIDTH, HEIGHT);
        panel2.setBackground(new Color(17,44,80));
        panel2.setLayout(null);
        ArrayList<String> courses = get(major);
        String course = "";
        JLabel label2 = null;
        int y = 50;
        for (int i = 0; i < courses.size(); i += 2) {
            course = courses.get(i) + " " + courses.get(i + 1);
            y = y + 25;
            label2 = new JLabel(course);
            label2.setForeground(new Color(255, 203, 0));
            label2.setBounds(50, y, 700, 15);
            label2.setFont(new Font("Arial", Font.PLAIN, 15));
            panel2.add(label2);
        }

        button = new JButton("<-");
        button.setBounds(10, 10, 50, 30);
        button.setBackground(new Color(255, 203, 0));
        button.setFocusPainted(true);
        button.setFont(new Font("Arial", Font.PLAIN, 10));
        button.addActionListener(this);
        panel2.add(button);
        picLabel.setBounds(750,550,200,200);
        panel2.add(picLabel);
        frame.add(panel2);
    }


    public void actionPerformed(ActionEvent e) {
        //add true and false statement
        if (e.getSource() == button) {
            try {
                panel2.setVisible(false);
                frame.remove(panel2);
                makePanel1();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        //when the user enters his major:
        if (e.getSource() == textField) {
            major = textField.getText();
            try {
                if(get(major)!=null) {
                    panel1.setVisible(false);
                    frame.remove(panel1);
                    makePanel2(major);
                }
                else{
                    errorMessage = new JLabel("Error! Please enter a valid entry.");
                    errorMessage.setBounds(350,350,300,25);
                    errorMessage.setForeground(Color.RED);
                    errorMessage.setFont(new Font("Arial", Font.PLAIN, 15));
                    panel1.add(errorMessage);
                    panel1.repaint();
                }
//                createTable();
//                post(get(major));
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public ArrayList<String> addDegree() {
            if (degrees.size()<5) {
                degrees.add("computer_science_general");
                degrees.add("computer_science_honours");
                degrees.add("computer_science_software_engineering");
                degrees.add("computer_science_information_systems");
                degrees.add("computer_science_applied_computing");
                 return degrees;
            }
        return degrees;
    }


    public static void main(String[] args) throws Exception {
        new gui();
        getConnection();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== label2){
            System.out.println("U DID IT MOFO");
            panel2.setVisible(false);
            frame.remove(panel2);
            panel3 = new JPanel();
            panel3.setBounds(0, 0, WIDTH, HEIGHT);
            panel3.setBackground(new Color(17,44,80));
            panel3.setLayout(null);
            panel3.setVisible(true);
            frame.add(panel3);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}