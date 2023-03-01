package dao;

import entity.Owner;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
        public List<Owner> selectAll() {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

            List<Owner> owners = session.createQuery("from Owner").list();
            return owners;
    }

    public void updateOwner(Owner owner, Integer id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Owner ownerToUpdate = getById(id);
        ownerToUpdate.setName(owner.getName());

        session.update(ownerToUpdate);

        session.getTransaction().commit();
        session.close();
    }

    public void createOwner(Owner owner) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(owner);

        session.getTransaction().commit();
        session.close();

    }

    public void deleteOwner(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();


        Owner owner = getById(id);
        session.delete(owner);

        session.getTransaction().commit();
        session.close();

    }
    public Owner getById(Integer id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Owner owner = session.get(Owner.class, id);

        session.getTransaction().commit();
        session.close();

        return owner;
    }
}
