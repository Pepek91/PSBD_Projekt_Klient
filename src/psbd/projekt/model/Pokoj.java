/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psbd.projekt.model;

/**
 *
 * @author Michal
 */
public class Pokoj extends javax.swing.JPanel {

    private int id;
    private Hotel parentHotel;
    private int nrPokoju;
    private float cena;
    private short standard;
    private short maxOsob;
    private short liczbaPomieszczen;

    /**
     * 
     * @param id
     * @param parentHotel
     * @param nrPokoju
     * @param cena
     * @param standard
     * @param maxOsob
     * @param liczbaPomieszczen 
     */
    public Pokoj(int id,
            Hotel parentHotel,
            int nrPokoju,
            float cena,
            short standard,
            short maxOsob,
            short liczbaPomieszczen) {
        initComponents();
        this.id = id;
        this.parentHotel = parentHotel;
        this.nrPokoju = nrPokoju;
        this.cena = cena;
        this.standard = standard;
        this.maxOsob = maxOsob;
        this.liczbaPomieszczen = liczbaPomieszczen;
        
        lblStandard.setText(SiecHoteli.getInstance().getStandard(standard));
        lblMax.setText("/" + maxOsob);
        lblCena.setText("Cena: " + cena +" zł");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStandard = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jsLgosci = new javax.swing.JSpinner();
        lblCena = new javax.swing.JLabel();

        lblStandard.setText("Standard");

        lblMax.setText("/x");

        jLabel3.setText("Liczba osób");

        jsLgosci.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsLgosciStateChanged(evt);
            }
        });

        lblCena.setText("Cena");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblStandard, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsLgosci, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCena, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblStandard)
                .addComponent(lblMax)
                .addComponent(jLabel3)
                .addComponent(jsLgosci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCena))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jsLgosciStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsLgosciStateChanged
        if(((int)jsLgosci.getValue()) >maxOsob){
            jsLgosci.setValue((int)maxOsob);
        }else{
            if(((int)jsLgosci.getValue()) < 0){
                jsLgosci.setValue(0);
            }
        }
    }//GEN-LAST:event_jsLgosciStateChanged

    /**
     * 
     * @return Object[] 0 - id_pokoju, 1 - liczba osób, 2 - cena
     */
    public Object[] getIdileOsobArray(){
        Object[] arrayRet = {id, jsLgosci.getValue(), cena};
        return arrayRet;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jsLgosci;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblStandard;
    // End of variables declaration//GEN-END:variables
}