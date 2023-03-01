package dao;

import entity.Owner;
import entity.Pet;
import org.hibernate.Session;

import java.util.List;

public class PetDAO {
    public List<Pet> selectAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Pet> pets = session.createQuery("from Pet").list();
        return pets;
    }

    public void updatePet(Pet pet, Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Pet petToUpdate = getById(id);
        petToUpdate.setAnimal(pet.getAnimal());
        petToUpdate.setName(pet.getName());
        petToUpdate.setAge(pet.getAge());
        petToUpdate.setColor(pet.getColor());
        petToUpdate.setOwnerId(pet.getOwnerId());

        session.update(petToUpdate);

        session.getTransaction().commit();
        session.close();
    }

    public void createPet(Pet pet) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(pet);

        session.getTransaction().commit();
        session.close();

    }

    public void deletePet(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Pet pet = getById(id);
        session.delete(pet);

        session.getTransaction().commit();
        session.close();

    }

    public Pet getById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Pet pet = session.get(Pet.class, id);

        session.getTransaction().commit();
        session.close();

        return pet;
    }
}
