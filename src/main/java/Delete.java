import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public static void deletar(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicacaoJpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            PessoaDAO pessoaDao = new PessoaDAO(em);

            pessoaDao.delete(id);

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

