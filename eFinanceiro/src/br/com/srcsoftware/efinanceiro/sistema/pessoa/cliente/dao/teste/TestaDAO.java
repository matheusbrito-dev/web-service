package br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.dao.teste;

import java.time.LocalDateTime;

import org.junit.Test;

import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.dao.ClienteDAO;
import br.com.srcsoftware.efinanceiro.sistema.pessoa.cliente.model.ClientePO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TestaDAO {
	@Test
	public void executar() throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();	
		try {
		ClienteDAO dao = new ClienteDAO();
		hibernate.iniciarTransacao();
		ClientePO po = new ClientePO();
		po.setTelefone("3312-3512");
		po.setSexo("Masculino");
		po.setEmail("ouiahpsoduhasd");
		po.setEndereco("IUAshdlaus");
		po.setCpf("435.213.245.54");
		po.setNome("Diogay");
		po.setStatus(true);
		po.setDataHoraCadrastro(LocalDateTime.now());
		hibernate.inserir(po);
		hibernate.commitTransacao();
		System.out.println(po);
		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();

		}
	}
	
	
}
