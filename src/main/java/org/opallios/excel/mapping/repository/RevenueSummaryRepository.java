package org.opallios.excel.mapping.repository;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.opallios.excel.mapping.hibernate.util.HibernateUtil;
import org.opallios.excel.mapping.model.RevenueSummary;
import org.opallios.excel.mapping.yml.ConfiguredData;

public class RevenueSummaryRepository {
	
	public boolean save (List<RevenueSummary> summaries, ConfiguredData configuredData) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory(configuredData).openSession();
			transaction = session.beginTransaction();
			int count = 0;
			for (RevenueSummary summary : summaries) {
				System.out.println(summary);
				Criteria cr = session.createCriteria(RevenueSummary.class);
				cr.add(Restrictions.eq("month", summary.getMonth()));
				cr.add(Restrictions.eq("bankId", summary.getBankId()));
				List<?> results = cr.list();
				if (results.size() > 0 && results.get(0) != null) {
					summary.setId(((RevenueSummary)results.get(0)).getId());
				}
			}
			session.flush();
			session.clear();
			for (RevenueSummary revenueSummary : summaries) {
				session.saveOrUpdate(revenueSummary);
				count ++;
				if (count % configuredData.getBatchSize() == 0) {
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
			return true;
		} catch (org.hibernate.exception.ConstraintViolationException e){
			throw e;
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	} 
}
