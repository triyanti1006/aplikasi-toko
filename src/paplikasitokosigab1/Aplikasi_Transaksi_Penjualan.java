package paplikasitokosigab1;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.io.*;



public class Aplikasi_Transaksi_Penjualan extends javax.swing.JFrame {

    Connection c;
    ResultSet r;
    Statement s;
    private Object[][]datajual=null;
    private String[] label={"Kode Transaksi","Tanggal Transaksi","Kode Barang","Nama Barang","Harga Jual","Jumlah","Total Harga","Kode Pegawai","Nama Pegawai"};
    
    public Aplikasi_Transaksi_Penjualan() {
        initComponents();
        BukaKoneksi();
        BacaTabelPenjualan();
        tkd_trans.setVisible(true);
    
        tkd_trans.requestFocus();
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

    private void BacaTabelPenjualan(){
    try{
        
    s=c.createStatement();
    String sql="Select * FROM transaksi";
    r=s.executeQuery(sql);
    ResultSetMetaData m=r.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(r.next()){
    baris=r.getRow();
    }
    datajual=new Object[baris][kolom];
    int x=0;
    r.beforeFirst();
        while (r.next()) {            
            datajual[x][0]=r.getString("kd_trans");
            datajual[x][1]=r.getString("tgl");
            datajual[x][2]=r.getString("kd_brg");
            datajual[x][3]=r.getString("nm_brg");
            datajual[x][4]=r.getString("hrg_jual");
            datajual[x][5]=r.getString("jml");
            datajual[x][6]=r.getString("Total");
            datajual[x][7]=r.getString("kd_peg");
            datajual[x][8]=r.getString("nm_peg");
            x++;
        }
        tbl_jual.setModel(new DefaultTableModel(datajual,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
       
    
    private void SetTabel(){
        int row=tbl_jual.getSelectedRow();
        tkd_trans.setText((String)tbl_jual.getValueAt(row,0));
        ttgl.setText((String)tbl_jual.getValueAt(row,1));
        tkd_brg.setText((String)tbl_jual.getValueAt(row,2));
        tnm_brg.setText((String)tbl_jual.getValueAt(row,3));
        thrg_jual.setText((String)tbl_jual.getValueAt(row,4));
        tjml.setText((String)tbl_jual.getValueAt(row,5));
        thrg_tot.setText((String)tbl_jual.getValueAt(row,6));
        tkd_peg.setText((String)tbl_jual.getValueAt(row,7));
        tnm_peg.setText((String)tbl_jual.getValueAt(row,8));
    }
    
    private void BersihField(){
        tkd_trans.setText("");
        ttgl.setText("");
        tkd_brg.setText("");
        tnm_brg.setText("");
        thrg_jual.setText("");
        tjml.setText("");
        thrg_tot.setText("");
        tkd_peg.setText("");
        tnm_peg.setText("");
        ltot.setText("");
        tbyr.setText("");
        lkembali.setText("");
    }
    
    private void SimpanData(){
        try{
            String sql="Insert Into penjualan Values('"+tkd_trans.getText()+"','"+ttgl.getText()+"','"+tkd_brg.getText()+"','"+tjml.getText()+"','"+tkd_peg.getText()+"')";
                   
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void TambahData(){
        try{
            String sql="Insert Into jual Values('"+tkd_brg.getText()+"','"+tnm_brg.getText()+"','"+thrg_jual.getText()+"','"+tjml.getText()+"','"+thrg_tot.getText()+"','"+tkd_peg.getText()+"','"+tnm_peg.getText()+"')";
                   
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambah");
            BersihField();
            BacaTabelPenjualan();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void HapusData(){
        try{
            String sql="Delete from jual Where kd_brg='"+tkd_brg.getText()+"'";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
            BersihField();
            BacaTabelPenjualan();
        }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            }
        }
    
    
     private void total(){
         int y =0;
         int totrec=tbl_jual.getRowCount();
         for(int z=0;z<totrec;z++){
             y=y+Integer.parseInt(tbl_jual.getValueAt(z,4).toString());
             ltot.setText(String.valueOf(y));
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
        tkd_trans.requestFocus();
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
        tbl_jual = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ltot = new javax.swing.JLabel();
        tkd_trans = new javax.swing.JTextField();
        ttgl = new javax.swing.JTextField();
        tkd_brg = new javax.swing.JTextField();
        tnm_brg = new javax.swing.JTextField();
        thrg_jual = new javax.swing.JTextField();
        tjml = new javax.swing.JTextField();
        thrg_tot = new javax.swing.JTextField();
        tkd_peg = new javax.swing.JTextField();
        tnm_peg = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbyr = new javax.swing.JTextField();
        bt_total = new javax.swing.JButton();
        bt_tot = new javax.swing.JButton();
        lkembali = new javax.swing.JLabel();
        bt_kembali = new javax.swing.JButton();
        bt_tambah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_cetak = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TRANSAKSI PENJUALAN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI PENJUALAN");

        tbl_jual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Transaksi", "Tanggal Transaksi", "Kode Barang", "Nama Barang", "Harga Jual", "Jumlah", "Total Harga", "Kode Pegawai", "Nama Pegawai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_jual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jual);

        jLabel2.setText("Kode Transaksi");

        jLabel3.setText("Kode Barang");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Kode Pegawai");

        jLabel6.setText("Tanggal Transaksi");

        jLabel7.setText("Harga Jual");

        jLabel8.setText("Jumlah Jual");

        jLabel9.setText("Nama Pegawai");

        tkd_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkd_transActionPerformed(evt);
            }
        });
        tkd_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_transKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tkd_transKeyReleased(evt);
            }
        });

        ttgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ttglKeyPressed(evt);
            }
        });

