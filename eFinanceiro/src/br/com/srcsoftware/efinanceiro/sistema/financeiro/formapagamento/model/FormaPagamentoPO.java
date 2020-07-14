package br.com.srcsoftware.efinanceiro.sistema.financeiro.formapagamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

import br.com.srcsoftware.manager.abstracts.AbstractPO;

@Entity
@Table(name = "formaspagamento")
@XmlRootElement
public class FormaPagamentoPO extends AbstractPO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, nullable = false, unique = true)
	private String nome;

	@Column(length = 3, nullable = false)
	private String compensacao;

	@Column(nullable = false)
	@Type(type = "true_false")
	private Boolean gerarQuitada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public String getIdToString() {
		if (getId() != null) {
			return getId().toString();
		}
		return null;
	}

	public void setIdToString(String id) {
		if (id != null && !id.isEmpty()) {
			setId(Long.valueOf(id));
			return;
		}
		setId(null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCompensacao() {
		return compensacao;
	}

	public void setCompensacao(String compensacao) {
		this.compensacao = compensacao;
	}

	public Boolean getGerarQuitada() {
		return gerarQuitada;
	}

	public void setGerarQuitada(Boolean gerarQuitada) {
		this.gerarQuitada = gerarQuitada;
	}

	@Transient
	public String getGerarQuitadaToString() {
		if ( gerarQuitada != null ) {
			return gerarQuitada.toString();

		}
		return null;
	}

	public void setGerarQuitadaToString( String gerarQuitada ) {
		if ( gerarQuitada != null && !gerarQuitada.isEmpty() ) {
			setGerarQuitada( Boolean.valueOf( gerarQuitada ) );
			return;
		}
		this.gerarQuitada = null;
	}
	
	@Transient
	public String getGerarQuitadaView() {
		if ( gerarQuitada != null ) {
			return String.valueOf( ( "true".equals( getGerarQuitadaToString() ) ? "Ativo" : "Inativo" ) );

		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaPagamentoPO other = (FormaPagamentoPO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FormaPagamentoPO [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", compensacao=");
		builder.append(compensacao);
		builder.append(", gerarQuitada=");
		builder.append(gerarQuitada);
		builder.append("]");
		return builder.toString();
	}

}
