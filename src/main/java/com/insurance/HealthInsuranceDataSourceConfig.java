package com.insurance;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.insurance.repository.healthinsurance", 
entityManagerFactoryRef = "healthinsuranceEntityManagerFactory", transactionManagerRef = "healthinsuranceTransactionManager")
@EnableTransactionManagement
public class HealthInsuranceDataSourceConfig
{
  @Bean
  @ConfigurationProperties(prefix = "datasource.healthinsurance")
  @Primary
  public DataSource healthinsuranceDataSource()
  {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean healthinsuranceEntityManagerFactory(final EntityManagerFactoryBuilder builder)
  {
    return builder
        .dataSource(healthinsuranceDataSource())
        .packages("com.insurance.domain.healthinsurance")
        .persistenceUnit("adminPersistenceUnit")
        .build();
  }

  @Bean
  @Primary
  public JpaTransactionManager healthinsuranceTransactionManager(@Qualifier("healthinsuranceEntityManagerFactory") final EntityManagerFactory factory)
  {
    return new JpaTransactionManager(factory);
  }
}
