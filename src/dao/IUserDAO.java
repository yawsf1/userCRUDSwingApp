package dao;

import metier.User;

import java.util.ArrayList;

public interface IUserDAO {
    void ajouter(User user);
    void modifier(User user);
    void supprimer(int id);
    User trouverParId(int id);
    ArrayList<User> trouverTous();
}
