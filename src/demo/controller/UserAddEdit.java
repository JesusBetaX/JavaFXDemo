package demo.controller;

import demo.App;
import demo.dao.UserDao;
import demo.model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javax.swing.JOptionPane;

/**
 * Formulario del recurso User.
 * 
 * @author jesus
 */
public class UserAddEdit implements Initializable {

  private User user;
    
  @FXML Hyperlink back;
  @FXML TextField email;
  @FXML TextField phone;
  @FXML TextField address;
    
  /**
   * Inicializa la clase del controlador. Este método se llama 
   * automáticamente igual que El archivo fxml.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // Recupera el user selecionado anteriormente en UserList.
    user = (User) App.getInstance().getParam("user");

    email.setText(user.getEmail());
    phone.setText(user.getPhone());
    address.setText(user.getAddress());

    if (user.getId() == 0) {
      email.setEditable(Boolean.TRUE);
    }
  }

  /**
   * Evento de boton 'delete'. Elimina registro.
   *
   * @param event
   */
  @FXML
  private void handleDeleteAction(ActionEvent event) {
    UserDao.getInstance().delete(user);
    App.getInstance().gotoView("view/UserList.fxml", "List");
  }

  /**
   * Evento de boton 'save'. Agrega o edita el registro.
   *
   * @param event
   */
  @FXML
  private void handleSaveAction(ActionEvent event) {
    if (isInputValid()) {
      user.setEmail(email.getText());
      user.setPhone(phone.getText());
      user.setAddress(address.getText());

      UserDao.getInstance().save(user);
      App.getInstance().gotoView("view/UserList.fxml", "List");
    }
  }

  /**
   * Evento de link 'back'. Regresamos a la lista.
   *
   * @param event
   */
  @FXML
  private void handleBackAction(ActionEvent event) {
    App.getInstance().gotoView("view/UserList.fxml", "List");
  }

  /**
   * Validates the user input in the text fields.
   *
   * @return true if the input is valid
   */
  private boolean isInputValid() {
    String errorMessage = "";

    if (email.getText() == null || email.getText().length() == 0) {
      errorMessage += "No valid email!\n";
    }
    if (phone.getText() == null || phone.getText().length() == 0) {
      errorMessage += "No valid phone!\n";
    }
    if (address.getText() == null || address.getText().length() == 0) {
      errorMessage += "No valid address!\n";
    }

    if (errorMessage.length() == 0) {
      return true;
    } else {

      JOptionPane.showMessageDialog(null,
              "Please correct invalid fields\n" + errorMessage,
              "Invalid Fields",
              JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }
}
