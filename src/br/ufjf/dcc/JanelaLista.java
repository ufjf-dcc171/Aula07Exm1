package br.ufjf.dcc;

import com.sun.media.sound.ModelOscillator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

class JanelaLista extends JFrame{
    private final JLabel lblNumero = new JLabel("Número");
    private final JTextField txtNumero = new JTextField("0", 20);
    private final JButton btnExcluir = new JButton("Excluir");
    private final JList lstLista = new JList(new DefaultListModel());

    public JanelaLista() throws HeadlessException {
        super("Listas");
        setLayout(new BorderLayout(5,5));
        JPanel pnlEntrada = new JPanel(new BorderLayout(5,5));
        
        pnlEntrada.add(lblNumero, BorderLayout.WEST);
        pnlEntrada.add(txtNumero, BorderLayout.CENTER);
        add(pnlEntrada, BorderLayout.NORTH);
        add(btnExcluir, BorderLayout.SOUTH);
        add(new JScrollPane(lstLista), BorderLayout.CENTER);
        lstLista.setVisibleRowCount(10);
        DefaultListModel modelo = (DefaultListModel) lstLista.getModel();
       modelo.addElement("10");
       modelo.addElement("20");
       modelo.addElement("30");
       lstLista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        System.out.println(modelo.getSize());
        
       txtNumero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addElement(txtNumero.getText());
                txtNumero.setText("");
                txtNumero.requestFocus();
                
            }
        });
       
       btnExcluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for(Object o: lstLista.getSelectedValuesList()){
                    System.out.println(o);
                    modelo.removeElement(o);
                }
            }
        });
    }
    
    
}
