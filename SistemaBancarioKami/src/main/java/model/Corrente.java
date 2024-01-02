package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.Session;

import hibernateUtil.HibernateUtil;

@Entity
public class Corrente extends Conta{

	@Column
	private double limite;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCartao", nullable = true, foreignKey = @ForeignKey(name = "fkCorrenteCartao"))
	private List<Cartao> listaCartao = new ArrayList<>(); ;
	
	@Transient
	protected String msg = null;
	
	public Corrente() {
		super();
	}

	public Corrente(long id, String agencia, String nrConta, Usuario user, double saldo, double limite,
			List<Cartao> listaCartao) {
		super(id, agencia, nrConta, user, saldo);
		this.limite = limite;
		this.listaCartao = listaCartao;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public List<Cartao> getListaCartao() {
		return listaCartao;
	}

	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "Corrente " + super.toString() + "limite: " + limite + "]";
	}

	public boolean salvar() {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			session.save(this);

			session.getTransaction().commit();

			HibernateUtil.fecharSession();
			msg = "Conta cadastrada com sucesso!";
			return true;
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public Corrente localizar(long id) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Corrente c = session.find(Corrente.class, id);

			session.getTransaction().commit();
			HibernateUtil.fecharSession();

			if (c != null) {
				c.setAgencia(c.getAgencia());
	            c.setNrConta(c.getNrConta());
	            c.setUser(c.getUser());
	            c.setSaldo(c.getSaldo());
	            c.setLimite(c.getLimite());
	            c.setListaCartao(getListaCartao());
	            
	            List<Cartao> listaCartao = c.getListaCartao(); 
	            c.setListaCartao(listaCartao);
				
	            msg = c.toString();
				return c;
			} else {
				msg = "ID: " + id + " não localizado!";
				return null;
			}
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public boolean atualizarCorrente() {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Corrente c = session.find(Corrente.class, getId());

			if (c == null) {
				msg = "ID não encontrado!";
				return false;
			} else {
				
				c.setAgencia(getAgencia());
				c.setNrConta(getNrConta());
				c.setUser(getUser());
				c.setSaldo(getSaldo());
				c.setLimite(getLimite());
				
				List<Cartao> listaCartao = c.getListaCartao(); 
	            c.setListaCartao(listaCartao);
	            
	            for (Cartao cartao : listaCartao) {
	            	cartao.setNome(cartao.getNome());
	            	cartao.setNumero(cartao.getNumero());
	            	cartao.setCodigo(cartao.getCodigo());
	            	cartao.setBandeira(cartao.getBandeira());
	            	cartao.setLimite(cartao.getLimite());
	            }
				session.update(c);

				session.getTransaction().commit();
				HibernateUtil.fecharSession();
				
				msg = "Conta corrente atualizada com sucesso!";
				return true;
			}

		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean editar(long id, String editar, String novoValor) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Corrente c = session.find(Corrente.class, id);

			if (c == null) {
				msg = "Conta não encontrada";
				return false;
			} else {
				if (editar != null) {
					if (editar.equalsIgnoreCase("nome")) {
						c.getUser().setNome(novoValor);
						msg = "Titular Editado com sucesso!";
					}else if (editar.equalsIgnoreCase("cpf")) {
						c.getUser().setCpf(novoValor);
						msg = "CPF Editado com sucesso!";
					}else if (editar.equalsIgnoreCase("email")) {
						c.getUser().setEmail(novoValor);
						msg = "E-mail Editado com sucesso!";
					}
				}
			
				session.update(c);

				session.getTransaction().commit();
				HibernateUtil.fecharSession();

				return true;
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean deletar(long id) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Corrente c = session.find(Corrente.class, id);

			if (c == null) {
				msg = "ID " + id + " não encontrado!";
				return false;
			} else {
				session.delete(c);

				session.getTransaction().commit();
				HibernateUtil.fecharSession();

				msg = c.toString();
				return true;
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public boolean sacar(long id, double valorSaque) {
		try {
			if (valorSaque <= 0) {
				msg = "Valor do saque inválido";
				return false;
			} else {
				Session session = HibernateUtil.abrirSession();
				session.beginTransaction();

				Corrente c = session.find(Corrente.class, id);
				if (c == null) {
					msg = "Conta não encontrada";
					return false;
				} else {
					double saldoAtual = c.getSaldo() + c.getLimite();
					if (saldoAtual < valorSaque) {
						msg = "Saldo insuficiente";
						return false;
					} else {
						c.setSaldo(saldoAtual - valorSaque);
						session.update(c);

						session.getTransaction().commit();
						HibernateUtil.fecharSession();

						msg = "Saque de " + valorSaque + " realizado com sucesso!";
						return true;
					}
				}
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean depositar(long id, double valorDeposito) {
		try {
			if (valorDeposito <= 0) {
				msg = "Valor do depósito inválido";
				return false;
			} else {
				Session session = HibernateUtil.abrirSession();
				session.beginTransaction();

				Corrente c = session.find(Corrente.class, id);
				if (c == null) {
					msg = "Conta não encontrada";
					return false;
				} else {
					double saldoAtual = c.getSaldo() + c.getLimite();
					c.setSaldo(saldoAtual + valorDeposito);
					session.update(c);

					session.getTransaction().commit();
					HibernateUtil.fecharSession();

					msg = "Depósito de " + valorDeposito + " realizado com sucesso!";
					return true;

				}
			}
		} catch (

		Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean exibirSaldo(long id) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Corrente c = session.find(Corrente.class, id);

			if (c == null) {
				msg = "Conta corrente não encontrada";
				return false;
			} else {
				double saldo = c.getSaldo();

				session.getTransaction().commit();
				HibernateUtil.fecharSession();

				msg = "Nr Conta: " + c.getNrConta() + " - Saldo: " + saldo;
				return true;
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}
}
