package vista.area4Caja;

import controlador.CajaController;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Caja;
import modelo.Empleado;
import utilidades.Constantes;
import utilidades.Mensajes;
import utilidades.UtilLabels;
import vista.area0Login.FormLogin;
import vista.area1TomarPedido.FormTomarPedido;
import vista.area2Historial.FormHistorial;
import vista.area3Inventario.FormInventario;
import vista.imagenes.area4Boletas.FormBoletas;
import vista.area5Administracion.FormAdministracion;

public final class FormCaja extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCaja.class.getName());

    Empleado empleado = null;
    
    // Controladores
    private CajaController cajaControl;
            
    private DefaultTableModel modelo = new DefaultTableModel();
    List<Caja> listaCajas = new ArrayList<>();

    // Tipo de rol asignado (va junto al nombre del empleado)
    private String adminLabel = "Administrador(a):";
    private String empleadoLabel = "Empleado(a):";
    
    public FormCaja(Empleado empleado) {
        initComponents();
        
        // Asignar los datos del empleado en sesion
        this.empleado = empleado;
        
        
        // Se inicializa los controladores
        cajaControl = new CajaController();
        UtilLabels.refrescarEstadoCaja(txtEstadoCaja, cajaControl, this);
        
        // Tabla
        tablaCajas.setModel(modelo);
        
        Object[] columnas = new Object[]{
            "Id",
            "Empleado Apertura",
            "Empleado Cierre",
            "Fecha",
            "Hora Apertura",
            "Hora Cierre",
            "Monoto Apertura",
            "Monto Cierre",
            "Estado"
        };
        
        modelo.setColumnIdentifiers(columnas);
        
        tablaCajas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCajas.setDefaultEditor(Object.class, null);
        
        // Extras
        txtNombresEmp.setText(empleado.getApellidos());
        lblFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        btnCaja.setBackground(new Color(252, 231, 218));
        btnCaja.setForeground(new Color(181, 69, 63));

        switch (empleado.getRol()) {
            case "Administrador" -> {
                txtRol.setText(adminLabel);
            }
            case "Empleado" -> {
                txtRol.setText(empleadoLabel);
                btnAdministracion.setVisible(false);
            }
            default -> {
                Mensajes.rolDesconocido();
            }
        }
        
        

    }

    private void deseleccionarBotonesLaterales() {
        btnTomarPedido.setBackground(new Color(253, 246, 240));
        btnTomarPedido.setForeground(Color.black);

        btnHistorial.setBackground(new Color(253, 246, 240));
        btnHistorial.setForeground(Color.black);

        btnInventario.setBackground(new Color(253, 246, 240));
        btnInventario.setForeground(Color.black);

        btnBoletas.setBackground(new Color(253, 246, 240));
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
        btnCerrarSesion1 = new javax.swing.JButton();
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
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtFechaInicio = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtFechaFin = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAbrirCaja = new javax.swing.JButton();
        btnCerrarCaja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCajas = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtRol = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtNombresEmp = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtRol1 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtEstadoCaja = new javax.swing.JLabel();

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

        btnCerrarSesion1.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrarSesion1.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCerrarSesion1.setText("Cerrar sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(lblLogoMarcela, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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
                .addGap(36, 36, 36)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoFlores1))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(639, 565));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(204, 0, 0));
        lblProductos.setText("Opción de Cajas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Inicio");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtFechaInicio.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtFechaInicio.setForeground(new java.awt.Color(102, 102, 102));
        txtFechaInicio.setBorder(null);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo lupa 2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFechaInicio)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnLimpiar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo escoba 2.png"))); // NOI18N
        btnLimpiar.setText("  Limpiar  ");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar Cajas");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtFechaFin.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtFechaFin.setForeground(new java.awt.Color(102, 102, 102));
        txtFechaFin.setBorder(null);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo lupa 2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFechaFin)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel4.setText("Fecha fin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        btnAbrirCaja.setBackground(new java.awt.Color(0, 255, 0));
        btnAbrirCaja.setFont(new java.awt.Font("Inter SemiBold", 0, 13)); // NOI18N
        btnAbrirCaja.setForeground(new java.awt.Color(0, 0, 0));
        btnAbrirCaja.setText("+   Abrir una Nueva Caja");
        btnAbrirCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCajaActionPerformed(evt);
            }
        });

        btnCerrarCaja.setBackground(new java.awt.Color(255, 153, 51));
        btnCerrarCaja.setFont(new java.awt.Font("Inter SemiBold", 0, 13)); // NOI18N
        btnCerrarCaja.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarCaja.setText("-   Cerrar la Caja Actual ");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });

        tablaCajas.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tablaCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCajas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(btnAbrirCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrirCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Caja");

        jLabel55.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Fecha:");

        jPanel22.setBackground(new java.awt.Color(255, 246, 239));

        txtRol.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        txtRol.setForeground(new java.awt.Color(193, 99, 92));
        txtRol.setText("Cajero(a):");

        txtNombresEmp.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtNombresEmp.setForeground(new java.awt.Color(193, 99, 92));
        txtNombresEmp.setText("Rosa Isabel");

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo usuario 7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombresEmp)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRol)
                            .addComponent(txtNombresEmp))
                        .addComponent(jLabel66))
                    .addComponent(jLabel57))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFecha.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("24/02/26");

        jPanel23.setBackground(new java.awt.Color(255, 246, 239));

        txtRol1.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        txtRol1.setForeground(new java.awt.Color(193, 99, 92));
        txtRol1.setText("Caja:");

        txtEstadoCaja.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtEstadoCaja.setForeground(new java.awt.Color(193, 99, 92));
        txtEstadoCaja.setText("-");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRol1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstadoCaja)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRol1)
                        .addComponent(txtEstadoCaja))
                    .addComponent(jLabel58))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(38, 38, 38)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(lblFecha))
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
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
        btnHistorial.setBackground(new Color(252, 231, 218));
        btnHistorial.setForeground(new Color(181, 69, 63));
        new FormHistorial(empleado).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        deseleccionarBotonesLaterales();
        btnInventario.setBackground(new Color(252, 231, 218));
        btnInventario.setForeground(new Color(181, 69, 63));
        new FormInventario(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnBoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletasActionPerformed
//        deseleccionarBotonesLaterales();
//        btnBoletas.setBackground(new Color(252, 231, 218));
//        btnBoletas.setForeground(new Color(181, 69, 63));
//        new FormBoletas(empleado).setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnBoletasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAbrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCajaActionPerformed
        try {
            Caja cajaAbierta = cajaControl.buscarCajaAbierta();
            
            if (cajaAbierta == null) {
                boolean respuesta = Mensajes.confirmacion("¿Está seguro que desea abrir una caja nueva?", "Apertura de Caja");

                if (!respuesta) {
                    return;
                }
                
                Caja caja = new Caja();
                caja.setEmpleadoApertura(empleado);
                caja.setFecha(LocalDate.now());
                caja.setHoraApertura(LocalTime.now());
                caja.setMontoApertura(Constantes.MONTO_APERTURA_FIJO);
                
                cajaControl.abrirCaja(caja);
                
                Mensajes.exito("La caja se ha abierto exitosamente!");
                UtilLabels.refrescarEstadoCaja(txtEstadoCaja, cajaControl, this);
                
                cargarTablaCajas("1999-01-01", LocalDate.now().toString());
            } else {
                Mensajes.aviso("Ya hay una caja abierta!");
            }
        } catch (Exception e) {
            Mensajes.error("No se pudo abrir la caja: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnAbrirCajaActionPerformed

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        try {
            Caja cajaAbierta = cajaControl.buscarCajaAbierta();
            
            if (cajaAbierta != null) {
                boolean respuesta = Mensajes.confirmacion("¿Está seguro que desea cerrar la caja actual?", "Cierre de Caja");

                if (!respuesta) {
                    return;
                }
                cajaControl.cerrarCaja(empleado);
                
                Mensajes.exito("La caja se ha cerrado exitosamente!");
                UtilLabels.refrescarEstadoCaja(txtEstadoCaja, cajaControl, this);
                
                cargarTablaCajas("1999-01-01", LocalDate.now().toString());
            } else {
                Mensajes.aviso("No hay una caja abierta!");
            }
        } catch (Exception e) {
            Mensajes.error("No se pudo cerrar la caja: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed

        switch (empleado.getRol()) {
            case "Administrador" -> {
                new FormAdministracion(empleado).setVisible(true);
                this.dispose();
            }
            case "Empleado" -> {
                // Si el rol es de empleado no va a abrir nada
            }
            default -> {
                Mensajes.rolDesconocido();
            }
        }

    }//GEN-LAST:event_btnAdministracionActionPerformed

    private void btnCerrarSesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion2ActionPerformed
        if (Mensajes.cerrarSesion()) {
            new FormLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesion2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            String fechaInicio;
            String fechaCierre;

            if (txtFechaInicio.getText().isEmpty()) {
                fechaInicio = "1999-01-01";
            } else {
                fechaInicio = txtFechaInicio.getText().trim();
            }

            if (txtFechaFin.getText().isEmpty()) {
                fechaCierre = LocalDate.now().toString();
            } else {
                fechaCierre = txtFechaFin.getText().trim();
            }

            cargarTablaCajas(fechaInicio, fechaCierre);
        } catch (Exception e) {
            Mensajes.error("El formato de fecha es: yyyy-mm-dd");
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablaCajas("1999-01-01", LocalDate.now().toString());
    }//GEN-LAST:event_formWindowOpened

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed

        new FormCaja(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCajaActionPerformed

    protected void cargarTablaCajas (String fechaInicio, String fechaCierre) {
        modelo.setRowCount(0);
        LocalDate fechaInicioLocal = LocalDate.parse(fechaInicio);
        LocalDate fechaFinLocal = LocalDate.parse(fechaCierre);

        switch (empleado.getRol()) {
            case "Administrador" -> {
                try {
                    listaCajas = cajaControl.buscarCajasPorRangoDeFechas(fechaInicioLocal, fechaFinLocal);
                    for (Caja caja : listaCajas) {
                        Object[] fila = new Object[]{
                            caja.getIdCaja(),
                            caja.getEmpleadoApertura().getApellidos(),
                            caja.getEmpleadoCierre() != null ? caja.getEmpleadoCierre().getApellidos() : "-",
                            caja.getFecha(),
                            caja.getHoraApertura(),
                            caja.getHoraCierre(),
                            caja.getMontoApertura(),
                            caja.getMontoCierre(),
                            caja.getEstado()
                        };
                        modelo.addRow(fila);
                    }
                } catch (Exception e) {
                    Mensajes.error(e.getMessage());
                }
            }
            case "Empleado" -> {
                try {
                    listaCajas = cajaControl.buscarCajaPorEstado("Abierta");
                    for (Caja caja : listaCajas) {
                        Object[] fila = new Object[]{
                            caja.getIdCaja(),
                            caja.getEmpleadoApertura().getApellidos(),
                            caja.getEmpleadoCierre() != null ? caja.getEmpleadoCierre().getApellidos() : "-",
                            caja.getFecha(),
                            caja.getHoraApertura(),
                            caja.getHoraCierre(),
                            caja.getMontoApertura(),
                            caja.getMontoCierre(),
                            caja.getEstado()
                        };
                        modelo.addRow(fila);
                    }
                } catch (Exception e) {
                    Mensajes.error(e.getMessage());
                }
            }
            default -> {
                Mensajes.rolDesconocido();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCaja;
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnBoletas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnCerrarSesion1;
    private javax.swing.JButton btnCerrarSesion2;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblLogoFlores;
    private javax.swing.JLabel lblLogoFlores1;
    private javax.swing.JLabel lblLogoMarcela;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JTable tablaCajas;
    private javax.swing.JLabel txtEstadoCaja;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JLabel txtNombresEmp;
    private javax.swing.JLabel txtRol;
    private javax.swing.JLabel txtRol1;
    // End of variables declaration//GEN-END:variables
}
