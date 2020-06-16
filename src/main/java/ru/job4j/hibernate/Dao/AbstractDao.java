package ru.job4j.hibernate.Dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.hibernate.Util.HibernateUtil;

import java.util.List;
import java.util.function.Function;

public class AbstractDao {
    private static final Logger LOG = LogManager.getLogger(AbstractDao.class);

    public <T> T tx(final Function<Session, T> command) {
        final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            LOG.error("error msg: {}", e.getMessage());
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public <T> void save(T t) {
        tx(session -> {
                    session.save(t);
                    return t;
                }
        );
    }

    public <T> void update(T t) {
        tx(session -> {
            session.update(t);
            return t;
        });
    }

    public <T> List<T> findAll(String modelName) {
        return tx(session ->
                (List<T>) session.createQuery("from " + modelName).getResultList()
        );
    }

    public <T> T find(Class<T> tClass, Integer id) {
        return tx(session ->
                session.get(tClass, id)
        );
    }

    public <T> void delete(T t) {
        tx(session -> {
                    session.delete(t);
                    return t;
                }
        );
    }
}
