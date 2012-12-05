package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class xEsposax extends xUsuariox{
	
	//@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Long id;
	long cupo;
	@OneToMany
	@JoinTable(name = "EsposaCompra", joinColumns = @JoinColumn(name = "CompraE"), inverseJoinColumns = @JoinColumn(name = "EsposaC")) 
	List<xTransaccionx> compra = new ArrayList<xTransaccionx>();

	@ManyToOne
	xPoligamox marido;
		
	
	public List<xTransaccionx> getCompra() {
		return compra;
	}
	public void setCompra(List<xTransaccionx> compra) {
		this.compra = compra;
	}
	
	public long getCupo() {
		return cupo;
	}
	public void setCupo(long cupo) {
		this.cupo = cupo;
	}
	public xPoligamox getMarido() {
		return marido;
	}
	public void setMarido(xPoligamox marido) {
		this.marido = marido;
	}
}
