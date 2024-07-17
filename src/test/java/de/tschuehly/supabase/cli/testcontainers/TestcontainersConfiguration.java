package de.tschuehly.supabase.cli.testcontainers;

import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
  public GenericContainer<?> supabaseContainer() {
		GenericContainer<?> supabase = new GenericContainer<>("supabase-cli")
				.withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("supabase")))
				.withCopyFileToContainer(
						MountableFile.forClasspathResource("/supabase/"),
						"/app/supabase/"
				)
				.withFileSystemBind("/var/run/docker.sock", "/var/run/docker.sock")
				.withExposedPorts(56661)
				.withAccessToHost(true)
				.withCommand("supabase start --debug --ignore-health-check")
				.waitingFor(Wait.forLogMessage(".*Started supabase local development setup.*", 1));
		Testcontainers.exposeHostPorts(56661);
		return supabase;
  }

}
