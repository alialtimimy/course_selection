package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.layout.Background;
import keeptoo.KButton;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;

public class gui extends Main implements ActionListener, MouseListener {
    private static JFrame frame;
    private static JLabel label, info,courseInfoTitle,specialization1, enter, errorMessage, css, css1, css2, specializations, generalDegree, honoursDegree, picLabel, picLabel1, picLabel2, picLabel3, picLabel4, picLabel5, electiveLabel;
    private static ArrayList<JLabel> array;
    private JLabel[] jLabelArr = new JLabel[3];
    private JLabel[] jLabelArr1 = new JLabel[100];
    private static JPanel panel1, panel2, panel3, panel4, panel5;
    private static JButton button, button1, button2,button4;
    private static String major = "";
    private static ArrayList<String> degrees = new ArrayList<String>();
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private BufferedImage myPicture, myPicture1, myPicture2, myPicture3, myPicture4, myPicture5;
    private ArrayList<String> courses;
    private static ArrayList<JLabel> courseLabels;
    private static ArrayList<String> degreeNames = new ArrayList<String>();
    private static ArrayList<String> specializationArray;

    private HashMap<String, String> infoOnCourses;
    private KButton electiveButton, button3;


    public gui() {
        frame = new JFrame("Uwindsor courses");
        //frame
        ImageIcon image = new ImageIcon("css-logo-square.png");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);
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
        panel1.setBackground(new Color(17, 44, 80));
        panel1.setBounds(0, 0, WIDTH, HEIGHT);
        panel1.setLayout(null);

        //css logo
        myPicture = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\css-logo-square100px.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(43, 200, 100, 100);
        panel1.add(picLabel);

        //yellow_bar
        myPicture1 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\yellowbar.jpg"));
        picLabel1 = new JLabel(new ImageIcon(myPicture1));
        picLabel1.setBounds(0, 600, 1000, 200);
        panel1.add(picLabel1);

        //css logo
        myPicture2 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\doneborder.png"));
        picLabel2 = new JLabel(new ImageIcon(myPicture2));
        picLabel2.setBounds(538, 0, 450, 435);
        panel1.add(picLabel2);

        myPicture3 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\bottomleft.png"));
        picLabel3 = new JLabel(new ImageIcon(myPicture3));
        picLabel3.setBounds(-4, 165, 450, 435);
        panel1.add(picLabel3);

        myPicture4 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\bottomright.png"));
        picLabel4 = new JLabel(new ImageIcon(myPicture4));
        picLabel4.setBounds(538, 165, 450, 435);
        panel1.add(picLabel4);

        myPicture5 = ImageIO.read(new File("C:\\Users\\12262\\Desktop\\project\\topleft.png"));
        picLabel5 = new JLabel(new ImageIcon(myPicture5));
        picLabel5.setBounds(-4, 0, 450, 435);
        panel1.add(picLabel5);

        //Initialize label
        label = new JLabel("Select A Major:");
        label.setBounds(205, 145, 190, 43);
        label.setForeground(new Color(255, 203, 0));
        label.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(label);

