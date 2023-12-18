/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author matt3
 */
public class LoggedIndex extends javax.swing.JFrame {

    //variabili della classe LoggedIndex
    String localuser = "UserNotFound";  //utilizzata nel caso il programma venga aperto in modo non corretto 
    
    //arraylist -> database locale
    ArrayList<String> Contacts = new ArrayList<String>(); //arraylist di contatti
    ArrayList<ArrayList<Message>> MsgsContacts = new ArrayList<ArrayList<Message>>(); // arraylist di arraylist di messaggi (uno per utente)
    
    //
    
    
    
    /**
     * Creates new form Login2
     */
    public LoggedIndex(String localuser) {
        initComponents();
        centrareJFrame();
        setIconaImage();
        titleBar1.init(this);
        this.localuser=localuser;
        ciao_user.setText("Ciao "+localuser);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        titleBar1 = new client.style.TitleBar();
        panel_user = new javax.swing.JPanel();
        ketu_logo = new javax.swing.JLabel();
        icon_user = new javax.swing.JLabel();
        ciao_user = new javax.swing.JLabel();
        messaggio_field = new javax.swing.JTextField();
        invia_icon = new javax.swing.JLabel();
        scrollPane = new client.style.ScrollPaneWin11();
        jPanel3 = new javax.swing.JPanel();
        itemPeople1 = new client.style.ItemPeople();
        itemPeople2 = new client.style.ItemPeople();
        allChat = new javax.swing.JPanel();
        chatLayer = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatMessageSender1 = new client.style.ChatMessageSender();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(18, 18, 18));
        jPanel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        titleBar1.setBackground(new java.awt.Color(18, 18, 18));

        panel_user.setBackground(new java.awt.Color(43, 43, 43));

        ketu_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/logo/logo-nobg-insidebg-128x128.png"))); // NOI18N

        icon_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/icon/login/human.png"))); // NOI18N

        ciao_user.setForeground(new java.awt.Color(241, 241, 241));
        ciao_user.setText("Ciao "+localuser);

        javax.swing.GroupLayout panel_userLayout = new javax.swing.GroupLayout(panel_user);
        panel_user.setLayout(panel_userLayout);
        panel_userLayout.setHorizontalGroup(
            panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_userLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_userLayout.createSequentialGroup()
                        .addComponent(icon_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ciao_user))
                    .addComponent(ketu_logo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_userLayout.setVerticalGroup(
            panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_userLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(ketu_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_user)
                    .addComponent(ciao_user))
                .addGap(17, 17, 17))
        );

        messaggio_field.setBackground(new java.awt.Color(18, 18, 18));
        messaggio_field.setForeground(new java.awt.Color(225, 225, 225));
        messaggio_field.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(187, 134, 252)));

        invia_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invia_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/loggedindex/telegram-xxl-32x32.png"))); // NOI18N
        invia_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invia_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invia_iconMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(43, 43, 43));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemPeople1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemPeople2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemPeople1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemPeople2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(jPanel3);

        allChat.setBackground(new java.awt.Color(43, 43, 43));

        javax.swing.GroupLayout chatLayerLayout = new javax.swing.GroupLayout(chatLayer);
        chatLayer.setLayout(chatLayerLayout);
        chatLayerLayout.setHorizontalGroup(
            chatLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chatLayerLayout.setVerticalGroup(
            chatLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(chatMessageSender1);

        javax.swing.GroupLayout allChatLayout = new javax.swing.GroupLayout(allChat);
        allChat.setLayout(allChatLayout);
        allChatLayout.setHorizontalGroup(
            allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allChatLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
            .addGroup(allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allChatLayout.createSequentialGroup()
                    .addGap(325, 325, 325)
                    .addComponent(chatLayer)
                    .addGap(326, 326, 326)))
            .addGroup(allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allChatLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        allChatLayout.setVerticalGroup(
            allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allChatLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(756, Short.MAX_VALUE))
            .addGroup(allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allChatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chatLayer)
                    .addContainerGap()))
            .addGroup(allChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allChatLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(messaggio_field)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invia_icon)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(allChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addComponent(titleBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(titleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(allChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messaggio_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invia_icon, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invia_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invia_iconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_invia_iconMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoggedIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoggedIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoggedIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggedIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoggedIndex("UserNotFound").setVisible(true);

            }
        });

    }

    public void setIconaImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(("png/logo/logo-nobg-insidebg-64x64.png")));
        setTitle("Ketu");
    }

    

    // Metodo per centrare il JFrame
    public void centrareJFrame() {
        // Ottieni le dimensioni dello schermo
        Dimension dimensioneSchermo = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcola le coordinate per centrare il JFrame
        int x = (dimensioneSchermo.width - getWidth()) / 2;
        int y = (dimensioneSchermo.height - getHeight()) / 2;

        // Imposta la posizione del JFrame
        setLocation(x, y);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allChat;
    private javax.swing.JLayeredPane chatLayer;
    private client.style.ChatMessageSender chatMessageSender1;
    private javax.swing.JLabel ciao_user;
    private javax.swing.JLabel icon_user;
    private javax.swing.JLabel invia_icon;
    private client.style.ItemPeople itemPeople1;
    private client.style.ItemPeople itemPeople2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ketu_logo;
    private javax.swing.JTextField messaggio_field;
    private javax.swing.JPanel panel_user;
    private client.style.ScrollPaneWin11 scrollPane;
    private client.style.TitleBar titleBar1;
    // End of variables declaration//GEN-END:variables
}