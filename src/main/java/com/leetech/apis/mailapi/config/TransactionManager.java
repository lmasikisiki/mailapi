package com.leetech.apis.mailapi.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionManager {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		// em.setPackagesToScan(new String[] { "org.baeldung.persistence.model" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dbtest");
		dataSource.setUsername("dbuser");
		dataSource.setPassword("lizo90");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager tm(EntityManagerFactory emf) {
		JpaTransactionManager t = new JpaTransactionManager();
		t.setEntityManagerFactory(emf);

		return t;
	}

	@Bean
	public EntityManagerProvider entityManagerProvider() {
		return new ContainerManagedEntityManagerProvider();
	}

	// @Bean
	// public JpaEventStorageEngine jpaEventStorageEngine(EntityManagerProvider e,
	// org.axonframework.common.transaction.TransactionManager tm) {
	// return new JpaEventStorageEngine(entityManagerProvider(), tm);
	// }

	// @Bean
	// public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	// return new PersistenceExceptionTranslationPostProcessor();
	// }

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
		return properties;
	}
}