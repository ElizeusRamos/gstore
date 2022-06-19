# GStore - Sistema Generic Store 👜
![GStore](https://user-images.githubusercontent.com/83174570/171053744-a18428e5-2c50-4d3d-87cd-ffb20a585f99.png)
---

Sistema genérico de gerenciamento de loja, dentre as principais funcionalidades básicas inclusas:
- Controle de cliente
- Controle de estoque
- Controle de Pedido 

---
Tecnologias utilizadas no projeto
- Java 11
- Apache Maven 3.6
- Apache Tomcat 8
- MySql 8
- Bootstrap v 5.2

---
Ferramentas utilizadas
- Eclipse
- DBeaver
- Notepad++
- GitBash

---
SCRIPT DE BANCO DE DADOS - CRIAÇÃO

[script](https://github.com/ElizeusRamos/gstore/blob/master/scripts.sql)
---
CONFIGURAÇÃO DA CONEXÃO COM O BANCO DE DADOS

```
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
private static final String USER = "root";
private static final String PASSWORD = "root";
private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/bancodedados";
```
arquivo: [ConnectionFactory.java](https://github.com/ElizeusRamos/gstore/blob/master/GStoreWorkspace/GStoreWeb/src/com/gstore/dao/ConnectionFactory.java)
---
DEPENDÊNCIA - DRIVER DE CONEXÃO AO BANCO DE DADOS - MYSQL
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>
```
arquivo: [pom.xml](https://github.com/ElizeusRamos/gstore/blob/master/GStoreWorkspace/GStoreWeb/pom.xml)
---

## Imagens do sistema

Página inicial de apresentação
![main-page](https://user-images.githubusercontent.com/83174570/174497131-175baa21-2f3e-446d-82f0-b26cae55cb62.png)


Controle de Clientes
![clientes-page](https://user-images.githubusercontent.com/83174570/171053470-7bdcf977-88d9-4502-a172-b01e0c6364b9.png)
- Consultar e/ou Excluir
![clientes-consultar-exclusao](https://user-images.githubusercontent.com/83174570/171053512-a8816a80-d1fb-407e-b033-0d3baf613c37.png)

- Alterar dados cadastrais
![clientes-alterar](https://user-images.githubusercontent.com/83174570/171053545-7f749f17-e0ee-4a7c-ad84-0082b6e75257.png)


Controle de Produtos
![produtos-page](https://user-images.githubusercontent.com/83174570/171053479-d34615d4-017e-4094-8f16-acc7ad6a3fb7.png)

- Consultar e/ou excluir
![produtos-consulta-exclusao](https://user-images.githubusercontent.com/83174570/171053556-ab4b022b-9ecb-4453-a22c-1e381903f3e1.png)

- Alterar dados cadastrais
![produtos-alteracao](https://user-images.githubusercontent.com/83174570/171053574-710e8d14-5eba-4ae0-a1df-09db86da2e95.png)
