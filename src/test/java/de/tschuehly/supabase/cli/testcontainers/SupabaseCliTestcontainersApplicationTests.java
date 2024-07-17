package de.tschuehly.supabase.cli.testcontainers;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.MountableFile;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:postgresql://localhost:56661/postgres"})
class SupabaseCliTestcontainersApplicationTests {

  @Test
  void contextLoads() {
  }

}
