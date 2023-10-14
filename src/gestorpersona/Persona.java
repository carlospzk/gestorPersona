
package gestorpersona;

import java.util.Date;

/**
 *
 * @author sergi
 */
public class Persona {
  private String nombre;
  private String apellidos;
  private Date fechaNacimiento;
  private int sexo;
  

  //Constructor vacio
  public Persona() {
  }

  public Persona(String nombre, String apellidos, Date fechaNacimiento, int sexo) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
    this.sexo = sexo;
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

  
    
}
