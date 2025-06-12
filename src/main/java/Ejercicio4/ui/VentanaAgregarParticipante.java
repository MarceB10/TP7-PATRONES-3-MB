package Ejercicio4.ui;

import Ejercicio4.model.Participantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaAgregarParticipante extends JFrame {

    private final Participantes participanteService;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;

    public VentanaAgregarParticipante(Participantes participanteService){
        this.participanteService = participanteService;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        this.email = new JTextField(10);
        this.email.setText("");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar(nombre.getText(), telefono.getText(), region.getText(), email.getText());
                } catch (SQLException e1) {
                    throw new RuntimeException(e1.getMessage());
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar(String nombre,String telefono,String region, String email) throws SQLException {
        this.participanteService.nuevoParticipante(nombre,telefono,region, email);
    }
}
