import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicacaoJpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            PessoaDAO pessoaDao = new PessoaDAO(em);

           pessoaDao.delete(1L);

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

