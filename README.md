
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Lei Zhu                    |
| Date         | 12/01/2024                 |
| Course       | Fall                       |
| Assignment # | Term Project               |

# Assignment Overview
Design a Mountain Resorts Booking System, help users to make a reservation to a resort.

# GitHub Repository Link:
https://github.com/LeiZ54/cs-665-term-project.git

# Implementation Description
- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.  
The implementation leverages the DAO (Data Access Object) design pattern, which abstracts database
operations into specific interfaces and classes. This abstraction allows:  
Ease of addition: Adding a new entity type, such as Hotel or SkiEquipment, involves creating a 
corresponding DAO interface and implementation, with no impact on existing DAOs.  
Ease of removal: Removing an entity only requires deleting its DAO implementation and associated 
services, minimizing side effects.  
Flexibility: Changes to database schemas (e.g., new columns) only require updates in the specific 
DAO and associated service, isolating the impact of changes.  
- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.  
Entity Classes: Representing business objects (e.g., MtResort, Book).  
DAO Interfaces: Defining database operations for entities.  
DAO Implementations: Handling specific SQL operations.  
Service Layer: Managing business logic and interacting with DAOs.  
- Describe how you have avoided duplicated code and why it is important.  
Centralized Configuration: All database connections are managed through JDBCConfig, ensuring consistency and reducing redundancy in connection handling.  
Reusable Methods: Common operations like closing database resources (closeResources) are encapsulated in helper methods, ensuring they are handled consistently.  
Entity Mapping: Entities like MtResort and Book have constructors and methods that simplify data mapping from ResultSet objects, avoiding repetitive code for each DAO.  
Avoiding duplication:
Improves maintainability: Changes to shared logic only need to be made in one place.
Reduces errors: Consistent handling of resources (e.g., connections) minimizes the risk of issues like resource leaks.
- If applicable, mention any design patterns you have used and explain why they were chosen.
DAO Pattern: Abstracts data persistence operations, making it easier to swap out database implementations or frameworks without affecting the business logic.  
Factory Pattern: Used indirectly through helper methods like JDBCConfig.getConnection(), which centralizes the creation of database connections.  