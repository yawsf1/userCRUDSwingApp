package metier;

import java.util.ArrayList;

public interface IUserService {
    void creerUser(User user);
    void modifierUser(User user);
    void supprimerUser(int id);
    User obtenirUser(int id);
    ArrayList<User> obtenirTousLesUsers();
    boolean validerEmail(String email);
}