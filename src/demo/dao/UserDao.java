package demo.dao;

import demo.model.User;
import java.util.ArrayList;

/**
 * Origen de Datos del recurso User. Esta clase solo sirve para hacer un test
 * cambiar por una conexion a base de datos.
 *
 * @author jesus
 */
public class UserDao {

  //private final ObservableList<User> users = FXCollections.observableArrayList();
  private final ArrayList<User> users;
  
  private static UserDao instance;

  private UserDao() {
    users = new ArrayList<User>();
    users.add(new User(1, "user.a@gmail.com", "3310224480", "AV. A"));
    users.add(new User(2, "user.b@gmail.com", "3310224481", "AV. B"));
    users.add(new User(3, "user.c@gmail.com", "3310224482", "AV. C"));
    users.add(new User(4, "user.d@gmail.com", "3310224483", "AV. D"));
    users.add(new User(5, "user.e@gmail.com", "3310224484", "AV. E"));
  }

  public static UserDao getInstance() {
    if (instance == null) {
      instance = new UserDao();
    }
    return instance;
  }

  public ArrayList<User> findAll() {
    return users;
  }

  public void save(User user) {
    if (!users.contains(user)) {
      users.add(user);
    }
  }

  public boolean delete(User user) {
    return users.remove(user);
  }
}
