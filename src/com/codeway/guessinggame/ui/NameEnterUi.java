package com.codeway.guessinggame.ui;

import com.codeway.guessinggame.db.DataBaseConnection;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NameEnterUi extends JFrame implements ActionListener {

  NameEnterUi() {
    initComponents();
  }

  private void initComponents() {
    jLabel2 = new javax.swing.JLabel();
    tfPlayerName = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    btnSubmit = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setIconImages(null);

    jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Enter Your Name");

    tfPlayerName.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
    tfPlayerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    btnSubmit.setBackground(new java.awt.Color(51, 255, 51));
    btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnSubmit.setText("Submit");
    btnSubmit.addActionListener(this);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          layout
            .createSequentialGroup()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(
                      jLabel2,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      207,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(34, 34, 34)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                      layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          layout
                            .createSequentialGroup()
                            .addComponent(
                              btnSubmit,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              104,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(93, 93, 93)
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          layout
                            .createSequentialGroup()
                            .addComponent(
                              tfPlayerName,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              239,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(18, 18, 18)
                        )
                    )
                )
            )
            .addComponent(
              jLabel1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              63,
              Short.MAX_VALUE
            )
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(
                      jLabel2,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      53,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(18, 18, 18)
                    .addComponent(
                      tfPlayerName,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      62,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(40, 40, 40)
                    .addComponent(
                      btnSubmit,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      47,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(0, 47, Short.MAX_VALUE)
                )
                .addComponent(
                  jLabel1,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
            )
            .addContainerGap()
        )
    );

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>

  public static void main(String[] args) {
    new NameEnterUi().setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSubmit) {
      String user = tfPlayerName.getText();

      if (user.equals("")) {
        JOptionPane.showMessageDialog(null, "Please Enter the Name");
      }
      if (user.length() < 2 && user.isEmpty()) {
        JOptionPane.showMessageDialog(
          null,
          "The name is too short. Please enter a valid name."
        );
      } else {
        try {
            DataBaseConnection dbConnection = new DataBaseConnection();

          String query =
            "SELECT * FROM leaderboard WHERE player = '" + user + "'";

          ResultSet resultSet = dbConnection.statement.executeQuery(query);

          if (resultSet.next()) {
            JOptionPane.showMessageDialog(
              null,
              "Username already in leaderboard"
            );
          } else {
            this.dispose();
            new MainGameUi(user).setVisible(true);
          }
        } catch (Exception exception) {
          System.out.println(exception);
        }
      }
    }
  }

  private javax.swing.JButton btnSubmit;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JTextField tfPlayerName;
  
}
