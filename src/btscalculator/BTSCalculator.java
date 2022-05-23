
package btscalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BTSCalculator extends JFrame {
    
    // Component Declarations.
    
    JPanel TitleBar, InputOutputPanel, ButtonsPanel;
    
    JLabel CompanyLogo, CompanyName, ProgramName;
    
    JButton AddButton, SubButton, MultiButton, DivButton, ModulusButton, DelButton, EqualButton, ClearButton, MinimizeButton, ExitButton,
            ZeroButton, OneButton, TwoButton, ThreeButton, FourButton, FiveButton, SixButton, SevenButton, EightButton,
            NineButton;
    
    JTextField FirstNumberInput, AnswerOutput, OperatorInput;
    
    double num, ans;
    int calculation;
    
    // FRAME DRAGGER.
    int xMouse;
    int yMouse;
    
    // CUSTOM FONT DECLARATION.
    Font IronShark, Quicksand;
    
    private String displayFirstNum = "";
    private String displayAnswer = "";
    private String displayOperator = "";
    
    public BTSCalculator() {
        
        GUIComponents();
        
    }
    
    private void GUIComponents(){
        
        TitleBar = new JPanel();
        InputOutputPanel = new JPanel();
        ButtonsPanel = new JPanel();
        
        CompanyLogo = new JLabel();
        CompanyName = new JLabel();
        ProgramName = new JLabel();
        
        MinimizeButton = new JButton();
        ExitButton = new JButton();
        
        AddButton = new JButton();
        SubButton = new JButton();
        MultiButton = new JButton();
        DivButton = new JButton();
        ModulusButton = new JButton();
        DelButton = new JButton();
        EqualButton = new JButton();
        ClearButton = new JButton();
        
        ZeroButton = new JButton();
        OneButton = new JButton();
        TwoButton = new JButton();
        ThreeButton = new JButton();
        FourButton = new JButton();
        FiveButton = new JButton();
        SixButton = new JButton();
        SevenButton = new JButton();
        EightButton = new JButton();
        NineButton = new JButton();
        
        FirstNumberInput = new JTextField();
        OperatorInput = new JTextField();
        AnswerOutput = new JTextField();
        
        // JFrame Declaration
        final int FrameSizeX = 500;
        final int FrameSizeY = 500;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("BTS : Calculator");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        
        // CUSTOM FONTS 
        try {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                
                // FOR COMPANY NAME
                IronShark = Font.createFont(Font.TRUETYPE_FONT, new File("src\\BTSCalcu Files\\fonts\\Iron-Shark.ttf")).deriveFont(18f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\BTSCalcu Files\\fonts\\Iron-Shark.ttf")));
                
                // FOR THE ENTIRE SYSTEM
                Quicksand = Font.createFont(Font.TRUETYPE_FONT, new File("src\\BTSCalcu Files\\fonts\\Quicksand-Regular.ttf")).deriveFont(18f);
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\BTSCalcu Files\\fonts\\Quicksand-Regular.ttf")));
                
                
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Title Bar (JPanel) Decorations.
        final int titlePanelHeight = 128;
        final int titlePanelWidth = 500;
        final int titlePanelLocationX = 0;
        final int titlePanelLocationY = 0;

        TitleBar.setBounds(titlePanelLocationX, titlePanelLocationY, titlePanelWidth, titlePanelHeight);
        add(TitleBar);
        TitleBar.setBackground(new Color(0, 29, 61));
        TitleBar.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        TitleBar.setLayout(null);
        TitleBar.setVisible(true);

        // Title Bar Frame dragging Declaration.
        TitleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                // JFRAME DRAGGER
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();

                setLocation(x - xMouse, y - yMouse);
            }
        });

        TitleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // JFRAME DRAGGER PART 2
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });

        // Title Bar Logo (JLabel) Decorations.
        final int logoHeight = 120;
        final int logoWidth = 120;
        final int logoLocationX = 15;
        final int logoLocationY = 5;

        CompanyLogo.setBounds(logoLocationX, logoLocationY, logoWidth, logoHeight);
        TitleBar.add(CompanyLogo);
        CompanyLogo.setForeground(new Color(0, 0, 0));
        CompanyLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyLogo.setLayout(null);

        ImageIcon logoGetter = new ImageIcon("src\\BTSCalcu Files\\logo\\BTSLogo.png");
        Image getLogo = logoGetter.getImage();
        Image scaleLogo = getLogo.getScaledInstance(CompanyLogo.getWidth(), CompanyLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon displayLogo = new ImageIcon(scaleLogo);
        CompanyLogo.setIcon(displayLogo);

        // Title Bar Text (JLabel) Declarations.        
        final int companyNameHeight = 14;
        final int companyNameWidth = 300;
        final int companyNameLocationX = 150;
        final int companyNameLocationY = 56;
        final int cNameShadowLocationY = 60;
        
        JLabel cNameShadow = new JLabel();

        CompanyName.setBounds(companyNameLocationX, companyNameLocationY, companyNameWidth, companyNameHeight);
        TitleBar.add(CompanyName);
        CompanyName.setForeground(new Color(255, 208, 0));
        CompanyName.setFont(new Font("Iron Shark", Font.PLAIN, 14));

        cNameShadow.setBounds(companyNameLocationX, cNameShadowLocationY, companyNameWidth, companyNameHeight);
        TitleBar.add(cNameShadow);
        cNameShadow.setForeground(new Color(0, 0, 0));
        cNameShadow.setFont(new Font("Iron Shark", Font.PLAIN, 14));

        CompanyName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        CompanyName.setText("Brion Tactical Systems");
        CompanyName.setVisible(true);

        cNameShadow.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cNameShadow.setText("Brion Tactical Systems");
        cNameShadow.setVisible(true);

        // Program Name (JLabel) Declarations.
        final int programNameHeight = 12;
        final int programNameWidth = 600;
        final int programNameLocationX = 150;
        final int programNameLocationY = 75;

        ProgramName.setBounds(programNameLocationX, programNameLocationY, programNameWidth, programNameHeight);
        TitleBar.add(ProgramName);
        ProgramName.setForeground(new Color(255, 255, 255));
        ProgramName.setFont(new Font("QuickSand", Font.BOLD, 12));
        ProgramName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        ProgramName.setText("COMPROG 3 FINALS : EVENT-DRIVEN CALCULATOR");
        ProgramName.setVisible(true);
        
        // Exit Button.
        final int exitButtonLocationX = 466;
        final int exitButtonLocationY = 10;
        final int exitButtonWidth = 24;
        final int exitButtonHeight = 24;

        TitleBar.add(ExitButton);
        ExitButton.setBounds(exitButtonLocationX, exitButtonLocationY, exitButtonWidth, exitButtonHeight);
        ExitButton.setForeground(new Color(0, 0, 0));
        ExitButton.setBackground(new Color(248, 249, 250));
        ExitButton.setBorder(null);
        ExitButton.setFocusPainted(false);
        ExitButton.setHorizontalAlignment(SwingConstants.CENTER);
        ExitButton.setOpaque(false);
        ExitButton.setVisible(true);
        ExitButton.setContentAreaFilled(false);
        ExitButton.setBorderPainted(false);
        ExitButton.setIconTextGap(0);

        ImageIcon exitIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\DehoveredExit.png");
        Image importExitIcon = exitIcon.getImage();
        ImageIcon scaledExitIcon = new ImageIcon(importExitIcon);
        ExitButton.setIcon(scaledExitIcon);

        ImageIcon exitSelectedIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\HoveredExit.png");
        Image importExitSelectedIcon = exitSelectedIcon.getImage();
        ImageIcon GetExitSelectedIcon = new ImageIcon(importExitSelectedIcon);
        ExitButton.setSelectedIcon(GetExitSelectedIcon);

        ImageIcon exitRolloverIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\ClickedExit.png");
        Image importExitRolloverIcon = exitRolloverIcon.getImage();
        ImageIcon scaledExitRolloverIcon = new ImageIcon(importExitRolloverIcon);
        ExitButton.setRolloverIcon(scaledExitRolloverIcon);

        // Exit Function 
        ExitButton.addActionListener((ActionEvent evt) -> {

            ExitButtonFunction(evt);

        });

        // Minimize Button.
        final int minimizeButtonLocationX = 438;
        final int minimizeButtonLocationY = 10;
        final int minimizeButtonWidth = 24;
        final int minimizeButtonHeight = 24;

        TitleBar.add(MinimizeButton);
        MinimizeButton.setBounds(minimizeButtonLocationX, minimizeButtonLocationY, minimizeButtonWidth, minimizeButtonHeight);
        MinimizeButton.setForeground(new Color(0, 0, 0));
        MinimizeButton.setBackground(new Color(248, 249, 250));
        MinimizeButton.setBorder(null);
        MinimizeButton.setFocusPainted(false);
        MinimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
        MinimizeButton.setOpaque(false);
        MinimizeButton.setVisible(true);
        MinimizeButton.setContentAreaFilled(false);
        MinimizeButton.setBorderPainted(false);
        MinimizeButton.setIconTextGap(0);

        ImageIcon minimizeIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\DehoveredMinimize.png");
        Image importMinimizeIcon = minimizeIcon.getImage();
        ImageIcon GetMinimizeIcon = new ImageIcon(importMinimizeIcon);
        MinimizeButton.setIcon(GetMinimizeIcon);

        ImageIcon minimizeSelectedIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\HoveredMinimize.png");
        Image importMinimizeSelectedIcon = minimizeSelectedIcon.getImage();
        ImageIcon GetMinimizeSelectedIcon = new ImageIcon(importMinimizeSelectedIcon);
        MinimizeButton.setSelectedIcon(GetMinimizeSelectedIcon);

        ImageIcon minimizeRolloverIcon = new ImageIcon("src\\BTSCalcu Files\\icons\\Clicked Minimize.png");
        Image importMinimizeRolloverIcon = minimizeRolloverIcon.getImage();
        ImageIcon GetMinimizeRolloverIcon = new ImageIcon(importMinimizeRolloverIcon);
        MinimizeButton.setRolloverIcon(GetMinimizeRolloverIcon);

        // Minimize Function 
        MinimizeButton.addActionListener((ActionEvent evt) -> {

            MinimizeButtonFunction(evt);

        });
        
        // Input Output Panel (JPanel) Decorations.
        final int InputOutputPanelHeight = 128;
        final int InputOutputPanelWidth = 500;
        final int InputOutputPanelLocationX = 0;
        final int InputOutputPanelLocationY = 126;

        InputOutputPanel.setBounds(InputOutputPanelLocationX, InputOutputPanelLocationY, InputOutputPanelWidth, InputOutputPanelHeight);
        add(InputOutputPanel);
        InputOutputPanel.setBackground(new Color(248, 249, 250));
        InputOutputPanel.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        InputOutputPanel.setLayout(null);
        InputOutputPanel.setVisible(true);
        
            
            // Number Input Field (JTextField) Decorations.
            
                final int userInputLocationX = 4;
                final int userInputLocationY = 5;
                final int userInputWidth = 492;
                final int userInputHeight = 50;

                InputOutputPanel.add(FirstNumberInput);
                FirstNumberInput.setBounds(userInputLocationX, userInputLocationY, userInputWidth, userInputHeight);
                FirstNumberInput.setBackground(new Color(0, 0, 0, 0));
                FirstNumberInput.setForeground(new Color(0, 0, 0));
                FirstNumberInput.setOpaque(false);
                FirstNumberInput.setCaretColor(new Color(0, 0, 0));
                FirstNumberInput.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(0, 0, 0)));
                FirstNumberInput.setFont(new Font("Quicksand", Font.PLAIN, 50));
                FirstNumberInput.setHorizontalAlignment(SwingConstants.TRAILING);
                FirstNumberInput.setVisible(true);
                

            // Operator Input Field (JTextField) Decorations.
                
                final int operatorInputLocationX = 4;
                final int operatorInputLocationY = 70;
                final int operatorInputWidth = 50;
                final int operatorInputHeight = 50;

                InputOutputPanel.add(OperatorInput);
                OperatorInput.setBounds(operatorInputLocationX, operatorInputLocationY, operatorInputWidth, operatorInputHeight);
                OperatorInput.setBackground(new Color(0, 0, 0, 0));
                OperatorInput.setForeground(new Color(0, 0, 0));
                OperatorInput.setOpaque(false);
                OperatorInput.setCaretColor(new Color(0, 0, 0));
                OperatorInput.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(0, 0, 0)));
                OperatorInput.setFont(new Font("Quicksand", Font.PLAIN, 50));
                OperatorInput.setHorizontalAlignment(SwingConstants.TRAILING);
                OperatorInput.setVisible(true);
            
            // Answer Output Field (JTextField) Decorations.
            
                final int userOutputLocationX = 54;
                final int userOutputLocationY = 70;
                final int userOutputWidth = 442;
                final int userOutputHeight = 50;

                InputOutputPanel.add(AnswerOutput);
                AnswerOutput.setBounds(userOutputLocationX, userOutputLocationY, userOutputWidth, userOutputHeight);
                AnswerOutput.setBackground(new Color(0, 0, 0, 0));
                AnswerOutput.setForeground(new Color(0, 0, 0));
                AnswerOutput.setOpaque(false);
                AnswerOutput.setCaretColor(new Color(0, 0, 0));
                AnswerOutput.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(0, 0, 0)));
                AnswerOutput.setFont(new Font("Quicksand", Font.BOLD, 50));
                AnswerOutput.setHorizontalAlignment(SwingConstants.TRAILING);
                AnswerOutput.setVisible(true);

        // Button Panel (JPanel) Decorations.
        final int ButtonsPanelHeight = 248;
        final int ButtonsPanelWidth = 500;
        final int ButtonsPanelLocationX = 0;
        final int ButtonsPanelLocationY = 252;

        ButtonsPanel.setBounds(ButtonsPanelLocationX, ButtonsPanelLocationY, ButtonsPanelWidth, ButtonsPanelHeight);
        add(ButtonsPanel);
        ButtonsPanel.setBackground(new Color(0, 29, 61));
        ButtonsPanel.setBorder(new javax.swing.border.LineBorder(new Color(255, 200, 0), 2, false));
        ButtonsPanel.setLayout(new GridLayout(3,6,0,0));
        ButtonsPanel.setVisible(true);
            
            // Button 1 (JButtons) Declarations.
            ButtonsPanel.add(OneButton);
            OneButton.setBackground(new java.awt.Color(248, 249, 250));
            OneButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            OneButton.setFocusPainted(false);
            OneButton.setHorizontalAlignment(SwingConstants.CENTER);
            OneButton.setOpaque(false);
            OneButton.setForeground(new java.awt.Color(0,0,0));
            OneButton.setText("1");
            OneButton.setVisible(true);

            OneButton.setContentAreaFilled(true);
            OneButton.setBorderPainted(false);
            OneButton.setIconTextGap(-2);

            OneButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                OneButton.setBackground(new java.awt.Color(0, 0, 0));
                OneButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                OneButton.setBackground(new java.awt.Color(248, 249, 250));
                OneButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                OneButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                OneButton.setBackground(new java.awt.Color(248, 249, 250));
                OneButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 2 (JButtons) Declarations.
            ButtonsPanel.add(TwoButton);
            TwoButton.setBackground(new java.awt.Color(248, 249, 250));
            TwoButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            TwoButton.setFocusPainted(false);
            TwoButton.setHorizontalAlignment(SwingConstants.CENTER);
            TwoButton.setOpaque(false);
            TwoButton.setForeground(new java.awt.Color(0,0,0));
            TwoButton.setText("2");
            TwoButton.setVisible(true);

            TwoButton.setContentAreaFilled(true);
            TwoButton.setBorderPainted(false);
            TwoButton.setIconTextGap(-2);

            TwoButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                TwoButton.setBackground(new java.awt.Color(0, 0, 0));
                TwoButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                TwoButton.setBackground(new java.awt.Color(248, 249, 250));
                TwoButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                TwoButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                TwoButton.setBackground(new java.awt.Color(248, 249, 250));
                TwoButton.setForeground(new java.awt.Color(0,0,0));
            }

            });

            // Button 3 (JButtons) Declarations.
            ButtonsPanel.add(ThreeButton);
            ThreeButton.setBackground(new java.awt.Color(248, 249, 250));
            ThreeButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            ThreeButton.setFocusPainted(false);
            ThreeButton.setHorizontalAlignment(SwingConstants.CENTER);
            ThreeButton.setOpaque(false);
            ThreeButton.setForeground(new java.awt.Color(0,0,0));
            ThreeButton.setText("3");
            ThreeButton.setVisible(true);

            ThreeButton.setContentAreaFilled(true);
            ThreeButton.setBorderPainted(false);
            ThreeButton.setIconTextGap(-2);

            ThreeButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                ThreeButton.setBackground(new java.awt.Color(0, 0, 0));
                ThreeButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ThreeButton.setBackground(new java.awt.Color(248, 249, 250));
                ThreeButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                ThreeButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                ThreeButton.setBackground(new java.awt.Color(248, 249, 250));
                ThreeButton.setForeground(new java.awt.Color(0,0,0));
            }

            });

            // Button 4 (JButtons) Declarations.
            ButtonsPanel.add(FourButton);
            FourButton.setBackground(new java.awt.Color(248, 249, 250));
            FourButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            FourButton.setFocusPainted(false);
            FourButton.setHorizontalAlignment(SwingConstants.CENTER);
            FourButton.setOpaque(false);
            FourButton.setForeground(new java.awt.Color(0,0,0));
            FourButton.setText("4");
            FourButton.setVisible(true);

            FourButton.setContentAreaFilled(true);
            FourButton.setBorderPainted(false);
            FourButton.setIconTextGap(-2);

            FourButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                FourButton.setBackground(new java.awt.Color(0, 0, 0));
                FourButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                FourButton.setBackground(new java.awt.Color(248, 249, 250));
                FourButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                FourButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                FourButton.setBackground(new java.awt.Color(248, 249, 250));
                FourButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 5 (JButtons) Declarations.
            ButtonsPanel.add(FiveButton);
            FiveButton.setBackground(new java.awt.Color(248, 249, 250));
            FiveButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            FiveButton.setFocusPainted(false);
            FiveButton.setHorizontalAlignment(SwingConstants.CENTER);
            FiveButton.setOpaque(false);
            FiveButton.setForeground(new java.awt.Color(0,0,0));
            FiveButton.setText("5");
            FiveButton.setVisible(true);

            FiveButton.setContentAreaFilled(true);
            FiveButton.setBorderPainted(false);
            FiveButton.setIconTextGap(-2);

            FiveButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                FiveButton.setBackground(new java.awt.Color(0, 0, 0));
                FiveButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                FiveButton.setBackground(new java.awt.Color(248, 249, 250));
                FiveButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                FiveButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                FiveButton.setBackground(new java.awt.Color(248, 249, 250));
                FiveButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button Clear (JButtons) Declarations.
            ButtonsPanel.add(ClearButton);
            ClearButton.setBackground(new java.awt.Color(120, 0, 0));
            ClearButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            ClearButton.setFocusPainted(false);
            ClearButton.setHorizontalAlignment(SwingConstants.CENTER);
            ClearButton.setOpaque(false);
            ClearButton.setForeground(new java.awt.Color(248, 249, 250));
            ClearButton.setText("AC");
            ClearButton.setVisible(true);

            ClearButton.setContentAreaFilled(true);
            ClearButton.setBorderPainted(false);
            ClearButton.setIconTextGap(-2);

            ClearButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                ClearButton.setBackground(new java.awt.Color(248, 249, 250));
                ClearButton.setForeground(new java.awt.Color(120, 0, 0));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ClearButton.setBackground(new java.awt.Color(120, 0, 0));
                ClearButton.setForeground(new java.awt.Color(248, 249, 250));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                ClearButton.setBackground(new java.awt.Color(193, 18, 31));
            }

            @Override
            public void mouseExited(MouseEvent e){
                ClearButton.setBackground(new java.awt.Color(120, 0, 0));
                ClearButton.setForeground(new java.awt.Color(248, 249, 250));
            }

            });
            
            // Button 6 (JButtons) Declarations.
            ButtonsPanel.add(SixButton);
            SixButton.setBackground(new java.awt.Color(248, 249, 250));
            SixButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            SixButton.setFocusPainted(false);
            SixButton.setHorizontalAlignment(SwingConstants.CENTER);
            SixButton.setOpaque(false);
            SixButton.setForeground(new java.awt.Color(0,0,0));
            SixButton.setText("6");
            SixButton.setVisible(true);

            SixButton.setContentAreaFilled(true);
            SixButton.setBorderPainted(false);
            SixButton.setIconTextGap(-2);

            SixButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                SixButton.setBackground(new java.awt.Color(0, 0, 0));
                SixButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                SixButton.setBackground(new java.awt.Color(248, 249, 250));
                SixButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                SixButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                SixButton.setBackground(new java.awt.Color(248, 249, 250));
                SixButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 7 (JButtons) Declarations.
            ButtonsPanel.add(SevenButton);
            SevenButton.setBackground(new java.awt.Color(248, 249, 250));
            SevenButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            SevenButton.setFocusPainted(false);
            SevenButton.setHorizontalAlignment(SwingConstants.CENTER);
            SevenButton.setOpaque(false);
            SevenButton.setForeground(new java.awt.Color(0,0,0));
            SevenButton.setText("7");
            SevenButton.setVisible(true);

            SevenButton.setContentAreaFilled(true);
            SevenButton.setBorderPainted(false);
            SevenButton.setIconTextGap(-2);

            SevenButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                SevenButton.setBackground(new java.awt.Color(0, 0, 0));
                SevenButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                SevenButton.setBackground(new java.awt.Color(248, 249, 250));
                SevenButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                SevenButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                SevenButton.setBackground(new java.awt.Color(248, 249, 250));
                SevenButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 8 (JButtons) Declarations.
            ButtonsPanel.add(EightButton);
            EightButton.setBackground(new java.awt.Color(248, 249, 250));
            EightButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            EightButton.setFocusPainted(false);
            EightButton.setHorizontalAlignment(SwingConstants.CENTER);
            EightButton.setOpaque(false);
            EightButton.setForeground(new java.awt.Color(0,0,0));
            EightButton.setText("8");
            EightButton.setVisible(true);

            EightButton.setContentAreaFilled(true);
            EightButton.setBorderPainted(false);
            EightButton.setIconTextGap(-2);

            EightButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                EightButton.setBackground(new java.awt.Color(0, 0, 0));
                EightButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                EightButton.setBackground(new java.awt.Color(248, 249, 250));
                EightButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                EightButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                EightButton.setBackground(new java.awt.Color(248, 249, 250));
                EightButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 9 (JButtons) Declarations.
            ButtonsPanel.add(NineButton);
            NineButton.setBackground(new java.awt.Color(248, 249, 250));
            NineButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            NineButton.setFocusPainted(false);
            NineButton.setHorizontalAlignment(SwingConstants.CENTER);
            NineButton.setOpaque(false);
            NineButton.setForeground(new java.awt.Color(0,0,0));
            NineButton.setText("9");
            NineButton.setVisible(true);

            NineButton.setContentAreaFilled(true);
            NineButton.setBorderPainted(false);
            NineButton.setIconTextGap(-2);

            NineButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                NineButton.setBackground(new java.awt.Color(0, 0, 0));
                NineButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                NineButton.setBackground(new java.awt.Color(248, 249, 250));
                NineButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                NineButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                NineButton.setBackground(new java.awt.Color(248, 249, 250));
                NineButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button 0 (JButtons) Declarations.
            ButtonsPanel.add(ZeroButton);
            ZeroButton.setBackground(new java.awt.Color(248, 249, 250));
            ZeroButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            ZeroButton.setFocusPainted(false);
            ZeroButton.setHorizontalAlignment(SwingConstants.CENTER);
            ZeroButton.setOpaque(false);
            ZeroButton.setForeground(new java.awt.Color(0,0,0));
            ZeroButton.setText("0");
            ZeroButton.setVisible(true);

            ZeroButton.setContentAreaFilled(true);
            ZeroButton.setBorderPainted(false);
            ZeroButton.setIconTextGap(-2);

            ZeroButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                ZeroButton.setBackground(new java.awt.Color(0, 0, 0));
                ZeroButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ZeroButton.setBackground(new java.awt.Color(248, 249, 250));
                ZeroButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                ZeroButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                ZeroButton.setBackground(new java.awt.Color(248, 249, 250));
                ZeroButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button Delete (JButtons) Declarations.
            ButtonsPanel.add(DelButton);
            DelButton.setBackground(new java.awt.Color(120, 0, 0));
            DelButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            DelButton.setFocusPainted(false);
            DelButton.setHorizontalAlignment(SwingConstants.CENTER);
            DelButton.setOpaque(false);
            DelButton.setForeground(new java.awt.Color(248, 249, 250));
            DelButton.setText("DEL");
            DelButton.setVisible(true);

            DelButton.setContentAreaFilled(true);
            DelButton.setBorderPainted(false);
            DelButton.setIconTextGap(-2);

            DelButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                DelButton.setBackground(new java.awt.Color(248, 249, 250));
                DelButton.setForeground(new java.awt.Color(120, 0, 0));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                DelButton.setBackground(new java.awt.Color(120, 0, 0));
                DelButton.setForeground(new java.awt.Color(248, 249, 250));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                DelButton.setBackground(new java.awt.Color(193, 18, 31));
            }

            @Override
            public void mouseExited(MouseEvent e){
                DelButton.setBackground(new java.awt.Color(120, 0, 0));
                DelButton.setForeground(new java.awt.Color(248, 249, 250));
            }
            
            });
            
            // Button Addition (JButtons) Declarations.
            ButtonsPanel.add(AddButton);
            AddButton.setBackground(new java.awt.Color(248, 249, 250));
            AddButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            AddButton.setFocusPainted(false);
            AddButton.setHorizontalAlignment(SwingConstants.CENTER);
            AddButton.setOpaque(false);
            AddButton.setForeground(new java.awt.Color(0,0,0));
            AddButton.setText("+");
            AddButton.setVisible(true);

            AddButton.setContentAreaFilled(true);
            AddButton.setBorderPainted(false);
            AddButton.setIconTextGap(-2);

            AddButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                AddButton.setBackground(new java.awt.Color(0, 0, 0));
                AddButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                AddButton.setBackground(new java.awt.Color(248, 249, 250));
                AddButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                AddButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                AddButton.setBackground(new java.awt.Color(248, 249, 250));
                AddButton.setForeground(new java.awt.Color(0,0,0));
            }

            });
            
            // Button Subtract (JButtons) Declarations.
            ButtonsPanel.add(SubButton);
            SubButton.setBackground(new java.awt.Color(248, 249, 250));
            SubButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            SubButton.setFocusPainted(false);
            SubButton.setHorizontalAlignment(SwingConstants.CENTER);
            SubButton.setOpaque(false);
            SubButton.setForeground(new java.awt.Color(0,0,0));
            SubButton.setText("-");
            SubButton.setVisible(true);

            SubButton.setContentAreaFilled(true);
            SubButton.setBorderPainted(false);
            SubButton.setIconTextGap(-2);

            SubButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                SubButton.setBackground(new java.awt.Color(0, 0, 0));
                SubButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                SubButton.setBackground(new java.awt.Color(248, 249, 250));
                SubButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                SubButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                SubButton.setBackground(new java.awt.Color(248, 249, 250));
                SubButton.setForeground(new java.awt.Color(0,0,0));
            }
            
            });
           
            // Button Multiply (JButtons) Declarations.
            ButtonsPanel.add(MultiButton);
            MultiButton.setBackground(new java.awt.Color(248, 249, 250));
            MultiButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            MultiButton.setFocusPainted(false);
            MultiButton.setHorizontalAlignment(SwingConstants.CENTER);
            MultiButton.setOpaque(false);
            MultiButton.setForeground(new java.awt.Color(0,0,0));
            MultiButton.setText("x");
            MultiButton.setVisible(true);

            MultiButton.setContentAreaFilled(true);
            MultiButton.setBorderPainted(false);
            MultiButton.setIconTextGap(-2);

            MultiButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                MultiButton.setBackground(new java.awt.Color(0, 0, 0));
                MultiButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MultiButton.setBackground(new java.awt.Color(248, 249, 250));
                MultiButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                MultiButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                MultiButton.setBackground(new java.awt.Color(248, 249, 250));
                MultiButton.setForeground(new java.awt.Color(0,0,0));
            }
            
            });
            
            // Button Divide (JButtons) Declarations.
            ButtonsPanel.add(DivButton);
            DivButton.setBackground(new java.awt.Color(248, 249, 250));
            DivButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            DivButton.setFocusPainted(false);
            DivButton.setHorizontalAlignment(SwingConstants.CENTER);
            DivButton.setOpaque(false);
            DivButton.setForeground(new java.awt.Color(0,0,0));
            DivButton.setText("÷");
            DivButton.setVisible(true);

            DivButton.setContentAreaFilled(true);
            DivButton.setBorderPainted(false);
            DivButton.setIconTextGap(-2);

            DivButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                DivButton.setBackground(new java.awt.Color(0, 0, 0));
                DivButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                DivButton.setBackground(new java.awt.Color(248, 249, 250));
                DivButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                DivButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                DivButton.setBackground(new java.awt.Color(248, 249, 250));
                DivButton.setForeground(new java.awt.Color(0,0,0));
            }
            
            });
            
            // Button Modulus (JButtons) Declarations.
            ButtonsPanel.add(ModulusButton);
            ModulusButton.setBackground(new java.awt.Color(248, 249, 250));
            ModulusButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            ModulusButton.setFocusPainted(false);
            ModulusButton.setHorizontalAlignment(SwingConstants.CENTER);
            ModulusButton.setOpaque(false);
            ModulusButton.setForeground(new java.awt.Color(0,0,0));
            ModulusButton.setText("%");
            ModulusButton.setVisible(true);

            ModulusButton.setContentAreaFilled(true);
            ModulusButton.setBorderPainted(false);
            ModulusButton.setIconTextGap(-2);

            ModulusButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                ModulusButton.setBackground(new java.awt.Color(0, 0, 0));
                ModulusButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ModulusButton.setBackground(new java.awt.Color(248, 249, 250));
                ModulusButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                ModulusButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                ModulusButton.setBackground(new java.awt.Color(248, 249, 250));
                ModulusButton.setForeground(new java.awt.Color(0,0,0));
            }
            
            });
            
            // Button Equal (JButtons) Declarations.
            ButtonsPanel.add(EqualButton);
            EqualButton.setBackground(new java.awt.Color(248, 249, 250));
            EqualButton.setFont(new java.awt.Font("Quicksand", Font.PLAIN, 25));
            EqualButton.setFocusPainted(false);
            EqualButton.setHorizontalAlignment(SwingConstants.CENTER);
            EqualButton.setOpaque(false);
            EqualButton.setForeground(new java.awt.Color(0,0,0));
            EqualButton.setText("=");
            EqualButton.setVisible(true);

            EqualButton.setContentAreaFilled(true);
            EqualButton.setBorderPainted(false);
            EqualButton.setIconTextGap(-2);

            EqualButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                EqualButton.setBackground(new java.awt.Color(0, 0, 0));
                EqualButton.setForeground(new java.awt.Color(255,255,255));
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                EqualButton.setBackground(new java.awt.Color(248, 249, 250));
                EqualButton.setForeground(new java.awt.Color(0,0,0));
            }

            @Override
            public void mouseEntered(MouseEvent e){
                EqualButton.setBackground(new java.awt.Color(150,150,150));
            }

            @Override
            public void mouseExited(MouseEvent e){
                EqualButton.setBackground(new java.awt.Color(248, 249, 250));
                EqualButton.setForeground(new java.awt.Color(0,0,0));
            }
            
            });
            
        // One Button Function 
        OneButton.addActionListener((ActionEvent evt) -> {

            OneButtonFunction(evt);

        });
        
        // Two Button Function 
        TwoButton.addActionListener((ActionEvent evt) -> {

            TwoButtonFunction(evt);

        });
        
        // Three Button Function 
        ThreeButton.addActionListener((ActionEvent evt) -> {

            ThreeButtonFunction(evt);

        });
        
        // Four Button Function 
        FourButton.addActionListener((ActionEvent evt) -> {

            FourButtonFunction(evt);

        });
        
        // Five Button Function 
        FiveButton.addActionListener((ActionEvent evt) -> {

            FiveButtonFunction(evt);

        });
        
        // Clear Button Function 
        ClearButton.addActionListener((ActionEvent evt) -> {

            ClearButtonFunction(evt);

        });
        
        // Six Button Function 
        SixButton.addActionListener((ActionEvent evt) -> {

            SixButtonFunction(evt);

        });
        
        // Seven Button Function 
        SevenButton.addActionListener((ActionEvent evt) -> {

            SevenButtonFunction(evt);

        });
        
        // Eight Button Function 
        EightButton.addActionListener((ActionEvent evt) -> {

            EightButtonFunction(evt);

        });
        
        // Nine Button Function 
        NineButton.addActionListener((ActionEvent evt) -> {

            NineButtonFunction(evt);

        });
        
        // Zero Button Function 
        ZeroButton.addActionListener((ActionEvent evt) -> {

            ZeroButtonFunction(evt);

        });
        
        // Delete Button Function 
        DelButton.addActionListener((ActionEvent evt) -> {

            DeleteButtonFunction(evt);

        });
        
        // Addition Button Function 
        AddButton.addActionListener((ActionEvent evt) -> {

            AdditionButtonFunction(evt);

        });
        
        // Subtraction Button Function 
        SubButton.addActionListener((ActionEvent evt) -> {

            SubtractionButtonFunction(evt);

        });
        
        // Mulitplication Button Function 
        MultiButton.addActionListener((ActionEvent evt) -> {

            MultiplicationButtonFunction(evt);

        });
        
        // Divition Button Function 
        DivButton.addActionListener((ActionEvent evt) -> {

            DivisionButtonFunction(evt);

        });
        
        // Modulus Button Function 
        ModulusButton.addActionListener((ActionEvent evt) -> {

            ModulusButtonFunction(evt);

        });
        
        // Equal Button Function 
        EqualButton.addActionListener((ActionEvent evt) -> {

            EqualButtonFunction(evt);

        });

        pack();
        setLocationRelativeTo(null);
        
    }
    
    // Class Functions.
    
    private void ExitButtonFunction(ActionEvent evt){
        // CUSTOM EXIT BUTTON PROMP
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        int Question_YES = JOptionPane.showConfirmDialog(null, "Do you want to close the Program?", 
                "BTS : Calculator - Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (Question_YES == JOptionPane.YES_OPTION) {

            System.exit(0);

        } else if (Question_YES == JOptionPane.NO_OPTION) {

            String message = "Program Closure Aborted";
            String title1 = "BTS : Calculator - Confirmation";

            JOptionPane.showMessageDialog(null, message, title1, JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    private void OneButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "1");
    }

    private void TwoButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "2");
    }
    
    private void ThreeButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "3");
    }
    
    private void FourButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "4");
    }

    private void FiveButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "5");
    }

    private void ClearButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText("");
        OperatorInput.setText("");
        AnswerOutput.setText("");
    }

    private void SixButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "6");
    }

    private void SevenButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "7");
    }

    private void EightButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "8");
    }

    private void NineButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "9");
    }

    private void ZeroButtonFunction(ActionEvent evt) {
        displayFirstNum = FirstNumberInput.getText();
        FirstNumberInput.setText(displayFirstNum + "0");
    }
    
    private void DeleteButtonFunction(ActionEvent evt){
        
        int length = FirstNumberInput.getText().length();
        int number = FirstNumberInput.getText().length() - 1;
        String store;
        
        if(length > 0){
            
            StringBuilder delete = new StringBuilder(FirstNumberInput.getText());
            delete.deleteCharAt(number);
            store = delete.toString();
            FirstNumberInput.setText(store);
            
        }
    }

    private void AdditionButtonFunction(ActionEvent evt) {
        num = Double.parseDouble(FirstNumberInput.getText());
        calculation = 1;
        FirstNumberInput.setText("");
        OperatorInput.setText("+");
        
    }

    private void SubtractionButtonFunction(ActionEvent evt) {
        num = Double.parseDouble(FirstNumberInput.getText());
        calculation = 2;
        FirstNumberInput.setText("");
        OperatorInput.setText("-");
    }

    private void MultiplicationButtonFunction(ActionEvent evt) {
        num = Double.parseDouble(FirstNumberInput.getText());
        calculation = 3;
        FirstNumberInput.setText("");
        OperatorInput.setText("*");
    }

    private void DivisionButtonFunction(ActionEvent evt) {
        num = Double.parseDouble(FirstNumberInput.getText());
        calculation = 4;
        FirstNumberInput.setText("");
        OperatorInput.setText("÷");
    }

    private void ModulusButtonFunction(ActionEvent evt) {
        num = Double.parseDouble(FirstNumberInput.getText());
        calculation = 5;
        FirstNumberInput.setText("");
        OperatorInput.setText("%");
    }

    private void EqualButtonFunction(ActionEvent evt) {
        
        Calculator();
        
    }
    
    
    private void MinimizeButtonFunction(ActionEvent evt){
        
        setState(BTSCalculator.ICONIFIED);
        
    }
    
    public void Calculator(){
        
        switch(calculation){
            case 1: // Addition
                ans = num + Double.parseDouble(FirstNumberInput.getText());
                AnswerOutput.setText("Answer : " +Double.toString(ans));
                break;
            case 2: // Subtraction
                ans = num - Double.parseDouble(FirstNumberInput.getText());
                AnswerOutput.setText("Answer : " +Double.toString(ans));
                break;
            case 3: // Multiplication
                ans = num * Double.parseDouble(FirstNumberInput.getText());
                AnswerOutput.setText("Answer : " +Double.toString(ans));
                break;
            case 4: // Division
                ans = num / Double.parseDouble(FirstNumberInput.getText());
                AnswerOutput.setText("Answer : " +Double.toString(ans));
                break;
            case 5: // Modulus
                ans = num % Double.parseDouble(FirstNumberInput.getText());
                AnswerOutput.setText("Answer : " +Double.toString(ans));
                break;              
                
        }
        
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BTSCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Call Loading Screen Before Launching BTS Calculator
        BTSSplash Execute = new BTSSplash();
        Execute.setTitle("Brion Tactical Systems");
        Execute.setVisible(true);

        File file = new File("src\\BTSCalcu Files\\audio\\BTSVocalRecConv.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        BTSCalculator Launch = new BTSCalculator();

        try {
            for (int i = 0; i < 101; i++) {
                
                Thread.sleep(2 * 10);
                
                if (i == 1) {
                    clip.start();
                }

                switch (i) {
                    case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101 ->
                        Execute.Status.setText("Loading        | " + Integer.toString(i) + "%");
                    default -> {
                    }
                }
                Execute.LoadingBar.setValue(i);        // Loading is a name of progressbar
            }
        } catch (InterruptedException e) {
        }

        // DELAY BEFORE BTS CALCULATOR POP UP WINDOW
        try {

            Thread.sleep(2 * 1000);
            Launch.setTitle("Brion Tactical Systems : Calculator");
            Launch.setVisible(true);
            Launch.setOpacity(0.98f);
            Execute.dispose();

        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        
    }
}
