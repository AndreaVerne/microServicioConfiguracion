package ps.repository;

import java.util.Date;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ps.model.Configuracion;

@EnableMongoRepositories
public interface ConfiguracionRepository extends MongoRepository< Configuracion, ObjectId> {
	

    // Consulta para obtener la configuración más reciente anterior a una fecha específica
    Configuracion findFirstByFechaBeforeOrderByFechaDesc(Date date);


		
	 }

