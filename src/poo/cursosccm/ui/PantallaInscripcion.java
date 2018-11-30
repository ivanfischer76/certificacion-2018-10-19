/*
 * 
 */
package poo.cursosccm.ui;

import javax.swing.JOptionPane;
import poo.cursosccm.controller.GestorInscripcion;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Participantes;
import poo.cursosccm.entity.Tematicas;

/**
 * Clase de tipo Interfaz encargada de interactuar con el usuario.
 * @author Iván Fischer
 */
public class PantallaInscripcion extends javax.swing.JFrame {
    //declaramos los objetos necesarios para desarrollar la funcionalidad de la clase
    private final GestorInscripcion gestor;       
    private final TematicasComboBoxModel tematicasComboBoxModel;
    private CursosTableModel cursosTableModel;
    private final TematicasItemListener tematicasItemListener;
    private Participantes participante;
    private Cursos cursoSeleccionado;
    
    /**
     * Constructor principal de la Clase
     * @param gestor un objeto de tipo GestorInscripcion.
     */
    public PantallaInscripcion(GestorInscripcion gestor) {
        this.gestor = gestor;
        this.tematicasComboBoxModel = new TematicasComboBoxModel(gestor.listarTematicas());
        this.tematicasItemListener = new TematicasItemListener(this, gestor); 
        participante = null;
        cursoSeleccionado = null;
        initComponents();      
    }

    /**
     * Permite obtener el ItemListener asociado al JComboBox cbTematicas.
     * @return TematicasItemListener un objeto de tipo TematicasItemListener.
     */
    public TematicasItemListener getTematicasItemListener() {
        return tematicasItemListener;
    }
    
    /**
     * Este método se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método 
     * siempre es regenerado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngRegistro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbEstudianteRegistrado = new javax.swing.JRadioButton();
        rbEstudianteNoRegistrado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbTematicas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        btnInscribirse = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Inscripcion a Cursos del Centro Cultural Municipal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Estudiante", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        btngRegistro.add(rbEstudianteRegistrado);
        rbEstudianteRegistrado.setSelected(true);
        rbEstudianteRegistrado.setText("Estudiante Registrado");

        btngRegistro.add(rbEstudianteNoRegistrado);
        rbEstudianteNoRegistrado.setText("Estudiante No Registrado");

        jLabel1.setText("Ingrese su e-mail: ");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Apellido: ");

        lblNombre.setText("---");

        lblApellido.setText("---");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(rbEstudianteRegistrado)
                        .add(65, 65, 65)
                        .add(jLabel1))
                    .add(rbEstudianteNoRegistrado))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnBuscar))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblNombre)
                            .add(lblApellido))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rbEstudianteRegistrado)
                    .add(jLabel1)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBuscar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rbEstudianteNoRegistrado)
                    .add(jLabel2)
                    .add(lblNombre))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(lblApellido))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cursos Vigentes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel4.setText("Temáticas:");

        cbTematicas.setToolTipText("");
        cbTematicas.setEnabled(false);

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Profesor", "Aula", "Duración", "Carga Horaria", "Cupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCursos.setEnabled(false);
        jScrollPane1.setViewportView(tablaCursos);
        if (tablaCursos.getColumnModel().getColumnCount() > 0) {
            tablaCursos.getColumnModel().getColumn(0).setResizable(false);
            tablaCursos.getColumnModel().getColumn(1).setResizable(false);
            tablaCursos.getColumnModel().getColumn(2).setResizable(false);
            tablaCursos.getColumnModel().getColumn(3).setResizable(false);
            tablaCursos.getColumnModel().getColumn(4).setResizable(false);
            tablaCursos.getColumnModel().getColumn(5).setResizable(false);
        }

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(cbTematicas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbTematicas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
        );

        btnInscribirse.setText("Inscribirse");
        btnInscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirseActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnInscribirse)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnInscribirse)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //centramos el formulario en la pantalla.
        this.setLocationRelativeTo(null);
        //pasamos el foco a la caja de texo de e-mail del participante.
        txtEmail.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //verificamos si el participante existe en la base de datos
        participante = gestor.buscarParticipante(txtEmail.getText());
        if(participante!=null){
            //si existe habilitamos la inscripcion
            habilitarInscripcion();
        }else{
            // si no existe deshabilitamos la inscripcion
            deshabilitarInscripcion();
        }      
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirseActionPerformed
        obtenerCursoSeleccionado();
        //si se ha seleccionado un curso de la tabla generamos la inscripción
        if(cursoSeleccionado!=null){
            gestor.generarInscripcion(participante, cursoSeleccionado);
        }else{
            //sino damos una advertencia al usuario indicando que debe seleccionar un curso para inscribirse.
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún curso.\n"
            + "Debe seleccionar un curso para inscribirse", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnInscribirseActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInscribirse;
    private javax.swing.ButtonGroup btngRegistro;
    private javax.swing.JComboBox<Tematicas> cbTematicas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JRadioButton rbEstudianteNoRegistrado;
    private javax.swing.JRadioButton rbEstudianteRegistrado;
    private javax.swing.JTable tablaCursos;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método asigna el curso seleccionado en la tabla al campo cursoSeleccionado.
     */
    public void obtenerCursoSeleccionado() {
        int filaSeleccionada = tablaCursos.getSelectedRow();       
        // validamos que haya una fila seleccionada
        if (filaSeleccionada >= 0) {   
            //si hay una fila seleccionada obtenemos el curso correspondiente.
            cursoSeleccionado = cursosTableModel.obtenerCursoEn(filaSeleccionada);  
        }       
    }
    
    /**
     * Este método obtiene la temática seleccionada en el JComboBox cbTematicas.
     * @return tematica un objeto de tipo Tematicas que está seleccionado en el JComboBox.
     */
    public Tematicas obtenerTematicaSeleccionada() {
        Tematicas tematica = null;
        int indice = cbTematicas.getSelectedIndex();        
        // validamos que haya una indice seleccionado
        if (indice >= 0) {
            tematica = tematicasComboBoxModel.obtenerTematicaEn(indice);
            cursosTableModel = new CursosTableModel(gestor.listarCursos(tematica));
            tablaCursos.setModel(cursosTableModel);
        }       
        return tematica;
    }

    private void habilitarInscripcion() {
        cbTematicas.setModel(tematicasComboBoxModel);
        cbTematicas.addItemListener(tematicasItemListener);
        cursosTableModel = new CursosTableModel(gestor.listarCursos(this.obtenerTematicaSeleccionada())); 
        tablaCursos.setModel(cursosTableModel);
        rbEstudianteRegistrado.setSelected(true);
        lblApellido.setText(gestor.buscarParticipante(txtEmail.getText()).getApellido());
        lblNombre.setText(gestor.buscarParticipante(txtEmail.getText()).getNombre());
        cbTematicas.setEnabled(true);
        tablaCursos.setEnabled(true);
        tablaCursos.setVisible(true);
    }

    private void deshabilitarInscripcion() {
        rbEstudianteNoRegistrado.setSelected(true);
        lblApellido.setText("---");
        lblNombre.setText("---");
        cbTematicas.setEnabled(false);
        tablaCursos.setEnabled(false);
        tablaCursos.setVisible(false);
    }
    
    /**
     * Establece el modelo de la tabla tablaCursos
     * @param miModel un modelo de tipo CursosTablaModel.
     */
    public void setTableModel(CursosTableModel miModel){
        tablaCursos.setModel(miModel);
    }
    
}
