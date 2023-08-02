import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicacaoJpa");
        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);

        try {
            em.getTransaction().begin();

            Pessoa pessoa1 = new Pessoa();
            pessoa1.setNome("Eduarda Juliana Silva");
            pessoa1.setCpf("03095442629");
            em.persist(pessoa1);
            pessoaDAO.create(pessoa1);

            em.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

