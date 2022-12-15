package pos.java.maven.hibernate;

import org.junit.Ignore;
import org.junit.Test;

import dao.GenericDao;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	@Ignore
	public void TesteHibernateUtil() {

		HibernateUtil.getEntityManager();

	}

	@Test
	@Ignore
	public void TesteDaoSalvar() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();

		pessoa.setNome("katarina");
		pessoa.setSobrenome("da Cunha Pires");
		pessoa.setIdade(45);
		pessoa.setLogin("katarinapires");
		pessoa.setSenha("5678910");
		pessoa.setEmail("katarinapires@gmail.com");

		genericDao.salvar(pessoa);

	}

	@Test
	@Ignore
	public void testePesquisar() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(3L);

		pessoa = genericDao.pesquisar(pessoa);

		System.out.println(pessoa);

	}

	@Test
	public void testePesquisarId() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisarId(2L, UsuarioPessoa.class);

		System.out.println(pessoa);

	}
}
