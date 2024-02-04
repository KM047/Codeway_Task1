/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.codeway.guessinggame.ui;

import com.codeway.guessinggame.db.DataBaseConnection;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kunal
 */
public class MainGameUi extends JFrame implements ActionListener {

  Random random = new Random();

  // Generate a random integer between 0 and 100
  int randomNumber = random.nextInt(10);

  /**
   * Creates new form MainGameUi
   */
  String user;
  int Score;

  public MainGameUi(String username) {
    this.user = username;
    initComponents();
    ScaleImage();
  }

  public void ScaleImage() {
    ImageIcon icon = new ImageIcon(
      "src\\com\\codeway\\guessinggame\\ui\\assets\\background-2.png"
    );
    Image img = icon.getImage();
    Image imgSacle = img.getScaledInstance(
      label.getWidth(),
      label.getHeight(),
      Image.SCALE_SMOOTH
    );
    ImageIcon scaledIcon = new ImageIcon(imgSacle);
    label.setIcon(scaledIcon);
  }

  private void displayMessage(String message) {
    tfOutput.setText(message);
  }

  int attempts = 10;

  int take_attempts = 0;

  private void Increment() {
    attempts--;
    take_attempts++;

    lblatempt.setText("" + take_attempts + "");

    lblchance.setText("" + attempts + "");

    if (attempts == 0) {
      displayMessage("You have run out of tries");

      JOptionPane.showMessageDialog(
        MainGameUi.this,
        "You have run out of tries"
      );

      this.dispose();

      new GameOverUi(user).setVisible(true);
    }
  }

  
  private void initComponents() {
    jLabel1 = new javax.swing.JLabel();
    tfInput = new javax.swing.JTextField();
    btnSubmit = new javax.swing.JButton();
    tfOutput = new javax.swing.JTextField();
    lblatempt = new javax.swing.JLabel();
    lblchance = new javax.swing.JLabel();
    label = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Game");
    setAlwaysOnTop(true);
    setMinimumSize(new java.awt.Dimension(500, 500));
    setSize(new java.awt.Dimension(500, 500));

    jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(153, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Enter Your Number");
    jLabel1.setBorder(
      javax.swing.BorderFactory.createMatteBorder(
        1,
        1,
        1,
        1,
        new java.awt.Color(0, 102, 255)
      )
    );
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    tfInput.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
    tfInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    btnSubmit.setBackground(new java.awt.Color(51, 255, 255));
    btnSubmit.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    btnSubmit.setText("Submit");
    btnSubmit.setBorder(
      javax.swing.BorderFactory.createBevelBorder(
        javax.swing.border.BevelBorder.RAISED
      )
    );
    btnSubmit.addMouseListener(
      new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          btnSubmitMouseClicked(evt);
        }
      }
    );
    btnSubmit.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnSubmitActionPerformed(evt);
        }
      }
    );

    tfOutput.setBackground(new java.awt.Color(0, 0, 0));
    tfOutput.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    tfOutput.setForeground(new java.awt.Color(255, 51, 51));
    tfOutput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    lblatempt.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
    lblatempt.setForeground(new java.awt.Color(255, 51, 51));
    lblatempt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblatempt.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Attempt Take",
        javax.swing.border.TitledBorder.CENTER,
        javax.swing.border.TitledBorder.TOP,
        new java.awt.Font("Segoe Print", 1, 10),
        new java.awt.Color(255, 51, 51)
      )
    ); // NOI18N

    lblchance.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
    lblchance.setForeground(new java.awt.Color(51, 255, 51));
    lblchance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblchance.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Chance left",
        javax.swing.border.TitledBorder.CENTER,
        javax.swing.border.TitledBorder.TOP,
        new java.awt.Font("Segoe Print", 1, 10),
        new java.awt.Color(51, 255, 51)
      )
    ); // NOI18N

    label.setMinimumSize(new java.awt.Dimension(500, 500));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(170, 170, 170)
            .addComponent(
              tfInput,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              108,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(80, 80, 80)
            .addComponent(
              tfOutput,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              300,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(240, 240, 240)
            .addComponent(
              lblchance,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              120,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(120, 120, 120)
            .addComponent(
              jLabel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              211,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(170, 170, 170)
            .addComponent(
              btnSubmit,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              108,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(80, 80, 80)
            .addComponent(
              lblatempt,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              120,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addComponent(
          label,
          javax.swing.GroupLayout.PREFERRED_SIZE,
          500,
          javax.swing.GroupLayout.PREFERRED_SIZE
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(190, 190, 190)
            .addComponent(
              tfInput,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              70,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(150, 150, 150)
            .addComponent(
              tfOutput,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              50,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(120, 120, 120)
            .addComponent(
              lblchance,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(50, 50, 50)
            .addComponent(
              jLabel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              56,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(290, 290, 290)
            .addComponent(
              btnSubmit,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              49,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(120, 120, 120)
            .addComponent(
              lblatempt,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              60,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
        )
        .addComponent(
          label,
          javax.swing.GroupLayout.PREFERRED_SIZE,
          500,
          javax.swing.GroupLayout.PREFERRED_SIZE
        )
    );

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnSubmitActionPerformed
    // TODO add your handling code here:

    // This is logic

    String inputNumber = tfInput.getText().trim();

    int user_input = Integer.parseInt(inputNumber);

    if (user_input < 0 || user_input > 100) {
      tfInput.setText("");
      tfOutput.setText("Invalid Number");
    }

    //

    if (randomNumber == user_input) {
      displayMessage("You win!");
      JOptionPane.showMessageDialog(MainGameUi.this, "You win!");
      try {
        Thread.sleep(1000);
        setVisible(false);
        this.dispose();
      } catch (InterruptedException ex) {
        Logger
          .getLogger(MainGameUi.class.getName())
          .log(Level.SEVERE, null, ex);
      }

      int total = (attempts * 10) + 10;
      // System.out.println("remaining_attempts - " + attempts);
      // System.out.println(" total  - " + total );

      DataBaseConnection dbConnection = new DataBaseConnection();

      try {
        String query =
          "SELECT * FROM leaderboard WHERE player = '" + user + "'";

        ResultSet resultSet = dbConnection.statement.executeQuery(query);

        if (resultSet.next()) {
          int oldScore = resultSet.getInt("score");

          if (total > oldScore) {
            String queryUpdate =
              "UPDATE leaderboard SET score = '" +
              total +
              "' WHERE player = '" +
              user +
              "'";
            dbConnection.statement.executeUpdate(queryUpdate);
            this.dispose();
          }
        } else {
          String query2 =
            "INSERT INTO leaderboard (player, score) VALUES ('" +
            user +
            "', '" +
            total +
            "')";
          dbConnection.statement.executeUpdate(query2);
          this.dispose();
        }
      } catch (Exception exception) {
        System.out.println("exception - " + exception);
      }

      new StartingFrameUi().setVisible(true);
    } else if (randomNumber < user_input) {
      displayMessage("Your guess number is high, try again.");
    } else {
      displayMessage("Too low, try again.");
    }

    tfInput.setText("");
  } //GEN-LAST:event_btnSubmitActionPerformed

  private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) { //GEN-FIRST:event_btnSubmitMouseClicked
    // TODO add your handling code here:

    Increment();
  } //GEN-LAST:event_btnSubmitMouseClicked

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    new MainGameUi("").setVisible(true);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSubmit;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel label;
  private javax.swing.JLabel lblatempt;
  private javax.swing.JLabel lblchance;
  private javax.swing.JTextField tfInput;
  private javax.swing.JTextField tfOutput;

  // End of variables declaration//GEN-END:variables

  @Override
  public void actionPerformed(ActionEvent e) {
    //

  }
}
