package vista.area1Productos;

import controlador.CategoriaController;
import controlador.MarcaController;
import controlador.ProductoController;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Marca;
import modelo.Producto;
import util.AlgoritmoOrdenamientoIndirecto;
import util.Mensajes;
import util.Validaciones;
import vista.area0Login.FormLogin;
import vista.area2Categorias.FormCategorias;
import vista.area3Marcas.FormMarcas;


public class FormProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormProductos.class.getName());
    
    // Inicialización del modelo de la tabla de productos
    private final DefaultTableModel modelo = new DefaultTableModel();
    
    // Controladores
    private final ProductoController prodControl;
    private final CategoriaController catControl;
    private final MarcaController marControl;
    
    // Listas
    private List<Producto> listaProductos;
    private List<Categoria> listaCategorias;
    private List<Marca> listaMarcas;

    public FormProductos() {
        initComponents();
        btnProductos.setBackground(Color.decode("#015BBB"));
        
        // Se inicializa los controladores
        prodControl = new ProductoController();
        catControl = new CategoriaController();
        marControl = new MarcaController();
        
        // Tabla
        tblProductos.setModel(modelo);
        
        Object[] columnas = new Object[]{
            "ID",
            "Nombre",
            "Categoria",
            "Marca",
            "Precio",
            "Stock",
            "Estado",
            "Fecha de Creación",
            "Fecha de Modificación"
        };
        
        modelo.setColumnIdentifiers(columnas);
        
        tblProductos.setSelectionMode(SINGLE_SELECTION);
        tblProductos.setDefaultEditor(Object.class, null);
        
        cargarTablaProductos();
        cargarComboCategorias();
        cargarComboMarcas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnMarcas = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxMetodo = new javax.swing.JComboBox<>();
        cbxOrdenar = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRecorrer = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxMarca = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnMostrarDetalles = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 30, 66));

        jPanel3.setBackground(new java.awt.Color(1, 91, 187));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/apla.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnProductos.setBackground(new java.awt.Color(0, 29, 63));
        btnProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
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
        btnMarcas.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/marcas.png"))); // NOI18N
        btnMarcas.setText("  Marcas             ");
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
        btnCategorias.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
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
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 44, 44));
        jLabel2.setText("Métodos de Ordenamiento Indirecto");

        btnOrdenar.setBackground(new java.awt.Color(0, 63, 156));
        btnOrdenar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoOrdenar.png"))); // NOI18N
        btnOrdenar.setText("   Ordenar      ");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel14.setText("Ordenar por:");

        jLabel15.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel15.setText("Método:");

        cbxMetodo.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QuickSort", "MergeSort", "ShellSort" }));

        cbxOrdenar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Precio", "Stock" }));
        cbxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxOrdenar, 0, 199, Short.MAX_VALUE)
                            .addComponent(cbxMetodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 44, 44));
        jLabel3.setText("Matriz de Categoria por Estado");

        tblMatriz.setBackground(new java.awt.Color(0, 63, 156));
        tblMatriz.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMatriz);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 44, 44));
        jLabel6.setText("Operaciones fundamentales");

        btnAgregar.setBackground(new java.awt.Color(0, 63, 156));
        btnAgregar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoGUARDAR.png"))); // NOI18N
        btnAgregar.setText("  Agregar   ");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(25, 23, 22));
        btnActualizar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/LogoACTUALIZAR2.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(25, 23, 22));
        btnEliminar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoELIMINAR2.png"))); // NOI18N
        btnEliminar.setText(" Eliminar ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRecorrer.setBackground(new java.awt.Color(25, 23, 22));
        btnRecorrer.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnRecorrer.setForeground(new java.awt.Color(255, 255, 255));
        btnRecorrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoRECORRER.png"))); // NOI18N
        btnRecorrer.setText("Recorrer");
        btnRecorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnRecorrer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecorrer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(44, 44, 44));
        jLabel7.setText("Detalles del Producto");

        jLabel9.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel9.setText("Categoría:");

        jLabel11.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel11.setText("Stock:");

        jLabel12.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel8.setText("Marca:");

        cbxCategoria.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        cbxMarca.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        txtStock.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel13.setText("Precio:");

        txtPrecio.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        btnMostrarDetalles.setBackground(new java.awt.Color(0, 63, 156));
        btnMostrarDetalles.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnMostrarDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarDetalles.setText("Mostrar Detalle");
        btnMostrarDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnMostrarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Productos");

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("Administra los productos del inventario");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 44, 44));
        jLabel10.setText("Tabla de productos");

        tblProductos.setBackground(new java.awt.Color(0, 63, 156));
        tblProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 422, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        new FormCategorias().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        new FormMarcas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void cbxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrdenarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new FormLogin().setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRecorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorrerActionPerformed
        cargarTablaProductos();
    }//GEN-LAST:event_btnRecorrerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblProductos.getSelectedRow();
        
        if (fila == -1) {
            Mensajes.error("Selecciona un producto de la tabla.");
            return;
        }
        
        int id = (int) modelo.getValueAt(fila, 0);
        Producto producto = new Producto();
        producto.setIdProducto(id);
        boolean activo = (boolean) modelo.getValueAt(fila, 6);
        
        if (!activo) {
            Mensajes.error("El registro ya está eliminado (inactivo).");
            return;
        }
        
        boolean confirmacion = Mensajes.confirmacion("¿Está seguro que desea eliminar el producto?", "Eliminación de Producto");
        
        if (confirmacion) {
            try {
                prodControl.eliminarProducto(producto);
                Mensajes.exito("El producto ha sido eliminado correctamente!");
                cargarTablaProductos();
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = tblProductos.getSelectedRow();
                
        if (fila == -1){
            Mensajes.error("Seleccione un producto de la tabla.");
            return;
        }
                        
        try {
            Producto prodActualizar = listaProductos.get(fila);
            
            String nombre = txtNombre.getText();
            Categoria categoria = obtenerCategoriaSeleccionada();
            Marca marca = obtenerMarcaSeleccionada();
            BigDecimal precio = Validaciones.parsearPrecio(txtPrecio.getText());
            int stock = Validaciones.parsearStock(txtStock.getText());
            
            prodActualizar.setNombreProducto(nombre);
            prodActualizar.setCategoria(categoria);
            prodActualizar.setMarca(marca);
            prodActualizar.setPrecio(precio);
            prodActualizar.setStock(stock);
            
            prodControl.actualizarProducto(prodActualizar);
            Mensajes.exito("El producto ha sido actualizado exitosamente!");
            limpiarTextsAreas();
            cargarTablaProductos();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Producto prodAgregar = new Producto();
        
        try {
            String nombre = txtNombre.getText();
            Categoria categoria = obtenerCategoriaSeleccionada();
            Marca marca = obtenerMarcaSeleccionada();
            BigDecimal precio = Validaciones.parsearPrecio(txtPrecio.getText());
            int stock = Validaciones.parsearStock(txtStock.getText());

            prodAgregar.setNombreProducto(nombre);
            prodAgregar.setCategoria(categoria);
            prodAgregar.setMarca(marca);
            prodAgregar.setPrecio(precio);
            prodAgregar.setStock(stock);
        
            prodControl.registrarProducto(prodAgregar);
            Mensajes.exito("Se ha guardado el producto exitosamente!");
            cargarTablaProductos();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        if (listaProductos == null || listaProductos.isEmpty()) {
            Mensajes.error("No hay productos cargados para ordenar.");
            return;
        }

        Producto[] arreglo = listaProductos.toArray(new Producto[0]);
        Comparator<Producto> comparador = obtenerComparador();
        String metodo = (String) cbxMetodo.getSelectedItem();

        switch (metodo) {
            case "QuickSort" ->
                AlgoritmoOrdenamientoIndirecto.quickSort(arreglo, comparador);
            case "MergeSort" ->
                AlgoritmoOrdenamientoIndirecto.mergeSort(arreglo, comparador);
            case "ShellSort" ->
                AlgoritmoOrdenamientoIndirecto.shellSort(arreglo, comparador);
            default -> {
                Mensajes.error("Seleccione un método de ordenamiento válido.");
                return;
            }
        }

        actualizarTablaConArreglo(arreglo);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnMostrarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDetallesActionPerformed
        int fila = tblProductos.getSelectedRow();

        if (fila == -1){
            Mensajes.error("Seleccione un producto de la tabla.");
            return;
        }

        try {
            Producto prodAgregar = listaProductos.get(fila);
            txtNombre.setText(prodAgregar.getNombreProducto());
            cbxCategoria.setSelectedItem(prodAgregar.getCategoria().getNombreCategoria());
            cbxMarca.setSelectedItem(prodAgregar.getMarca().getNombreMarca());
            txtPrecio.setText(prodAgregar.getPrecio().toString());
            txtStock.setText(String.valueOf(prodAgregar.getStock()));
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnMostrarDetallesActionPerformed

    private void cargarComboCategorias() {
        cbxCategoria.removeAllItems();
        try {
            listaCategorias = catControl.verTodasLasCategorias();
            
            listaCategorias.sort(Comparator.comparing(Categoria::getNombreCategoria, String.CASE_INSENSITIVE_ORDER));
            
            for (Categoria c : listaCategorias) {
                if (c.isEstado()) {
                    cbxCategoria.addItem(c.getNombreCategoria());
                }
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }

    private void cargarComboMarcas() {
        cbxMarca.removeAllItems();
        try {
            listaMarcas = marControl.verTodasLasMarcas();
            
            listaMarcas.sort(Comparator.comparing(Marca::getNombreMarca, String.CASE_INSENSITIVE_ORDER));
            
            for (Marca m : listaMarcas) {
                if (m.isEstado()) {
                    cbxMarca.addItem(m.getNombreMarca());
                }
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }
    
    private Categoria obtenerCategoriaSeleccionada() {
        String nombre = (String) cbxCategoria.getSelectedItem();
        if (nombre == null || listaCategorias == null) {
            return null;
        }
        for (Categoria c : listaCategorias) {
            if (c.getNombreCategoria().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    private Marca obtenerMarcaSeleccionada() {
        String nombre = (String) cbxMarca.getSelectedItem();
        if (nombre == null || listaMarcas == null) {
            return null;
        }
        for (Marca m : listaMarcas) {
            if (m.getNombreMarca().equals(nombre)) {
                return m;
            }
        }
        return null;
    }
    
    private void limpiarTextsAreas() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        if (cbxCategoria.getItemCount() > 0) cbxCategoria.setSelectedIndex(0);
        if (cbxMarca.getItemCount() > 0) cbxMarca.setSelectedIndex(0);
    }
    
    private void cargarTablaProductos() {
        modelo.setRowCount(0);
        
        try {
            listaProductos = prodControl.verTodosLosProductos();
            
            for (Producto prod : listaProductos) {
                Object[] fila = new Object[]{
                    prod.getIdProducto(),
                    prod.getNombreProducto(),
                    prod.getCategoria().getNombreCategoria(),
                    prod.getMarca().getNombreMarca(),
                    prod.getPrecio(),
                    prod.getStock(),
                    prod.isEstado(),
                    prod.getFechaCreacion(),
                    prod.getFechaModificacion()
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }
    
    private void actualizarTablaConArreglo(Producto[] arreglo) {
        modelo.setRowCount(0);
        for (Producto prod : arreglo) {
            Object[] fila = new Object[]{
                prod.getIdProducto(),
                prod.getNombreProducto(),
                prod.getCategoria().getNombreCategoria(),
                prod.getMarca().getNombreMarca(),
                prod.getPrecio(),
                prod.getStock(),
                prod.isEstado(),
                prod.getFechaCreacion(),
                prod.getFechaModificacion()
            };
            modelo.addRow(fila);
        }
        listaProductos = new ArrayList<>(Arrays.asList(arreglo));
    }
    
    private Comparator<Producto> obtenerComparador() {
        String campo = (String) cbxOrdenar.getSelectedItem();
        return switch (campo) {
            case "Precio" ->
                Comparator.comparing(Producto::getPrecio);
            case "Stock" ->
                Comparator.comparingInt(Producto::getStock);
            default ->
                Comparator.comparingInt(Producto::getIdProducto);
        };
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JButton btnMostrarDetalles;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRecorrer;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
