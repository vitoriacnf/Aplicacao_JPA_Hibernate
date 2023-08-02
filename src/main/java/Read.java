import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicacaoJpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            PessoaDAO pessoaDAO = new PessoaDAO(em);

            pessoaDAO.findAll();

            List<Pessoa> pessoas = pessoaDAO.findAll();
            for (Pessoa p : pessoas) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", CPF: " + p.getCpf());
            }

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
