package demo.model;

import javafx.beans.property.SimpleObjectProperty;

/**
 * Modelo para la clase User.
 *
 * @author jesus
 */
public class User {

  public final SimpleObjectProperty<Integer> id;
  public final SimpleObjectProperty<String> email;
  public final SimpleObjectProperty<String> phone;
  public final SimpleObjectProperty<String> address;

  /**
   * Default constructor.
   */
  public User() {
    this(0, "", "", "");
  }

  public User(Integer id, String email, String phone, String address) {
    this.id = new SimpleObjectProperty<Integer>(id);
    this.email = new SimpleObjectProperty<String>(email);
    this.phone = new SimpleObjectProperty<String>(phone);
    this.address = new SimpleObjectProperty<String>(address);
  }

  public Integer getId() {
    return id.get();
  }

  public void setId(Integer id) {
    this.id.set(id);
  }

  public String getEmail() {
    return email.get();
  }

  public void setEmail(String email) {
    this.email.set(email);
  }

  public String getPhone() {
    return phone.get();
  }

  public void setPhone(String phone) {
    this.phone.set(phone);
  }

  public String getAddress() {
    return address.get();
  }

  public void setAddress(String address) {
    this.address.set(address);
  }

  @Override
  public String toString() {
    return email.get();
  }
}
