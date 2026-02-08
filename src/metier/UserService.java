package metier;

import dao.IUserDAO;
import dao.UserDAO;

import javax.swing.*;
import java.util.ArrayList;

public class UserService implements IUserService {
    private IUserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    @Override
    public void creerUser(User user) {
        if (validerEmail(user.getEmail())) {
            userDAO.ajouter(user);
        }
    }

    @Override
    public void modifierUser(User user) {
        if (validerEmail(user.getEmail())) {
            userDAO.modifier(user);
        }

    }

    @Override
    public void supprimerUser(int id) {
        userDAO.supprimer(id);
    }

    @Override
    public User obtenirUser(int id) {
        return userDAO.trouverParId(id);
    }

    @Override
    public ArrayList<User> obtenirTousLesUsers() {
        return userDAO.trouverTous();
    }

    @Override
    public boolean validerEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
