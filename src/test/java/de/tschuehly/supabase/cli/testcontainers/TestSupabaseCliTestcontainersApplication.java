package de.tschuehly.supabase.cli.testcontainers;

import org.springframework.boot.SpringApplication;

public class TestSupabaseCliTestcontainersApplication {

	public static void main(String[] args) {
		SpringApplication.from(SupabaseCliTestcontainersApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
