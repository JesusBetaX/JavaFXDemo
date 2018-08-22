package demo.controller;

import demo.App;
import demo.dao.UserDao;
import demo.model.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.*;

/**
 * Listado del recurso User.
 *
 * @author jesus
 */
public class UserList implements Initializable {

  @FXML TableView<User> table;
  @FXML TableColumn<User, String> email;
  @FXML TableColumn<User, String> phone;
  @FXML TableColumn<User, String> address;

  /**
   * Inicializa la clase del controlador. Este método se llama 
   * automáticamente igual que El el archivo fxml.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // Llenamos la tabla con registros.
    ArrayList<User> users = UserDao.getInstance().findAll();
    table.setItems(FXCollections.observableArrayList(users));

    // Le decimos a las columnas de la tabla que campos deben agarrar del
    // modelo User.
    email.setCellValueFactory(
            new PropertyValueFactory<User, String>("email"));

    phone.setCellValueFactory(
            new PropertyValueFactory<User, String>("phone"));

    address.setCellValueFactory(
            new PropertyValueFactory<User, String>("address"));
  }

  /**
   * Evento de boton 'add'. Abre el formulario para agregar un nuevo registro.
   *
   * @param event
   */
  @FXML
  private void handleAddAction(ActionEvent event) {
    // Obtenemos la instancia de la aplicacion principal.
    // Agregamos el parametro user.
    // Mostramos la vista para agregar.
    App.getInstance()
            .putParam("user", new User())
            .gotoView("view/UserAddEdit.fxml", "User");
  }

  /**
   * Evento de la Tabla 'table'. Abre el formulario para editar el registro
   * seleccionado.
   *
   * @param event
   */
  @FXML
  private void handleTableMousePressed(MouseEvent t) {
    User user = table.getSelectionModel().getSelectedItem();
    if (user != null) {
      // Obtenemos la instancia de la aplicacion principal.
      // Agregamos el parametro user.
      // Mostramos la vista para editar.
      App.getInstance()
              .putParam("user", user)
              .gotoView("view/UserAddEdit.fxml", "User");
    }
  }
}
