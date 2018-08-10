package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import com.visa.training.domain.Product;

@Component
@org.springframework.transaction.annotation.Transactional//(propagation=Propagation.REQUIRED)
public class MySqlProductDAO implements ProductDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public void delete(int id)
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		Product p= em.find(Product.class, id);
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		em.remove(p); // does insert into the table // persistent state
		tx.commit();
		//em.close(); //return back transaction
		
	}
	
	@Override
	public void changePrice(int id, float newPrice)
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		Product p= em.find(Product.class, id);
		//EntityTransaction tx= em.getTransaction();
		//tx.begin();
		p.setPrice(newPrice);
		//em.remove(p); // does insert into the table // persistent state
		//tx.commit();
		//em.close(); //return back transaction //detached
		
	}
	@Override
	public List<Product> findAll()
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		Query q= em.createQuery("select p from Product p");
		List<Product> all=q.getResultList();
		
		//em.close();
		return all;
	}
	@Override
	public List<Product> findByPriceGreaterThan(float price)
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		Query q= em.createQuery("select p from Product p where p.price> :price").setParameter("price", price);
		List<Product> all=q.getResultList();
		
		//em.close();
		return all;
	}
	@Override
	public int removeOutOfStocks()
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		//EntityTransaction tx= em.getTransaction();
		//tx.begin();
		Query q= em.createQuery("delete from Product p where p.qoh=10");
		
		int i=q.executeUpdate();
		//tx.commit();
		//em.close();
		return i;
	}
	@Override
	public Product findOne(int id)
	{
		//EntityManager em= JpaUtil.getEmf().createEntityManager();
		Product p= em.find(Product.class, id);
		//em.close();
		return p;
		
	}
	@Override
	public Product addNew(Product p){ //transient
		
		//EntityManagerFactory emf = JpaUtil.getEmf();
		//EntityManager em= emf.createEntityManager();
		//EntityTransaction tx= em.getTransaction();
		//tx.begin();
		em.persist(p); // does insert into the table // persistent state
		//tx.commit();
		//em.close(); // bcz it was an expensive operation to have it long //detached
		
		return p; //returning a detahced object
	}
}
