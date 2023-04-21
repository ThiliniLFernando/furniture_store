package database;
// Generated Dec 18, 2019 4:06:31 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BackendUser generated by hbm2java
 */
public class BackendUser  implements java.io.Serializable {


     private Integer id;
     private Role role;
     private String name;
     private String username;
     private String password;
     private Date dateCreated;
     private Date dateUpdate;
     private String buserStatus;
     private String mobile;
     private String email;
     private String image;
     private Set<BackendUserLog> backendUserLogs = new HashSet<BackendUserLog>(0);

    public BackendUser() {
    }

	
    public BackendUser(Role role, String name, String username, String password, Date dateCreated, String buserStatus, String mobile) {
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
        this.dateCreated = dateCreated;
        this.buserStatus = buserStatus;
        this.mobile = mobile;
    }
    public BackendUser(Role role, String name, String username, String password, Date dateCreated, Date dateUpdate, String buserStatus, String mobile, String email, String image, Set<BackendUserLog> backendUserLogs) {
       this.role = role;
       this.name = name;
       this.username = username;
       this.password = password;
       this.dateCreated = dateCreated;
       this.dateUpdate = dateUpdate;
       this.buserStatus = buserStatus;
       this.mobile = mobile;
       this.email = email;
       this.image = image;
       this.backendUserLogs = backendUserLogs;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getDateUpdate() {
        return this.dateUpdate;
    }
    
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
    public String getBuserStatus() {
        return this.buserStatus;
    }
    
    public void setBuserStatus(String buserStatus) {
        this.buserStatus = buserStatus;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set<BackendUserLog> getBackendUserLogs() {
        return this.backendUserLogs;
    }
    
    public void setBackendUserLogs(Set<BackendUserLog> backendUserLogs) {
        this.backendUserLogs = backendUserLogs;
    }




}