        tkd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_brgKeyPressed(evt);
            }
        });

        tnm_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnm_brgKeyPressed(evt);
            }
        });

        thrg_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thrg_jualActionPerformed(evt);
            }
        });
        thrg_jual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thrg_jualKeyPressed(evt);
            }
        });

        tjml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjmlActionPerformed(evt);
            }
        });
        tjml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlKeyPressed(evt);
            }
        });

        thrg_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thrg_totActionPerformed(evt);
            }
        });

        tkd_peg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkd_pegActionPerformed(evt);
            }
        });
        tkd_peg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tkd_pegKeyPressed(evt);
            }
        });

        tnm_peg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tnm_pegKeyPressed(evt);
            }
        });

        jLabel10.setText("Pembayaran");

        bt_total.setText("Total");
        bt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_totalActionPerformed(evt);
            }
        });

        bt_tot.setText("Total Bayar");
        bt_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_totActionPerformed(evt);
            }
        });

        bt_kembali.setText("Kembali");
        bt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembaliActionPerformed(evt);
            }
        });

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_cetak.setText("Cetak");
        bt_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cetakActionPerformed(evt);
            }
        });

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tkd_trans)
                                    .addComponent(tkd_brg)
                                    .addComponent(tnm_brg)
                                    .addComponent(tkd_peg, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(bt_total)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ltot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thrg_jual)
                                    .addComponent(tjml)
                                    .addComponent(ttgl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(thrg_tot)
                                    .addComponent(tnm_peg))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_tambah))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(bt_simpan)
                                .addGap(41, 41, 41)
                                .addComponent(bt_cetak)
                                .addGap(44, 44, 44)
                                .addComponent(bt_keluar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10)
                                .addGap(34, 34, 34)
                                .addComponent(tbyr, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(tkd_trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thrg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(tnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(thrg_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_total))
                    .addComponent(ltot, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tot)
                    .addComponent(bt_tambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_kembali)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_hapus)
                        .addGap(4, 4, 4)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cetak)
                    .addComponent(bt_simpan)
                    .addComponent(bt_keluar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkd_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkd_transActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkd_transActionPerformed

    private void thrg_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thrg_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thrg_jualActionPerformed

    private void tkd_pegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkd_pegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkd_pegActionPerformed

    private void tbl_jualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jualMouseClicked
        SetTabel();
    }//GEN-LAST:event_tbl_jualMouseClicked

    private void tkd_transKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_transKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ttgl.requestFocus();
        }
    }//GEN-LAST:event_tkd_transKeyPressed

    private void ttglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttglKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tkd_brg.requestFocus();
        }
    }//GEN-LAST:event_ttglKeyPressed

    private void tkd_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_brgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tnm_brg.requestFocus();
        }
    }//GEN-LAST:event_tkd_brgKeyPressed

    private void tnm_brgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnm_brgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            thrg_jual.requestFocus();
        }
    }//GEN-LAST:event_tnm_brgKeyPressed

    private void thrg_jualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thrg_jualKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tjml.requestFocus();
        }
    }//GEN-LAST:event_thrg_jualKeyPressed

    private void tjmlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tkd_peg.requestFocus();
        }
    }//GEN-LAST:event_tjmlKeyPressed

    private void tkd_pegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_pegKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tnm_peg.requestFocus();
        }
    }//GEN-LAST:event_tkd_pegKeyPressed

    private void tnm_pegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnm_pegKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //tbyr.requestFocus();
            bt_tambahActionPerformed(new ActionEvent(c, WIDTH, null));
        }
    }//GEN-LAST:event_tnm_pegKeyPressed

    private void tkd_transKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkd_transKeyReleased
