package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class xPoligamox extends xUsuariox{
	
	//@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Long id;
	int fechaNacimiento;
	@Transient
	int edad;
	@Embedded
	@Column(name="Contacto")
	xDatosContactox datosContacto;
	@OneToMany(mappedBy="marido")
	List<xEsposax> esposas = new ArrayList<xEsposax>();
	
	public List<xEsposax> getEsposas() {
		return esposas;
	}
	public void setEsposas(List<xEsposax> esposas) {
		this.esposas = esposas;
	}
	public int getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public xDatosContactox getDatosContacto() {
		return datosContacto;
	}
	public void setDatosContacto(xDatosContactox datosContacto) {
		this.datosContacto = datosContacto;
	}
}
