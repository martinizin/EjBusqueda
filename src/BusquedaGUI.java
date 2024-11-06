import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaGUI {
    private JTextField textField1;
    private JButton AGREGARButton;
    private JButton ELIMINARButton;
    private JButton ORDENARButton;
    private JButton BUSCARLINEALButton;
    private JButton BUSCARINTERPOLADAButton;
    private JButton MOSTRARButton;
    private JTextArea txtResultado;
    private JPanel pGeneral;
    Lista lista=new Lista();

    public BusquedaGUI() {
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, txtResultado);
                    textField1.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido");
                }
            }

        });

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor, txtResultado);
                    textField1.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido");
                }

            }
        });

        ORDENARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarBurbuja(txtResultado);
                JOptionPane.showMessageDialog(null,"Lista ordenada");
            }
        });

        BUSCARLINEALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField1.getText();
                try {
                    int valor=Integer.parseInt(input);
                    int posicion=lista.buscarLineal(valor,txtResultado);
                    if(posicion==-1){


                    }else {
                        JOptionPane.showMessageDialog(null,"Elemento: " +valor+ "encontrado en la posicion"+posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Elemento erróneo");
                }
            }
        });

        BUSCARINTERPOLADAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField1.getText();
                try {
                    int valor=Integer.parseInt(input);
                    int posicion=lista.busquedaInterpolada(valor,txtResultado);
                    if(posicion==-1){


                    }else {
                        JOptionPane.showMessageDialog(null,"Elemento: " +valor+ "encontrado en la posicion"+posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Elemento erróneo");
                }

            }
        });

        MOSTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(txtResultado);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaGUI");
        frame.setContentPane(new BusquedaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
