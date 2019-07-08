package br.com.casadocodigo.loja.dao.abstracts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.interfaces.IModel;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractDAO<T extends IModel> {

    @PersistenceContext
    private EntityManager entityManager;

    //bruxaria do reflections
    @SuppressWarnings({"unchecked"})
    public Class<T> getPersistenceClazz() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T model) {
        getEntityManager().persist(model);
    }

    public List<T> findAll(Class<T> clazz) {

        StringBuffer sql = new StringBuffer()
                .append("select o from ")
                .append(clazz.getName())
                .append(" o WHERE 1=1 ");

        Query query = this.entityManager.createQuery(sql.toString(), clazz);

        List<T> result = query.getResultList();
        return result;
    }

    public List<T> findAll() {
        try {
            return findAll(getPersistenceClazz());
        } catch (Exception e) {
            System.out.println("Erro ao realizar a pesquisa" + e.toString());
            throw e;
        }
    }

    public T find(Class<T> clazz, Object id) {
        return this.entityManager.find(clazz, id);
    }

    public T findById(Long id) {
        return this.entityManager.find(getPersistenceClazz(), id);
    }

}
