package pos.java.maven.hibernate;

import java.util.List;

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

		pessoa.setNome("Hortencio");
		pessoa.setSobrenome("Van dibriolli");
		pessoa.setIdade(65);
		pessoa.setLogin("vandibriolli");
		pessoa.setSenha("77777777");
		pessoa.setEmail("vandibriolli@gmail.com");

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
	@Ignore
	public void testePesquisarId() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisarId(2L, UsuarioPessoa.class);

		System.out.println(pessoa);

	}

	@Test
	@Ignore
	public void testeUpdateMerge() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisarId(2L, UsuarioPessoa.class);

		pessoa.setIdade(51);
		pessoa.setSenha("5632895");

		pessoa = genericDao.updateMerge(pessoa);

		System.out.println(pessoa);

	}

	@Test
	@Ignore
	public void testeDelete() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisarId(1L, UsuarioPessoa.class);

		genericDao.deletarPorId(pessoa);

	}

	@Test
	@Ignore
	public void Listar() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		List<UsuarioPessoa> lista = genericDao.listar(UsuarioPessoa.class);

		for (UsuarioPessoa e : lista) {

			System.out.println(e);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}
	@Test
	public void testQueryList() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> lista = genericDao.getEntityManager().createQuery(" from UsuarioPessoa where nome = 'katarina'").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println(usuarioPessoa);
		}
		
		
	}
	
	
}
