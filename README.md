# Spring Boot + Hibernate Envers

## Prerequisites:
- Java 8
- Maven

## Database:
- Apache Derby

## Project Structure
* com.example.springdataenvers
    * SpringDataEnversApplication
      * Main spring boot application
* com.example.springdataenvers.model
    * Product
      * Domain data object
    * ProductRevision
      * Pack audit data transfer object for Product
* com.example.springdataenvers.controller
    * ProductController
      * Rest Controller for CRUD Product and look up Product audit log
* com.example.springdataenvers.dao
    * IProductRepository
      * Repository for CRUD Product object and write Product audit log
    * IProductRevisionQuery
    * ProductRevisionQuery
      * Query Product audit log and pack to ProductRevision


### Database Schema
![database-schema](src/main/resources/db-schema.png)

## Entity
### Domain
```java
@Entity(name = "DATA_PRODUCT")
@Audited
@AuditTable("AUDIT_PRODUCT")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private Long id;
	private String code;
	private String name;
	private BigDecimal price;
}
```
### Audit POJO
```java
public class ProductRevision {
	private Product product;
	private DefaultRevisionEntity revision;
	private RevisionType revisionType;

	public Number getRevisionNumber() {
		return revision.getId();
	}

	public Date getRevisionDate() {
		return revision.getRevisionDate();
	}
}
```

## Example Rest API:
- POST - http://localhost:8888/save : {"code": "P1","name": "Pepsi","price": 10.00}
- POST - http://localhost:8888/list
- POST - http://localhost:8888/update : {"id":1,"code": "C2","name": "Coke","price": 12.12}
- GET - http://localhost:8888/getProductById/1
- GET - http://localhost:8888/deleteById/1
- GET - http://localhost:8888/getProductRevisionsById/1

### Blog
[Spring Boot + JPA (Hibernate) Envers]: https://medium.com/@sarun.wn/spring-boot-jpa-hibernate-envers-53d54131e365?source=friends_link&sk=a9f921bee3aedfdd9ec909d9224a342b
[Spring Boot + JPA (Hibernate) Envers]
