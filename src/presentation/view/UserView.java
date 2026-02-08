package presentation.view;

import metier.User;
import presentation.controller.UserController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserView extends JFrame {

    private UserController controller;

    private JTextField txtNom, txtPrenom, txtEmail;
    private JButton btnAjouter, btnModifier, btnSupprimer, btnRafraichir;
    private JTable tableUsers;
    private DefaultTableModel tableModel;

    public UserView() {
        controller = new UserController(this);
        initComponents();
        controller.rafraichirListe();
    }

    private void initComponents() {
        setTitle("Gestion des Users");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Informations User"));

        panelForm.add(new JLabel("Nom:"));
        txtNom = new JTextField();
        panelForm.add(txtNom);

        panelForm.add(new JLabel("Prénom:"));
        txtPrenom = new JTextField();
        panelForm.add(txtPrenom);

        panelForm.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelForm.add(txtEmail);

        add(panelForm, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new FlowLayout());

        btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> ajouterUser());
        panelButtons.add(btnAjouter);

        btnModifier = new JButton("Modifier");
        btnModifier.addActionListener(e -> modifierUser());
        panelButtons.add(btnModifier);

        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.addActionListener(e -> supprimerUser());
        panelButtons.add(btnSupprimer);

        btnRafraichir = new JButton("Rafraîchir");
        btnRafraichir.addActionListener(e -> controller.rafraichirListe());
        panelButtons.add(btnRafraichir);

        add(panelButtons, BorderLayout.CENTER);

        String[] colonnes = {"ID", "Nom", "Prénom", "Email"};
        tableModel = new DefaultTableModel(colonnes, 0);
        tableUsers = new JTable(tableModel);
        tableUsers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                remplirFormulaire();
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableUsers);
        add(scrollPane, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void ajouterUser() {
        String nom = txtNom.getText().trim();
        String prenom = txtPrenom.getText().trim();
        String email = txtEmail.getText().trim();
        
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!");
        } else if (!validerEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email invalide!");
        } else {
            controller.ajouterUser(nom, prenom, email);
            viderFormulaire();
        }
    }

    private void modifierUser() {
        int selectedRow = tableUsers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un user!");
        }

        else {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String email = txtEmail.getText().trim();
            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!");
            } else if (!validerEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email invalide!");
            }
            else  {
                controller.modifierUser(id, nom, prenom, email);
                viderFormulaire();
            }
        }
    }

    private void supprimerUser() {
        int selectedRow = tableUsers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un user!");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Voulez-vous vraiment supprimer ce user?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            controller.supprimerUser(id);
            viderFormulaire();
        }
    }

    private void remplirFormulaire() {
        int selectedRow = tableUsers.getSelectedRow();
        if (selectedRow != -1) {
            txtNom.setText((String) tableModel.getValueAt(selectedRow, 1));
            txtPrenom.setText((String) tableModel.getValueAt(selectedRow, 2));
            txtEmail.setText((String) tableModel.getValueAt(selectedRow, 3));
        }
    }

    private void viderFormulaire() {
        txtNom.setText("");
        txtPrenom.setText("");
        txtEmail.setText("");
        tableUsers.clearSelection();
    }

    public void afficherUsers(List<User> users) {
        tableModel.setRowCount(0);
        for (User user : users) {
            tableModel.addRow(new Object[]{
                    user.getId(),
                    user.getNom(),
                    user.getPrenom(),
                    user.getEmail()
            });
        }
    }
    public boolean validerEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}