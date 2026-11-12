package vista.area6Compras;

import util.ControlAcceso;
import util.SesionActual;
import vista.area0Login.FormLogin;
import vista.area1Productos.FormProductos;
import vista.area2Categorias.FormCategorias;
import vista.area3Marcas.FormMarcas;
import vista.area4Historial.FormHistorial;
import vista.area5AjusteStock.FormAjusteStock;
import vista.area7ListaDeEspera.FormEnEspera;
import vista.area8Garantia.FormGarantia;
import vista.area9Administracion.FormAdministracion;
import controlador.BusquedaABBController;
import controlador.CompraController;
import controlador.ProductoController;
import controlador.ProveedorController;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Producto;
import modelo.Proveedor;
import util.Mensajes;
import util.Validaciones;

public class FormCompras extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCompras.class.getName());

    private final CompraController compraControl = new CompraController();
    private final ProveedorController provControl = new ProveedorController();
    private final ProductoController prodControl = new ProductoController();

    private final DefaultTableModel modeloProveedor = new DefaultTableModel();
    private final DefaultTableModel modeloProducto = new DefaultTableModel();
    private final DefaultTableModel modeloCarrito = new DefaultTableModel();

    private List<Proveedor> listaProveedores = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();

    private List<Proveedor> proveedoresEnTabla = new ArrayList<>();
    private List<Producto> productosEnTabla = new ArrayList<>();

    private final BusquedaABBController busqueda = new BusquedaABBController();

    private FormNuevoProveedor ventanaNuevoProveedor;

    public FormCompras() {
        initComponents();

        ControlAcceso.configurarVentana(this, btnAjusteStock, btnAdministracion);

        // Buscar y Ordenar -  árboles binarios de búsqueda
        cbxOrdenarProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"RUC", "Razón social", "Contacto", "Teléfono"}));

        cbxOrdenarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Nombre", "Marca", "Stock", "Último costo"}));

        configurarTablas();
        configurarCierreDeVentana();

        txtFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txtTotalNumeroProductos.setText("/  " + CompraController.LIMITE_CARRITO);
        txtCantidad.setText("1");
        txtPrecio.setText("");

        cargarTablaProveedores();
        cargarTablaProductos();
        refrescarCarrito();
        actualizarProveedorSeleccionado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxOrdenarProveedor = new javax.swing.JComboBox<>();
        txtBuscarProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        btnAgregarProveedor = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxOrdenarProducto = new javax.swing.JComboBox<>();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnConfirmarCompra = new javax.swing.JButton();
        btnCancelarCompra = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarritoCompra = new javax.swing.JTable();
        txtTotalNumeroProductos = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNumeroProductosCarrito = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtNombreProveedor = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtFecha = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnMarcas = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnAdministracion = new javax.swing.JButton();
        btnAjusteStock = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnEnEspera = new javax.swing.JButton();
        btnGarantia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Registro de Compras");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Seleccionar proveedor");

        tblProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProveedor);

        jLabel7.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Buscar:");

        jLabel8.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ordenar por:");

        cbxOrdenarProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxOrdenarProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "Razón social", "Contacto" }));

        txtBuscarProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        btnBuscarProveedor.setBackground(new java.awt.Color(0, 63, 156));
        btnBuscarProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBuscarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnAgregarProveedor.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregarProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAgregarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProveedor))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbxOrdenarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxOrdenarProveedor)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seleccionar producto");

        tblProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblProducto);

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Buscar:");

        jLabel11.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Ordenar por:");

        cbxOrdenarProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxOrdenarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre" }));

        txtBuscarProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        btnBuscarProducto.setBackground(new java.awt.Color(0, 63, 156));
        btnBuscarProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(51, 153, 0));
        btnAgregarProducto.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtCantidad.setText("1");

        jLabel13.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cantidad:");

        jLabel15.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Precio de costo:");

        txtPrecio.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        txtPrecio.setText("32");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxOrdenarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxOrdenarProducto))
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(23, 23, 23))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnConfirmarCompra.setBackground(new java.awt.Color(0, 63, 156));
        btnConfirmarCompra.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnConfirmarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarCompra.setText("Guardar Compra");
        btnConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCompraActionPerformed(evt);
            }
        });

        btnCancelarCompra.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelarCompra.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnCancelarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCompra.setText("Cancelar");
        btnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompraActionPerformed(evt);
            }
        });

        btnDeshacer.setBackground(new java.awt.Color(204, 204, 204));
        btnDeshacer.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnDeshacer.setForeground(new java.awt.Color(0, 0, 0));
        btnDeshacer.setText("Deshacer último");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        tblCarritoCompra.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblCarritoCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblCarritoCompra);

        txtTotalNumeroProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtTotalNumeroProductos.setForeground(new java.awt.Color(51, 51, 51));
        txtTotalNumeroProductos.setText("/  20");

        jLabel19.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Productos en el carrito:");

        txtNumeroProductosCarrito.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtNumeroProductosCarrito.setForeground(new java.awt.Color(51, 51, 51));
        txtNumeroProductosCarrito.setText("0");

        jPanel13.setBackground(new java.awt.Color(226, 226, 226));

        txtNombreProveedor.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProveedor.setText("Distribuidora Tecno");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtFecha.setBackground(new java.awt.Color(0, 0, 0));
        txtFecha.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(26, 26, 26));
        txtFecha.setText("02/11/2026");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtFecha)
                .addGap(17, 17, 17))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel22.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("TOTAL: s/");

        jLabel23.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("3840");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Proveedor:");

        jLabel12.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Carrito de Compra");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumeroProductosCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalNumeroProductos)
                                        .addGap(211, 211, 211))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTotalNumeroProductos)
                    .addComponent(txtNumeroProductosCarrito))
                .addGap(3, 3, 3)
                .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(52, 52, 52)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 30, 66));

        jPanel3.setBackground(new java.awt.Color(1, 91, 187));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/apla.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnProductos.setBackground(new java.awt.Color(0, 29, 63));
        btnProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/productos.png"))); // NOI18N
        btnProductos.setText("   Productos      ");
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setFocusPainted(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnMarcas.setBackground(new java.awt.Color(0, 29, 63));
        btnMarcas.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/marcas.png"))); // NOI18N
        btnMarcas.setText("   Marcas             ");
        btnMarcas.setBorder(null);
        btnMarcas.setBorderPainted(false);
        btnMarcas.setContentAreaFilled(false);
        btnMarcas.setFocusPainted(false);
        btnMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasActionPerformed(evt);
            }
        });

        btnCategorias.setBackground(new java.awt.Color(0, 29, 63));
        btnCategorias.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/categorias.png"))); // NOI18N
        btnCategorias.setText("  Categorias      ");
        btnCategorias.setBorder(null);
        btnCategorias.setBorderPainted(false);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.setFocusPainted(false);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 63, 156));
        btnSalir.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnHistorial.setBackground(new java.awt.Color(0, 29, 63));
        btnHistorial.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/historial.png"))); // NOI18N
        btnHistorial.setText("   Historial           ");
        btnHistorial.setBorder(null);
        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setFocusPainted(false);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnAdministracion.setBackground(new java.awt.Color(0, 29, 63));
        btnAdministracion.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAdministracion.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/administracion.png"))); // NOI18N
        btnAdministracion.setText(" Administración   ");
        btnAdministracion.setBorder(null);
        btnAdministracion.setBorderPainted(false);
        btnAdministracion.setContentAreaFilled(false);
        btnAdministracion.setFocusPainted(false);
        btnAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministracionActionPerformed(evt);
            }
        });

        btnAjusteStock.setBackground(new java.awt.Color(0, 29, 63));
        btnAjusteStock.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAjusteStock.setForeground(new java.awt.Color(255, 255, 255));
        btnAjusteStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/stock.png"))); // NOI18N
        btnAjusteStock.setText("   Ajuste Stock  ");
        btnAjusteStock.setBorder(null);
        btnAjusteStock.setBorderPainted(false);
        btnAjusteStock.setContentAreaFilled(false);
        btnAjusteStock.setFocusPainted(false);
        btnAjusteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjusteStockActionPerformed(evt);
            }
        });

        btnCompras.setBackground(new java.awt.Color(1, 91, 187));
        btnCompras.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/compras.png"))); // NOI18N
        btnCompras.setText("   Compras        ");
        btnCompras.setBorder(null);
        btnCompras.setBorderPainted(false);
        btnCompras.setFocusPainted(false);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });

        btnEnEspera.setBackground(new java.awt.Color(0, 29, 63));
        btnEnEspera.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnEnEspera.setForeground(new java.awt.Color(255, 255, 255));
        btnEnEspera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/lista.png"))); // NOI18N
        btnEnEspera.setText("   En espera      ");
        btnEnEspera.setBorder(null);
        btnEnEspera.setBorderPainted(false);
        btnEnEspera.setContentAreaFilled(false);
        btnEnEspera.setFocusPainted(false);
        btnEnEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnEsperaActionPerformed(evt);
            }
        });

        btnGarantia.setBackground(new java.awt.Color(1, 91, 187));
        btnGarantia.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnGarantia.setForeground(new java.awt.Color(255, 255, 255));
        btnGarantia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/marcas.png"))); // NOI18N
        btnGarantia.setText("   Garantia        ");
        btnGarantia.setBorder(null);
        btnGarantia.setBorderPainted(false);
        btnGarantia.setContentAreaFilled(false);
        btnGarantia.setFocusPainted(false);
        btnGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGarantiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAjusteStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEnEspera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnGarantia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAjusteStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSalir)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        try {
            String texto = txtBuscarProveedor.getText().trim();
            Comparator<Proveedor> comparador = obtenerComparadorProveedor();
            List<Proveedor> resultado;
            if (texto.isEmpty()) {
                resultado = busqueda.ordenar(listaProveedores, comparador);
            } else {
                resultado = busqueda.buscarPorPrefijo(listaProveedores, comparador, texto, obtenerClaveProveedor());
            }
            mostrarProveedores(resultado);
            if (resultado.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontraron proveedores con ese criterio.",
                        "Sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        // Evita abrir dos ventanas de "Nuevo proveedor"
        if (ventanaNuevoProveedor != null && ventanaNuevoProveedor.isDisplayable()) {
            ventanaNuevoProveedor.toFront();
            return;
        }

        ventanaNuevoProveedor = new FormNuevoProveedor(this::alRegistrarProveedor);
        ventanaNuevoProveedor.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                FormCompras.this.setEnabled(true);
                FormCompras.this.toFront();
            }
        });
        this.setEnabled(false);
        ventanaNuevoProveedor.setVisible(true);
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        try {
            String texto = txtBuscarProducto.getText().trim();
            String campo = (String) cbxOrdenarProducto.getSelectedItem();
            Comparator<Producto> comparador = obtenerComparadorProducto();
            List<Producto> resultado;
            if (texto.isEmpty()) {
                resultado = busqueda.ordenar(listaProductos, comparador);
            } else {
                switch (campo) {
                    case "Stock" -> {
                        Producto referencia = new Producto();
                        referencia.setStock(Validaciones.parsearStock(texto));
                        resultado = busqueda.buscarExacto(listaProductos, comparador, referencia);
                    }
                    case "Último costo" -> {
                        Producto referencia = new Producto();
                        referencia.setPrecioCompra(Validaciones.parsearPrecio(texto));
                        resultado = busqueda.buscarExacto(listaProductos, comparador, referencia);
                    }
                    default ->
                        resultado = busqueda.buscarPorPrefijo(listaProductos, comparador, texto, obtenerClaveProducto());
                }
            }
            mostrarProductos(resultado);
            if (resultado.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontraron productos con ese criterio.",
                        "Sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        int fila = tblProducto.getSelectedRow();

        if (fila == -1) {
            Mensajes.error("Seleccione un producto de la tabla.");
            return;
        }

        try {
            Producto producto = productosEnTabla.get(fila);
            int cantidad = Validaciones.parsearCantidad(txtCantidad.getText());
            BigDecimal precio = Validaciones.parsearPrecioCosto(txtPrecio.getText());

            compraControl.agregarAlCarrito(producto, cantidad, precio);

            tblProducto.clearSelection();
            txtCantidad.setText("1");
            txtPrecio.setText("");
            refrescarCarrito();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCompraActionPerformed
        boolean confirmacion = Mensajes.confirmacion(
                "¿Desea registrar la compra a " + txtNombreProveedor.getText()
                + " por s/ " + jLabel23.getText() + "?\n"
                + "Quedará PENDIENTE hasta que se reciba la mercadería.",
                "Registro de Compra");

        if (confirmacion) {
            try {
                Compra compra = compraControl.guardarCompra();
                Mensajes.exito("La compra N° " + compra.getIdCompra() + " ha sido registrada como PENDIENTE!");
                reiniciarFormulario();
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnConfirmarCompraActionPerformed

    private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompraActionPerformed
        if (!compraControl.carritoVacio()) {
            boolean confirmacion = Mensajes.confirmacion(
                    "¿Está seguro que desea cancelar la compra? Se perderán los productos del carrito.",
                    "Cancelar Compra");
            if (!confirmacion) {
                return;
            }
        }
        reiniciarFormulario();
    }//GEN-LAST:event_btnCancelarCompraActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try {
            compraControl.deshacerUltimo();
            refrescarCarrito();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormProductos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormMarcas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormCategorias().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        SesionActual.cerrarSesion();
        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormHistorial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed
        if (!ControlAcceso.validarAdministracion()) {
            return;
        }
        if (!confirmarSalida()) {
            return;
        }

        new FormAdministracion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministracionActionPerformed

    private void btnAjusteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjusteStockActionPerformed
        if (!ControlAcceso.validarAjusteStock()) {
            return;
        }
        if (!confirmarSalida()) {
            return;
        }

        new FormAjusteStock().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAjusteStockActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed

    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnEnEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnEsperaActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormEnEspera().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEnEsperaActionPerformed

    private void btnGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGarantiaActionPerformed
        if (!confirmarSalida()) {
            return;
        }
        new FormGarantia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGarantiaActionPerformed

    private void configurarTablas() {
        // Proveedores
        tblProveedor.setModel(modeloProveedor);
        modeloProveedor.setColumnIdentifiers(new Object[]{"RUC", "Razón social", "Contacto", "Teléfono"});
        tblProveedor.setSelectionMode(SINGLE_SELECTION);
        tblProveedor.setDefaultEditor(Object.class, null);
        tblProveedor.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarProveedorDeLaTabla();
            }
        });

        // Productos: al seleccionar una fila se autocompleta el precio de costo
        tblProducto.setModel(modeloProducto);
        modeloProducto.setColumnIdentifiers(new Object[]{"Nombre", "Marca", "Stock", "Último costo"});
        tblProducto.setSelectionMode(SINGLE_SELECTION);
        tblProducto.setDefaultEditor(Object.class, null);
        tblProducto.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                autocompletarPrecioCosto();
            }
        });

        // Carrito: la última fila (la cima de la pila) se pinta de celeste
        tblCarritoCompra.setModel(modeloCarrito);
        modeloCarrito.setColumnIdentifiers(new Object[]{"Producto", "Cantidad", "Costo unit.", "Subtotal"});
        tblCarritoCompra.setDefaultEditor(Object.class, null);
        tblCarritoCompra.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, false, false, row, column);
                boolean esCima = row == table.getRowCount() - 1;
                c.setBackground(esCima ? new Color(204, 229, 255) : Color.WHITE);
                return c;
            }
        });
    }

    // La X de la ventana también pide confirmación si hay productos en el carrito
    private void configurarCierreDeVentana() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (confirmarSalida()) {
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    private boolean confirmarSalida() {
        if (compraControl.carritoVacio()) {
            return true;
        }
        return Mensajes.confirmacion(
                "Hay productos en el carrito de compra y se perderán si sale de esta pantalla.\n¿Desea salir de todas formas?",
                "Salir de Compras");
    }

    private void cargarTablaProveedores() {
        modeloProveedor.setRowCount(0);

        try {
            listaProveedores = provControl.verProveedoresActivos();

            for (Proveedor prov : listaProveedores) {
                Object[] fila = new Object[]{
                    prov.getRuc(),
                    prov.getRazonSocial(),
                    prov.getContacto(),
                    prov.getTelefono()
                };
                modeloProveedor.addRow(fila);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }

    // Solo productos activos
    private void cargarTablaProductos() {
        modeloProducto.setRowCount(0);
        listaProductos = new ArrayList<>();

        try {
            for (Producto prod : prodControl.verTodosLosProductos()) {
                if (!prod.isEstado()) {
                    continue;
                }
                listaProductos.add(prod);
                Object[] fila = new Object[]{
                    prod.getNombreProducto(),
                    prod.getMarca().getNombreMarca(),
                    prod.getStock(),
                    prod.getPrecioCompra()
                };
                modeloProducto.addRow(fila);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }

    private void seleccionarProveedorDeLaTabla() {
        int fila = tblProveedor.getSelectedRow();
        if (fila == -1) {
            return;
        }

        try {
            compraControl.seleccionarProveedor(proveedoresEnTabla.get(fila));
            actualizarProveedorSeleccionado();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }

    // Solo llena la tabla; la lista completa (listaProveedores) no se modifica
    private void mostrarProveedores(List<Proveedor> lista) {
        proveedoresEnTabla = lista;
        modeloProveedor.setRowCount(0);
        for (Proveedor prov : lista) {
            modeloProveedor.addRow(new Object[]{
                prov.getRuc(),
                prov.getRazonSocial(),
                prov.getContacto(),
                prov.getTelefono()
            });
        }
    }

    // Solo llena la tabla; la lista completa (listaProductos) no se modifica
    private void mostrarProductos(List<Producto> lista) {
        productosEnTabla = lista;
        modeloProducto.setRowCount(0);
        for (Producto prod : lista) {
            modeloProducto.addRow(new Object[]{
                prod.getNombreProducto(),
                prod.getMarca().getNombreMarca(),
                prod.getStock(),
                prod.getPrecioCompra()
            });
        }
    }

    private Comparator<Proveedor> obtenerComparadorProveedor() {
        String campo = (String) cbxOrdenarProveedor.getSelectedItem();
        return switch (campo) {
            case "RUC" ->
                Comparator.comparing(Proveedor::getRuc, String.CASE_INSENSITIVE_ORDER);
            case "Contacto" ->
                Comparator.comparing(Proveedor::getContacto, Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER));
            case "Teléfono" ->
                Comparator.comparing(Proveedor::getTelefono, Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER));
            default ->
                Comparator.comparing(Proveedor::getRazonSocial, String.CASE_INSENSITIVE_ORDER);
        };
    }

    private Function<Proveedor, String> obtenerClaveProveedor() {
        String campo = (String) cbxOrdenarProveedor.getSelectedItem();
        return switch (campo) {
            case "RUC" ->
                Proveedor::getRuc;
            case "Contacto" ->
                Proveedor::getContacto;
            case "Teléfono" ->
                Proveedor::getTelefono;
            default ->
                Proveedor::getRazonSocial;
        };
    }

    private Comparator<Producto> obtenerComparadorProducto() {
        String campo = (String) cbxOrdenarProducto.getSelectedItem();
        return switch (campo) {
            case "Marca" ->
                Comparator.comparing(p -> p.getMarca().getNombreMarca(), String.CASE_INSENSITIVE_ORDER);
            case "Stock" ->
                Comparator.comparingInt(Producto::getStock);
            case "Último costo" ->
                Comparator.comparing(Producto::getPrecioCompra, Comparator.nullsFirst(Comparator.<BigDecimal>naturalOrder()));
            default ->
                Comparator.comparing(Producto::getNombreProducto, String.CASE_INSENSITIVE_ORDER);
        };
    }

    private Function<Producto, String> obtenerClaveProducto() {
        String campo = (String) cbxOrdenarProducto.getSelectedItem();
        return switch (campo) {
            case "Marca" ->
                p -> p.getMarca().getNombreMarca();
            default ->
                Producto::getNombreProducto;
        };
    }

    private void autocompletarPrecioCosto() {
        int fila = tblProducto.getSelectedRow();
        if (fila == -1) {
            return;
        }

        // Vacío si el producto nunca se compró (precio 0), para obligar a escribirlo
        BigDecimal sugerido = compraControl.sugerirPrecioCosto(productosEnTabla.get(fila));
        txtPrecio.setText(sugerido == null ? "" : sugerido.toPlainString());
    }

    // Callback de FormNuevoProveedor: recarga la tabla y deja seleccionado al proveedor recién creado
    private void alRegistrarProveedor(Proveedor registrado) {
        cargarTablaProveedores();

        for (int i = 0; i < listaProveedores.size(); i++) {
            if (listaProveedores.get(i).getIdProveedor() == registrado.getIdProveedor()) {
                tblProveedor.setRowSelectionInterval(i, i);
                tblProveedor.scrollRectToVisible(tblProveedor.getCellRect(i, 0, true));
                break;
            }
        }
    }

    private void actualizarProveedorSeleccionado() {
        Proveedor prov = compraControl.getProveedorSeleccionado();
        txtNombreProveedor.setText(prov == null ? "Seleccione un proveedor" : prov.getRazonSocial());
    }

    // Vuelve a dibujar el carrito desde la pila: tabla, contador, total y estado de los botones
    private void refrescarCarrito() {
        modeloCarrito.setRowCount(0);

        for (DetalleCompra detalle : compraControl.verCarrito()) {
            Object[] fila = new Object[]{
                detalle.getProducto().getNombreProducto(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getSubtotal()
            };
            modeloCarrito.addRow(fila);
        }

        txtNumeroProductosCarrito.setText(String.valueOf(compraControl.getCantidadEnCarrito()));
        jLabel23.setText(compraControl.calcularTotal().toPlainString());
        actualizarEstadoControles();
    }

    private void actualizarEstadoControles() {
        boolean vacio = compraControl.carritoVacio();
        boolean bloqueado = compraControl.proveedorBloqueado();

        btnDeshacer.setEnabled(!vacio);
        btnConfirmarCompra.setEnabled(!vacio);
        btnAgregarProducto.setEnabled(!compraControl.carritoLleno());

        // Con productos en el carrito el proveedor ya no se puede cambiar
        tblProveedor.setEnabled(!bloqueado);
        btnAgregarProveedor.setEnabled(!bloqueado);
    }

    // Deja el formulario como nuevo (Cancelar y después de guardar)
    private void reiniciarFormulario() {
        compraControl.reiniciarCompra();
        tblProveedor.clearSelection();
        tblProducto.clearSelection();
        txtCantidad.setText("1");
        txtPrecio.setText("");
        refrescarCarrito();
        actualizarProveedorSeleccionado();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnAjusteStock;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelarCompra;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnConfirmarCompra;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEnEspera;
    private javax.swing.JButton btnGarantia;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxOrdenarProducto;
    private javax.swing.JComboBox<String> cbxOrdenarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCarritoCompra;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtNombreProveedor;
    private javax.swing.JLabel txtNumeroProductosCarrito;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JLabel txtTotalNumeroProductos;
    // End of variables declaration//GEN-END:variables
}
