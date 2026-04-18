-- Inserindo a tabela tarifária
INSERT INTO tabela_tarifaria (nome, vigencia, ativo, criado_em)
VALUES ('Tabela Tarifária 2026', '2026-01-01', true, NOW());

-- Inserindo as categorias (tabela_tarifaria_id = 1)
INSERT INTO tabela_categoria (tabela_tarifaria_id, categoria) VALUES (1, 'INDUSTRIAL');
INSERT INTO tabela_categoria (tabela_tarifaria_id, categoria) VALUES (1, 'COMERCIAL');
INSERT INTO tabela_categoria (tabela_tarifaria_id, categoria) VALUES (1, 'PARTICULAR');
INSERT INTO tabela_categoria (tabela_tarifaria_id, categoria) VALUES (1, 'PUBLICO');

-- Faixas da categoria INDUSTRIAL (categoria_tabela_id = 1)
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (1, 0, 10, 1.00);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (1, 11, 20, 2.00);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (1, 21, 30, 3.00);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (1, 31, 99999, 4.00);

-- Faixas da categoria COMERCIAL (categoria_tabela_id = 2)
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (2, 0, 10, 1.50);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (2, 11, 20, 2.50);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (2, 21, 30, 3.50);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (2, 31, 99999, 4.50);

-- Faixas da categoria PARTICULAR (categoria_tabela_id = 3)
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (3, 0, 10, 0.50);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (3, 11, 20, 1.00);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (3, 21, 30, 1.50);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (3, 31, 99999, 2.00);

-- Faixas da categoria PUBLICO (categoria_tabela_id = 4)
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (4, 0, 10, 0.75);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (4, 11, 20, 1.25);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (4, 21, 30, 1.75);
INSERT INTO faixa_consumo (categoria_tabela_id, inicio, fim, valor_unitario) VALUES (4, 31, 99999, 2.25);