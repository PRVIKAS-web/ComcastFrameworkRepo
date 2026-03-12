package practice.pom.repository;

import java.util.UUID;

public class GenerateRandomData {

	public static void main(String[] args) {
		UUID random = UUID.randomUUID();
		System.out.println(random);
		System.out.println(random.toString().replaceAll("[^a-zA-Z]",""));
	}
}
