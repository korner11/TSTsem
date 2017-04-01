package tst.sem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tst.sem.entity.Task;
import tst.sem.entity.User;
import tst.sem.repository.TaskRepository;
import tst.sem.repository.UserRepository;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}


	@Bean
	CommandLineRunner init(UserRepository accountRepository,
						   TaskRepository bookmarkRepository) {
		return (evt) -> Arrays.asList(
				"dezo,fero".split(","))
				.forEach(
						a -> {
							User account = accountRepository.save(new User(a, "password"));
							bookmarkRepository.save(new Task("task1", "task1Descr",false,new Date(), new Date(), account));
							bookmarkRepository.save(new Task("task2", "task2Descr",false,new Date(),new Date(), account));

						});
	}
}
