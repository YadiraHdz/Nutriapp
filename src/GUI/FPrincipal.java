package GUI;

import Clases.Tiempo;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

public class FPrincipal extends javax.swing.JFrame implements Runnable {

    public static final String URL = "jdbc:mysql://localhost:3306/cita";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    PreparedStatement ps;
    ResultSet rs;

    Thread hilo;
    Tiempo time = new Tiempo();
    String fechaactual;
    String hora, minutos, segundos;
    DefaultTableModel modelo = new DefaultTableModel();
    Object[] A = new Object[2];

    public FPrincipal() {
        this.getContentPane().setBackground(new Color(204, 235, 208));
        initComponents();
        setLocationRelativeTo(null);
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
        mostrarTiempo();
        modelo.addColumn("Hora");
        modelo.addColumn("Nombre");
        PacienteDia();

    }

    public void mostrarTiempo() {
        Dia();
        lblFechaActual.setText(fechaactual);
        run();
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


    public void Dia() {
        // Creamos una instancia del calendario
        Calendar now = Calendar.getInstance();
        // Array con los dias de la semana
        String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miercoles",
            "Jueves", "Viernes", "Sabado"};
        // Array con los meses
        String[] strMonth = new String[]{"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        // El dia de la semana inicia en el 1 mientras que el array empieza en el 0
        fechaactual = (strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " "
                + (now.get(Calendar.DATE)) + " de "
                + strMonth[now.get(Calendar.MONTH)] + " del "
                + (now.get(Calendar.YEAR)));
    }

    public void Hora() {
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0"
                + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0"
                + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0"
                + calendario.get(Calendar.SECOND);
    }

    public void run() {
        //WHILE
        Thread current = Thread.currentThread();
        while (current == hilo) {
            Hora();
            lblHoraActual.setText(hora + ":" + minutos + ":" + segundos);
        }
    }

    public void PacienteDia() {
        Connection con = null;
        Calendar C = Calendar.getInstance();
        java.util.Date date = C.getTime();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        limpiarTabla();
        TPrincipal.setModel(modelo);

        try {
            con = getConection();
            ps = con.prepareStatement("SELECT hora,nombre FROM citas WHERE dia = ?");
            ps.setDate(1, fecha);

            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantcolum = rsMd.getColumnCount();

            while (rs.next()) {
                for (int i = 0; i < cantcolum; i++) {
                    A[i] = rs.getObject(i + 1);
                }
                modelo.addRow(A);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

    }

    public void limpiarTabla() {
        try {

            int filas = TPrincipal.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHoraActual = new java.awt.Label();
        lblFechaActual = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPrincipal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MInicio = new javax.swing.JMenu();
        MCalendario = new javax.swing.JMenu();
        MPacientes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setIconImage(getIconImage());

        lblHoraActual.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblHoraActual.setText("15:00:00");

        lblFechaActual.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFechaActual.setText("Jueves 7 de abril de 2022");

        TPrincipal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TPrincipal.setRowHeight(30);
        jScrollPane2.setViewportView(TPrincipal);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NutriappPrincipal.png"))); // NOI18N

        MInicio.setText("Inicio");
        MInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MInicioMouseClicked(evt);
            }
        });
        jMenuBar1.add(MInicio);

        MCalendario.setText("Calendario");
        MCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MCalendarioMouseClicked(evt);
            }
        });
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
                        .addGap(112, 112, 112)
                        .addComponent(lblFechaActual))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lblHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(lblFechaActual)
                        .addGap(29, 29, 29)
                        .addComponent(lblHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MInicioMouseClicked

    }//GEN-LAST:event_MInicioMouseClicked

    private void MCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MCalendarioMouseClicked
        FCalendario X = new FCalendario();
        X.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MCalendarioMouseClicked

    private void MPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MPacientesMouseClicked
        FPaciente X = new FPaciente();
        X.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MPacientesMouseClicked

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
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MCalendario;
    private javax.swing.JMenu MInicio;
    private javax.swing.JMenu MPacientes;
    private javax.swing.JTable TPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblFechaActual;
    public java.awt.Label lblHoraActual;
    // End of variables declaration//GEN-END:variables
}
