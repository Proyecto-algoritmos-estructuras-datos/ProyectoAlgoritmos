package vista.area2Categorias;

import controlador.CategoriaController;
import vista.area1Productos.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import util.AlgoritmoOrdenamientoDirecto;
import util.Mensajes;
import vista.area0Login.FormLogin;
import vista.area3Marcas.FormMarcas;


public class FormCategorias extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCategorias.class.getName());

    // Inicialización del modelo de la tabla de productos
    private final DefaultTableModel modelo = new DefaultTableModel();
    List<Categoria> listaCategorias = new ArrayList<>();
    
    // Controladores
    private final CategoriaController cateControl;
    
    public FormCategorias() {
        initComponents();
        btnCategorias.setBackground(Color.decode("#015BBB"));
        
        // Se inicializa los controladores
        cateControl = new CategoriaController();
        
        // Tabla
        tblCategorias.setModel(modelo);
        
        Object[] columnas = new Object[]{
            "ID",
            "Nombre",
            "Descripcion",
            "Estado",
            "Fecha de Creación",
            "Fecha de Modificación"
        };
        
        modelo.setColumnIdentifiers(columnas);
        
        tblCategorias.setSelectionMode(SINGLE_SELECTION);
        tblCategorias.setDefaultEditor(Object.class, null);
        
        cargarTablaCategorias();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnMostrarDetalles = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 30, 66));

        jPanel16.setBackground(new java.awt.Color(1, 91, 187));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apla.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(35, 35, 35))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnProductos.setBackground(new java.awt.Color(0, 29, 63));
        btnProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N
        btnProductos.setText("   Productos      ");
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setFocusPainted(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnMarcas.setBackground(new java.awt.Color(0, 29, 63));
        btnMarcas.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marcas.png"))); // NOI18N
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
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        btnCategorias.setText("  Categorias      ");
        btnCategorias.setBorder(null);
        btnCategorias.setBorderPainted(false);
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
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnSalir)
                .addGap(0, 187, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 44, 44));
        jLabel2.setText("Métodos de Ordenamiento Directo");

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
        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Burbuja", "Selección", "Inserción" }));

        cbxOrdenar.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        cbxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(19, Short.MAX_VALUE))
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
        jLabel7.setText("Detalles de la Categoría");

        jLabel12.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel8.setText("Descripción:");

        txtDescripcion.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N

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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnMostrarDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Categorias");

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("Administra las categorías de los productos");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 44, 44));
        jLabel10.setText("Tabla de categorías");

        tblCategorias.setBackground(new java.awt.Color(0, 63, 156));
        tblCategorias.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCategorias);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        new FormMarcas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void cbxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrdenarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        new FormProductos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new FormLogin().setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRecorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorrerActionPerformed
        cargarTablaCategorias();
    }//GEN-LAST:event_btnRecorrerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblCategorias.getSelectedRow();
        
        if (fila == -1) {
            Mensajes.error("Selecciona una categoria de la tabla.");
            return;
        }
        
        int id = (int) modelo.getValueAt(fila, 0);
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(id);
        boolean activo = (boolean) modelo.getValueAt(fila, 3);
        
        if (!activo) {
            Mensajes.error("El registro ya está eliminado (inactivo).");
            return;
        }
        
        boolean confirmacion = Mensajes.confirmacion("¿Está seguro que desea eliminar la categoria?", "Eliminación de Categoria");
        
        if (confirmacion) {
            try {
                cateControl.eliminarCategoria(categoria);
                Mensajes.exito("La categoria ha sido eliminado correctamente!");
                cargarTablaCategorias();
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Categoria cateAgregar = new Categoria();
        
        try {
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();

            cateAgregar.setNombreCategoria(nombre);
            cateAgregar.setDescripcion(descripcion);

            cateControl.registrarCategoria(cateAgregar);
            Mensajes.exito("Se ha guardado la categoria exitosamente!");
            cargarTablaCategorias();
            
            txtNombre.setText("");
            txtDescripcion.setText("");
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMostrarDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDetallesActionPerformed
        int fila = tblCategorias.getSelectedRow();
                
        if (fila == -1){
            Mensajes.error("Seleccione una categoria de la tabla.");
            return;
        }
                        
        try {
            Categoria cateAgregar = listaCategorias.get(fila);
            txtNombre.setText(cateAgregar.getNombreCategoria());
            txtDescripcion.setText(cateAgregar.getDescripcion());
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnMostrarDetallesActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = tblCategorias.getSelectedRow();
                
        if (fila == -1){
            Mensajes.error("Seleccione una categoria de la tabla.");
            return;
        }
                        
        try {
            Categoria cateActualizar = listaCategorias.get(fila);
            
            String nombreCate = txtNombre.getText();
            String descripcionCate = txtDescripcion.getText();
            
            cateActualizar.setNombreCategoria(nombreCate);
            cateActualizar.setDescripcion(descripcionCate);
            
            cateControl.actualizarCategoria(cateActualizar);
            Mensajes.exito("La categoria ha sido actualizada exitosamente!");
            limpiarTextsAreas();
            cargarTablaCategorias();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        if (listaCategorias == null || listaCategorias.isEmpty()) {
            Mensajes.error("No hay categorías cargadas para ordenar.");
            return;
        }

        Categoria[] arreglo = listaCategorias.toArray(new Categoria[0]);
        Comparator<Categoria> comparador = obtenerComparadorCategoria();
        String metodo = (String) cbxMetodo.getSelectedItem();

        switch (metodo) {
            case "Burbuja" ->
                AlgoritmoOrdenamientoDirecto.burbuja(arreglo, comparador);
            case "Selección" ->
                AlgoritmoOrdenamientoDirecto.seleccion(arreglo, comparador);
            case "Inserción" ->
                AlgoritmoOrdenamientoDirecto.insercion(arreglo, comparador);
            default -> {
                Mensajes.error("Seleccione un método de ordenamiento válido.");
                return;
            }
        }

        actualizarTablaConArreglo(arreglo);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void limpiarTextsAreas() {
        txtNombre.setText("");
        txtDescripcion.setText("");
    }
    
    private void cargarTablaCategorias() {
        modelo.setRowCount(0);
        
        try {            
            listaCategorias = cateControl.verTodasLasCategorias();
            
            for (Categoria cate : listaCategorias) {
                Object[] fila = new Object[]{
                    cate.getIdCategoria(),
                    cate.getNombreCategoria(),
                    cate.getDescripcion(),
                    cate.isEstado(),
                    cate.getFechaCreacion(),
                    cate.getFechaModificacion()
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }
    
    private void actualizarTablaConArreglo(Categoria[] arreglo) {
        modelo.setRowCount(0);
        for (Categoria cate : arreglo) {
            Object[] fila = new Object[]{
                cate.getIdCategoria(),
                cate.getNombreCategoria(),
                cate.getDescripcion(),
                cate.isEstado(),
                cate.getFechaCreacion(),
                cate.getFechaModificacion()
            };
            modelo.addRow(fila);
        }
        listaCategorias = new ArrayList<>(Arrays.asList(arreglo));
    }
    
    private Comparator<Categoria> obtenerComparadorCategoria() {
        String campo = (String) cbxOrdenar.getSelectedItem();
        return switch (campo) {
            default ->
                Comparator.comparingInt(Categoria::getIdCategoria);
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
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxOrdenar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
