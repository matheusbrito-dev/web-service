package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model;

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
@Table(name="clientes")
@XmlRootElement
public class ClientePO extends AbstractPO{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 30, nullable = false)
	private String cpf;
	
	@Column(length = 30, nullable = false)
	private String telefone;
	
	@Column(length = 30, nullable = false)
	private String sexo;
	
	@Column(length = 30, nullable = false)
	private String email;
	

	@Column(length = 30, nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	@Type( type = "true_false")
	private Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	//Getter's and Setter's
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	//ToString's
	@Transient
	public String getIdToString() {
		if (getId() != null) {
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
	public String getStatusToString() {
		if ( status != null ) {
			return status.toString();

		}
		return null;
	}

	public void setStatusToString( String status ) {
		if ( status != null && !status.isEmpty() ) {
			setStatus( Boolean.valueOf( status ) );
			return;
		}
		this.status = null;
	}

	@Transient
	public String getStatusView() {
		if ( status != null ) {
			return String.valueOf( ( "true".equals( getStatusToString() ) ? "Ativo" : "Inativo" ) );
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ClientePO other = (ClientePO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientePO [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
