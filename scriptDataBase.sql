CREATE TABLE `asignar_examen` (
  `id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) DEFAULT NULL,
  `examen_id` bigint(20) DEFAULT NULL,
  `fecha_examen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





CREATE TABLE `estudiante` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `zona` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `examen` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `examen_by_alumno` (
  `id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) DEFAULT NULL,
  `respuesta` varchar(255) DEFAULT NULL,
  `examen_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `exmen_preguntas` (
  `id` bigint(20) NOT NULL,
  `id_examen` bigint(20) DEFAULT NULL,
  `id_pregunta` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





CREATE TABLE `preguntasexamen` (
  `id` bigint(20) NOT NULL,
  `pregunta` varchar(255) DEFAULT NULL,
  `respuestaa` varchar(255) DEFAULT NULL,
  `respuestab` varchar(255) DEFAULT NULL,
  `respuestac` varchar(255) DEFAULT NULL,
  `respuestad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `asignar_examen`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `examen_by_alumno`
--
ALTER TABLE `examen_by_alumno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKogn1xenth5gk6hkot6exbvvve` (`examen_id`);

--
-- Indices de la tabla `exmen_preguntas`
--
ALTER TABLE `exmen_preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntasexamen`
--
ALTER TABLE `preguntasexamen`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignar_examen`
--
ALTER TABLE `asignar_examen`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `examen`
--
ALTER TABLE `examen`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `examen_by_alumno`
--
ALTER TABLE `examen_by_alumno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `exmen_preguntas`
--
ALTER TABLE `exmen_preguntas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `preguntasexamen`
--
ALTER TABLE `preguntasexamen`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `examen_by_alumno`
--
ALTER TABLE `examen_by_alumno`
  ADD CONSTRAINT `FKogn1xenth5gk6hkot6exbvvve` FOREIGN KEY (`examen_id`) REFERENCES `examen` (`id`);
COMMIT;