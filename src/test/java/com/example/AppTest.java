package com.example;

import cloud.localstack.DockerTestUtils;
import cloud.localstack.LocalstackExtension;
import cloud.localstack.LocalstackTestRunner;
import cloud.localstack.docker.LocalstackDockerExtension;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(LocalstackTestRunner.class)
@LocalstackDockerProperties(randomizePorts = true, services = { "dynamodb" })
class AppTest {

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