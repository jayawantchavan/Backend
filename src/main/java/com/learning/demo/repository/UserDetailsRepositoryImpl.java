package com.learning.demo.repository;

import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learning.demo.entity.UserInfo;

@Repository
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserInfo findUserInfoById(String id) {
		
		return entityManager.find(UserInfo.class, id);
	}
}