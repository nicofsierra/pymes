package ar.com.pymes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDireccion;
	private Integer piso;
	private Integer dpto;
	private Integer altura;
	private String entreCalle1;
	private String entreCalle2;
	private String cp;
	
	@OneToOne(mappedBy="direccion")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="calle")
	private Calle calle;
	
	public Direccion(){}

	public Direccion(Long idDireccion, Integer piso, Integer dpto, String entreCalle1,
			String entreCalle2, Cliente cliente, Calle calle , String cp , Integer altura) {
		super();
		this.idDireccion = idDireccion;
		this.piso = piso;
		this.dpto = dpto;
		this.entreCalle1 = entreCalle1;
		this.entreCalle2 = entreCalle2;
		this.cliente = cliente;
		this.calle = calle;
		this.cp = cp;
		this.altura = altura;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getDpto() {
		return dpto;
	}

	public void setDpto(Integer dpto) {
		this.dpto = dpto;
	}

	public String getEntreCalle1() {
		return entreCalle1;
	}

	public void setEntreCalle1(String entreCalle1) {
		this.entreCalle1 = entreCalle1;
	}

	public String getEntreCalle2() {
		return entreCalle2;
	}

	public void setEntreCalle2(String entreCalle2) {
		this.entreCalle2 = entreCalle2;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calle getcalle() {
		return calle;
	}

	public void setcalle(Calle calle) {
		this.calle = calle;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
}
