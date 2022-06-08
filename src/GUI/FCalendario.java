package GUI;

import static GUI.FAgrePaciente.PASSWORD;
import static GUI.FAgrePaciente.URL;
import static GUI.FAgrePaciente.USERNAME;
import static GUI.FAgrePaciente.getConection;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FCalendario extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/cita";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    PreparedStatement ps;
    ResultSet rs;
    
    String auxHoraT="00";
    String idcitaE,diaE,horaE;
    
    private int seleccionFila=0;

    DefaultTableModel modelo = new DefaultTableModel();
    Object[] B = new Object[2];

    public FCalendario() {
        this.getContentPane().setBackground(new Color(204, 235, 208));
        initComponents();
        setLocationRelativeTo(null);
        modelo.addColumn("Hora");
        modelo.addColumn("Nombre");

    }

    //Para la conexion de a la Base de Datos
    public static Connection getConection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public void sacarid(){
        //Para crear una id para la cita
        java.util.Date date = Calendario.getDate();
        long d = date.getTime();
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fechaa = sdf.format(date);
        String auxh1=auxHoraT.substring(0, 2);
        idcitaE = fechaa + auxh1;
        
    }
    public void sacardia(){
        java.util.Date date = Calendario.getDate();
        long d = date.getTime();
       
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaa = sdf.format(date);
        diaE = fechaa;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Calendario = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        TCalendario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MInicio = new javax.swing.JMenu();
        MCalendario = new javax.swing.JMenu();
        MPacientes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendario");
        setIconImage(getIconImage());
        setResizable(false);

        Calendario.setBackground(new java.awt.Color(195, 231, 232));
        Calendario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarioMouseClicked(evt);
            }
        });
        Calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioPropertyChange(evt);
            }
        });

        TCalendario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TCalendario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Hora", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TCalendario.setGridColor(new java.awt.Color(225, 243, 244));
        TCalendario.setRowHeight(20);
        TCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TCalendarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TCalendario);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NutriappCalendario.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnEliminar.setBackground(new java.awt.Color(148, 185, 185));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgendar.setBackground(new java.awt.Color(148, 185, 185));
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        MInicio.setText("Inicio");
        MInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MInicioMouseClicked(evt);
            }
        });
        jMenuBar1.add(MInicio);

        MCalendario.setText("Calendario");
        jMenuBar1.add(MCalendario);

        MPacientes.setText("Pacientes");
        MPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MPacientesMouseClicked(evt);
            }
        });
        jMenuBar1.add(MPacientes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPacientesMouseClicked
        FPaciente X = new FPaciente();
        X.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MPacientesMouseClicked

    private void MInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MInicioMouseClicked
        FPrincipal X = new FPrincipal();
        X.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MInicioMouseClicked

    private void CalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarioMouseClicked

    }//GEN-LAST:event_CalendarioMouseClicked

    private void CalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioPropertyChange
        Connection con = null;
        java.util.Date date = Calendario.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        limpiarTabla();
        TCalendario.setModel(modelo);

        try {
            con = getConection();
            ps = con.prepareStatement("SELECT hora,nombre FROM citas WHERE dia = ?");
            ps.setDate(1, fecha);

            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantcolum = rsMd.getColumnCount();

            while (rs.next()) {
                for (int i = 0; i < cantcolum; i++) {
                    B[i] = rs.getObject(i + 1);
                }
                modelo.addRow(B);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

    }//GEN-LAST:event_CalendarioPropertyChange

    private void TCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TCalendarioMouseClicked
        seleccionFila = TCalendario.rowAtPoint(evt.getPoint());
        auxHoraT = (String.valueOf(TCalendario.getValueAt(seleccionFila, 0)));
        
        
    }//GEN-LAST:event_TCalendarioMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        sacarid();
        sacardia();
        int i = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar la cita del \n dia: "+ diaE+
                "\nhora: "+auxHoraT);
        //i = 0 Si elimina la cita
        if(i == 0){
            Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement("DELETE FROM citas WHERE idcitas = ?");
            ps.setString(1, idcitaE);

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cita Eliminada");
            } else {
                
            }
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        }
        //i = 1 No elimina la cita
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        FAgendarCita X = new FAgendarCita();
        X.setVisible(true);
    }//GEN-LAST:event_btnAgendarActionPerformed

    public void limpiarTabla() {
        try {

            int filas = TCalendario.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            
        }
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
            java.util.logging.Logger.getLogger(FCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCalendario().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendario;
    private javax.swing.JMenu MCalendario;
    private javax.swing.JMenu MInicio;
    private javax.swing.JMenu MPacientes;
    private javax.swing.JTable TCalendario;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
