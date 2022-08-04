package fr.eni.stationaryShop.dal;

import java.util.List;

import fr.eni.stationaryShop.bo.Item;
import fr.eni.stationaryShop.bo.Ream;
import fr.eni.stationaryShop.bo.Pen;
import fr.eni.stationaryShop.dal.jdbc.ItemDAOJdbcImpl;

public class AppliTestDAL {

    public static void main(String[] args) throws Exception {

        //Déclaration et instanciation de la DAO
        ItemDAO articleDAO = new ItemDAOJdbcImpl();

        //Instanciation du jeu d'essai
        Item a1 = new Pen("Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "bleu");
        Item a2 = new Ream("Clairef", "CRA4S", "Ream A4 Sup", 9f, 20, 80);
        Item a3 = new Pen("Stypen", "PlumeS", "Pen Plume Stypen", 5.5f, 20, "jaune");


        System.out.println("Ajout des articles... ");

        articleDAO.insert(a1);
        System.out.println("Item ajouté  : " + a1.toString());
        articleDAO.insert(a2);
        System.out.println("Item ajouté  : " + a2.toString());
        articleDAO.insert(a3);
        System.out.println("Item ajouté  : " + a3.toString());


        //Sélection de l'article par id
        Item a = articleDAO.selectById(a2.getItemID());
        System.out.println("\nSélection de l'article par id  : " + a.toString());

        //Sélection de tous les articles
        List<Item> articles = articleDAO.selectAll();
        System.out.println("\nSélection de tous les articles  : ");
        afficherArticles(articles);

        //Modification d'un article
        System.out.println("\nModification d'un article  : ");
        System.out.println("Item avant modification : " + a1.toString());
        ((Pen) a1).setColor("noir");
        ((Pen) a1).setDesignation("Bic bille noir");
        ((Pen) a1).setRef("BBNoir");
        articleDAO.update(a1);
        System.out.println("Item après modification  : " + a1.toString());


        //Suppression d'un article
        System.out.println("\nSuppression de l'article  : " + a1.toString());
        articleDAO.deleteById(a1.getItemID());
        articles = articleDAO.selectAll();
        System.out.println("Liste des articles après suppression : ");
        afficherArticles(articles);
        System.out.println("---------------------------------------------------------------");


    }


    private static void afficherArticles(List<Item> articles) {
        StringBuffer sb = new StringBuffer();
        for (Item art : articles) {
            sb.append(art.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
