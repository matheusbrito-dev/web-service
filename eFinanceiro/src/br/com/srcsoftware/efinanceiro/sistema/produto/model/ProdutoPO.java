package br.com.srcsoftware.efinanceiro.sistema.produto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.utilidades.Utilidades;

@Entity
@Table(name="produtos")
@XmlRootElement
public class ProdutoPO extends AbstractPO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false, unique = true)
	private String codigo;
	
	@Column(length = 30, nullable = false)
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Transient
	public String getIdToString() {
		if ( getId() != null ) {
			return getId().toString();
		}
		return null;
	}

	public void setIdToString( String id ) {
		if ( id != null && !id.isEmpty() ) {
			setId( Long.valueOf( id ) );
			return;
		}
		setId( null );
	}
	
	@Transient
	public String getValorToString() {
		if ( getValor() != null ) {
			return Utilidades.parseBigDecimal( getValor() );
		}
		return null;
	}

	public void setValorToString( String valor ) {
		if ( valor != null && !valor.isEmpty() ) {
			setValor( Utilidades.parseBigDecimal( valor ) );
			return;
		}
		setValor( null );
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProdutoPO other = (ProdutoPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProdutoPO [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", valor=");
		builder.append(valor);
		builder.append("]");
		return builder.toString();
	}
	
}

