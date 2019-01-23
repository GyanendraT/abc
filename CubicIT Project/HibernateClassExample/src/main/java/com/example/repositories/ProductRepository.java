package com.example.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.entities.ProductEntity;
import com.example.utils.HibernateUtil;

public class ProductRepository {

	public void save(ProductEntity product) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public ProductEntity getById(long productId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("From ProductEntity p where p.id = :id", ProductEntity.class);
		query.setParameter("id", productId);
		ProductEntity productEntity = (ProductEntity)query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return productEntity;
		
	}
	
	public List<ProductEntity> getByCategory(String productCategory) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("From ProductEntity p where p.category = :category", ProductEntity.class);
		query.setParameter("category", productCategory);
		
		List<ProductEntity> products = query.getResultList();
		session.getTransaction().commit();
		session.close();
		
		return products;
	}
	
	public void updateProduct(ProductEntity productEntity) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.merge(productEntity);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
