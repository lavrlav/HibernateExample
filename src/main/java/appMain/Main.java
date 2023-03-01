package appMain;

import dao.OwnerDAO;
import dao.PetDAO;

public class Main {
    public static void main(String[] args) {
        PetDAO petDAO = new PetDAO();
        petDAO.selectAll().forEach(System.out::println);

        OwnerDAO ownerDAO = new OwnerDAO();
        ownerDAO.selectAll().forEach(System.out::println);

    }
}
