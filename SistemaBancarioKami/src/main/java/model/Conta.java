package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String agencia;
	
	@Column
	private String nrConta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario", nullable = true, foreignKey = @ForeignKey(name = "fkContaUsuario"))
	protected Usuario user;
	
	@Column
	private double saldo;

	@Transient
	protected String msg = null;
	
	public Conta() {
		super();
	}

	public Conta(long id, String agencia, String nrConta, Usuario user, double saldo) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.nrConta = nrConta;
		this.user = user;
		this.saldo = saldo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", agencia: " + agencia + ", nrConta: " + nrConta + ", titular: " + user.getNome() + ", saldo: "
				+ saldo;
	}
	
}
