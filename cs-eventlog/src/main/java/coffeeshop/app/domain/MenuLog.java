package coffeeshop.app.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Table("logs")
public class MenuLog implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private String description;
    private String log_timestamp;
    
    public String getLog_timestamp() {
		return log_timestamp;
	}

	public void setLog_timestamp(String log_timestamp) {
		this.log_timestamp = log_timestamp;
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	public MenuLog() {
        id = UUID.randomUUID();
        Date date = new Date();
        log_timestamp = sdf.format(date);
    }
}
