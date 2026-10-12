package vista.area4Historial;

import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controlador.MovimientoInventarioController;
import modelo.MovimientoInventario;
import util.ControlAcceso;
import util.SesionActual;
import util.ListaEnlazadaDoble;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import vista.area5AjusteStock.*;
import vista.area2Categorias.*;
import vista.area1Productos.*;
import vista.area0Login.FormLogin;
import vista.area3Marcas.FormMarcas;
import vista.area6Administracion.FormAdministracion;


public class FormHistorial extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormHistorial.class.getName());

// Modelo y controladores
    private final DefaultTableModel modeloHistorial = new DefaultTableModel();
    private final MovimientoInventarioController movControl = new MovimientoInventarioController();
    private ListaEnlazadaDoble listaDoblePaginada;
    
// Paginación 
    
    
    
private void cargarYPaginarMovimientos() {
    try {
        List<MovimientoInventario> todosLosMovimientos = movControl.verTodosLosMovimientos();
        listaDoblePaginada = new ListaEnlazadaDoble(todosLosMovimientos, 15);
        
        if (listaDoblePaginada.getActual() != null) {
            actualizarTabla(listaDoblePaginada.getActual().getSubLista());
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el historial: " + e.getMessage());
    }
}



private void actualizarTabla(List<MovimientoInventario> listaPagina) {
    if (listaPagina == null) return;
    modeloHistorial.setRowCount(0);

    for (MovimientoInventario m : listaPagina) {
        Integer idProd = (m.getProducto() != null) ? m.getProducto().getIdProducto() : null;
        Integer idEmp = (m.getEmpleado() != null) ? m.getEmpleado().getIdEmpleado() : null;
        
        Object[] fila = new Object[]{
            m.getIdMovimiento(),
            idProd,
            idEmp,
            m.getTipoMovimiento() != null ? m.getTipoMovimiento().name() : "",
            m.getCantidad(),
            m.getStockAnterior(),
            m.getStockNuevo(),
            m.getMotivo() != null ? m.getMotivo() : "-",    
            m.getIdCompra() != null ? m.getIdCompra() : "-",
            m.getIdVenta() != null ? m.getIdVenta() : "-",
            m.getFechaMovimiento() != null ? m.getFechaMovimiento().toString() : ""
        };
        modeloHistorial.addRow(fila);
    }
}
    
public FormHistorial() {
        initComponents();
        ControlAcceso.configurarVentana(this, btnAjusteStock, btnAdministracion);
        btnHistorial.setBackground(Color.decode("#015BBB"));
        tblHistorial.setModel(modeloHistorial);
        Object[] columnas = new Object[]{
            "id",
            "Producto",
            "Empleado",
            "Tipo_movimiento",
            "Cantidad",
            "Stock_anterior",
            "Stock_nuevo",
            "Motivo",
            "id_compra",
            "id_venta",
            "fecha_movimiento"
        };
        modeloHistorial.setColumnIdentifiers(columnas);
        tblHistorial.setSelectionMode(SINGLE_SELECTION);
        tblHistorial.setDefaultEditor(Object.class, null);
        cargarYPaginarMovimientos();
        
        int[] anchos = {40, 65, 70, 100, 65, 90, 85, 170, 65, 60, 130};
        for (int i = 0; i < anchos.length; i++) {
        tblHistorial.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
}

        btnInicio.addActionListener(this::btnInicioActionPerformed);
        btnAnterior.addActionListener(this::btnAnteriorActionPerformed);
        btnSiguiente.addActionListener(this::btnSiguienteActionPerformed);
        btnFin.addActionListener(this::btnFinActionPerformed);
    }

    @SuppressWarnings("unchecked")
    
    

    // Acciones de los botones de navegación de la lista doble
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (listaDoblePaginada != null) {
            actualizarTabla(listaDoblePaginada.irPrimero());
        }
    }                                       

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (listaDoblePaginada != null) {
            actualizarTabla(listaDoblePaginada.irAnterior());
        }
    }                                         

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (listaDoblePaginada != null) {
            actualizarTabla(listaDoblePaginada.irSiguiente());
        }
    }                                          

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (listaDoblePaginada != null) {
            actualizarTabla(listaDoblePaginada.irUltimo());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnInicio = new javax.swing.JButton();
        btnFin = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnMarcas = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnAdministracion = new javax.swing.JButton();
        btnAjusteStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Historial de movimientos");

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("Administra el historial de los movimientos");

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        tblHistorial.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblHistorial);

        btnInicio.setBackground(new java.awt.Color(204, 255, 255));
        btnInicio.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(0, 0, 0));
        btnInicio.setText("Inicio");

        btnFin.setBackground(new java.awt.Color(204, 255, 255));
        btnFin.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnFin.setForeground(new java.awt.Color(0, 0, 0));
        btnFin.setText("Fin");

        btnSiguiente.setBackground(new java.awt.Color(102, 255, 102));
        btnSiguiente.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(0, 0, 0));
        btnSiguiente.setText("Siguiente");

        btnAnterior.setBackground(new java.awt.Color(255, 102, 102));
        btnAnterior.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(0, 0, 0));
        btnAnterior.setText("Anterior");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnFin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 30, 66));

        jPanel13.setBackground(new java.awt.Color(1, 91, 187));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apla.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(35, 35, 35))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnProductos.setBackground(new java.awt.Color(0, 29, 63));
        btnProductos.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N
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
        btnMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/marcas.png"))); // NOI18N
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
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAjusteStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAjusteStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnSalir)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        new FormProductos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        new FormMarcas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        new FormCategorias().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        SesionActual.cerrarSesion();
        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracionActionPerformed
        if (!ControlAcceso.validarAdministracion()) {
            return;
        }
        
        new FormAdministracion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministracionActionPerformed

    private void btnAjusteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjusteStockActionPerformed
        if (!ControlAcceso.validarAjusteStock()) {
            return;
        }
        
        new FormAjusteStock().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAjusteStockActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnAjusteStock;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnFin;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorial;
    // End of variables declaration//GEN-END:variables
}
