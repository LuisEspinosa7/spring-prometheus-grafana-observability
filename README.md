# Hotels Occupancy Service

Hotels occupancy service is used for creating occupancy records on a database. The docker containers either for the MySQL database and the spring boot spplication are build using docker-compose. This was developed by Luis Espinosa Llanos using the following technologies and tools: 

<table style="width:100%">
  <tr>
    <td>
  	Core	
    </td>
    <td>
  	Java 21, Spring Boot 3, Data JPA, Hibernate, Loombok, Jackson Databinding.
    </td>
  </tr>
  <tr>
    <td>
  	Databases
    </td>
    <td>
  	MySQL 8
    </td>
  </tr>
  <tr>
    <td>
  	Virtualization
    </td>
    <td>
  	Docker, docker-compose
    </td>
  </tr>
  <tr>
    <td>
  	Server	
    </td>
    <td>
  	Apache Tomcat Embebido (Spring Boot)
    </td>
  </tr>
  <tr>
    <td>
  	IDE	
    </td>
    <td>
  	STS
    </td>
  </tr>
  <tr>
    <td>
  	Executable	
    </td>
    <td>
  	Jar
    </td>
  </tr>
</table>


## Installation

This proyect should be installed using the following command on the base project's folder:
```bash
docker-compose -f 0.monitoring.yml up -d
docker-compose -f common.yml -f 1.infra-structure.yml up -d
docker-compose -f common.yml -f 2.applications.yml up -d
```


## Contributing
This proyect is quite simple, and is part of my personal portfolio, so it is not intended to receive contributions.
