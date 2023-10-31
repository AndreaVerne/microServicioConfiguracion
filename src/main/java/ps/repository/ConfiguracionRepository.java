package ps.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ps.model.Configuracion;

@EnableMongoRepositories
public interface ConfiguracionRepository extends MongoRepository< Configuracion, ObjectId> {


}
