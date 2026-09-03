package vista.area1TomarPedido;

import controlador.CajaController;
import controlador.PedidoController;
import controlador.ProductoController;
import controlador.VentaController;
import dao.ProductoDAO;
import interfaces.IProductoDAO;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import modelo.Caja;
import modelo.Empleado;
import modelo.Producto;
import modelo.Venta;
import utilidades._ItemCarrito;
import utilidades.Mensajes;
import utilidades.UtilLabels;
import vista.area0Login.FormLogin;
import vista.area2Historial.FormHistorial;
import vista.area3Inventario.FormInventario;
import vista.area5Administracion.FormAdministracion;
import vista.area4Caja.FormCaja;

public final class FormTomarPedido extends javax.swing.JFrame {
    
    Empleado empleado = null;
    
    // Controladores
    private ProductoController prodControl;
    private CajaController cajaControl;
    private PedidoController pedidoController;
    
    // Tipo de rol asignado (va junto al nombre del empleado)
    private String adminLabel = "Administrador(a):";
    private String empleadoLabel = "Empleado(a):";
    
    // Lista de los productos para mostrar
    List<Producto> listaProductos = new ArrayList<>();
    
    // Stock original cargado al inicio, usado para calcular stock visual sin volver a consultar la BD
    Map<Integer, Integer> productosOriginales = new HashMap<>();
    
    // Modelo de tablas
    DefaultTableModel modeloTblProducto = new DefaultTableModel();
    DefaultTableModel modeloTblCarrito = new DefaultTableModel();

    // Guarda el tipo de despacho del botón seleccionado
    private String tipoDespachoSeleccionado = null;
    
