package demo;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

/**
 * Clase principal
 *
 * @author jesus
 */
public class App extends Application {

  /** Etapa primaria. */
  private Stage stage;
  
  /** Datos de nuestra App. */
  private final HashMap<String, Object> params;
  
  /** Instancia unica de nuestra App. */
  private static App instance;

  public App() {
    params = new HashMap<String, Object>();
    instance = this;
  }

  public static App getInstance() {
    return instance;
  }
  
  /**
   * Inicia la app.
   *
   * @param stage
   */
  @Override
  public void start(Stage stage) {
    try {
      this.stage = stage;
      gotoView("view/UserList.fxml", "List");
      stage.show();
    } catch (Exception ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * The main() method is ignored in correctly deployed JavaFX application.
   * main() serves only as fallback in case the application can not be launched
   * through deployment artifacts, e.g., in IDEs with limited FX support.
   * NetBeans ignores main().
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Retorna un valor asociado con la llave.
   *
   * @param key llave.
   *
   * @return un object.
   */
  public Object getParam(String key) {
    return params.get(key);
  }

  /**
   * Asigna un valor a la coleccion de datos.
   *
   * @param key llave del valor
   * @param value valor
   * 
   * @return instancia de la app.
   */
  public App putParam(String key, Object value) {
    params.put(key, value);
    return this;
  }

  /**
   * Remplaza la escena del layout.
   *
   * @param fxml vista a llamar
   *
   * @return la escena invoada
   *
   * @throws Exception
   */
  private Parent replaceSceneContent(String fxml) throws Exception {
    Parent page = FXMLLoader.load(App.class.getResource(fxml));
    Scene scene = stage.getScene();
    if (scene == null) {
      scene = new Scene(page, 700, 550);
      //scene.getStylesheets().add(App.class.getResource("bootstrap.css").toExternalForm());
      stage.setScene(scene);
    } else {
      stage.getScene().setRoot(page);
    }
    stage.sizeToScene();
    return page;
  }

  /**
   * Mada llamar la vista que queramos
   * 
   * @param fxml vista a llamar
   * @param titulo titulo de la ventana
   * 
   * @return la escena invoada
   */
  public Parent gotoView(String fxml, String titulo) {
    Parent parent = null;
    try {
      parent = replaceSceneContent(fxml);
      stage.setTitle(titulo);
    } catch (Exception ex) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
    return parent;
  }
}
