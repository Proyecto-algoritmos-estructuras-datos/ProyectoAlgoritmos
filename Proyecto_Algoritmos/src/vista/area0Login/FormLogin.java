package vista.area0Login;

import controlador.CajaController;
import controlador.EmpleadoController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.Caja;
import modelo.Empleado;
import utilidades.Mensajes;
import vista.area1TomarPedido.FormTomarPedido;
import vista.area5Administracion.FormAdministracion;
import vista.area4Caja.FormCaja;

public class FormLogin extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormLogin.class.getName());
    private final EmpleadoController empleadoController;
    private final CajaController cajaController;

    FondoPanel fondo = new FondoPanel();

    public FormLogin() {
        // Controlador del empleado
        this.empleadoController = new EmpleadoController();
        this.cajaController = new CajaController();
        
        this.setContentPane(fondo);

        initComponents();

        this.setLocationRelativeTo(null); //Para centrar el Jframe
        this.requestFocusInWindow();

        System.out.println(getClass().getResource("/vista/imagenes/FLORES4.png"));
        
        
        txtDniLogin.setText("Usuario");
        txtDniLogin.setForeground(Color.decode("#666666"));

        txtContraseniaLogin.setEchoChar((char) 0);
        txtContraseniaLogin.setText("Contraseña");
        txtContraseniaLogin.setForeground(Color.GRAY);


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        btnIniciarSesionLogin = new javax.swing.JToggleButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtDniLogin = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtContraseniaLogin = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreClickenTxt(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreClicFuera(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        jPanel12.setBackground(new java.awt.Color(254, 251, 246));

        btnIniciarSesionLogin.setBackground(new java.awt.Color(182, 22, 20));
        btnIniciarSesionLogin.setFont(new java.awt.Font("Inter", 0, 11)); // NOI18N
        btnIniciarSesionLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesionLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoIniciarSesion6.png"))); // NOI18N
        btnIniciarSesionLogin.setText("   Iniciar sesión ");
        btnIniciarSesionLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesiónActionPerformed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Inter SemiBold", 0, 9)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText(" Acceso seguro al sistema");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoEscudo2.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("¡Bienvenido!");

        jLabel31.setFont(new java.awt.Font("Inter SemiBold", 0, 9)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Inicia sesión para continuar");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel11.setPreferredSize(new java.awt.Dimension(33, 35));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoUsuario2.png"))); // NOI18N

        txtDniLogin.setBackground(new java.awt.Color(255, 255, 255));
        txtDniLogin.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtDniLogin.setForeground(new java.awt.Color(51, 51, 51));
        txtDniLogin.setBorder(null);
        txtDniLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clickEnUsuario(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clickFueraUsuario(evt);
            }
        });
        txtDniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(txtDniLogin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoCandado2.png"))); // NOI18N

        txtContraseniaLogin.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseniaLogin.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtContraseniaLogin.setBorder(null);
        txtContraseniaLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clicEnConstraseña(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clicFueraContraseña(evt);
            }
        });
        txtContraseniaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContraseniaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txtContraseniaLogin))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Inter SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(96, 49, 14));
        jLabel11.setText("Sistema de Gestión");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/arrib1.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/abajo2.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/LoginMarcela6.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(98, 98, 98))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(btnIniciarSesionLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel30)
                                            .addGap(85, 85, 85))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel31)
                                            .addGap(61, 61, 61))
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))))
                            .addComponent(jLabel10))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(24, 24, 24)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnIniciarSesionLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel28)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClickenTxt(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreClickenTxt
        if (txtNombre.getText().equals("Nombre del cliente")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNombreClickenTxt

    private void txtNombreClicFuera(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreClicFuera
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Nombre del cliente");
            txtNombre.setForeground(Color.decode("#666666"));
        }
    }//GEN-LAST:event_txtNombreClicFuera

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void clicFueraContraseña(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clicFueraContraseña
        if (txtContraseniaLogin.getText().isEmpty()) {
            txtContraseniaLogin.setEchoChar((char) 0);
            txtContraseniaLogin.setText("Contraseña");
            txtContraseniaLogin.setForeground(Color.decode("#666666"));
        }
    }//GEN-LAST:event_clicFueraContraseña

    private void clicEnConstraseña(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clicEnConstraseña
        if (String.valueOf(txtContraseniaLogin.getPassword()).equals("Contraseña")) {
            txtContraseniaLogin.setText("");
            txtContraseniaLogin.setEchoChar('*');
            txtContraseniaLogin.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_clicEnConstraseña

    private void btnIniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesiónActionPerformed
      
        String dni = txtDniLogin.getText();
        String contrasenia = new String(txtContraseniaLogin.getPassword());
        
        //Para que el boton de Iniciar Sesión permanezca de color rojo
        btnIniciarSesionLogin.setContentAreaFilled(false);
        btnIniciarSesionLogin.setOpaque(true);
        btnIniciarSesionLogin.setBackground(new Color(182,22,20));
        
        try {
            Empleado empleado = empleadoController.iniciarSesionEmpleado(dni, contrasenia);
            Caja caja = cajaController.buscarCajaAbierta();
            
            switch (empleado.getRol()) {
                case "Administrador" -> {
                    new FormAdministracion(empleado).setVisible(true);
                    this.dispose();
                    
                    if (caja == null) {
                        Mensajes.aviso("No hay caja Abierta");
                    }
                    
                }
                case "Empleado" -> {
                    
                    
                    if (caja == null) {
                        new FormCaja(empleado).setVisible(true);
                        this.dispose();
                        Mensajes.aviso("No hay caja Abierta");
                    } else {
                        new FormTomarPedido(empleado).setVisible(true);
                        this.dispose();
                    }
                }
                default -> {
                    Mensajes.rolDesconocido();
                }
            }
            
            
        } catch (Exception e) {
            Mensajes.loginIncorrecto();
            
            txtDniLogin.setForeground(Color.decode("#666666"));

            txtContraseniaLogin.setForeground(Color.decode("#666666"));
            
            btnIniciarSesionLogin.setFocusable(false);
            btnIniciarSesionLogin.setBackground(new Color(182,22,20));

            // txtContraseniaLogin.setEchoChar((char) 0);
        }
        
    }//GEN-LAST:event_btnIniciarSesiónActionPerformed

    private void txtContraseniaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaLoginActionPerformed
        
    }//GEN-LAST:event_txtContraseniaLoginActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void clickFueraUsuario(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clickFueraUsuario
        if (txtDniLogin.getText().isEmpty()) {
            txtDniLogin.setText("Usuario");
            txtDniLogin.setForeground(Color.decode("#666666"));
        }
    }//GEN-LAST:event_clickFueraUsuario

    private void clickEnUsuario(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clickEnUsuario
        if (txtDniLogin.getText().equals("Usuario")) {
            txtDniLogin.setText("");
            txtDniLogin.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_clickEnUsuario

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnIniciarSesionLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtContraseniaLogin;
    private javax.swing.JTextField txtDniLogin;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            imagen = new ImageIcon(getClass().getResource("/vista/imagenes/fondoPanaderia.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

        }

    }

}
