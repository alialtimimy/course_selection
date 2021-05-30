package com.company;

import com.sun.media.sound.SoftTuning;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.layout.Background;
import keeptoo.KButton;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
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
    private static JLabel label, info, courseInfoTitle, specialization1, enter, errorMessage, css, css1, css2, specializations, generalDegree, honoursDegree, picLabel, picLabel1, picLabel2, picLabel3, picLabel4, picLabel5, electiveLabel;
    private static ArrayList<JLabel> array;
    private JLabel[] jLabelArr = new JLabel[3];
    private JLabel[] jLabelArr1 = new JLabel[100];
    private static JPanel panel1, panel2, panel3, panel4, panel5, schedulePanel;
    private static String major = "";
    private static ArrayList<String> degrees = new ArrayList<String>();
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static int easyElectiveIndex, requiredElectiveIndex;
    private BufferedImage myPicture, myPicture1, myPicture2, myPicture3, myPicture4, myPicture5;
    private ArrayList<String> courses;
    private static ArrayList<JLabel> courseLabels;
    private static ArrayList<String> degreeNames = new ArrayList<String>();
    private static ArrayList<String> specializationArray, easyElectives, requiredElectives;
    private static JTable table1, table2, table3, table4;
    private static Object[][] data;
    private static String[] columnNames;
    private HashMap<String, String> infoOnCourses;
    private KButton electiveButton, button3, scheduleButton, button4, returnButtonSchedule, button2, button1, button;


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
            jLabelArr[r].setBounds(205, y, 1000, 40);
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
        if (major.equals("computer_science_honours")) {
            courseTitle = new JLabel(degreeNames.get(1));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        } else if (major.equals("computer_science_general")) {
            courseTitle = new JLabel(degreeNames.get(0));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        } else if (major.equals("computer_science_applied_computing")) {
            courseTitle = new JLabel(degreeNames.get(2));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        } else if (major.equals("computer_science_information_systems")) {
            courseTitle = new JLabel(degreeNames.get(3));
            courseTitle.setForeground(new Color(255, 199, 0));
            courseTitle.setFont(new Font("Arial", Font.BOLD, 25));
            courseTitle.setBounds(85, 25, courseTitle.getMaximumSize().width, courseTitle.getMaximumSize().height);
            panel2.add(courseTitle);
        } else if (major.equals("computer_science_software_engineering")) {
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

        button = new KButton();
        button.setBounds(10, 10, 50, 30);
        button.setFont(new Font("Arial Black", Font.PLAIN, 15));
        button.setText("<-");
        button.addActionListener(this);
        button.setFocusable(true);
        button.setkBackGroundColor(new Color(255, 203, 0));
        button.setkBorderRadius(0);
        button.setkBackGroundColor(new Color(255, 203, 0));
        button.setkStartColor(new Color(255, 203, 0));
        button.setkEndColor(new Color(255, 203, 0));
        button.setkForeGround(Color.BLACK);
        button.setkHoverForeGround(new Color(255, 203, 0));
        button.setkHoverEndColor(new Color(255, 203, 0));
        button.setkHoverColor(new Color(255, 203, 0));
        button.setkHoverStartColor(new Color(255, 203, 0));
        button.setBorder(BorderFactory.createEtchedBorder());

        panel2.add(button);
        picLabel.setBounds(750, 550, 200, 200);
        panel2.add(picLabel);
        if (!major.equals("Bachelor of Science (Honours Computer Science with Software Engineering Specialization)")) {
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
        scheduleButton = new KButton();
        scheduleButton.setBounds(680, 500, 200, 50); // set the button bounds
        scheduleButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        scheduleButton.setText("Create Schedule");
        scheduleButton.addActionListener(this);
        scheduleButton.setFocusable(true);
        scheduleButton.setkBackGroundColor(new Color(255, 203, 0));
        scheduleButton.setkBorderRadius(0);
        scheduleButton.setkBackGroundColor(new Color(255, 203, 0));
        scheduleButton.setkStartColor(new Color(255, 203, 0));
        scheduleButton.setkEndColor(new Color(255, 203, 0));
        scheduleButton.setkForeGround(Color.BLACK);
        scheduleButton.setkHoverForeGround(new Color(255, 203, 0));
        scheduleButton.setkHoverEndColor(new Color(255, 203, 0));
        scheduleButton.setkHoverColor(new Color(255, 203, 0));
        scheduleButton.setkHoverStartColor(new Color(255, 203, 0));
        scheduleButton.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(scheduleButton);
        frame.add(panel2);
    }

    public void makePanel3(JLabel label4) throws Exception {
        JLabel extraInfo;
        JLabel extraTitle1;
        JLabel extraTitle2;
        Boolean flag = false;
        panel3 = new JPanel();
        String temp = "";
        if (major.equals("Bachelor of Science (Honours Computer Information Systems)")) {
            infoOnCourses = getInfoOnCourseInformationSystems(major);
        } else {
            infoOnCourses = getInfoOnCourse(major);
        }

        panel3.setBounds(0, 0, WIDTH, HEIGHT);
        panel3.setBackground(new Color(17, 44, 80));
        panel3.setLayout(null);
        panel3.setVisible(true);


        button1 = new KButton();
        button1.setBounds(10, 10, 50, 30);
        button1.setFont(new Font("Arial Black", Font.PLAIN, 15));
        button1.setText("<-");
        button1.addActionListener(this);
        button1.setFocusable(true);
        button1.setkBackGroundColor(new Color(255, 203, 0));
        button1.setkBorderRadius(0);
        button1.setkBackGroundColor(new Color(255, 203, 0));
        button1.setkStartColor(new Color(255, 203, 0));
        button1.setkEndColor(new Color(255, 203, 0));
        button1.setkForeGround(Color.BLACK);
        button1.setkHoverForeGround(new Color(255, 203, 0));
        button1.setkHoverEndColor(new Color(255, 203, 0));
        button1.setkHoverColor(new Color(255, 203, 0));
        button1.setkHoverStartColor(new Color(255, 203, 0));
        button1.setBorder(BorderFactory.createEtchedBorder());

        panel3.add(button1);
        courseInfoTitle = new JLabel(label4.getText());
        courseInfoTitle.setForeground(new Color(255, 203, 0));
        courseInfoTitle.setFont(new Font("Lucida Blackletter", Font.PLAIN, 22));
        courseInfoTitle.setBounds(110, 65, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
        if (label4.getText().substring(0, 9).equals("MATH-1720")) {
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

        } else if (label4.getText().substring(0, 9).equals("MATH-1250")) {
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
        if (major.equals("Bachelor of Computer Science (Honours)")) {
            if (label4.getText().substring(0, 9).equals("STAT-2910")) {
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
            if (label4.getText().substring(0, 9).equals("MATH-3940")) {
                courseInfoTitle.setBounds(55, 65, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
                extraTitle1 = new JLabel("MATH-3940");
                extraTitle1.setForeground(new Color(255, 203, 0));
                extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle1.setBounds(110, 130, 200, 100);
                extraInfo = new JLabel("<html>" + infoOnCourses.get("MATH-3800") + "</html>");
                extraInfo.setForeground(new Color(255, 203, 0));
                extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
                extraInfo.setBounds(110, 240, 700, 600);
                extraTitle2 = new JLabel("MATH-3800");
                extraTitle2.setForeground(new Color(255, 203, 0));
                extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle2.setBounds(110, 405, 200, 100);
                panel3.add(extraInfo);
                panel3.add(extraTitle1);
                panel3.add(extraTitle2);

            }
        }
        if (major.equals("Bachelor of Computer Science (Honours)") || major.equals("Bachelor of Science (Honours Computer Science with Software Engineering Specialization)")) {
            if (label4.getText().substring(0, 9).equals("COMP-4990")) {
                courseInfoTitle.setBounds(50, 50, courseInfoTitle.getMaximumSize().width, courseInfoTitle.getMaximumSize().height);
                extraTitle1 = new JLabel("COMP-4990");
                extraTitle1.setForeground(new Color(255, 203, 0));
                extraTitle1.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle1.setBounds(50, 100, 200, 100);
                extraInfo = new JLabel("<html>" + infoOnCourses.get("COMP-4960") + "</html>");
                extraInfo.setForeground(new Color(255, 203, 0));
                extraInfo.setFont(new Font("Arial", Font.PLAIN, 18));
                extraInfo.setBounds(50, 280, 700, 600);
                extraTitle2 = new JLabel("COMP-4960");
                extraTitle2.setForeground(new Color(255, 203, 0));
                extraTitle2.setFont(new Font("Arial", Font.PLAIN, 18));
                extraTitle2.setBounds(50, 405, 200, 100);
                panel3.add(extraInfo);
                panel3.add(extraTitle1);
                panel3.add(extraTitle2);
                flag = true;
            }
        }
        info = new JLabel("<html>" + infoOnCourses.get(label4.getText().substring(0, 9)) + "</html>");
        info.setForeground(new Color(255, 203, 0));
        info.setFont(new Font("Arial", Font.PLAIN, 18));
        if (flag) {
            info.setBounds(50, 60, 600, 400);
        } else {
            info.setBounds(110, 60, 600, 400);
        }
        panel3.add(info);
        panel3.add(courseInfoTitle);
        picLabel.setBounds(750, 550, 200, 200);
        panel3.add(picLabel);
        frame.add(panel3);
    }

    public void makePanel4() throws Exception {
        JLabel electiveLabelTitle = new JLabel("Electives");
        electiveLabelTitle.setForeground(new Color(255, 203, 0));
        electiveLabelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        electiveLabelTitle.setBounds(10, 65, electiveLabelTitle.getMaximumSize().width, electiveLabelTitle.getMaximumSize().height);
        int y = 100;
        ArrayList<String> electives = getElectives(major);
        panel4 = new JPanel();
        panel4.setBounds(0, 0, WIDTH, HEIGHT);
        panel4.setBackground(new Color(17, 44, 80));
        panel4.setLayout(null);
        panel4.setVisible(true);


        button2 = new KButton();
        button2.setBounds(10, 10, 50, 30);
        button2.setFont(new Font("Arial Black", Font.PLAIN, 15));
        button2.setText("<-");
        button2.addActionListener(this);
        button2.setFocusable(true);
        button2.setkBackGroundColor(new Color(255, 203, 0));
        button2.setkBorderRadius(0);
        button2.setkBackGroundColor(new Color(255, 203, 0));
        button2.setkStartColor(new Color(255, 203, 0));
        button2.setkEndColor(new Color(255, 203, 0));
        button2.setkForeGround(Color.BLACK);
        button2.setkHoverForeGround(new Color(255, 203, 0));
        button2.setkHoverEndColor(new Color(255, 203, 0));
        button2.setkHoverColor(new Color(255, 203, 0));
        button2.setkHoverStartColor(new Color(255, 203, 0));
        button2.setBorder(BorderFactory.createEtchedBorder());
        panel4.add(button2);

        for (int i = 0; i < electives.size(); i += 2) {
            electiveLabel = new JLabel("<html>" + electives.get(i)+ " " + electives.get(i + 1) + "</html>");
            electiveLabel.setForeground(new Color(255, 203, 0));
            electiveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            electiveLabel.setBounds(10, y,1000,100);
            y = y + 25;
            panel4.add(electiveLabel);
        }
        panel4.add(electiveLabelTitle);
        frame.add(panel4);

    }


    //creates specialization panel
    public void makePanel5() throws Exception {
        panel5 = new JPanel();
        panel5.setBounds(0, 0, WIDTH, HEIGHT);
        panel5.setBackground(new Color(17, 44, 80));
        panel5.setLayout(null);
        panel5.setVisible(true);

        specializationArray = getSpecialization(major);
        button4 = new KButton();
        button4.setBounds(10, 10, 50, 30);
        button4.setFont(new Font("Arial Black", Font.PLAIN, 15));
        button4.setText("<-");
        button4.addActionListener(this);
        button4.setFocusable(true);
        button4.setkBackGroundColor(new Color(255, 203, 0));
        button4.setkBorderRadius(0);
        button4.setkBackGroundColor(new Color(255, 203, 0));
        button4.setkStartColor(new Color(255, 203, 0));
        button4.setkEndColor(new Color(255, 203, 0));
        button4.setkForeGround(Color.BLACK);
        button4.setkHoverForeGround(new Color(255, 203, 0));
        button4.setkHoverEndColor(new Color(255, 203, 0));
        button4.setkHoverColor(new Color(255, 203, 0));
        button4.setkHoverStartColor(new Color(255, 203, 0));
        button4.setBorder(BorderFactory.createEtchedBorder());
        panel5.add(button4);


        specialization1 = new JLabel("<html>Students may specialize in one of the following areas. A special annotation will be made on the transcript for a specialization in one of the following areas, if the specified courses are completed:</html>");
        specialization1.setBounds(5, 20, 1000, 100);
        specialization1.setForeground(new Color(255, 203, 0));
        specialization1.setFont(new Font("Arial", Font.BOLD, 18));
        panel5.add(specialization1);


        int y = 40;

        for (int i = 0; i < specializationArray.size(); i++) {
            y = y + 35;
            specializations = new JLabel("<html>" + specializationArray.get(i)+"</html>");
            specializations.setForeground(new Color(255, 203, 0));
            specializations.setFont(new Font("Arial", Font.PLAIN, 15));
            specializations.setBounds(5, y, 1000, 100);
            panel5.add(specializations);
        }
        frame.add(panel5);
    }

    public void makeSchedulePanel() throws Exception {

        schedulePanel = new JPanel();
        schedulePanel.setBounds(0, 0, WIDTH, HEIGHT);
        schedulePanel.setBackground(new Color(17, 44, 80));
        schedulePanel.setLayout(null);
        schedulePanel.setVisible(true);

        returnButtonSchedule = new KButton();
        returnButtonSchedule.setBounds(10, 10, 50, 30);
        returnButtonSchedule.setFont(new Font("Arial Black", Font.PLAIN, 15));
        returnButtonSchedule.setText("<-");
        returnButtonSchedule.addActionListener(this);
        returnButtonSchedule.setFocusable(true);
        returnButtonSchedule.setkBackGroundColor(new Color(255, 203, 0));
        returnButtonSchedule.setkBorderRadius(0);
        returnButtonSchedule.setkBackGroundColor(new Color(255, 203, 0));
        returnButtonSchedule.setkStartColor(new Color(255, 203, 0));
        returnButtonSchedule.setkEndColor(new Color(255, 203, 0));
        returnButtonSchedule.setkForeGround(Color.BLACK);
        returnButtonSchedule.setkHoverForeGround(new Color(255, 203, 0));
        returnButtonSchedule.setkHoverEndColor(new Color(255, 203, 0));
        returnButtonSchedule.setkHoverColor(new Color(255, 203, 0));
        returnButtonSchedule.setkHoverStartColor(new Color(255, 203, 0));
        returnButtonSchedule.setBorder(BorderFactory.createEtchedBorder());
        schedulePanel.add(returnButtonSchedule);


        //computer science honours schedule
        if(major.equals("Bachelor of Computer Science (Honours)")) {
            columnNames = new String[]{"First Year", "hi", "hello", "monkee", "monkee1", "monkee2"};
             data = new Object[][]{
                     {"Semester 1", "COMP-1000", "COMP-1400", "MATH-1720", "MATH-1250", "elective"},
                     {"Semester 2", "COMP-1410", "MATH-1730", "MATH-1020", "electives.get(1)", "elective"},
                     {"Semester 3", "COMP-2560", "STAT-2910", "COMP-2120", "COMP-2310", "electives.get(0)"},
                     {"Semester 4", "COMP-2540", "COMP-2660", "COMP-2140", "elective4", "elective5"},
                     {"Semester 5", "COMP-3110", "COMP-3220", "COMP-3540", "COMP-3670", "elective6"},
                     {"Semester 6", "COMP-3150", "COMP-3300", "MATH-3940", "elective7", "elective8"},
                     {"Semester 7", "COMP-4400", "COMP-4540", "elective9", "elective10", "elective11"},
                     {"Semester 8", "COMP-4990", "elective12", "elective13", "elective14", "elective15"},
             };
        }
        else if(major.equals("Bachelor of Science (Honours Computer Science with Software Engineering Specialization)")){
            columnNames = new String[]{"First Year", "hi", "hello", "monkee", "monkee1", "monkee2"};
            data = new Object[][]{
                    {"Semester 1", "COMP-1000", "COMP-1400", "MATH-1720", "MATH-1250", "elective"},
                    {"Semester 2", "COMP-1410", "MATH-1730", "MATH-1020", "electives.get(1)", "electives.get(2)"},
                    {"Semester 3", "COMP-2560", "STAT-2910", "COMP-2120", "COMP-2310", "electives.get(0)"},
                    {"Semester 4", "COMP-2540", "COMP-2660", "COMP-2140", "elective4", "elective5"},
                    {"Semester 5", "COMP-3110", "COMP-3220", "COMP-3540", "COMP-3670", "elective6"},
                    {"Semester 6", "COMP-3150", "COMP-3300", "MATH-3940", "elective7", "elective8"},
                    {"Semester 7", "COMP-4400", "COMP-4540", "elective9", "elective10", "elective11"},
                    {"Semester 8", "COMP-4990", "elective12", "elective13", "elective14", "elective15"},
            };

        }
        else if(major.equals("Bachelor of Computer Science (General)")){
            columnNames = new String[]{"First Year", "hi", "hello", "monkee", "monkee1", "monkee2"};
            data = new Object[][]{
                    {"Semester 1", "COMP-1000", "COMP-1400", "MATH-1720", "MATH-1250", "elective"},
                    {"Semester 2", "COMP-1410", "MATH-1730", "MATH-1020", "electives.get(1)", "electives.get(2)"},
                    {"Semester 3", "COMP-2560", "STAT-2910", "COMP-2120", "COMP-2310", "electives.get(0)"},
                    {"Semester 4", "COMP-2540", "COMP-2660", "COMP-2140", "elective4", "elective5"},
                    {"Semester 5", "COMP-3110", "COMP-3220", "COMP-3540", "COMP-3670", "elective6"},
                    {"Semester 6", "COMP-3150", "COMP-3300", "MATH-3940", "elective7", "elective8"},
                    {"Semester 7", "COMP-4400", "COMP-4540", "elective9", "elective10", "elective11"},
                    {"Semester 8", "COMP-4990", "elective12", "elective13", "elective14", "elective15"},
            };
        }
        else if(major.equals("Bachelor of Computer Science (Honours Applied Computing)")){
            columnNames = new String[]{"First Year", "hi", "hello", "monkee", "monkee1", "monkee2"};
            data = new Object[][]{
                    {"Semester 1", "COMP-1000", "COMP-1400", "MATH-1720", "MATH-1250", "elective"},
                    {"Semester 2", "COMP-1410", "MATH-1730", "MATH-1020", "electives.get(1)", "electives.get(2)"},
                    {"Semester 3", "COMP-2560", "STAT-2910", "COMP-2120", "COMP-2310", "electives.get(0)"},
                    {"Semester 4", "COMP-2540", "COMP-2660", "COMP-2140", "elective4", "elective5"},
                    {"Semester 5", "COMP-3110", "COMP-3220", "COMP-3540", "COMP-3670", "elective6"},
                    {"Semester 6", "COMP-3150", "COMP-3300", "MATH-3940", "elective7", "elective8"},
                    {"Semester 7", "COMP-4400", "COMP-4540", "elective9", "elective10", "elective11"},
                    {"Semester 8", "COMP-4990", "elective12", "elective13", "elective14", "elective15"},
            };
        }
        else if(major.equals("Bachelor of Science (Honours Computer Information Systems)")){
            columnNames = new String[]{"First Year", "hi", "hello", "monkee", "monkee1", "monkee2"};
            data = new Object[][]{
                    {"Semester 1", "COMP-1000", "COMP-1400", "MATH-1720", "MATH-1250", "elective"},
                    {"Semester 2", "COMP-1410", "MATH-1730", "MATH-1020", "electives.get(1)", "electives.get(2)"},
                    {"Semester 3", "COMP-2560", "STAT-2910", "COMP-2120", "COMP-2310", "electives.get(0)"},
                    {"Semester 4", "COMP-2540", "COMP-2660", "COMP-2140", "elective4", "elective5"},
                    {"Semester 5", "COMP-3110", "COMP-3220", "COMP-3540", "COMP-3670", "elective6"},
                    {"Semester 6", "COMP-3150", "COMP-3300", "MATH-3940", "elective7", "elective8"},
                    {"Semester 7", "COMP-4400", "COMP-4540", "elective9", "elective10", "elective11"},
                    {"Semester 8", "COMP-4990", "elective12", "elective13", "elective14", "elective15"},
            };
        }

        JLabel scheduleTitle = new JLabel("Schedule:");
        scheduleTitle.setBounds(400, 40, 350,50);
        scheduleTitle.setFont(new Font("Arial", Font.BOLD, 21));
        scheduleTitle.setForeground(new Color(255, 203, 0));
        schedulePanel.add(scheduleTitle);

        table1 = new JTable(data, columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(800, 50));
        table1.setFillsViewportHeight(true);
        table1.setFont(new Font("Arial", Font.BOLD, 18));
        table1.setBounds(50, 90, 850, 128);
        table1.setBackground(new Color(17, 44, 80));

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);


        table1.setBorder(BorderFactory.createMatteBorder(1,1,1,1, new Color(255, 203, 0)));
        table1.setForeground(new Color(255, 203, 0));
        schedulePanel.add(table1);


        frame.add(schedulePanel);
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
        if (e.getSource() == button2) {
            panel4.setVisible(false);
            frame.remove(panel4);
            try {
                makePanel2(major);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource() == electiveButton) {
            panel2.setVisible(false);
            frame.remove(panel2);
            try {
                makePanel4();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource() == button3) {
            panel2.setVisible(false);
            frame.remove(panel2);
            try {
                makePanel5();
            } catch (Exception exception1) {
                exception1.printStackTrace();
            }
        }
        if (e.getSource() == button4) {
            panel5.setVisible(false);
            frame.remove(panel5);
            try {
                makePanel2(major);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource() == scheduleButton) {
            panel2.setVisible(false);
            frame.remove(panel2);
            try {
                makeSchedulePanel();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource() == returnButtonSchedule) {
            schedulePanel.setVisible(false);
            frame.remove(schedulePanel);
            try {
                makePanel2(major);
            } catch (Exception exception) {
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
        if (e.getSource() == generalDegree) {
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
        if (e.getSource() == honoursDegree) {
            major = honoursDegree.getText();

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