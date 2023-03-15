package com.example.itemwriter;

import java.util.ArrayList;
import java.util.List;

import com.example.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Customer;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ConsoleItemWriter<T> implements ItemWriter<T> {
	Logger logger = LoggerFactory.getLogger(ConsoleItemWriter.class);
	@Autowired
	private CustomerRepository repository;

	List<Customer> newCusts = new ArrayList<>();
	List<Customer> custs = new ArrayList<>();

	public Iterable<Customer> saveAllData(List<Customer> saveCusts){
		return repository.saveAll(saveCusts);
	}

	public List<Customer> getAllData(){
		return (List<Customer>) repository.findAll();
	}

	public List<Customer> getFirstNameData(String firstName){
		return (List<Customer>) repository.findByFirstName(firstName);
	}

	public List<Customer> getLastNameData(String lastName){
		return (List<Customer>) repository.findByLastName(lastName);
	}

	@Override
	public void write(List<? extends T> items) throws Exception {

		for (T item : items) {
			Customer cust = (Customer) item;
			logger.info(item.toString());
			newCusts.add(cust);
			cust = new Customer();
		}
		saveAllData(newCusts);
		logger.info("Customers found with findAll():");
		logger.info("-------------------------------");
		for (Customer customer : getAllData()) {
			custs.add(customer);
			logger.info(customer.toString());
		}


		Integer cust = custs.get(0).getId();
		logger.info("--------------------------------");
		logger.info("Customer found with findById of John:");
		logger.info(repository.findById(cust).toString());

		logger.info("--------------------------------");
		logger.info("Customer found with findByFirstName('Jay'):");
		for (Customer customer : getFirstNameData("Jay")) {
			logger.info(customer.toString());
		}


		logger.info("--------------------------------");
		logger.info("Customers found with findByLastName('William'):");
		for (Customer customer : getLastNameData("William")) {
			logger.info(customer.toString());
		}


	}
}
