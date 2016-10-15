/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psbd.projekt.model;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import psbd.projekt.MainWindow;
import psbd.projekt.classes.Klient;
import psbd.projekt.dialogs.Rezerwacja;

/**
 *
 * @author Michal
 */
public class Hotel extends javax.swing.JPanel {

    short iloscGwiazdek;
    String nazwa;
    int id;
    ArrayList<Pokoj> pokoje = new ArrayList<>();
    JPanel p = new JPanel();
    private MainWindow parentFrame;

    /**
     * Creates new form Hotel
     */
    public Hotel(short liczbaGwiazdek, String nazwa, int id, MainWindow parentFrame) {
        initComponents();
        this.iloscGwiazdek = liczbaGwiazdek;
        this.nazwa = nazwa;
        this.id = id;
        this.parentFrame = parentFrame;

        lblNazwa.setText(nazwa);
        StringBuilder sb = new StringBuilder("Liczba gwiazdek: ");
        String str = "Liczba gwiazdek: ";
        for (int i = 0; i < liczbaGwiazdek; ++i) {
            sb.append("*");
            str += "*";
        }
        lblLiczbaGwiazdek.setText(sb.toString());
    }

    public void addPokojDoHotelu(int idPokoju, int nrPokoju, float cena, short standard, short maxOsob, short liczbaPomieszczen) {
        pokoje.add(new Pokoj(idPokoju,
                this,
                nrPokoju,
                cena,
                standard,
                maxOsob,
                liczbaPomieszczen
        ));
    }

    public int getIdHotelu() {
        return id;
    }

    public void drawPokoje() {
        int size = pokoje.size();
        Dimension dim = jspPokoje.getSize();
        jspPokoje.setSize(dim.width, size*25);
        p.setLayout(new GridLayout(size, 1));
        for (int i = 0; i < size; ++i) {
            p.add(pokoje.get(i));
        }
        jspPokoje.setViewportView(p);
    }

    public void hideRezerwuj() {
        btnRezerwuj.hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNazwa = new javax.swing.JLabel();
        lblLiczbaGwiazdek = new javax.swing.JLabel();
        btnRezerwuj = new javax.swing.JButton();
        jspPokoje = new javax.swing.JScrollPane();

        lblNazwa.setText("Nazwa");

        lblLiczbaGwiazdek.setText("Liczba gwiazdek:");

        btnRezerwuj.setText("Rezerwuj");
        btnRezerwuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezerwujActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspPokoje)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNazwa)
                        .addGap(18, 18, 18)
                        .addComponent(lblLiczbaGwiazdek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                        .addComponent(btnRezerwuj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazwa)
                    .addComponent(lblLiczbaGwiazdek)
                    .addComponent(btnRezerwuj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspPokoje, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRezerwujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezerwujActionPerformed

        if (Klient.getInstance().isZalogowany()) {
            Rezerwacja rezerwacja = new Rezerwacja(null, true, this);
            rezerwacja.setVisible(true);
            if (rezerwacja.isSucces()) {
                parentFrame.wyszukaj();
            } else {
                parentFrame.wyszukaj();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Proszę się wcześniej zalogować lub załozyć darmowe konto",
                    "Niezalogowany użytkownik!",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRezerwujActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRezerwuj;
    private javax.swing.JScrollPane jspPokoje;
    private javax.swing.JLabel lblLiczbaGwiazdek;
    private javax.swing.JLabel lblNazwa;
    // End of variables declaration//GEN-END:variables

    public Object[][] getZarezerwowanePokoje() {
        ArrayList<ArrayList<Object>> listaPokoje = new ArrayList<ArrayList<Object>>();
        for (Pokoj p : pokoje) {
            Object[] pokojDane = p.getIdileOsobArray();
            if ((int) pokojDane[1] > 0) {
                ArrayList<Object> pokoj = new ArrayList<>();
                pokoj.add(pokojDane[0]);
                pokoj.add(pokojDane[1]);
                pokoj.add(pokojDane[2]);
                listaPokoje.add(pokoj);
            }
        }
        int size = listaPokoje.size();
        Object[][] toRet = new Object[size][3];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < 3; ++j) {
                toRet[i][j] = listaPokoje.get(i).get(j);
            }
        }
        return toRet;
    }
}