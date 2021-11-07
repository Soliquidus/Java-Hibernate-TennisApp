package com.pazdev.tennis.core.repository;

import com.pazdev.tennis.core.DataSourceProvider;
import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class JoueurRepositoryImpl
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */
public class JoueurRepositoryImpl {

    public void create(Joueur joueur) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(joueur);
        System.out.println("Joueur créé");
    }

    public void update(Joueur joueur) {
        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE JOUEUR SET NOM=?,PRENOM=?,SEXE=? WHERE ID=?");
            preparedStatement.setString(1, joueur.getNom());
            preparedStatement.setString(2, joueur.getPrenom());
            preparedStatement.setString(3, joueur.getSexe().toString());
            preparedStatement.setLong(4, joueur.getId());

            preparedStatement.executeUpdate();

            System.out.println("Joueur modifié");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        Joueur joueur = new Joueur();
        joueur.setId(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(joueur);
        System.out.println("Joueur supprimé");
    }

    public Joueur getById(Long id) {
        Joueur joueur;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        joueur = session.get(Joueur.class, id);
        System.out.println("Joueur lu");
        return joueur;
    }

    public List<Joueur> listJoueur() {
        Connection conn = null;
        List<Joueur> joueurs = new ArrayList<>();
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM, PRENOM, SEXE FROM JOUEUR");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Joueur joueur = new Joueur();
                joueur.setId(resultSet.getLong("ID"));
                joueur.setNom(resultSet.getString("NOM"));
                joueur.setPrenom(resultSet.getString("PRENOM"));
                joueur.setSexe(resultSet.getString("SEXE").charAt(0));
                joueurs.add(joueur);
            }
            System.out.println("Joueurs lus");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return joueurs;
    }
}