//        try{
//            Statement s=c.createStatement();
//            String search=tkd_trans.getText();
//            ResultSet r=s.executeQuery("Select * from jual where kd_trans like '%"+search+"%'");
//            DefaultTableModel dtm=(DefaultTableModel)tbl_jual.getModel();
//            dtm.setRowCount(0);
//            String [] data=new String[7];
//            int i=1;
//            while (r.next())
//            {
//                data[0]=r.getString("kd_brg");
//                data[1]=r.getString("nm_brg");
//                data[2]=r.getString("hrg_jual");
//                data[3]=r.getString("jml");
//                data[4]=r.getString("tot_harga");
//                data[5]=r.getString("kd_peg");
//                data[6]=r.getString("nm_peg");
//                dtm.addRow(data);
//                i++;
//            }
//                r.close();
//        }
//        catch (Exception e){
//            JOptionPane.showMessageDialog(null,"Data yang Anda cari tidak ditemukan");
//            System.err.println("error (search): "+e);
//        }
//            String input=tkd_trans.getText();
//        if(input.length()>10){
//            JOptionPane.showMessageDialog(rootPane,"jumlah input melebihi batas");
//            tkd_trans.setText("");
//        }
    }//GEN-LAST:event_tkd_transKeyReleased

    private void bt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_totalActionPerformed
        //bt_totalActionPerformed(evt);
    }//GEN-LAST:event_bt_totalActionPerformed

    private void tjmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjmlActionPerformed
        //tjmlActionPerformed(evt);
    }//GEN-LAST:event_tjmlActionPerformed

    private void thrg_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thrg_totActionPerformed
        //thrg_totActionPerformed(evt);
    }//GEN-LAST:event_thrg_totActionPerformed

    private void bt_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_totActionPerformed
        //bt_totActionPerformed(evt);
    }//GEN-LAST:event_bt_totActionPerformed

    private void bt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembaliActionPerformed
       //bt_kembaliActionPerformed(evt);
    }//GEN-LAST:event_bt_kembaliActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Tambah Data","Simpan",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
        SimpanData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_trans.requestFocus();
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
    tkd_trans.requestFocus();
    }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cetakActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Simpan Data","Simpan",JOptionPane.YES_NO_OPTION );
    if (confirmed == JOptionPane.YES_OPTION )
    {
       SimpanData();
    }else
    {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    tkd_trans.requestFocus();
    }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        ExitWindow();
    }//GEN-LAST:event_bt_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi_Transaksi_Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cetak;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_kembali;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton bt_tot;
    private javax.swing.JButton bt_total;
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
    private javax.swing.JLabel lkembali;
    private javax.swing.JLabel ltot;
    private javax.swing.JTable tbl_jual;
    private javax.swing.JTextField tbyr;
    private javax.swing.JTextField thrg_jual;
    private javax.swing.JTextField thrg_tot;
    private javax.swing.JTextField tjml;
    private javax.swing.JTextField tkd_brg;
    private javax.swing.JTextField tkd_peg;
    private javax.swing.JTextField tkd_trans;
    private javax.swing.JTextField tnm_brg;
    private javax.swing.JTextField tnm_peg;
    private javax.swing.JTextField ttgl;
    // End of variables declaration//GEN-END:variables
}
