package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.Session;

import hibernateUtil.HibernateUtil;

@Entity
public class Poupanca extends Conta{

	@Column
	private double rendimento;
	
	@Transient
	protected String msg = null;

	public Poupanca() {
		super();
	}

	public Poupanca(long id, String agencia, String nrConta, Usuario user, double saldo, double rendimento) {
		super(id, agencia, nrConta, user, saldo);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public String getMsg() {
		return msg;
	}
	
	

	@Override
	public String toString() {
		return "Poupança " + super.toString() + ", rendimento: " + rendimento + "]";
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

	public Poupanca localizar(long id) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Poupanca p = session.find(Poupanca.class, id);

			session.getTransaction().commit();
			HibernateUtil.fecharSession();

			if (p != null) {
				p.setAgencia(p.getAgencia());
	            p.setNrConta(p.getNrConta());
	            p.setUser(p.getUser());
	            p.setSaldo(p.getSaldo());
	            p.setRendimento(p.getRendimento());
	            			
	            msg = p.toString();
	            return p;
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

			Poupanca p = session.find(Poupanca.class, getId());

			if (p == null) {
				msg = "ID não encontrado!";
				return false;
			} else {
				
				p.setAgencia(p.getAgencia());
	            p.setNrConta(p.getNrConta());
	            p.setUser(p.getUser());
	            p.setSaldo(p.getSaldo());
	            p.setRendimento(p.getRendimento());
 
				session.update(p);

				session.getTransaction().commit();
				HibernateUtil.fecharSession();
				
				msg = "Conta poupança atualizada com sucesso!";
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

			Poupanca p = session.find(Poupanca.class, id);

			if (p == null) {
				msg = "Conta não encontrada";
				return false;
			} else {
				if (editar != null) {
					if (editar.equalsIgnoreCase("nome")) {
						p.getUser().setNome(novoValor);
						msg = "Titular Editado com sucesso!";
					}else if (editar.equalsIgnoreCase("cpf")) {
						p.getUser().setCpf(novoValor);
						msg = "CPF Editado com sucesso!";
					}else if (editar.equalsIgnoreCase("email")) {
						p.getUser().setEmail(novoValor);
						msg = "E-mail Editado com sucesso!";
					}
				}
			
				session.update(p);

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

			Poupanca p = session.find(Poupanca.class, id);

			if (p == null) {
				msg = "ID " + id + " não encontrado!";
				return false;
			} else {
				session.delete(p);

				session.getTransaction().commit();
				HibernateUtil.fecharSession();

				msg = p.toString();
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

				Poupanca p = session.find(Poupanca.class, id);
				if (p == null) {
					msg = "Conta não encontrada";
					return false;
				} else {
					double saldoAtual = p.getSaldo();
					if (saldoAtual < valorSaque) {
						msg = "Saldo insuficiente";
						return false;
					} else {
						p.setSaldo(saldoAtual - valorSaque);
						session.update(p);

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

				Poupanca p = session.find(Poupanca.class, id);
				if (p == null) {
					msg = "Conta não encontrada";
					return false;
				} else {
					double saldoAtual = p.getSaldo();
					p.setSaldo(saldoAtual + valorDeposito);
					session.update(p);

					session.getTransaction().commit();
					HibernateUtil.fecharSession();

					msg = "Depósito de " + valorDeposito + " realizado com sucesso!";
					return true;

				}
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public boolean exibirSaldo(long id) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Poupanca p = session.find(Poupanca.class, id);

			if (p == null) {
				msg = "Conta corrente não encontrada";
				return false;
			} else {
				double saldo = p.getSaldo();

				session.getTransaction().commit();
				HibernateUtil.fecharSession();

				msg = "Nr Conta: " + p.getNrConta() + " - Saldo: " + saldo;
				return true;
			}
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}
}
