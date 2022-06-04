package SearchEngineApp.dao;

import SearchEngineApp.models.WebPage;
import SearchEngineApp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class WebPageDao
{
    public void save(WebPage webPage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(webPage);
        transaction.commit();
        session.close();
    }

    public List<WebPage> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<WebPage> query = session.createQuery("from WebPage where code = :code");
        query.setParameter("code", 200);
        List<WebPage> list = query.getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
