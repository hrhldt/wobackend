package com.wobackend.mhra.repositories;

import com.wobackend.mhra.models.User;
import com.wobackend.mhra.models.auth.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements JpaRepository<User, Long> {

    @Autowired
    private EntityManager em;

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void delete(Iterable<? extends User> entities) {
        
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    public User loadUserByUsername (String userName) {
        //User user = em.createQuery("FROM users u WHERE u.name = "+userName, User.class).getSingleResult();

        String hql = "FROM User where name = '"+userName+"'";
        Query query = em.createQuery(hql, User.class);
        List results = query.getResultList();

        if ( !results.isEmpty() ) {
            User user = (User)results.get(0);

            //FIXME Get Role from DB
            Role r = new Role();
            r.setName("ROLE_USER");
            List<Role> roles = new ArrayList<>();
            roles.add(r);
            user.setAuthorities(roles);

            return user;
        }

        return null;
    }

    @Override
    public User getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public <S extends User> List<S> save(Iterable<S> entities) {
        return null;
    }
}
