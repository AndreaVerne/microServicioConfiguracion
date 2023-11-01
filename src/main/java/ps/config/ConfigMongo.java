package ps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.yourpackage.repository")
public class ConfigMongo extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "your_database_name";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }


    protected String getMappingBasePackage() {
        return "com.example.yourpackage.model";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017/your_database_name");
    }
}