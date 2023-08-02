import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PessoaDAO {

    private final EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create
    public void create(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    // Read
    public Pessoa findById(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> findAll() {
        TypedQuery<Pessoa> query = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return query.getResultList();
    }

    // Update
    public void update(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    // Delete
    public void delete(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
        }
    }
}
