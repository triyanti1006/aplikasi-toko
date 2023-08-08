
package paplikasitokosigab1;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class Aplikasi_Transaksi_Pembelian extends javax.swing.JFrame {

    Connection c;
    ResultSet r;
    Statement s;
    private Object[][]datapembelian=null;
    private String[] label={"Kode Pembelian","Tanggal Pembelian","Kode Supplier","Kode Barang","Jumlah Pembelian","Harga Beli"};
   
    public Aplikasi_Transaksi_Pembelian() {
        initComponents();
        BukaKoneksi();
        BacaTabelPembelian();
        tbl_beli.setVisible(true);
    
        tkd_beli.requestFocus();
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

    private void BacaTabelPembelian(){
    try{
        
    s=c.createStatement();
    String sql="Select pembelian.kd_beli, pembelian.tgl_beli, pembelian.kd_sup, pembelian.kd_brg, pembelian.jum_beli, pembelian.hrg_beli FROM pembelian, supplier, barang Where pembelian.kd_sup=supplier.kd_sup AND pembelian.kd_brg=barang.kd_brg Order By pembelian.kd_beli";
    r=s.executeQuery(sql);
    ResultSetMetaData m=r.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(r.next()){
    baris=r.getRow();
    }
    datapembelian=new Object[baris][kolom];
    int x=0;
    r.beforeFirst();
        while (r.next()) {            
            datapembelian[x][0]=r.getString("kd_beli");
            datapembelian[x][1]=r.getString("tgl_beli");
            datapembelian[x][2]=r.getString("kd_sup");
            datapembelian[x][3]=r.getString("kd_brg");
            datapembelian[x][4]=r.getString("jum_beli");
            datapembelian[x][5]=r.getString("hrg_beli");
            x++;
        }
        tbl_beli.setModel(new DefaultTableModel(datapembelian,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    
    private void SetTabel(){
    int row=tbl_beli.getSelectedRow();
        tkd_beli.setText((String)tbl_beli.getValueAt(row,0));
        ttgl.setText((String)tbl_beli.getValueAt(row,1));
        tkd_sup.setText((String)tbl_beli.getValueAt(row,2));
        tkd_brg.setText((String)tbl_beli.getValueAt(row,3));
        tjum.setText((String)tbl_beli.getValueAt(row,4));
        thrg_beli.setText((String)tbl_beli.getValueAt(row,5));
    }
    
    private void BersihField(){
        tkd_beli.setText("");
        ttgl.setText("");
        tkd_sup.setText("");
        tkd_brg.setText("");
        tjum.setText("");
        thrg_beli.setText("");
    }
    
    
    private void SimpanData(){
        try{
            String sql="Insert Into pembelian Values('"+tkd_beli.getText()+"','"+ttgl.getText()+"','"+tkd_sup.getText()+"','"+tkd_brg.getText()+"','"+tjum.getText()+"','"+thrg_beli.getText()+"')";
                   
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambah");
            BersihField();
            BacaTabelPembelian();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    private void UpdateData(){
        try{
           String sql="Update pembelian Set pembelian.kd_beli='"+tkd_beli.getText()+"',pembelian.tgl_beli='"+ttgl.getText()+"',pembelian.kd_sup='"+tkd_sup.getText()+"',pembelian.kd_brg='"+tkd_brg.getText()+"',pembelian.jum_beli='"+tjum.getText()+"',pembelian.hrg_beli='"+thrg_beli.getText()+"'Where pembelian.kd_beli='"+tkd_beli.getText()+"'";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil diedit");
            BersihField();
            BacaTabelPembelian();
            }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
        private void HapusData(){
        try{
            String sql="Delete from pembelian Where pembelian.kd_beli='"+tkd_beli.getText()+"'";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
            BersihField();
            BacaTabelPembelian();
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
        tkd_beli.requestFocus();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_beli = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tkd_beli = new javax.swing.JTextField();
        ttgl = new javax.swing.JTextField();
        tkd_sup = new javax.swing.JTextField();
        tkd_brg = new javax.swing.JTextField();
        tjum = new javax.swing.JTextField();
        thrg_beli = new javax.swing.JTextField();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TRANSAKSI PEMBELIAN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TABEL DATA PEMBELIAN");

        tbl_beli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Beli", "Tanggal Beli", "Kode Supplier", "Kode Barang", "Jumlah Beli", "Harga Beli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_beli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_beliMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_beli);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("INPUT DATA TRANSAKSI PEMBELIAN");

        jLabel3.setText("Kode Transaksi Pembelian");

        jLabel4.setText("Tanggal Transaksi Pembelian");

        jLabel5.setText("Kode Supplier");

        jLabel6.setText("Kode Barang");

        jLabel7.setText("Jumlah Pembelian");

        jLabel8.setText("Harga Beli");

        tkd_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkd_beliActionPerformed(evt);
            }
        });
        tkd_beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_beliKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tkd_beliKeyReleased(evt);
            }
        });

        ttgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttglActionPerformed(evt);
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

        tkd_sup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_supKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tkd_supKeyReleased(evt);
            }
        });

        tkd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_brgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tkd_brgKeyReleased(evt);
            }
        });

        tjum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjumKeyPressed(evt);
            }
        });

        thrg_beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thrg_beliKeyPressed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tkd_beli)
                            .addComponent(ttgl)
                            .addComponent(tkd_sup)
                            .addComponent(tkd_brg)
                            .addComponent(tjum)
                            .addComponent(thrg_beli, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(bt_tambah)
                .addGap(99, 99, 99)
                .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(bt_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_keluar)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tkd_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tkd_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(thrg_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah)
                    .addComponent(bt_edit)
                    .addComponent(bt_hapus)
                    .addComponent(bt_keluar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkd_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkd_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkd_beliActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Edit Data","Edit",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        UpdateData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_beli.requestFocus();
    }    // TODO add your handling code here:
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Tambah Data","Simpan",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        SimpanData();
        tkd_beli.requestFocus();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_beli.requestFocus();
    }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Hapus Data","Hapus",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
       HapusData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_beli.requestFocus();
    }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        ExitWindow();
    }//GEN-LAST:event_bt_keluarActionPerformed

    private void tbl_beliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_beliMouseClicked
        SetTabel();
    }//GEN-LAST:event_tbl_beliMouseClicked

    private void tkd_beliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_beliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ttgl.requestFocus();
        }
    }//GEN-LAST:event_tkd_beliKeyPressed

    private void ttglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttglActionPerformed

    private void ttglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttglKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tkd_sup.requestFocus();
        }
    }//GEN-LAST:event_ttglKeyPressed

    private void tkd_supKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_supKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tkd_brg.requestFocus();
        }
    }//GEN-LAST:event_tkd_supKeyPressed

    private void tkd_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_brgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tjum.requestFocus();
        }
    }//GEN-LAST:event_tkd_brgKeyPressed

    private void tjumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjumKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            thrg_beli.requestFocus();
        }
    }//GEN-LAST:event_tjumKeyPressed

    private void thrg_beliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thrg_beliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //tkd_beli.requestFocus();
            bt_tambahActionPerformed(new ActionEvent(c, WIDTH, null));
        }
    }//GEN-LAST:event_thrg_beliKeyPressed

    private void ttglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttglKeyReleased
        String input=ttgl.getText();
        if(input.length()>8){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            ttgl.setText("");
        }
    }//GEN-LAST:event_ttglKeyReleased

    private void tkd_beliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_beliKeyReleased
        try{
        Statement s=c.createStatement();
            String search=tkd_beli.getText();
            ResultSet r=s.executeQuery("Select * from pembelian where kd_beli like '%"+search+"%'");
            DefaultTableModel dtm=(DefaultTableModel)tbl_beli.getModel();
            dtm.setRowCount(0);
            String [] data=new String[6];
            int i=1;
            while (r.next())
            {
                data[0]=r.getString("kd_beli");
                data[1]=r.getString("tgl_beli");
                data[2]=r.getString("kd_sup");
                data[3]=r.getString("kd_brg");
                data[4]=r.getString("jum_beli");
                data[5]=r.getString("hrg_beli");
                dtm.addRow(data);
                i++;
            }
                r.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Data yang Anda cari tidak ditemukan");
            System.err.println("error (search): "+e);
        }
            String input=tkd_beli.getText();
        if(input.length()>5){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            tkd_beli.setText("");
        }
    }//GEN-LAST:event_tkd_beliKeyReleased

    private void tkd_supKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_supKeyReleased
        String input=tkd_sup.getText();
        if(input.length()>5){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            tkd_sup.setText("");
        }
    }//GEN-LAST:event_tkd_supKeyReleased

    private void tkd_brgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_brgKeyReleased
        String input=tkd_brg.getText();
        if(input.length()>5){
            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
            tkd_brg.setText("");
        }
    }//GEN-LAST:event_tkd_brgKeyReleased

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
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Transaksi_Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbl_beli;
    private javax.swing.JTextField thrg_beli;
    private javax.swing.JTextField tjum;
    private javax.swing.JTextField tkd_beli;
    private javax.swing.JTextField tkd_brg;
    private javax.swing.JTextField tkd_sup;
    private javax.swing.JTextField ttgl;
    // End of variables declaration//GEN-END:variables
}
