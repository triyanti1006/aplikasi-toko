
package paplikasitokosigab1;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class Aplikasi_Master_Pegawai extends javax.swing.JFrame {

    Connection c;
    ResultSet r;
    Statement s;
    private Object[][]datapegawai=null;
    private String[] label={"Kode Pegawai","Nama Pegawai","Tempat Lahir","Tanggal Lahir","Pendidikan","Jabatan","No Telepon","Alamat"};
   
    public Aplikasi_Master_Pegawai() {
    initComponents();
    BukaKoneksi();
    BacaTabelPegawai();
    tbl_peg.setVisible(true);
    
    tkd_peg.requestFocus();
    }
    private void BukaKoneksi(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost/db_tokosigab1","root","");
        System.out.println("Koneksi Sukses");
    }
    catch(Exception e){
    System.out.println(e);
    }
    }
    
    private void BacaTabelPegawai(){
    try{
        
    s=c.createStatement();
    String sql="Select*From pegawai Order By kd_peg";
    r=s.executeQuery(sql);
    ResultSetMetaData m=r.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(r.next()){
    baris=r.getRow();
    }
    datapegawai=new Object[baris][kolom];
    int x=0;
    r.beforeFirst();
        while (r.next()) {            
            datapegawai[x][0]=r.getString("kd_peg");
            datapegawai[x][1]=r.getString("nm_peg");
            datapegawai[x][2]=r.getString("temp_lhr");
            datapegawai[x][3]=r.getString("tgl_lahir");
            datapegawai[x][4]=r.getString("pend");
            datapegawai[x][5]=r.getString("jab");
            datapegawai[x][6]=r.getString("no_telp");
            datapegawai[x][7]=r.getString("alamat");
            x++;
        }
        tbl_peg.setModel(new DefaultTableModel(datapegawai,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
    }

    private void SetTabel(){
        int row=tbl_peg.getSelectedRow();
        tkd_peg.setText((String)tbl_peg.getValueAt(row,0));
        tnm_peg.setText((String)tbl_peg.getValueAt(row,1));
        ttemp.setText((String)tbl_peg.getValueAt(row,2));
        ttgl.setText((String)tbl_peg.getValueAt(row,3));
        cb_pend.setSelectedItem((String)tbl_peg.getValueAt(row,4));
        cb_jab.setSelectedItem((String)tbl_peg.getValueAt(row,5));
        ttelp.setText((String)tbl_peg.getValueAt(row,6));
        talm.setText((String)tbl_peg.getValueAt(row,7));
    }

    private void BersihField(){
        tkd_peg.setText("");
        tnm_peg.setText("");
        ttemp.setText("");
        ttgl.setText("");
        cb_pend.setSelectedIndex(0);
        cb_jab.setSelectedIndex(0);
        ttelp.setText("");
        talm.setText("");
    }
    
    private void SimpanData(){
        try{
            String sql="Insert Into pegawai Values('"+tkd_peg.getText()+"','"+tnm_peg.getText()+"','"+ttemp.getText()+"','"+ttgl.getText()+"','"+cb_pend.getSelectedItem()+"','"+cb_jab.getSelectedItem()+"','"+ttelp.getText()+"','"+talm.getText()+"')";
                   
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambah");
            BersihField();
            BacaTabelPegawai();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void UpdateData(){
        try{
           String sql="Update pegawai Set kd_peg='"+tkd_peg.getText()+"',nm_peg='"+tnm_peg.getText()+"',temp_lhr='"+ttemp.getText()+"',tgl_lahir='"+ttgl.getText()+"',pend='"+cb_pend.getSelectedItem()+"',jab='"+cb_jab.getSelectedItem()+"',no_telp='"+ttelp.getText()+"',alamat='"+talm.getText()+"'Where kd_peg='"+tkd_peg.getText()+"'";
           
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil diedit");
            BersihField();
            BacaTabelPegawai();
            }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
        private void HapusData(){
        try{
            String sql="Delete from pegawai where kd_peg='"+tkd_peg.getText()+"'";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
            BersihField();
            BacaTabelPegawai();
        }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            }
        }

    private void ExitWindow(){
    int confirmed = JOptionPane.showConfirmDialog(null, "Keluar Dari Program","Exit",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        dispose();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_peg.requestFocus();
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_peg = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tkd_peg = new javax.swing.JTextField();
        tnm_peg = new javax.swing.JTextField();
        ttemp = new javax.swing.JTextField();
        ttgl = new javax.swing.JTextField();
        ttelp = new javax.swing.JTextField();
        talm = new javax.swing.JTextField();
        cb_pend = new javax.swing.JComboBox();
        cb_jab = new javax.swing.JComboBox();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI MASTER PEGAWAI");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("TABEL DATA PEGAWAI");

        tbl_peg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pegawai", "Nama Pegawai", "Tempat Lahir", "Tanggal Lahir", "Pendidikan", "Jabatan", "No telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_peg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_peg);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("INPUT DATA PEGAWAI");

        jLabel3.setText("Kode Pegawai");

        jLabel4.setText("Nama Pegawai");

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Pendidikan");

        jLabel8.setText("Jabatan");

        jLabel9.setText("No Telepon");

        jLabel10.setText("Alamat");

        tkd_peg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_pegKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tkd_pegKeyReleased(evt);
            }
        });

        tnm_peg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnm_pegKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnm_pegKeyReleased(evt);
            }
        });

        ttemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttempKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttempKeyReleased(evt);
            }
        });

        ttgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttglKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttglKeyReleased(evt);
            }
        });

        ttelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttelpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttelpKeyReleased(evt);
            }
        });

        talm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                talmKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                talmKeyReleased(evt);
            }
        });

        cb_pend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SMA/K", "D3", "S1", "S2" }));
        cb_pend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pendActionPerformed(evt);
            }
        });

        cb_jab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kasir / Adm", "Kepala Toko", "Progammer", "Manager" }));
        cb_jab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_jabActionPerformed(evt);
            }
        });

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_keluar.setText("Keluar");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tkd_peg, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(tnm_peg)
                                    .addComponent(ttemp)
                                    .addComponent(ttgl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ttelp)
                                    .addComponent(talm)
                                    .addComponent(cb_pend, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_jab, 0, 158, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(bt_tambah)
                .addGap(110, 110, 110)
                .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(bt_hapus)
                .addGap(95, 95, 95)
                .addComponent(bt_keluar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_pend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cb_jab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(ttemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(talm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_edit)
                    .addComponent(bt_hapus)
                    .addComponent(bt_keluar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkd_pegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_pegKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tnm_peg.requestFocus();
        }
    }//GEN-LAST:event_tkd_pegKeyPressed

    private void tnm_pegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnm_pegKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ttemp.requestFocus();
        }
    }//GEN-LAST:event_tnm_pegKeyPressed

    private void ttempKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttempKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ttgl.requestFocus();
        }
    }//GEN-LAST:event_ttempKeyPressed

    private void ttglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttglKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ttelp.requestFocus();
        }
    }//GEN-LAST:event_ttglKeyPressed

    private void ttelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttelpKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            talm.requestFocus();
        }
    }//GEN-LAST:event_ttelpKeyPressed

    private void talmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talmKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //tkd_peg.requestFocus();
            bt_tambahActionPerformed(new ActionEvent(c, WIDTH, null));
        }
    }//GEN-LAST:event_talmKeyPressed

    private void tkd_pegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_pegKeyReleased
       try{
            Statement s=c.createStatement();
            String search=tkd_peg.getText();
            ResultSet r=s.executeQuery("Select * from pegawai where kd_peg like '%"+search+"%'");
            DefaultTableModel dtm=(DefaultTableModel)tbl_peg.getModel();
            dtm.setRowCount(0);
            String [] data=new String[8];
            int i=1;
            while (r.next())
            {
                data[0]=r.getString("kd_peg");
                data[1]=r.getString("nm_peg");
                data[2]=r.getString("temp_lhr");
                data[3]=r.getString("tgl_lahir");
                data[4]=r.getString("pend");
                data[5]=r.getString("jab");
                data[6]=r.getString("no_telp");
                data[7]=r.getString("alamat");
                dtm.addRow(data);
                i++;
            }
                r.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Data yang Anda cari tidak ditemukan");
            System.err.println("error (search): "+e);
        }
            String input=tkd_peg.getText();
        if(input.length()>10){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            tkd_peg.setText("");
        }
    }//GEN-LAST:event_tkd_pegKeyReleased

    private void tnm_pegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnm_pegKeyReleased
        String input=tnm_peg.getText();
        if(input.length()>30){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            tnm_peg.setText("");
        }
    }//GEN-LAST:event_tnm_pegKeyReleased

    private void ttempKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttempKeyReleased
        String input=ttemp.getText();
        if(input.length()>20){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            ttemp.setText("");
        }
    }//GEN-LAST:event_ttempKeyReleased

    private void ttglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttglKeyReleased
       String input=ttgl.getText();
        if(input.length()>8){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            ttgl.setText("");
        }
    }//GEN-LAST:event_ttglKeyReleased

    private void ttelpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttelpKeyReleased
        String input=ttelp.getText();
        if(input.length()>15){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            ttelp.setText("");
        }
    }//GEN-LAST:event_ttelpKeyReleased

    private void talmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_talmKeyReleased
        String input=talm.getText();
        if(input.length()>50){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            talm.setText("");
        }
    }//GEN-LAST:event_talmKeyReleased

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Tambah Data","Simpan",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        SimpanData();
        tkd_peg.requestFocus();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_peg.requestFocus();
    }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Edit Data","Edit",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        UpdateData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_peg.requestFocus();
    }
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Hapus Data","Hapus",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
       HapusData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_peg.requestFocus();
    }  
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        ExitWindow();
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void cb_pendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pendActionPerformed

    private void cb_jabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_jabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_jabActionPerformed

    private void tbl_pegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pegMouseClicked
        SetTabel();
    }//GEN-LAST:event_tbl_pegMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                       
        ExitWindow();
    }      
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
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Master_Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JComboBox cb_jab;
    private javax.swing.JComboBox cb_pend;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField talm;
    private javax.swing.JTable tbl_peg;
    private javax.swing.JTextField tkd_peg;
    private javax.swing.JTextField tnm_peg;
    private javax.swing.JTextField ttelp;
    private javax.swing.JTextField ttemp;
    private javax.swing.JTextField ttgl;
    // End of variables declaration//GEN-END:variables
}
