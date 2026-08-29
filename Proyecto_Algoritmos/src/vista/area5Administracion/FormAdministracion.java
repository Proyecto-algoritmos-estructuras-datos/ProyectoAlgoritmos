package vista.area5Administracion;

import controlador.CajaController;
import controlador.EmpleadoController;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Caja;
import modelo.Empleado;
import utilidades.UtilLabels;
import utilidades.Mensajes;
import vista.area0Login.FormLogin;
import vista.area1TomarPedido.FormTomarPedido;
import vista.area2Historial.FormHistorial;
import vista.area3Inventario.FormInventario;
import vista.imagenes.area4Boletas.FormBoletas;
import vista.area4Caja.FormCaja;

public class FormAdministracion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAdministracion.class.getName());

    private Empleado empleado = null;
    
    // Controladores
    private final EmpleadoController empControl;
    private final CajaController cajaControl;
    
    private DefaultTableModel modelo = new DefaultTableModel();
        
    public FormAdministracion(Empleado empleado) {
        initComponents();
        
        // Asignar los datos del empleado en sesion
        this.empleado = empleado;
        
        // Se inicializa los controladores
        empControl = new EmpleadoController();
        cajaControl = new CajaController();
        UtilLabels.refrescarEstadoCaja(txtEstadoCaja, cajaControl, this);
        
        // Tabla
        tablaEmp.setModel(modelo);
        
        Object[] columnas = new Object[]{
            "ID",
            "Nombres",
            "Apellidos",
            "DNI",
            "Teléfono",
            "Dirección",
            "Rol",
            "Activo"
        };
        
        modelo.setColumnIdentifiers(columnas);
        
        tablaEmp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaEmp.setDefaultEditor(Object.class, null);
        
        // Llama a la tabla al abrir el menu de admin
        cargarTablaEmpleados("Todos","");
        
        // Datos del IGU
        txtNombresEmp.setText(empleado.getApellidos());
        lblFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        btnAdministracion.setBackground(new Color(252,231,218));
        btnAdministracion.setForeground(new Color(181,69,63));
        
    }
    
    private void deseleccionarBotonesLaterales(){
        btnTomarPedido.setBackground(new Color(253,246,240));
        btnTomarPedido.setForeground(Color.black);
        
        btnHistorial.setBackground(new Color(253,246,240));
        btnHistorial.setForeground(Color.black);
        
        btnInventario.setBackground(new Color(253,246,240));
        btnInventario.setForeground(Color.black);
        
        btnBoletas.setBackground(new Color(253,246,240));
        btnBoletas.setForeground(Color.black);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogoFlores = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblLogoMarcela = new javax.swing.JLabel();
        btnTomarPedido = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnBoletas = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        lblLogoFlores1 = new javax.swing.JLabel();
        btnAdministracion = new javax.swing.JButton();
        btnCerrarSesion2 = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cbxRoles = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        txtRol = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        txtNombresEmp = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        txtRol2 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtEstadoCaja = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscarEmp = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        cmbFiltros = new javax.swing.JComboBox<>();
        btnRestaurar = new javax.swing.JButton();

        lblLogoFlores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/FLORES4.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 246, 239));

        jLabel7.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(193, 99, 92));
        jLabel7.setText("Cajero(a):");

        jLabel17.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(193, 99, 92));
        jLabel17.setText("Rosa Isabel");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo usuario 7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel17))
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jLabel16.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("24/02/26");

        jLabel14.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha:");

        jLabel1.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Consulta y revisión de pedidos realizados");

        lblHistorial.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        lblHistorial.setForeground(new java.awt.Color(0, 0, 0));
        lblHistorial.setText("Historial");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de agregacion 2.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 246, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(152, 641));

        lblLogoMarcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/OP2.png"))); // NOI18N

        btnTomarPedido.setBackground(new java.awt.Color(253, 246, 240));
        btnTomarPedido.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnTomarPedido.setForeground(new java.awt.Color(0, 0, 0));
        btnTomarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Logo tomar pedido5.png"))); // NOI18N
        btnTomarPedido.setText("   Tomar pedido");
        btnTomarPedido.setBorder(null);
        btnTomarPedido.setBorderPainted(false);
        btnTomarPedido.setContentAreaFilled(false);
        btnTomarPedido.setFocusPainted(false);
        btnTomarPedido.setOpaque(true);
        btnTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarPedidoActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(253, 246, 240));
        btnInventario.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Logo inventario3.png"))); // NOI18N
        btnInventario.setText("  Inventario         ");
        btnInventario.setBorder(null);
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);
        btnInventario.setFocusPainted(false);
        btnInventario.setOpaque(true);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnBoletas.setBackground(new java.awt.Color(253, 246, 240));
        btnBoletas.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBoletas.setForeground(new java.awt.Color(0, 0, 0));
        btnBoletas.setBorder(null);
        btnBoletas.setBorderPainted(false);
        btnBoletas.setContentAreaFilled(false);
        btnBoletas.setFocusPainted(false);
        btnBoletas.setOpaque(true);
        btnBoletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletasActionPerformed(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(253, 246, 240));
        btnHistorial.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Logo historial 4.png"))); // NOI18N
        btnHistorial.setText("  Historial            ");
        btnHistorial.setBorder(null);
        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setFocusPainted(false);
        btnHistorial.setOpaque(true);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        lblLogoFlores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/FLORES4.png"))); // NOI18N

        btnAdministracion.setBackground(new java.awt.Color(253, 246, 240));
        btnAdministracion.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAdministracion.setForeground(new java.awt.Color(0, 0, 0));
        btnAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo Administraicon.png"))); // NOI18N
        btnAdministracion.setText("  Administración");
        btnAdministracion.setBorder(null);
        btnAdministracion.setBorderPainted(false);
        btnAdministracion.setContentAreaFilled(false);
        btnAdministracion.setFocusPainted(false);
        btnAdministracion.setOpaque(true);
        btnAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministracionActionPerformed(evt);
            }
        });

        btnCerrarSesion2.setBackground(new java.awt.Color(211, 47, 47));
        btnCerrarSesion2.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCerrarSesion2.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de SALIR 2.png"))); // NOI18N
        btnCerrarSesion2.setText("  Salir  ");
        btnCerrarSesion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesion2ActionPerformed(evt);
            }
        });

        btnCaja.setBackground(new java.awt.Color(253, 246, 240));
        btnCaja.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCaja.setForeground(new java.awt.Color(0, 0, 0));
        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/CAJA ULTIMO.png"))); // NOI18N
        btnCaja.setText("   Caja                   ");
        btnCaja.setBorder(null);
        btnCaja.setBorderPainted(false);
        btnCaja.setContentAreaFilled(false);
        btnCaja.setFocusPainted(false);
        btnCaja.setOpaque(true);
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBoletas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTomarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblLogoFlores1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(lblLogoMarcela, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblLogoMarcela, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBoletas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoFlores1))
        );

        jPanel2.setBackground(new java.awt.Color(255, 246, 241));

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nuevo personal");

        jLabel2.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel9.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel9.setText("DNI:");

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel10.setText("Contraseña:");

        jLabel11.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel11.setText("Teléfono:");

        jLabel12.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel12.setText("Dirección:");

        jLabel18.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel18.setText("Rol:");

        txtApellidos.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidos.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(102, 102, 102));

        txtNombres.setBackground(new java.awt.Color(255, 255, 255));
        txtNombres.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(102, 102, 102));

        txtDNI.setBackground(new java.awt.Color(255, 255, 255));
        txtDNI.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(102, 102, 102));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(102, 102, 102));

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(102, 102, 102));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));

        cbxRoles.setBackground(new java.awt.Color(255, 255, 255));
        cbxRoles.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxRoles.setForeground(new java.awt.Color(102, 102, 102));
        cbxRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Administrador" }));
        cbxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolesActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(102, 255, 51));
        btnAgregar.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar +");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/LOGO DE PERONSLA 3.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AFREAEG.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidos)
                            .addComponent(txtNombres)
                            .addComponent(txtContraseña)
                            .addComponent(txtDNI)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel82.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setText("Administración");

        jPanel28.setBackground(new java.awt.Color(255, 246, 239));

        txtRol.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        txtRol.setForeground(new java.awt.Color(193, 99, 92));
        txtRol.setText("Administrador(a):");

        txtNombresEmp.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtNombresEmp.setForeground(new java.awt.Color(193, 99, 92));
        txtNombresEmp.setText("Rosa Isabel");

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo usuario 7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombresEmp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRol)
                            .addComponent(txtNombresEmp))
                        .addComponent(jLabel87))
                    .addComponent(jLabel85))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFecha.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("24/02/26");

        jLabel83.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Fecha:");

        jPanel24.setBackground(new java.awt.Color(255, 246, 239));

        txtRol2.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        txtRol2.setForeground(new java.awt.Color(193, 99, 92));
        txtRol2.setText("Caja:");

        txtEstadoCaja.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtEstadoCaja.setForeground(new java.awt.Color(193, 99, 92));
        txtEstadoCaja.setText("-");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRol2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstadoCaja)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRol2)
                        .addComponent(txtEstadoCaja))
                    .addComponent(jLabel60))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 605, Short.MAX_VALUE)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(27, 27, 27)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(lblFecha))
                        .addComponent(jLabel82))
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Inter SemiBold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Lista de personal");

        lblBuscar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblBuscar.setText("Buscar:");

        txtBuscarEmp.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarEmp.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtBuscarEmp.setForeground(new java.awt.Color(102, 102, 102));

        btnBuscar.setBackground(new java.awt.Color(194, 194, 194));
        btnBuscar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaEmp.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        tablaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEmp);

        cmbFiltros.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cmbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "DNI", "Nombre", "ID", "Activos", "Inactivos" }));

        btnRestaurar.setBackground(new java.awt.Color(255, 102, 51));
        btnRestaurar.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(0, 0, 0));
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnRestaurar)
                                .addGap(3, 3, 3)))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(cmbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cmbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPedidoActionPerformed
        try {
            Caja caja = cajaControl.buscarCajaAbierta();
            
            if (caja == null) {
                boolean abrirCaja = Mensajes.confirmacion("No se puede ingresar sin una caja abierta, ¿Desea ir al menú caja para abrir una?", "No hay Caja Abierta");
                if (abrirCaja) {
                    new FormCaja(empleado).setVisible(true);
                    this.dispose();
                }
            } else {
                deseleccionarBotonesLaterales();
                btnTomarPedido.setBackground(new Color(252,231,218));
                btnTomarPedido.setForeground(new Color(181,69,63));
                new FormTomarPedido(empleado).setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            Mensajes.error("No se pudo entrar a la opción tomar pedido.");
        }
    }//GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        deseleccionarBotonesLaterales();
        btnHistorial.setBackground(new Color(252,231,218));
        btnHistorial.setForeground(new Color(181,69,63));
        new FormHistorial(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        deseleccionarBotonesLaterales();
        btnInventario.setBackground(new Color(252,231,218));
        btnInventario.setForeground(new Color(181,69,63));
        new FormInventario(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnBoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletasActionPerformed
//        deseleccionarBotonesLaterales();
//        btnBoletas.setBackground(new Color(252,231,218));
//        btnBoletas.setForeground(new Color(181,69,63));
//        new FormBoletas(empleado).setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnBoletasActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cbxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolesActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Empleado empAgregar = new Empleado();
        
        String nombres= txtNombres.getText();
        String apellidos= txtApellidos.getText();
        String dni= txtDNI.getText();
        String contrasenia= txtContraseña.getText();
        String direccion= txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String rol= cbxRoles.getSelectedItem().toString();
        
        empAgregar.setNombres(nombres);
        empAgregar.setApellidos(apellidos);
        empAgregar.setDni(dni);
        empAgregar.setContrasenia(contrasenia);
        empAgregar.setDireccion(direccion);
        empAgregar.setTelefono(telefono);
        empAgregar.setRol(rol);
        
        try {
            empControl.registrarEmpleado(empAgregar);
            Mensajes.registroGuardado();
            cargarTablaEmpleados("Todos","");
            
            txtNombres.setText("");
            txtApellidos.setText("");
            txtDNI.setText("");
            txtContraseña.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            cbxRoles.setSelectedItem("Empleado");
        
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed
        deseleccionarBotonesLaterales();
        btnAdministracion.setBackground(new Color(252,231,218));
        btnAdministracion.setForeground(new Color(181,69,63));

        
    }//GEN-LAST:event_btnAdministracionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = txtBuscarEmp.getText().trim();
        String tipoBusqueda = cmbFiltros.getSelectedItem().toString();
        cargarTablaEmpleados(tipoBusqueda, filtro);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaEmp.getSelectedRow();
        
        if (fila == -1){
            Mensajes.error("Seleccione un empleado de la tabla.");
            return;
        }
        
        int id = (int) modelo.getValueAt(fila, 0);
        boolean activo = (boolean) modelo.getValueAt(fila, 7);
        
        if (!activo) {
            Mensajes.error("El registro ya está eliminado (inactivo)");
            return;
        }
                
        boolean confirmacion = Mensajes.confirmarEliminacion();
        
        if (confirmacion) {
            try {
                empControl.cambiarEstadoEmpleado(id, false);
                Mensajes.registroEliminado();
                cargarTablaEmpleados("Todos","");
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarSesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion2ActionPerformed
        if (Mensajes.cerrarSesion()) {
            new FormLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesion2ActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        int fila = tablaEmp.getSelectedRow();
        
        if (fila == -1){
            Mensajes.error("Seleccione un empleado de la tabla.");
            return;
        }
        
        int id = (int) modelo.getValueAt(fila, 0);
        boolean activo = (boolean) modelo.getValueAt(fila, 7);
        
        if (activo) {
            Mensajes.error("El registro no está eliminado (activo)");
            return;
        }
                
        boolean confirmacion = Mensajes.confirmacion("¿Esta seguro de deshacer la eliminación?", "Restauración");
        
        if (confirmacion) {
            try {
                empControl.cambiarEstadoEmpleado(id, true);
                Mensajes.exito("Se deshizo la eliminación!");
                cargarTablaEmpleados("Todos","");
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        new FormCaja(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCajaActionPerformed

    private void cargarTablaEmpleados (String tipoBusqueda, String filtro) {
        modelo.setRowCount(0);
        
        try {
            List<Empleado> listaEmpleados;
            
            switch (tipoBusqueda) {
                case "Todos" -> {
                    listaEmpleados = empControl.verTodosLosEmpleados();
                }
                
                case "DNI" -> {
                    listaEmpleados = List.of(empControl.buscarEmpleadoPorDNI(filtro));
                }
                
                case "Nombre" -> {
                    listaEmpleados = empControl.buscarEmpleadoPorNombre(filtro);
                }
                
                case "ID" -> {
                    listaEmpleados = List.of(empControl.buscarEmpleadoPorID(filtro));
                }
                
                case "Activos" -> {
                    listaEmpleados = empControl.verEmpleadosPorEstado(true);
                }
                
                case "Inactivos" -> {
                    listaEmpleados = empControl.verEmpleadosPorEstado(false);
                }
                
                default -> {
                    listaEmpleados = empControl.verTodosLosEmpleados();
                }
            }
            
            for (Empleado emp : listaEmpleados) {
                Object[] fila = new Object[]{
                    emp.getIdEmpleado(),
                    emp.getNombres(),
                    emp.getApellidos(),
                    emp.getDni(),
                    emp.getTelefono(),
                    emp.getDireccion(),
                    emp.getRol(),
                    emp.isActivo()
                };
                
                modelo.addRow(fila);
            }
            
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBoletas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCerrarSesion2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JComboBox<String> cbxRoles;
    private javax.swing.JComboBox<String> cmbFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblLogoFlores;
    private javax.swing.JLabel lblLogoFlores1;
    private javax.swing.JLabel lblLogoMarcela;
    private javax.swing.JTable tablaEmp;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscarEmp;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtEstadoCaja;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JLabel txtNombresEmp;
    private javax.swing.JLabel txtRol;
    private javax.swing.JLabel txtRol2;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
