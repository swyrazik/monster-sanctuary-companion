package com.swyrazik.monstersanctuary.companion.testing.endtoend.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.swyrazik.monstersanctuary.companion.testing.endtoend.api.EndToEndTest;

public class DockerBasedTest {
    
    @EndToEndTest
    void test() {
        System.out.println("Running TEST...");
        try (DockerClient dockerClient = createDockerClient()) {
            System.out.println("Pulling image...");
            dockerClient.pullImageCmd("hello-world")
                    .withTag("latest")
                    .start()
                    .awaitCompletion();
            System.out.println("Pulled image.");
            
            System.out.println("Creating container...");
            final CreateContainerResponse containerResponse = dockerClient.createContainerCmd("hello-world:latest")
                    .withName("hello-world")
                    .exec();
            final String containerId = containerResponse.getId();
            System.out.println("Created container.");
            
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            System.out.println("Removing container...");
            dockerClient.removeContainerCmd(containerId).exec();
            System.out.println("Removed container.");
            
            System.out.println("Removing image...");
            dockerClient.removeImageCmd("hello-world:latest").exec();
            System.out.println("Removed image.");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static DockerClient createDockerClient() {
        final DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        
        final DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .build();
        return DockerClientImpl.getInstance(config, httpClient);
    }
}
