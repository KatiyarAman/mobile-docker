package com.mobiledocker.mobiledocker.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;

import com.mobiledocker.mobiledocker.Dao.StateDao;
import com.mobiledocker.mobiledocker.entity.Country;
import com.mobiledocker.mobiledocker.entity.Pagination;
import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;

@Repository
public class StateDaoImpl extends GenricRepositroyImpl<State> implements StateDao, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(StateDaoImpl.class);


    @Override
    public List<State> FindByCountry(int countryId) {
        // TODO Auto-generated method stub
        log.info("Load States by CountryId" + countryId);
        List<State> states = null;
        try (Session session = getCurrentSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
            Root<State> rootEmp = criteriaQuery.from(State.class);
            criteriaQuery.multiselect(rootEmp);
            criteriaQuery.where(builder.equal(rootEmp.get("country"), countryId));
            Query query = session.createQuery(criteriaQuery)
                    .setResultTransformer(Transformers.aliasToBean(State.class));
            states = query.getResultList();
            log.info("stateDaoImpl :" + states);
        }

        return states;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        super.setEntity(State.class);
    }

    @Override
    public State save(StateCo stateCo,Country country) {
                State state=new State(stateCo.getModelName(),country);
        return super.save(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<StateEntity> FindByCountryID(int countryId) {
        // TODO Auto-generated method stub
        List<StateEntity> stateEntity = null;
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String query = "select s.id as id, " + " s.name as name " + "from State s " + "where brandId=:countryId";
//			stateEntity=session.createQuery("select s.id as id, "
//		+" s.name as name "
//		+"from State s "
//		+"where brandId=:countryId")
            // Query q = getCurrentSession()).Query(query);
            // because of hibernate orm is 6 version we need 5 version
            stateEntity = session.createQuery(query)

                    .setInteger("countryId", countryId)
                    .setResultTransformer(Transformers.aliasToBean(StateEntity.class)).list();

            transaction.commit();

        } catch (Exception e) {
            stateEntity = null;
            if (transaction != null) {
                transaction.rollback();
            }
            // TODO: handle exception
        } finally {
            session.close();
        }
        System.out.println(stateEntity.size());
        return stateEntity;
    }

    @Override
    public State findByColumn(String countryId) {
        // TODO Auto-generated method stub

        return super.findByColumn("id", countryId);


    }

    @Override
    public List<State> findAll() {
        // TODO Auto-generated method stub
        return super.list();
    }


    /* for join result country or state brand series */
    @Override
    public List<State> findByJoins() {
        // TODO Auto-generated method stub
        List<State> results = new ArrayList<>();
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String query = "SELECT c.name, c.id, s.name, s.brandId FROM Country c JOIN State s ON c.id = s.brandId";
            results = session.createQuery(query)
                    .setResultTransformer(new AliasToBeanResultTransformer(State.class)).list();

            log.info("Size of Joins List :" + results.size());

            /*
             * for (Object[] result : results) { log.info(result[0] + " " + result[1] +
             * " - " + result[2]);
             *
             * }
             */

            transaction.commit();
        } catch (Exception e) {
            results = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return results;
    }
    @Override
    public List<State> fetchSearch(Pagination pagination,String category) {
        List<State> categoryList = new ArrayList<>();

        try (Session session = getCurrentSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            if (!pagination.isIgnorable()) {
                pagination.verify(session.createQuery(contAllCategoryByCategoryName(criteriaBuilder, category)).getSingleResult().intValue());
            }

            if (pagination.isIgnorable())
                categoryList.addAll(session.createQuery(getAllCategoryByCategoryName(criteriaBuilder, category)).getResultList());
            else
                categoryList.addAll(session.createQuery(getAllCategoryByCategoryName(criteriaBuilder, category))
                        .setFirstResult(pagination.getOffset()).setMaxResults(pagination.getLimit()).getResultList());

        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Exception while searching for  Category");
        }

        return categoryList;
    }

    private CriteriaQuery<Long> contAllCategoryByCategoryName(CriteriaBuilder criteriaBuilder, String category) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

        Root<State> countRoot = countQuery.from(State.class);
        countQuery.select(criteriaBuilder.count(countRoot));

        countQuery.where(criteriaBuilder.and(criteriaBuilder.like(countRoot.get("name"), category + "%"),
                criteriaBuilder.isFalse(countRoot.get("deleted"))));

        return countQuery;
    }

    private CriteriaQuery<State> getAllCategoryByCategoryName(CriteriaBuilder criteriaBuilder, String category) {
        CriteriaQuery<State> filterCategoryCq = criteriaBuilder.createQuery(State.class);

        Root<State> filtercategoryRoot = filterCategoryCq.from(State.class);
        filterCategoryCq.where(criteriaBuilder.and(criteriaBuilder.like(filtercategoryRoot.get("name"),category+"%"),criteriaBuilder.isFalse(filtercategoryRoot.get("deleted"))));

        return filterCategoryCq;
    }

    @Override
    public void updateFlage(Long seriesId) {
        // TODO Auto-generated method stub
        super.setDeleted(seriesId);
    }
}
