-- Criação da tabela principal
CREATE TABLE tabela_tarifaria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    vigencia DATE NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT NOW()
);

-- Criação da tabela de categorias
CREATE TABLE tabela_categoria (
    id SERIAL PRIMARY KEY,
    tabela_tarifaria_id INTEGER NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    CONSTRAINT fk_tabela_tarifaria FOREIGN KEY (tabela_tarifaria_id) 
        REFERENCES tabela_tarifaria(id)
);

-- Criação da tabela de faixas
CREATE TABLE faixa_consumo (
    id SERIAL PRIMARY KEY,
    categoria_tabela_id INTEGER NOT NULL,
    inicio INTEGER NOT NULL,
    fim INTEGER NOT NULL,
    valor_unitario NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_categoria_tabela FOREIGN KEY (categoria_tabela_id) 
        REFERENCES tabela_categoria(id)
);