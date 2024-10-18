package com.connector.sat.dao;

import com.connector.sat.repository.HibernateUtil;
import com.connector.sat.repository.SATRepository;
import com.connector.sat.service.Cupom;
import com.connector.sat.service.SATResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SATResponseDAO implements SATRepository {
    @Override
    public void save(SATResponse satResponse) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(satResponse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
    }

    @Override
    public SATResponse findBySAT(String nSat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SATResponse.class, nSat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SATResponse findByID(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SATResponse.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SATResponse> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from com.connector.sat.service.SATResponse", SATResponse.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<Cupom> findAllCuponsResponse(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from com.connector.sat.service.Cupom where satResponse.id = :id", Cupom.class).setParameter("id", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<Cupom> findAllSATCupons(Long nSat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from com.connector.sat.service.Cupom where nSat = :nSat", Cupom.class).setParameter("nSat", nSat).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<Cupom> findAllCupons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from com.connector.sat.service.Cupom", Cupom.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
