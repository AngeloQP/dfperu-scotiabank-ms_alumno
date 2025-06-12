CREATE TABLE alumno (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        apellido VARCHAR(100) NOT NULL,
                        estado INT NOT NULL DEFAULT 0,
                        edad INT NOT NULL
);
