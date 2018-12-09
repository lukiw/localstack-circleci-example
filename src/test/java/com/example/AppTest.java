package com.example;

import cloud.localstack.DockerTestUtils;
import cloud.localstack.LocalstackExtension;
import cloud.localstack.docker.LocalstackDockerExtension;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(LocalstackDockerExtension.class)
@LocalstackDockerProperties(randomizePorts = true, services = { "dynamodb" })
class AppTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doIt() {
        AmazonDynamoDB dynamoDB = DockerTestUtils.getClientDynamoDb();
        App app = new App(dynamoDB);

        app.it();
    }

    @Test
    void doQuery() {
        AmazonDynamoDB dynamoDB = DockerTestUtils.getClientDynamoDb();
        App app = new App(dynamoDB);

        app.query();
    }
}