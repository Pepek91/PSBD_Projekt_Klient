/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psbd.projekt.dialogs;

import psbd.projekt.utils.MySql;
import psbd.projekt.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 *
 * @author Michal
 */
public class ZalozKontoDialog extends javax.swing.JDialog {

    boolean success = false;
    /**
     * Creates new form ZalozKontoDialog
     */
    public ZalozKontoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        initComboBoxes();
    }

    public boolean getSuccess(){
        return success;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblBledy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldPass1 = new javax.swing.JPasswordField();
        fieldPass2 = new javax.swing.JPasswordField();
        fieldEmail = new javax.swing.JTextField();
        fieldImie = new javax.swing.JTextField();
        fieldNazwisko = new javax.swing.JTextField();
        fieldAdres1 = new javax.swing.JTextField();
        fieldAdres2 = new javax.swing.JTextField();
        fieldKod = new javax.swing.JTextField();
        fieldMiasto = new javax.swing.JTextField();
        cbDzien = new javax.swing.JComboBox();
        cbMiesiac = new javax.swing.JComboBox();
        cbRok = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Załóż konto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Anuluj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblBledy.setText("Komunikaty:");

        jLabel1.setText("Login");

        jLabel2.setText("Hasło");

        jLabel3.setText("Powtórz hasło");

        jLabel4.setText("E-mail");

        jLabel5.setText("Imię");

        jLabel6.setText("Nazwisko");

        jLabel7.setText("Adres");

        jLabel8.setText("Miasto");

        jLabel9.setText("Kod pocztowy");

        jLabel10.setText("Data urodzenia");

        fieldPass2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldPass1)
                            .addComponent(fieldPass2)
                            .addComponent(fieldLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldEmail)
                            .addComponent(fieldImie)
                            .addComponent(fieldNazwisko)
                            .addComponent(fieldAdres1)
                            .addComponent(fieldAdres2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBledy)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbDzien, 0, 62, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cbMiesiac, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbRok, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldKod)
                            .addComponent(fieldMiasto))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBledy)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fieldPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fieldPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fieldImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fieldAdres1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldAdres2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fieldKod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldMiasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbDzien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMiesiac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String login = fieldLogin.getText();
        if (loginZajety(login)) {
            lblBledy.setText("Login zajęty!");
            return;
        }
        if (login.equals("")) {
            lblBledy.setText("Proszę wpisać login");
            return;
        }
        String pass1 = new String(fieldPass1.getPassword());
        String pass2 = new String(fieldPass2.getPassword());

        if (pass1.length() < 5) {
            lblBledy.setText("Za krótkie hasło!");
            return;
        }

        if (!pass1.equals(pass2)) {
            lblBledy.setText("Hasła się nie zgadzają");
            return;
        }

        int urDzien;
        int urMiesiac;
        int urRok;
        try {
            urDzien = Integer.parseInt(String.valueOf(cbDzien.getSelectedItem()));
            urMiesiac = Integer.parseInt(String.valueOf(cbMiesiac.getSelectedItem()));;
            urRok = Integer.parseInt(String.valueOf(cbRok.getSelectedItem()));;
        } catch (NumberFormatException e) {
            lblBledy.setText("Proszę podać datę urodzenia!");
            return;
        }
        if (mniejNiz18(urDzien, urMiesiac, urRok)) {
            lblBledy.setText("Użytkownik jest nie pełnoletni!");
            return;
        }
        if (fieldImie.getText().equals("") || fieldNazwisko.getText().equals("")) {
            lblBledy.setText("Podaj imię i nazwisko!");
            return;
        }
        lblBledy.setText("OK");

        Connection connection = MySql.getInstance().getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection
                    .prepareStatement("INSERT INTO klienci VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, Utils.getMD5Sting(pass1));
            preparedStatement.setString(3, fieldImie.getText());
            preparedStatement.setString(4, fieldNazwisko.getText());
            preparedStatement.setDate(5, new java.sql.Date(urRok - 1900, urMiesiac - 1, urDzien));
            preparedStatement.setString(6, fieldMiasto.getText());
            preparedStatement.setString(7, fieldAdres1.getText() + fieldAdres2.getText());
            preparedStatement.setString(8, fieldKod.getText());

            int ilosc = preparedStatement.executeUpdate();
            if (ilosc == 1) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    long id = rs.getLong(1);
//                    Klient.getInstance().setDaneFull(id,
//                            login,
//                            pass2,
//                            new java.util.Date(urRok - 1900, urMiesiac - 1, urDzien),
//                            fieldAdres1.getText() + fieldAdres2.getText(),
//                            fieldKod.getText(),
//                            fieldMiasto.getText()
//                    );
                    success = true;
                    dispose();
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZalozKontoDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean loginZajety(String login) {
        MySql mySQL = MySql.getInstance();
        Connection connection = mySQL.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement("SELECT login FROM klienci WHERE login = ?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDzien;
    private javax.swing.JComboBox cbMiesiac;
    private javax.swing.JComboBox cbRok;
    private javax.swing.JTextField fieldAdres1;
    private javax.swing.JTextField fieldAdres2;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldImie;
    private javax.swing.JTextField fieldKod;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JTextField fieldMiasto;
    private javax.swing.JTextField fieldNazwisko;
    private javax.swing.JPasswordField fieldPass1;
    private javax.swing.JPasswordField fieldPass2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBledy;
    // End of variables declaration//GEN-END:variables

    private void initComboBoxes() {
        List<String> dzien = new ArrayList<String>();
        dzien.add("d");
        for (int i = 1; i < 32; i++) {
            dzien.add("" + i);
        }

        cbDzien.setModel(new javax.swing.DefaultComboBoxModel(dzien.toArray()));

        List<String> miesiac = new ArrayList<String>();
        miesiac.add("m");
        for (int i = 1; i < 13; i++) {
            miesiac.add("" + i);
        }

        cbMiesiac.setModel(new javax.swing.DefaultComboBoxModel(miesiac.toArray()));

        int year = Calendar.getInstance().get(Calendar.YEAR);

        List<String> rok = new ArrayList<String>();
        rok.add("r");
        for (int i = 0; i < 121; i++) {
            int rok2 = year - i;
            rok.add("" + rok2);
        }

        cbRok.setModel(new javax.swing.DefaultComboBoxModel(rok.toArray()));
    }

    private boolean mniejNiz18(int urDzien, int urMiesiac, int urRok) {

        DateTime now = new DateTime();
        DateTime dataUrodzenia = new DateTime(urRok, urMiesiac, urDzien, 0, 0);
        Period period = new Period(dataUrodzenia, now);
        if (period.getYears() < 18) {
            return true;
        }

        return false;
    }

}