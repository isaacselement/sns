package com.weibo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.weibo.exception.ExceptionToRuntimeException;
import com.weibo.init.HibernateUtil;

public class TransactionFilter implements Filter {

	public void destroy() {
	

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			
		Session session = null;
		try {
			session =HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			chain.doFilter(request, response);
			session.beginTransaction().commit();
		} catch (HibernateException e) {
			if(session.getTransaction().isActive()){
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new ExceptionToRuntimeException(e);
		}
		finally{
			
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
