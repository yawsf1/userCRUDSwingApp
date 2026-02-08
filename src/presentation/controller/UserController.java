package presentation.controller;

import metier.User;
import metier.IUserService;
import metier.UserService;
import presentation.view.UserView;
import java.util.List;

public class UserController {

    private UserView view;
    private IUserService userService;

    public UserController(UserView view) {
        this.view = view;
        this.userService = new UserService();
    }

    public void ajouterUser(String nom, String prenom, String email) {
        User user = new User(nom, prenom, email);
        userService.creerUser(user);
        rafraichirListe();
    }

    public void modifierUser(int id, String nom, String prenom, String email) {
        User user = new User(id, nom, prenom, email);
        userService.modifierUser(user);
        rafraichirListe();
    }

    public void supprimerUser(int id) {
        userService.supprimerUser(id);
        rafraichirListe();
    }

    public void rafraichirListe() {
        List<User> users = userService.obtenirTousLesUsers();
        view.afficherUsers(users);
    }

    public User obtenirUser(int id) {
        return userService.obtenirUser(id);
    }
}