package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.Session;

import hibernateUtil.HibernateUtil;

@Entity
public class Cartao {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
	private String numero;
	@Column
	private String codigo;
	@Column
	private String bandeira;
	@Column
	private double limite;

	@Transient
	protected String msg = null;
	
	@ManyToOne
	@JoinColumn(name = "idCorrente", nullable = true)
	public Corrente corrente;

	public Cartao() {
		super();
	}

	public Cartao(long id, String nome, String numero, String codigo, String bandeira, double limite) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.codigo = codigo;
		this.bandeira = bandeira;
		this.limite = limite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getMsg() {
		return msg;
	}

	public Corrente getCorrente() {
		return corrente;
	}

	public void setCorrente(Corrente corrente) {
		this.corrente = corrente;
	}
	
	public boolean salvar() {
		try {
			if (getNome() == null || getNome().isEmpty()) {
				msg="Nome em branco!";
				return false;
			} else if (getNumero() == null || getNumero().isEmpty()) {
				msg="Número em branco!";
				return false;
			} else if (getCodigo() == null) {
				msg="Código em branco!";
				return false;
			} else if (getBandeira() == null) {
				msg="Bandeira em branco!";
				return false;
			} else if (getLimite() < 0) {
				msg="Limite em branco!";
				return false;
			} else {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			session.save(this);

			session.getTransaction().commit();
			HibernateUtil.fecharSession();

			msg = "Cartão cadastrado com sucesso!";
			return true;
			}
		} catch (

		Exception e) {
			msg = e.toString();
			return false;
		}
	}

	
}
