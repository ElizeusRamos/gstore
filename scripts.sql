CREATE database bancodedados;

CREATE TABLE bancodedados.clientes (
	id int primary key auto_increment NOT NULL,
	nome varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	cpf varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	email varchar(255) NULL,
	telefone varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	endereco varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	cep varchar(255) NULL,
	bairro varchar(255) NULL,
	cidade varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	ativo BOOL NULL
)
ENGINE=MyISAM
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE bancodedados.produtos (
	id INT primary key auto_increment NOT NULL,
	nome varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	descricao varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	preco DOUBLE NOT NULL,
	qtde INT NOT NULL
)
ENGINE=MyISAM
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE bancodedados.cargos (
	id INT primary key auto_increment NOT NULL,
	nome varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	descricao varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	ativo BOOL DEFAULT true NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


CREATE TABLE bancodedados.pedidos (
	id INT primary key auto_increment NOT NULL,
	vendedor varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	cliente varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	total double NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE bancodedados.categorias (
	id INT primary key auto_increment NOT NULL,
	nome varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	descricao varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	ativo BOOL NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE bancodedados.colaboradores (
	id INT primary key auto_increment NOT NULL,
	nome varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	cargo varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	email varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	descricao varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
	ativo BOOL NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;