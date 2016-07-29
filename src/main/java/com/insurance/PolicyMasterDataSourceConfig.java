package com.insurance;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.insurance.repository.policymaster", entityManagerFactoryRef = "policymasterEntityManagerFactory", transactionManagerRef = "policymasterTransactionManager")
@EnableTransactionManagement
public class PolicyMasterDataSourceConfig
{
  @Bean
  @ConfigurationProperties(prefix = "datasource.policymaster")
  public DataSource policymasterDataSource()
  {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean policymasterEntityManagerFactory(final EntityManagerFactoryBuilder builder)
  {
    return builder
        .dataSource(policymasterDataSource())
        .packages("com.insurance.domain.policymaster")
        .persistenceUnit("localPersistenceUnit")
        .build();
  }

  @Bean
  public JpaTransactionManager policymasterTransactionManager(@Qualifier("policymasterEntityManagerFactory") final EntityManagerFactory factory)
  {
    return new JpaTransactionManager(factory);
  }
}