    public FormTomarPedido(Empleado empleado) {
        initComponents();
        this.empleado = empleado;
        
        // Se inicializa los controladores
        prodControl = new ProductoController();
        cajaControl = new CajaController();
        IProductoDAO productoDAO = new ProductoDAO();
        pedidoController = new PedidoController(productoDAO);
        
        UtilLabels.refrescarEstadoCaja(txtEstadoCaja, cajaControl, this);
        
        // Se asigna el modelo a su tabla respectiva
        tablaProductos.setModel(modeloTblProducto);
        tablaCarrito.setModel(modeloTblCarrito);
        
        // Columna de las tablas
        Object[] columnasProductos = new Object[]{
            "ID",
            "Nombre",
            "Categoria",
            "Stock",
            "Precio",
            "Unid. Medida",
            "Activo"
        };
        
        Object[] columnasCarrito = new Object[]{
            "ID",
            "Nombre",
            "Categoria",
            "Cantidad",
            "Precio",
            "Unid. Medida",
            "Total"
        };
        
        // Seteo de las columnas a los modelos
        modeloTblProducto.setColumnIdentifiers(columnasProductos);
        modeloTblCarrito.setColumnIdentifiers(columnasCarrito);
        
        // Los hacemos no editables y que solo se pueda seleccionar una a la vez
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setDefaultEditor(Object.class, null);
        tablaCarrito.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCarrito.setDefaultEditor(Object.class, null);
        
        // Llamado a carga tabla productos
        cargarTablaProductos(null, null, "Todos", null, null);
        
        // 
        txtNombresEmp.setText(empleado.getApellidos());
        lblFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        btnTomarPedido.setBackground(new Color(252,231,218));
        btnTomarPedido.setForeground(new Color(181,69,63));
        
        btnAqui.setBackground(Color.decode("#962E2B"));
        btnAqui.setForeground(Color.WHITE);
        
        
        txtNotas.setText("Notas(sin azúcar, caliente,etc)");
        txtNotas.setForeground(Color.decode("#90929B"));
        
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

    
    //Método para deseleccionar 
    private void deseleccionarBotonesLaterales(){
        btnTomarPedido.setBackground(new Color(253,246,240));
        btnTomarPedido.setForeground(Color.black);
        
        btnHistorial.setBackground(new Color(253,246,240));
        btnHistorial.setForeground(Color.black);
        
        btnInventario.setBackground(new Color(253,246,240));
        btnInventario.setForeground(Color.black);
        
        btnBoletas.setBackground(new Color(253,246,240));
        btnBoletas.setForeground(Color.black);
        
        btnAdministracion.setBackground(new Color(253,246,240));
        btnAdministracion.setForeground(Color.black);

        
    }
    
    private void deseleccionarBotonesDespacho(){
        btnAqui.setBackground(Color.white);
        btnAqui.setForeground(Color.black);
        
        btnLlevar.setBackground(Color.white);
        btnLlevar.setForeground(Color.black);
        
        btnDelivery.setBackground(Color.white);
        btnDelivery.setForeground(Color.black);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtNombre2 = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlBarraLateral = new javax.swing.JPanel();
        btnHistorial = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnBoletas = new javax.swing.JButton();
        lblLogoMarcela = new javax.swing.JLabel();
        btnTomarPedido = new javax.swing.JButton();
        lblLogoFlores = new javax.swing.JLabel();
        btnAdministracion = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        pnlCentral = new javax.swing.JPanel();
        lblCantidad1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pnlSuperior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbEstadoStock = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioMin = new javax.swing.JTextField();
        txtPrecioMax = new javax.swing.JTextField();
        pnlDerecho = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnGenerarPedido = new javax.swing.JButton();
        pnlCalculoSuma = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        pnlSuma = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblCantidad2 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnAqui = new javax.swing.JButton();
        btnLlevar = new javax.swing.JButton();
        btnDelivery = new javax.swing.JButton();
        txtCantidad2 = new javax.swing.JTextField();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtRol = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtNombresEmp = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtRol1 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtEstadoCaja = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        txtNombre1.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre1.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtNombre1.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre1ClickenTxt(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre1ClicFuera(evt);
            }
        });
        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
            }
        });

        txtNombre2.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre2.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtNombre2.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre2ClickenTxt(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre2ClicFuera(evt);
            }
        });
        txtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 750));
        setResizable(false);

        pnlBarraLateral.setBackground(new java.awt.Color(255, 246, 239));

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

        lblLogoFlores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/FLORES4.png"))); // NOI18N

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

        btnCerrarSesion.setBackground(new java.awt.Color(211, 47, 47));
        btnCerrarSesion.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de SALIR 2.png"))); // NOI18N
        btnCerrarSesion.setText("  Salir  ");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
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

        javax.swing.GroupLayout pnlBarraLateralLayout = new javax.swing.GroupLayout(pnlBarraLateral);
        pnlBarraLateral.setLayout(pnlBarraLateralLayout);
        pnlBarraLateralLayout.setHorizontalGroup(
            pnlBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBoletas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTomarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBarraLateralLayout.createSequentialGroup()
                .addComponent(lblLogoFlores)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBarraLateralLayout.createSequentialGroup()
                .addGroup(pnlBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBarraLateralLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblLogoMarcela, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBarraLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBarraLateralLayout.setVerticalGroup(
            pnlBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraLateralLayout.createSequentialGroup()
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
                .addGap(35, 35, 35)
                .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoFlores))
        );

        pnlCentral.setBackground(new java.awt.Color(255, 255, 255));
        pnlCentral.setPreferredSize(new java.awt.Dimension(398, 500));

        lblCantidad1.setFont(new java.awt.Font("Inter SemiBold", 0, 16)); // NOI18N
        lblCantidad1.setText("Cant:");

        btnAgregar.setBackground(new java.awt.Color(240, 240, 240));
        btnAgregar.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar ");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePresionado(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAgregarMouseSuelto(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de agregacion 2.png"))); // NOI18N

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(440, 35));

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        tablaProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProductos);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel13.setForeground(new java.awt.Color(153, 153, 153));
        jPanel13.setPreferredSize(new java.awt.Dimension(400, 30));

        jLabel19.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel19.setText("Buscar producto:");

        jLabel20.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel20.setText("Categoría:");

        jLabel27.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel27.setText("Estado de Stock:");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtBuscarProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtBuscarProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscarProducto.setBorder(null);
        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo lupa 2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cmbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cmbCategoria.setFont(new java.awt.Font("Inter", 0, 11)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Panes", "Bocaditos", "Bebidas", "Tortas" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        cmbEstadoStock.setBackground(new java.awt.Color(255, 255, 255));
        cmbEstadoStock.setFont(new java.awt.Font("Inter", 0, 11)); // NOI18N
        cmbEstadoStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Suficiente", "Bajo", "Sin stock" }));
        cmbEstadoStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoStockActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo escoba 2.png"))); // NOI18N
        btnLimpiar.setText("  Limpiar  ");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel13.setText("Precio Mínimo:");

        jLabel15.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel15.setText("Precio Máximo:");

        txtPrecioMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(cmbEstadoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(39, 39, 39)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstadoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblCantidad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(1123, 1123, 1123)
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidad1)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pnlDerecho.setBackground(new java.awt.Color(255, 246, 239));
        pnlDerecho.setPreferredSize(new java.awt.Dimension(100, 500));

        jLabel6.setFont(new java.awt.Font("Inter SemiBold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Pedido ");

        btnGenerarPedido.setBackground(new java.awt.Color(182, 20, 22));
        btnGenerarPedido.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnGenerarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPedido.setText("GENERAR PEDIDO");
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        jLabel21.setText("Subtotal:");

        jLabel22.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        jLabel22.setText("IGV (18%):");

        lblSubtotal.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lblSubtotal.setText("s/0.00");

        lblIGV.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lblIGV.setText("s/0.00");

        javax.swing.GroupLayout pnlCalculoSumaLayout = new javax.swing.GroupLayout(pnlCalculoSuma);
        pnlCalculoSuma.setLayout(pnlCalculoSumaLayout);
        pnlCalculoSumaLayout.setHorizontalGroup(
            pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalculoSumaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIGV, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );
        pnlCalculoSumaLayout.setVerticalGroup(
            pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalculoSumaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblSubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCalculoSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblIGV))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        lblTotal.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 0, 0));
        lblTotal.setText("s/ 0.00");

        jLabel25.setFont(new java.awt.Font("Inter SemiBold", 0, 15)); // NOI18N
        jLabel25.setText(" Total:");

        javax.swing.GroupLayout pnlSumaLayout = new javax.swing.GroupLayout(pnlSuma);
        pnlSuma.setLayout(pnlSumaLayout);
        pnlSumaLayout.setHorizontalGroup(
            pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(14, 14, 14))
        );
        pnlSumaLayout.setVerticalGroup(
            pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSumaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblCantidad2.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblCantidad2.setText("Cant.:");

        btnEditar.setBackground(new java.awt.Color(255, 204, 102));
        btnEditar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAqui.setBackground(new java.awt.Color(252, 245, 239));
        btnAqui.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAqui.setForeground(new java.awt.Color(0, 0, 0));
        btnAqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de la tienda.png"))); // NOI18N
        btnAqui.setText(" Aquí  ");
        btnAqui.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAqui.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAquiActionPerformed(evt);
            }
        });

        btnLlevar.setBackground(new java.awt.Color(252, 245, 239));
        btnLlevar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnLlevar.setForeground(new java.awt.Color(0, 0, 0));
        btnLlevar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo de llevar.png"))); // NOI18N
        btnLlevar.setText(" Llevar");
        btnLlevar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLlevar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLlevar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlevarActionPerformed(evt);
            }
        });

        btnDelivery.setBackground(new java.awt.Color(252, 245, 239));
        btnDelivery.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnDelivery.setForeground(new java.awt.Color(0, 0, 0));
        btnDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo delivery 2.png"))); // NOI18N
        btnDelivery.setText("Delivery");
        btnDelivery.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelivery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        cmbMetodoPago.setBackground(new java.awt.Color(255, 255, 255));
        cmbMetodoPago.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Yape", "Tarjeta" }));
        cmbMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoPagoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel1.setText("Método de pago:");

        tablaCarrito.setFont(new java.awt.Font("Inter SemiBold", 0, 11)); // NOI18N
        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaCarrito);

        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Inter SemiBold", 0, 13)); // NOI18N
        txtNotas.setForeground(new java.awt.Color(102, 102, 102));
        txtNotas.setRows(5);
        txtNotas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNotasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNotasFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(txtNotas);

        jLabel29.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel29.setText("Despacho:");

        javax.swing.GroupLayout pnlDerechoLayout = new javax.swing.GroupLayout(pnlDerecho);
        pnlDerecho.setLayout(pnlDerechoLayout);
        pnlDerechoLayout.setHorizontalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCalculoSuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSuma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDerechoLayout.createSequentialGroup()
                        .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDerechoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDerechoLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblCantidad2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlDerechoLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(btnAqui, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLlevar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGenerarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        pnlDerechoLayout.setVerticalGroup(
            pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDerechoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLlevar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAqui, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelivery)))
                    .addGroup(pnlDerechoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel29)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad2)
                    .addComponent(btnEditar)
                    .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(pnlCalculoSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnGenerarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nuevo pedido");

        lblFecha.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("24/02/26");

        jLabel14.setFont(new java.awt.Font("Inter SemiBold", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(18, 18, 18)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel14)
                        .addComponent(lblFecha)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(pnlBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed

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
//        
//        new FormBoletas(empleado).setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnBoletasActionPerformed

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

    private void btnAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAquiActionPerformed
        tipoDespachoSeleccionado = "Aquí";
        deseleccionarBotonesDespacho();

        btnAqui.setBackground(Color.decode("#962E2B"));
        btnAqui.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnAquiActionPerformed

    private void btnLlevarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlevarActionPerformed
        tipoDespachoSeleccionado = "Llevar";
        deseleccionarBotonesDespacho();

        btnLlevar.setBackground(Color.decode("#962E2B"));
        btnLlevar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnLlevarActionPerformed

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        tipoDespachoSeleccionado = "Delivery";
        deseleccionarBotonesDespacho();

        btnDelivery.setBackground(Color.decode("#962E2B"));
        btnDelivery.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada < 0) {
            Mensajes.error("Selecciona un producto de la tabla");
            return;
        }

        int idProducto = (int) modeloTblProducto.getValueAt(filaSeleccionada, 0); // ajusta índice según tu columna id
        Producto producto = null;
        
        try {
            producto = prodControl.buscarProductoPorID(idProducto);
        } catch (Exception e) {
            Mensajes.error("Error al buscar por ID: " + e.getMessage());
        }

        String cantidadTexto = txtCantidad.getText();

        boolean agregado = false;
        try {
            agregado = pedidoController.agregarProducto(producto, cantidadTexto);
        } catch (Exception e) {
            Mensajes.error("Error al agregar el producto al carrito" + e.getMessage());
        }
        if (agregado) {
            actualizarTablaCarrito();
            actualizarStockVisual();
            actualizarTotales();
            txtCantidad.setText("");
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tablaCarrito.getSelectedRow();
        boolean eliminado = pedidoController.eliminarProducto(filaSeleccionada);
        if (eliminado) {
            actualizarTablaCarrito();
            actualizarStockVisual();
            actualizarTotales();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombre1ClickenTxt(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre1ClickenTxt
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ClickenTxt

    private void txtNombre1ClicFuera(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre1ClicFuera
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ClicFuera

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void txtNombre2ClickenTxt(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre2ClickenTxt
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ClickenTxt

    private void txtNombre2ClicFuera(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre2ClicFuera
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ClicFuera

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnAgregarMousePresionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePresionado
        btnAgregar.setBackground(Color.decode("#83F213"));
    }//GEN-LAST:event_btnAgregarMousePresionado

    private void btnAgregarMouseSuelto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseSuelto
        btnAgregar.setBackground(Color.decode("#C5C5C5"));

    }//GEN-LAST:event_btnAgregarMouseSuelto

    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        if (pedidoController.obtenerCarrito().isEmpty()) {
            Mensajes.error("El carrito está vacío");
            return;
        }

        if (tipoDespachoSeleccionado == null) {
            Mensajes.error("Selecciona el tipo de despacho (Aquí, Llevar o Delivery)");
            return;
        }
        
        if (pedidoController.obtenerCarrito().isEmpty()) {
            Mensajes.error("El carrito está vacío");
            return;
        }

        String metodoPago = (String) cmbMetodoPago.getSelectedItem();
        if (metodoPago == null) {
            Mensajes.error("Selecciona un método de pago");
            return;
        }

        Caja cajaAbierta;
        try {
            cajaAbierta = cajaControl.buscarCajaAbierta();
        } catch (Exception e) {
            Mensajes.error("Error al verificar la caja: " + e.getMessage());
            return;
        }
        if (cajaAbierta == null) {
            Mensajes.error("No hay una caja abierta. Debe aperturar caja antes de generar un pedido.");
            return;
        }

        Venta venta = new Venta();
        venta.setEmpleado(empleado);
        venta.setCaja(cajaAbierta);
        venta.setTipoDespacho(tipoDespachoSeleccionado);
        venta.setNotaAdicional(txtNotas.getText().trim().isEmpty() ? null : txtNotas.getText().trim());
        venta.setMetodoPago(metodoPago);
        venta.setSubtotalVenta(pedidoController.calcularSubtotal());
        venta.setIgvVenta(pedidoController.calcularIgv());
        venta.setTotalVenta(pedidoController.calcularTotal());

        try {
            VentaController ventaControl = new VentaController();
            ventaControl.registrarVentaConDetalles(venta, pedidoController.obtenerCarrito());

            Mensajes.aviso("Pedido registrado correctamente. N° de venta: " + venta.getIdVenta());

            pedidoController.vaciarCarrito();
            actualizarTablaCarrito();
            cargarTablaProductos(null, null, "Todos", null, null); // recarga stock real desde BD
            actualizarTotales();
            txtNotas.setText("");

        } catch (Exception e) {
            Mensajes.error("Error al generar el pedido: " + e.getMessage());
        }
        
        cmbMetodoPago.setSelectedIndex(0);

        txtCantidad2.setText("");
        
        txtNotas.setText("Notas(sin azúcar, caliente,etc)");
        txtNotas.setForeground(Color.decode("#90929B"));
        
        txtBuscarProducto.setText("");
        
        deseleccionarBotonesDespacho();
        btnAqui.setBackground(Color.decode("#962E2B"));
        btnAqui.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tablaCarrito.getSelectedRow();
        if (filaSeleccionada < 0) {
            Mensajes.error("Selecciona un producto del carrito");
            return;
        }

        String cantidadTexto = txtCantidad2.getText();
        boolean editado = false;
        try {
            editado = pedidoController.editarCantidad(filaSeleccionada, cantidadTexto);
        } catch (Exception e) {
            Mensajes.error("Error al editar la cantidad: " + e.getMessage());
        }

        if (editado) {
            actualizarTablaCarrito();
            actualizarStockVisual();
            actualizarTotales();
            txtCantidad.setText("");
        }
        
        txtCantidad2.setText("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed
        //Definir que hace el botón Administración dependiendo del rol.
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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        if (Mensajes.cerrarSesion()) {
            new FormLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void cmbMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMetodoPagoActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        new FormCaja(empleado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCajaActionPerformed

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbEstadoStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoStockActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtBuscarProducto.setText("");
        cmbCategoria.setSelectedIndex(0);
        cmbEstadoStock.setSelectedIndex(0);
        txtPrecioMin.setText("");
        txtPrecioMax.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombreProducto = txtBuscarProducto.getText().trim();
        String categoriaProducto = cmbCategoria.getSelectedItem().toString();
        String estadoProducto = cmbEstadoStock.getSelectedItem().toString();
        String precioMinimo = txtPrecioMin.getText().trim();
        String precioMaximo = txtPrecioMax.getText().trim();
        cargarTablaProductos(nombreProducto, categoriaProducto, estadoProducto, precioMinimo, precioMaximo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNotasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNotasFocusGained
        if(txtNotas.getText().equals("Notas(sin azúcar, caliente,etc)")){
            txtNotas.setText("");
        txtNotas.setForeground(Color.decode("#333333"));
        }
    }//GEN-LAST:event_txtNotasFocusGained

    private void txtPrecioMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMinActionPerformed

    private void txtNotasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNotasFocusLost
        if(txtNotas.getText().equals("")){
        txtNotas.setText("Notas(sin azúcar, caliente,etc)");
        txtNotas.setForeground(Color.decode("#90929B"));
        }
    }//GEN-LAST:event_txtNotasFocusLost

    private void actualizarTablaCarrito() {
        modeloTblCarrito.setRowCount(0);
        for (_ItemCarrito item : pedidoController.obtenerCarrito()) {
            modeloTblCarrito.addRow(new Object[]{
                item.getProducto().getIdProducto(),
                item.getProducto().getNombre(),
                item.getProducto().getCategoria(),
                item.getCantidad(),
                String.format("%.2f", item.getPrecioUnitario()),
                item.getProducto().getUnidMedida(),
                String.format("%.2f", item.getPrecioTotal())
            });
        }
    }
    
    private void actualizarStockVisual() {
        for (int i = 0; i < modeloTblProducto.getRowCount(); i++) {
            int idProducto = (int) modeloTblProducto.getValueAt(i, 0);
            int stockOriginal = productosOriginales.get(idProducto);
            int cantidadEnCarrito = pedidoController.obtenerCantidadEnCarrito(idProducto);
            int stockVisible = stockOriginal - cantidadEnCarrito;
            modeloTblProducto.setValueAt(stockVisible, i, 3); // columna 3 = Stock
        }
    }
    
    private void actualizarTotales() {
        lblSubtotal.setText(String.format("s/%.2f", pedidoController.calcularSubtotal()));
        lblIGV.setText(String.format("s/%.2f", pedidoController.calcularIgv()));
        lblTotal.setText(String.format("s/ %.2f", pedidoController.calcularTotal()));
    }
    
    protected void cargarTablaProductos(String nombre, String categoria, String estadoStock, String precioMin, String precioMax) {
        modeloTblProducto.setRowCount(0);
        productosOriginales.clear(); // evita entradas viejas de un filtro anterior

        try {
            listaProductos = prodControl.listarConFiltros(nombre, categoria, estadoStock, precioMin, precioMax);

            for (Producto prod : listaProductos) {
                Object[] fila = new Object[]{
                    prod.getIdProducto(),
                    prod.getNombre(),
                    prod.getCategoria(),
                    prod.getStock(),
                    prod.getPrecio(),
                    prod.getUnidMedida(),
                    prod.isActivo()
                };

                modeloTblProducto.addRow(fila);
                productosOriginales.put(prod.getIdProducto(), prod.getStock());
            }

            actualizarStockVisual();

        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAqui;
    private javax.swing.JButton btnBoletas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLlevar;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstadoStock;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCantidad1;
    private javax.swing.JLabel lblCantidad2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblLogoFlores;
    private javax.swing.JLabel lblLogoMarcela;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBarraLateral;
    private javax.swing.JPanel pnlCalculoSuma;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlDerecho;
    private javax.swing.JPanel pnlSuma;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidad2;
    private javax.swing.JLabel txtEstadoCaja;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JLabel txtNombresEmp;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JTextField txtPrecioMax;
    private javax.swing.JTextField txtPrecioMin;
    private javax.swing.JLabel txtRol;
    private javax.swing.JLabel txtRol1;
    // End of variables declaration//GEN-END:variables
}
