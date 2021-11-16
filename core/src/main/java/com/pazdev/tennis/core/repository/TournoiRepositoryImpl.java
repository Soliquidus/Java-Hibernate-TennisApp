package com.pazdev.tennis.core.repository;

import com.pazdev.tennis.core.DataSourceProvider;
import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Tournoi;
import org.hibernate.Session;

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
public class TournoiRepositoryImpl {

    public void create(Tournoi tournoi) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(tournoi);
        System.out.println("Tournoi ajouté");
    }

    public void update(Tournoi tournoi) {
        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE TOURNOI SET NOM=?,CODE=? WHERE ID=?");
            preparedStatement.setString(1, tournoi.getNom());
            preparedStatement.setString(2, tournoi.getCode());
            preparedStatement.setLong(3, tournoi.getId());

            preparedStatement.executeUpdate();

            System.out.println("Tournoi modifié");
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
        Tournoi tournoi = getById(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(tournoi);
        System.out.println("Tournoi supprimé");
    }

    public Tournoi getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Tournoi tournoi = session.get(Tournoi.class, id);
        System.out.println("Tournoi lu");
        return tournoi;
    }

    public List<Tournoi> listTournoi() {
        Connection conn = null;
        List<Tournoi> tournois = new ArrayList<>();
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM, CODE FROM TOURNOI");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Tournoi tournoi = new Tournoi();
                tournoi.setId(resultSet.getLong("ID"));
                tournoi.setNom(resultSet.getString("NOM"));
                tournoi.setCode(resultSet.getString("CODE"));
                tournois.add(tournoi);
            }
            System.out.println("Tournois lus");
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
        return tournois;
    }
}
