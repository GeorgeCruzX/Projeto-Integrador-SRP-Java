-- Tabela Cidadao
CREATE TABLE `Cidadao` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) NOT NULL,
    `cpf` char(11) NOT NULL,
    `email` varchar(255) NOT NULL,
    `senha` varchar(500) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Tabela Setor
CREATE TABLE `Setor` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `nome` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Tabela Reclamacao
CREATE TABLE `Reclamacao` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `reclamar` varchar(1000) NOT NULL,
    `endereco` varchar(600) NOT NULL,
    `setor_id` bigint NOT NULL,
    `data_reclamacao` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `cidadao_id` bigint NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cidadao_id`) REFERENCES `Cidadao`(`id`),
    FOREIGN KEY (`setor_id`) REFERENCES `Setor`(`id`)
);