        css = new JLabel("Computer");
        css.setBounds(50, 300, 200, 30);
        css.setForeground(Color.WHITE);
        css.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css);

        css1 = new JLabel("Science");
        css1.setBounds(50, 320, 200, 30);
        css1.setForeground(Color.WHITE);
        css1.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css1);

        css2 = new JLabel("Society");
        css2.setBounds(50, 340, 200, 30);
        css2.setForeground(Color.WHITE);
        css2.setFont(new Font("Arial", Font.BOLD, 23));
        panel1.add(css2);



        //panel1 for major listing and enter
        //panel for textfield and enter major
        addDegree();
        int y = 220;
        array = new ArrayList<JLabel>();
        int r = 0;
        for (int i = 2; i < 5; i++) {
            y = y + 25;
            jLabelArr[r] = new JLabel(degreeNames.get(i));
            jLabelArr[r].addMouseListener(this);
            jLabelArr[r].setForeground(new Color(255, 199, 0));
            jLabelArr[r].setBounds(205, y, 1000,40);
            jLabelArr[r].setFont(new Font("Arial", Font.BOLD, 17));
            array.add(jLabelArr[r]);
            r++;
        }



        generalDegree = new JLabel(degreeNames.get(0));
        generalDegree.addMouseListener(this);
        generalDegree.setForeground(new Color(255, 199, 0));
        generalDegree.setFont(new Font("Arial", Font.BOLD, 17));
        generalDegree.setBounds(205, 195, generalDegree.getMaximumSize().width, 40);

        honoursDegree = new JLabel(degreeNames.get(1));
        honoursDegree.addMouseListener(this);
        honoursDegree.setForeground(new Color(255, 199, 0));
        honoursDegree.setFont(new Font("Arial", Font.BOLD, 17));
        honoursDegree.setBounds(205, 220, honoursDegree.getMaximumSize().width, 40);

        array.add(generalDegree);
        array.add(honoursDegree);

        for (int i = 0; i < array.size(); i++) {
            panel1.add(array.get(i));
        }
        frame.add(panel1);
    }

    public void makePanel2(String major) throws Exception {
        panel2 = new JPanel();
        JLabel courseTitle;
        panel2.setBounds(0, 0, WIDTH, HEIGHT);
        panel2.setBackground(new Color(17, 44, 80));
        panel2.setLayout(null);
        courses = get(major);
        courseLabels = new ArrayList<JLabel>();
        String course = "";
        int y = 50;
        if(major.equals("computer_science_honours")){
            courseTitle = new JLabel(degreeNames.get(1));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        }
        else if(major.equals("computer_science_general")){
            courseTitle = new JLabel(degreeNames.get(0));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        }
        else if(major.equals("computer_science_applied_computing")){
            courseTitle = new JLabel(degreeNames.get(2));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        }
        else if(major.equals("computer_science_information_systems")){
            courseTitle = new JLabel(degreeNames.get(3));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        }
        else if(major.equals("computer_science_software_engineering")){
            courseTitle = new JLabel(degreeNames.get(4));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 21));
            courseTitle.setBounds(70, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        }
        for (int i = 0; i < courses.size(); i += 2) {
            course = courses.get(i) + " " + courses.get(i + 1);
            y = y + 25;
            jLabelArr1[i] = new JLabel(course);
            jLabelArr1[i].setForeground(new Color(255, 203, 0));
            jLabelArr1[i].setFont(new Font("Arial", Font.PLAIN, 15));
            jLabelArr1[i].setBounds(85, y, jLabelArr1[i].getMaximumSize().width, jLabelArr1[i].getMaximumSize().height);
            courseLabels.add(jLabelArr1[i]);
            panel2.add(jLabelArr1[i]);
        }
        for (int i = 0; i < courseLabels.size(); i++) {
            courseLabels.get(i).addMouseListener(this);
        }
        electiveButton = new KButton();
        electiveButton.setBounds(750, 80, 100, 50); // set the button bounds
        electiveButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        electiveButton.setText("electives");
        electiveButton.addActionListener(this);
        electiveButton.setFocusable(true);
        electiveButton.setkBackGroundColor(new Color(255, 203, 0));
        electiveButton.setkBorderRadius(0);
        electiveButton.setkBackGroundColor(new Color(255, 203, 0));
        electiveButton.setkStartColor(new Color(255, 203, 0));
        electiveButton.setkEndColor(new Color(255, 203, 0));
        electiveButton.setkForeGround(Color.BLACK);
        electiveButton.setkHoverForeGround(new Color(255, 203, 0));
        electiveButton.setkHoverEndColor(new Color(255, 203, 0));
        electiveButton.setkHoverColor(new Color(255, 203, 0));
        electiveButton.setkHoverStartColor(new Color(255, 203, 0));
        electiveButton.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(electiveButton);

        button = new JButton("<-");
        button.setBounds(10, 10, 50, 30);
        button.setBackground(new Color(255, 203, 0));
        button.setFocusPainted(true);
        button.setFont(new Font("Arial", Font.PLAIN, 10));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);
        panel2.add(button);
        picLabel.setBounds(750, 550, 200, 200);
        panel2.add(picLabel);
        System.out.println(major);
        if(!major.equals("Bachelor of Science (Honours Computer Science with Software Engineering Specialization)")){
            button3 = new KButton();
            button3.setBounds(680, 300, 200, 50); // set the button bounds
            button3.setFont(new Font("Arial Black", Font.PLAIN, 15));
            button3.setText("Specializations");
            button3.addActionListener(this);
            button3.setFocusable(true);
            button3.setkBackGroundColor(new Color(255, 203, 0));
            button3.setkBorderRadius(0);
            button3.setkBackGroundColor(new Color(255, 203, 0));
            button3.setkStartColor(new Color(255, 203, 0));
            button3.setkEndColor(new Color(255, 203, 0));
            button3.setkForeGround(Color.BLACK);
            button3.setkHoverForeGround(new Color(255, 203, 0));
            button3.setkHoverEndColor(new Color(255, 203, 0));
            button3.setkHoverColor(new Color(255, 203, 0));
            button3.setkHoverStartColor(new Color(255, 203, 0));
            button3.setBorder(BorderFactory.createEtchedBorder());
            panel2.add(button3);
        }
        frame.add(panel2);
    }

    public void makePanel3(JLabel label4) throws Exception {
        JLabel extraInfo;
        JLabel extraTitle1;
        JLabel extraTitle2;
        panel3 = new JPanel();
        String temp = "";
        infoOnCourses = getInfoOnCourse(major);
        panel3.setBounds(0, 0, WIDTH, HEIGHT);
        panel3.setBackground(new Color(17, 44, 80));
        panel3.setLayout(null);
        panel3.setVisible(true);
        button1 = new JButton("<-");
        button1.setBounds(10, 10, 50, 30);
        button1.setBackground(new Color(255, 203, 0));
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setFocusPainted(true);
        button1.setFont(new Font("Arial", Font.PLAIN, 10));
        button1.addActionListener(this);
        panel3.add(button1);
//        if(major.equals("computer_science_general")) {
//            if (label4.getText().equals("STAT-2910 or STAT-2920 Statistics for the Sciences or  Introduction to Probability\n")) {
//                courseInfoTitle = new JLabel("STAT-2910");
//                courseInfoTitle.setForeground(new Color(255, 203, 0));
//                courseInfoTitle.setFont(new Font("Lucida Blackletter", Font.PLAIN, 22));
//                courseInfoTitle.setBounds(110, 50, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
//            }
//        }
            courseInfoTitle = new JLabel(label4.getText());
            courseInfoTitle.setForeground(new Color(255, 203, 0));
            courseInfoTitle.setFont(new Font("Lucida Blackletter", Font.PLAIN, 22));
            courseInfoTitle.setBounds(110, 50, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
        if(label4.getText().substring(0,9).equals("MATH-1720")){
            extraTitle1 = new JLabel("MATH-1720");
            extraTitle1.setForeground(new Color(255, 203, 0));
            extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
            extraTitle1.setBounds(110, 80, 200, 100);
            extraInfo = new JLabel("<html>" + infoOnCourses.get("MATH-1760") + "</html>");
            extraInfo.setForeground(new Color(255, 203, 0));
            extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
            extraInfo.setBounds(110, 250, 700, 600);
            extraTitle2 = new JLabel("MATH-1760");
            extraTitle2.setForeground(new Color(255, 203, 0));
            extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
            extraTitle2.setBounds(110, 380, 200, 100);
            panel3.add(extraInfo);
            panel3.add(extraTitle1);
            panel3.add(extraTitle2);

        }
        else if(label4.getText().substring(0,9).equals("MATH-1250")){
            extraTitle1 = new JLabel("MATH-1250");
            extraTitle1.setForeground(new Color(255, 203, 0));
            extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
            extraTitle1.setBounds(110, 123, 200, 100);
            extraInfo = new JLabel("<html>" + infoOnCourses.get("MATH-1260") + "</html>");
            extraInfo.setForeground(new Color(255, 203, 0));
            extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
            extraInfo.setBounds(110, 200, 700, 600);
            extraTitle2 = new JLabel("MATH-1260");
            extraTitle2.setForeground(new Color(255, 203, 0));
            extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
            extraTitle2.setBounds(110, 350, 200, 100);
            panel3.add(extraInfo);
            panel3.add(extraTitle1);
            panel3.add(extraTitle2);
        }

        if(major.equals("computer_science_honours")){
                if(label4.getText().substring(0,9).equals("STAT-2910")) {
                extraTitle1 = new JLabel("STAT-2910");
                extraTitle1.setForeground(new Color(255, 203, 0));
                extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle1.setBounds(110, 100, 200, 100);
                extraInfo = new JLabel("<html>" + infoOnCourses.get("STAT-2920") + "</html>");
                extraInfo.setForeground(new Color(255, 203, 0));
                extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
                extraInfo.setBounds(110, 158, 700, 600);
                extraTitle2 = new JLabel("STAT-2920");
                extraTitle2.setForeground(new Color(255, 203, 0));
                extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle2.setBounds(110, 350, 200, 100);
                panel3.add(extraInfo);
                panel3.add(extraTitle1);
                panel3.add(extraTitle2);
            }
                if(label4.getText().substring(0,9).equals("COMP-4990")){
                    courseInfoTitle.setBounds(50, 50, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
                    extraTitle1 = new JLabel("COMP-4990");
                    extraTitle1.setForeground(new Color(255, 203, 0));
                    extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
                    extraTitle1.setBounds(110, 100, 200, 100);
                    extraInfo = new JLabel("<html>" + infoOnCourses.get("COMP-4960") + "</html>");
                    extraInfo.setForeground(new Color(255, 203, 0));
                    extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
                    extraInfo.setBounds(110, 280, 700, 600);
                    extraTitle2 = new JLabel("COMP-4960");
                    extraTitle2.setForeground(new Color(255, 203, 0));
                    extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
                    extraTitle2.setBounds(110, 405, 200, 100);
                    panel3.add(extraInfo);
                    panel3.add(extraTitle1);
                    panel3.add(extraTitle2);
                }
        }
        info = new JLabel("<html>" + infoOnCourses.get(label4.getText().substring(0, 9)) + "</html>");
        info.setForeground(new Color(255, 203, 0));
        info.setFont(new Font("Arial", Font.PLAIN, 18));
        info.setBounds(110, 60, 600, 400);
        panel3.add(info);
        panel3.add(courseInfoTitle);
        picLabel.setBounds(750, 550, 200, 200);
        panel3.add(picLabel);
        frame.add(panel3);
    }

    public void makePanel4() throws Exception {
        int y = 70;
        ArrayList<String> electives = getElectives(major);
        panel4 = new JPanel();
        panel4.setBounds(0, 0, WIDTH, HEIGHT);
        panel4.setBackground(new Color(17, 44, 80));
        panel4.setLayout(null);
        panel4.setVisible(true);

        button2 = new JButton("<-");
        button2.setBounds(10, 10, 50, 30);
        button2.setBackground(new Color(255, 203, 0));
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setFocusPainted(true);
        button2.setFont(new Font("Arial", Font.PLAIN, 10));
        button2.addActionListener(this);
        panel4.add(button2);

//        electiveTitle = new JLabel("");
//        electiveTitle.
        for(int i = 0 ; i<electives.size(); i+=2){
            electiveLabel = new JLabel(electives.get(i) + " " + electives.get(i+1));
            electiveLabel.setForeground(new Color(255, 203, 0));
            electiveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            electiveLabel.setBounds(40, y, electiveLabel.getMaximumSize().width,  electiveLabel.getMaximumSize().height);
            y = y + 25;
            panel4.add(electiveLabel);
        }
        frame.add(panel4);

    }

    public void makePanel5() throws Exception {
        panel5 = new JPanel();
        panel5.setBounds(0, 0, WIDTH, HEIGHT);
        panel5.setBackground(new Color(17, 44, 80));
        panel5.setLayout(null);
        panel5.setVisible(true);

        specializationArray = getSpecialization(major);
        button4 = new JButton("<-");
        button4.setBounds(10, 10, 50, 30);
        button4.setBackground(new Color(255, 203, 0));
        button4.setBorder(BorderFactory.createEtchedBorder());
        button4.setFocusPainted(true);
        button4.setFont(new Font("Arial", Font.PLAIN, 10));
        button4.addActionListener(this);
        panel5.add(button4);


        specialization1 = new JLabel("Students may specialize in one of the following areas. A special annotation will be made on the transcript for a specialization in one of the following areas, if the specified courses are completed:");
        specialization1.setBounds(40, 20, 1000,  100);
        specialization1.setForeground(new Color(255, 203, 0));
        specialization1.setFont(new Font("Arial", Font.PLAIN, 15));
        panel5.add(specialization1);


        int y = 70;

        for(int i = 0; i<specializationArray.size(); i++){
            y = y + 25;
            specializations = new JLabel(specializationArray.get(i));
            specializations.setForeground(new Color(255, 203, 0));
            specializations.setFont(new Font("Arial", Font.PLAIN, 15));
            specializations.setBounds(40, y, 1000,  100);
            panel5.add(specializations);
        }
        frame.add(panel5);
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
        if (e.getSource() == button1) {
            try {
                panel3.setVisible(false);
                frame.remove(panel3);
                makePanel2(major);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if(e.getSource() == button2){
            panel4.setVisible(false);
            frame.remove(panel4);
            try {
                makePanel2(major);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if(e.getSource() == electiveButton){
            panel2.setVisible(false);
            frame.remove(panel2);
            try {
                makePanel4();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if(e.getSource() == button3){
            panel2.setVisible(false);
            frame.remove(panel2);
            try{
                makePanel5();
            }catch(Exception exception1){
                exception1.printStackTrace();
            }
        }
        if(e.getSource() == button4){
            panel5.setVisible(false);
            frame.remove(panel5);
            try{
                makePanel2(major);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public void addDegree() {
        if (degrees.size() < 5) {
            degrees.add("computer_science_general");
            degrees.add("computer_science_honours");
            degrees.add("computer_science_applied_computing");
            degrees.add("computer_science_information_systems");
            degrees.add("computer_science_software_engineering");
        }
        degreeNames.add("Bachelor of Computer Science (General)");
        degreeNames.add("Bachelor of Computer Science (Honours)");
        degreeNames.add("Bachelor of Computer Science (Honours Applied Computing)");
        degreeNames.add("Bachelor of Science (Honours Computer Information Systems)");
        degreeNames.add("Bachelor of Science (Honours Computer Science with Software Engineering Specialization)");

    }


    public static void main(String[] args) throws Exception {
        new gui();
        getConnection();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int r = 0; r < jLabelArr1.length; r++) {
            if (e.getSource() == jLabelArr1[r]) {
                panel2.setVisible(false);
                frame.remove(panel2);
                try {
                    makePanel3(jLabelArr1[r]);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (e.getSource() == jLabelArr[i]) {
                major = jLabelArr[i].getText();
                try {
                    if (get(major) != null) {
                        panel1.setVisible(false);
                        frame.remove(panel1);
                        makePanel2(major);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if(e.getSource() == generalDegree){
            major = generalDegree.getText();
            try {
                if (get(major) != null) {
                    panel1.setVisible(false);
                    frame.remove(panel1);
                    makePanel2(major);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        if(e.getSource() == honoursDegree){
            major = honoursDegree.getText();
            System.out.println(major);

            try {
                if (get(major) != null) {
                    panel1.setVisible(false);
                    frame.remove(panel1);
                    makePanel2(major);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

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