import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Update {
    public static void atualizarDados(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicacaoJpa");
        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDao = new PessoaDAO(em);

        try {
            em.getTransaction().begin();

            Pessoa pessoaBanco = pessoaDao.findById(pessoa.getId());
            if (pessoaBanco == null) {
                System.out.println("Erro ao encontrar pessoa na base de dados");
                return;
            }

            pessoaBanco.setNome(pessoa.getNome());
            pessoaBanco.setCpf(pessoa.getCpf());

            pessoaDao.update(pessoaBanco);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}




