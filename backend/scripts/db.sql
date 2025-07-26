DROP TABLE IF EXISTS basket_detail;
DROP TABLE IF EXISTS basket;
DROP TABLE IF EXISTS "user"; --user is a keyword in postgre
DROP TABLE IF EXISTS product_variant;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS genre;

CREATE TABLE genre (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE category (
	id SERIAL PRIMARY KEY,
	name VARCHAR(200) NOT NULL
);

CREATE TABLE product (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	descripcion VARCHAR(250) NOT NULL
);

CREATE TABLE product_variant (
	id SERIAL PRIMARY KEY,
	size VARCHAR(10) NOT NULL,
	color VARCHAR(30) NOT NULL,
	stock INTEGER NOT NULL,
	photo_url VARCHAR(250),
	price DECIMAL(10,2) NOT NULL,
	genre_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES genre(id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE "user" (
    id UUID PRIMARY KEY, 
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE basket (
    id SERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    status VARCHAR(20) DEFAULT 'active',
    FOREIGN KEY (user_id) REFERENCES "user"(id)
);

CREATE TABLE basket_detail (
    id SERIAL PRIMARY KEY,
    basket_id INTEGER NOT NULL,
    product_variant_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL DEFAULT 1,
    FOREIGN KEY (basket_id) REFERENCES basket(id),
    FOREIGN KEY (product_variant_id) REFERENCES product_variant(id)
);


INSERT INTO genre (name) VALUES
('Hombre'),
('Mujer'),
('Niño');

INSERT INTO category (name) VALUES
('Camisetas'),
('Pantalones'),
('Camisas'),
('Zapatos'),
('Zapatillas'),
('Sudaderas'),
('Trajes'),
('Bañadores');

INSERT INTO product (name, descripcion) VALUES
('Camiseta Básica', 'Camiseta de algodón cómoda y fresca.'),
('Pantalón Vaquero', 'Pantalón vaquero azul clásico.'),
('Camisa Formal', 'Camisa blanca para ocasiones formales.'),
('Zapatos de Cuero', 'Zapatos elegantes de cuero negro.'),
('Zapatillas Running', 'Zapatillas para correr, ligeras y cómodas.'),
('Sudadera con Capucha', 'Sudadera deportiva con capucha.'),
('Traje Completo', 'Traje de chaqueta y pantalón para eventos.'),
('Bañador Hombre', 'Bañador de secado rápido para piscina.');

INSERT INTO product_variant (size, color, stock, photo_url, price, genre_id, category_id, product_id) VALUES
('S', 'Blanco', 50, 'https://jaspeoriginal.es/cdn/shop/files/Camiseta_Basica_Blanca_2.jpg?v=1728372967&width=1445', 15.99, 1, 1, 1),
('M', 'Negro', 40, 'https://bamigo.com/media/catalog/product/cache/e5003119a0e3fd304438d617b07da7a2/c/o/connor_black.jpg', 15.99, 2, 1, 1),
('32', 'Azul', 20, 'https://mivestidorazul.es/17402-large_default/pantalon-vaquero-mujer-kate-vaquero.jpg', 39.99, 1, 2, 2),
('34', 'Azul', 15, 'https://mivestidorazul.es/17402-large_default/pantalon-vaquero-mujer-kate-vaquero.jpg', 39.99, 1, 2, 2),
('M', 'Blanco', 25, 'https://jaspeoriginal.es/cdn/shop/files/Camiseta_Basica_Blanca_2.jpg?v=1728372967&width=1445', 29.99, 2, 3, 3),
('42', 'Negro', 10, 'https://cdn.zapatosvas.com/54400-superlarge_default/zapato-de-hombre-negro-vas-3000-85102.jpg', 79.99, 1, 4, 4),
('40', 'Rojo', 30, 'https://shoppinginibiza.com/179579-large_default/nike-zapatillas-rojas-star-runner-4-nn-ninoa.jpg', 59.99, 2, 5, 5),
('L', 'Gris', 20, 'https://ferreteriacasado.es/16938/velilla-sudadera-basica-105701-gr-jasp-varias-tallas.jpg', 35.99, 3, 6, 6),
('M', 'Azul Marino', 5, 'https://img01.ztat.net/article/spp-media-p1/4ffa769636713e14adea4de2851f04ff/6dfc7d0ba9974063822253e45e7e0d9e.jpg?imwidth=1800&filter=packshot', 150.00, 1, 7, 7),
('M', 'Negro', 40, 'https://mktgifts.com/WebRoot/Store/Shops/Mktgifts/6781/FDCC/771C/3A03/3770/0A6E/0D02/71AD/21830-002-P.jpg', 19.99, 1, 8, 8);

