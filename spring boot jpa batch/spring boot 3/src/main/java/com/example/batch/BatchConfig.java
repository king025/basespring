package com.example.batch;

import com.example.itemwriter.ConsoleItemWriter;
import com.example.model.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	PlatformTransactionManager batchTransactionManager;

	@Autowired
	JobRepository jobRepository;

	@Bean
	public Job myJob(JobRepository jobRepository,PlatformTransactionManager transactionManager) throws Exception {
		return new JobBuilder("myJob",jobRepository).incrementer(new RunIdIncrementer()).start(myStep(jobRepository,transactionManager)).build();
	}

	@Bean
	public Step myStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("myStep",jobRepository).<Customer, Customer>chunk(5,transactionManager).reader(reader()).writer(writer()).build();
	}

	@Bean
	public JobLauncher jobLauncher() throws Exception {
		TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FlatFileItemReader<Customer> reader() {

		FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();


		reader.setResource(new FileSystemResource("user-sample-data.csv"));

		reader.setLinesToSkip(1);

		reader.setLineMapper(new DefaultLineMapper() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {
					{
						setTargetType(Customer.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public ConsoleItemWriter<Customer> writer() {
		return new ConsoleItemWriter<Customer>();
	}
}