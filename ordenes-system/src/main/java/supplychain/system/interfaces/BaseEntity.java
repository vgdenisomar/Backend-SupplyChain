package supplychain.system.interfaces;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author dovelasquez
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "ID_UUID")
    private String id;

    @Column(name = "UserCreated", length = 32, updatable = false)
    private String userCreated;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DateCreated", updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "UserLastModify", length = 32)
    private String userLastModify;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DateLastModify")
    private LocalDateTime dateLastModify;

    @Column(name = "RegistryStatus", length = 20)
    private String registryStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(String userLastModify) {
        this.userLastModify = userLastModify;
    }

    public LocalDateTime getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(LocalDateTime dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    public String getRegistryStatus() {
        return registryStatus;
    }

    public void setRegistryStatus(String registryStatus) {
        this.registryStatus = registryStatus;
    }

    @Override
    public String toString() {
        return "BaseEntity{" + "id=" + id + ", userCreated=" + userCreated + ", dateCreated=" + dateCreated + ", userLastModify=" + userLastModify + ", dateLastModify=" + dateLastModify + ", registryStatus=" + registryStatus + '}';
    }

    
    
}
