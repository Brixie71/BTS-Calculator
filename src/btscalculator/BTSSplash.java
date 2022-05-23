// Package, sets the Directory path of the class and its Dependencies.

package btscalculator;
// Swing, IO, AWT, and util imports of the Java Program.
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BTSSplash extends JFrame {
    
    /* The Functions of this Class is Called by the Parent Class (BTSCalculator class) inside the Main Method before loading the Login Window.
       Exception Handling (Try-Catch) is used in the Main Method to set the Speed of the Loading bar before and after it Appears. As well
       as the Information that the program is trying to load along with the Percentage.
    */
    
    // Component Declarations.
    
    JPanel SplashBackground;
    JLabel CompanyLogo, BTSTitle, Status, ProgramName;
    JProgressBar LoadingBar;
    
    Font IronShark, Quicksand, Gepestev;
    
    // Calling Method
    public BTSSplash(){
        
        SetComponentLookAndFeel();
        
        SplashComponents();
        
        setIconImage();
        
    }
    
    // Component Instantiations and Decorations. The UI (Java Swing) design of the class.
    private void SplashComponents() {
        
        // <editor-fold defaultstate="collapsed" desc="<<< JFrame Container.">
        // JFrame Declaration
        final int FrameSizeX = 500;
        final int FrameSizeY = 300;

        //JFrame Size.
        setSize(FrameSizeX, FrameSizeY);
        setMinimumSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));
        setPreferredSize(new java.awt.Dimension(FrameSizeX, FrameSizeY));

        //JFrame Decoration.
        setUndecorated(true);
        setOpacity(1.0f);
        setTitle("BTS : Police Record Management System");
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // CENTER POPUP MAIN WINDOW.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="<<< Component Instantiations.">
         
            SplashBackground = new JPanel();
            
            CompanyLogo = new JLabel();
            BTSTitle = new JLabel();
            Status = new JLabel();
            ProgramName = new JLabel();
            
            LoadingBar = new JProgressBar();
            
        // </editor-fold>
        
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
        
        // Company Logo (JLabel) Decorations.

            final int companyLogoLocationX = 120;
            final int companyLogoLocationY = 0;
            final int companyLogoWidth = 280;
            final int companyLogoHeight = 280;

            add(CompanyLogo);
            CompanyLogo.setBounds(companyLogoLocationX, companyLogoLocationY, companyLogoWidth, companyLogoHeight);
            CompanyLogo.setBackground(null);
            CompanyLogo.setHorizontalAlignment(SwingConstants.CENTER);
            CompanyLogo.setLayout(null);
            CompanyLogo.setVisible(true);

            ImageIcon findLogo = new ImageIcon("src\\BTSCalcu Files\\logo\\BTSLogo1.png");
            Image importLogo = findLogo.getImage();
            Image scaleLogo = importLogo.getScaledInstance(CompanyLogo.getWidth(), CompanyLogo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledLogo = new ImageIcon(scaleLogo);
            CompanyLogo.setIcon(scaledLogo);
            
        // Company Name Label (JLabel) Declarations.        

                    final int CompanyLabelHeight = 15;
                    final int CompanyLabelWidth = 500;
                    final int CompanyLabelLocationX = 0;
                    final int CompanyLabelLocationY = 202;
                    final int CompanyShadowLocationY = 206;

                    add(BTSTitle);
                    BTSTitle.setBounds(CompanyLabelLocationX, CompanyLabelLocationY, CompanyLabelWidth, CompanyLabelHeight);
                    BTSTitle.setForeground(new java.awt.Color(255, 208, 0));
                    BTSTitle.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 15));
                    
                    JLabel BTSTitleShadow = new JLabel();
                    
                    add(BTSTitleShadow);
                    BTSTitleShadow.setBounds(CompanyLabelLocationX, CompanyShadowLocationY, CompanyLabelWidth, CompanyLabelHeight);
                    BTSTitleShadow.setForeground(new java.awt.Color(0, 0, 0));
                    BTSTitleShadow.setFont(new java.awt.Font("Iron Shark", Font.PLAIN, 15));

                    BTSTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    BTSTitle.setText("Brion Tactical Systems");
                    BTSTitle.setVisible(true);

                    BTSTitleShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    BTSTitleShadow.setText("Brion Tactical Systems");
                    BTSTitleShadow.setVisible(true);

                    // Program Name Label (JLabel) Declarations.
                    
                        final int ProgramLabelHeight = 20;
                        final int ProgramLabelWidth = 500;
                        final int ProgramLabelLocationX = 0;
                        final int ProgramLabelLocationY = 228;
                        final int ProgramShadowLocationY = 232;
                        
                        add(ProgramName);
                        ProgramName.setBounds(ProgramLabelLocationX, ProgramLabelLocationY, ProgramLabelWidth, ProgramLabelHeight);
                        ProgramName.setForeground(new java.awt.Color(255, 255, 255));
                        ProgramName.setFont(new java.awt.Font("Impact", Font.PLAIN, 20));
                    
                        JLabel ProgramNameShadow = new JLabel();
                        
                        add(ProgramNameShadow);
                        ProgramNameShadow.setBounds(ProgramLabelLocationX, ProgramShadowLocationY, ProgramLabelWidth, ProgramLabelHeight);
                        ProgramNameShadow.setForeground(new java.awt.Color(0, 0, 0));
                        ProgramNameShadow.setFont(new java.awt.Font("Impact", Font.PLAIN, 20));

                        ProgramName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        ProgramName.setText("COMPROG 3 FINALS : EVENT-DRIVEN CALCULATOR");
                        ProgramName.setVisible(true);
                    
                        ProgramNameShadow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        ProgramNameShadow.setText("COMPROG 3 FINALS : EVENT-DRIVEN CALCULATOR");
                        ProgramNameShadow.setVisible(true);
                        
                // Status Timeline (JLabel) Decorations.
                
                    final int StatusLocationX = 0;
                    final int StatusLocationY = 255;
                    final int StatusWidth     = 500;
                    final int StatusHeight    = 35;

                    add(Status);
                    Status.setBounds(StatusLocationX, StatusLocationY, StatusWidth, StatusHeight);
                    Status.setBackground(new Color(0,0,0,0));
                    Status.setForeground(new Color(255, 255, 255));
                    Status.setText("");
                    Status.setOpaque(false);
                    Status.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(237, 242, 244)));
                    Status.setFont(new Font("Quicksand", Font.BOLD, 12));
                    Status.setHorizontalAlignment(SwingConstants.CENTER);
                    Status.setVisible(true);
                
                // Loading Bar (JProgressBar) Decorations.
                    
                    final int LoadingBarLocationX = 0;
                    final int LoadingBarLocationY = 280;
                    final int LoadingBarWidth     = 500;
                    final int LoadingBarHeight    = 20;
                    
                    add(LoadingBar);
                    LoadingBar.setBounds(LoadingBarLocationX, LoadingBarLocationY, LoadingBarWidth, LoadingBarHeight);
                    LoadingBar.setBackground(new Color(0,0,0,0));
                    LoadingBar.setVisible(true);
                    
                    
        // Splash Screen Background (JPanel) Decorations.
        
            final int dashBarLocationX = 0;
            final int dashBarLocationY = 0;
            final int dashBarHeight = 300;
            final int dashBarWidth = 500;

            add(SplashBackground);
            SplashBackground.setBounds(dashBarLocationX, dashBarLocationY, dashBarWidth, dashBarHeight);
            SplashBackground.setBackground(new java.awt.Color(0, 29, 61));
            SplashBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 200, 0), 1, false));
            SplashBackground.setLayout(null);
        
        
            
        
        pack();
        setLocationRelativeTo(null);

    }
    
    // Sets the Component Look and Feel ex. Nimbus, Windows, Default.
    private void SetComponentLookAndFeel() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }/*/ /*/
    }
    
    // Sets the Icon of the JFrame and the TaskBar Icon of the Program, instead of a Java Icon.
    private void setIconImage() {
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("BTSLogo.png")));
    }
}
