package com.example.demo.repository;

import com.example.demo.domain.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public MemberEntity save(MemberEntity member) {
        em.persist(member);
        return member;
    }

    public MemberEntity findOne(Long id) {
        return em.find(MemberEntity.class, id);
    }

    public List<MemberEntity> findAll() {
        return em.createQuery("select m from MemberEntity m", MemberEntity.class)
                .getResultList();
    }

    public List<MemberEntity> findByName(String name) {
        return em.createQuery("select m from MemberEntity m where m.name = :name", MemberEntity.class)
                .setParameter("name", name)
                .getResultList();
    }
}
