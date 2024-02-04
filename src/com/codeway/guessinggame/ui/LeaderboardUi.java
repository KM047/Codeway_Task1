package com.codeway.guessinggame.ui;

import com.codeway.guessinggame.db.DataBaseConnection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * LeaderboardUi
 */
public class LeaderboardUi extends JFrame implements ActionListener {

  ResultSet resultSet = null;

  public LeaderboardUi() {
    initComponents();
    // for to show leader board data
    showDataInTable();
  }

  private void showDataInTable() {
    try {
      DataBaseConnection dbConnection = new DataBaseConnection();

      String query = "SELECT * FROM leaderboard ORDER BY score DESC";
      resultSet = dbConnection.statement.executeQuery(query);
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

      // model.setRowCount(0);

      int count = 1;
      while (resultSet.next()) {
        model.addRow(
          new String[] {
            String.valueOf(count++),
            resultSet.getString(2),
            resultSet.getString(3),
          }
        );
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private void initComponents() {
    jLabel5 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    backButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel5.setBackground(new java.awt.Color(255, 255, 255));
    jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 255));
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("Game Ranking");

    jTable1.setAutoCreateRowSorter(true);
    jTable1.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] { "Rank", "Username", "Score" }
      ) {
        Class[] types = new Class[] {
          java.lang.Integer.class,
          java.lang.Object.class,
          java.lang.Object.class,
        };
        boolean[] canEdit = new boolean[] { false, false, false };

        public Class getColumnClass(int columnIndex) {
          return types[columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
          return canEdit[columnIndex];
        }
      }
    );
    jTable1.setToolTipText("");
    jScrollPane1.setViewportView(jTable1);
    if (jTable1.getColumnModel().getColumnCount() > 0) {
      jTable1.getColumnModel().getColumn(0).setResizable(false);
      jTable1.getColumnModel().getColumn(1).setResizable(false);
      jTable1.getColumnModel().getColumn(2).setResizable(false);
    }

    backButton.setText("Back To Game");
    backButton.addActionListener(this);

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
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                      jScrollPane1,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      0,
                      Short.MAX_VALUE
                    )
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGroup(
                      layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          layout
                            .createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel5)
                        )
                        .addGroup(
                          layout
                            .createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(backButton)
                        )
                    )
                    .addGap(0, 159, Short.MAX_VALUE)
                )
            )
            .addContainerGap()
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jLabel5,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              35,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              312,
              Short.MAX_VALUE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(backButton)
            .addContainerGap()
        )
    );

    pack();
    setLocationRelativeTo(null);

    
    // Cell render
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    cellRenderer.setHorizontalAlignment(JLabel.CENTER);

    for (int i = 0; i <= 2; i++) {
      jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }

  }

  public static void main(String[] args) {
    new LeaderboardUi().setVisible(true);
  }

  private javax.swing.JButton backButton;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;


  @Override
  public void actionPerformed(ActionEvent action) {

      if(action.getSource() == backButton){
        this.dispose();
        new StartingFrameUi().setVisible(true);
      }
  }

}
