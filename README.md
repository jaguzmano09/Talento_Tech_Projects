# 🌱⚡ Sistema de Gestión de Comunidades Energéticas

<div align="center">

![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)

### 🎓 Proyecto Final - Bootcamp Programación Intermedio

**TalentoTech 2025**

---

**Desarrollado por:**

🧑‍💻 **Andrés Gutiérrez** | 🧑‍💻 **Javier Guzmán** | 🧑‍💻 **José Buritica**

---

</div>

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Objetivos](#-objetivos)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Arquitectura del Sistema](#-arquitectura-del-sistema)
- [Modelo de Datos](#-modelo-de-datos)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Patrones de Diseño](#-patrones-de-diseño)
- [Funcionalidades Principales](#-funcionalidades-principales)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Uso del Sistema](#-uso-del-sistema)
- [Base de Datos](#-base-de-datos)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Conclusiones](#-conclusiones)

---

## 📖 Descripción del Proyecto

El **Sistema de Gestión de Comunidades Energéticas** es una aplicación de escritorio desarrollada en **Java** que permite administrar y monitorear comunidades dedicadas a la generación, distribución y consumo de energías renovables.

Este sistema facilita la gestión integral de:

- 🏘️ Comunidades energéticas
- 🏠 Hogares (Households) participantes
- ⚡ Proyectos de energía renovable (solar, eólica, hidroeléctrica, biomasa)
- 🔧 Equipamiento energético
- 📊 Registros de generación y consumo
- 🎓 Sesiones de capacitación
- 💰 Incentivos estatales

El proyecto fue desarrollado como **proyecto final del Bootcamp de Programación Intermedio de TalentoTech**, aplicando conceptos de programación orientada a objetos, gestión de bases de datos relacionales, y arquitectura de software en capas.

---

## 🎯 Objetivos

### Objetivos Principales

✅ Implementar un sistema CRUD completo para gestión de comunidades energéticas  
✅ Aplicar arquitectura en capas (MVC + DAO)  
✅ Utilizar JDBC para conexión con base de datos MySQL  
✅ Desarrollar un sistema robusto con manejo de excepciones  
✅ Implementar patrones de diseño profesionales

### Objetivos de Aprendizaje

📚 Consolidar conocimientos de Java SE  
📚 Dominar el patrón DAO (Data Access Object)  
📚 Trabajar con bases de datos relacionales complejas  
📚 Aplicar principios SOLID y buenas prácticas  
📚 Desarrollar trabajo colaborativo en equipo

---

## 🛠️ Tecnologías Utilizadas

### Backend y Lenguaje

```
☕ Java SE 25
📦 Maven (Gestión de dependencias)
🔌 JDBC (Conectividad con base de datos)
```

### Base de Datos

```
🐬 MySQL 8.0+
🌐 Aiven Cloud (MySQL en la nube)
🔐 SSL/TLS para conexiones seguras
```

### Librerías y Drivers

```xml
<!-- Driver oficial de MySQL -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

### Herramientas de Desarrollo

- **IDE**: IntelliJ IDEA / Eclipse
- **Control de versiones**: Git
- **Gestión de proyecto**: Maven
- **Cliente DB**: MySQL Workbench

---

## 🏗️ Arquitectura del Sistema

El proyecto sigue una **arquitectura en capas** que separa responsabilidades y facilita el mantenimiento:

```
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE PRESENTACIÓN                     │
│                   (CommunityEnergyApp)                      │
│  • Interfaz de usuario por consola                          │
│  • Menús interactivos                                       │
│  • Validación de entrada de datos                           │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE MODELO (Model)                   │
│                                                              │
│  📦 Community          📦 EnergyProject                     │
│  📦 Household          📦 Equipment                         │
│  📦 GenerationRecord   📦 ConsumptionRecord                 │
│  📦 TrainingSession    📦 StateIncentive                    │
│                                                              │
│  • Clases POJO con getters/setters                          │
│  • Representan entidades del dominio                        │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                  CAPA DE ACCESO A DATOS (DAO)               │
│                                                              │
│  🔧 CommunityDAO       🔧 EnergyProjectDAO                  │
│  🔧 HouseholdDAO       🔧 EquipmentDAO                      │
│                                                              │
│  • Operaciones CRUD                                          │
│  • Consultas SQL preparadas                                 │
│  • Manejo de ResultSet                                      │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                 CAPA DE UTILIDADES (Util)                   │
│                  (DatabaseConnection)                        │
│                                                              │
│  • Gestión de conexiones a BD                               │
│  • Configuración de parámetros                              │
│  • Test de conectividad                                     │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                      BASE DE DATOS MySQL                    │
│                   (energy_communities)                       │
│                                                              │
│  📊 8 Tablas relacionales                                   │
│  🔗 Integridad referencial                                  │
│  🔐 Conexión segura SSL                                     │
└─────────────────────────────────────────────────────────────┘
```

### Ventajas de esta Arquitectura

✅ **Separación de responsabilidades**: Cada capa tiene un propósito específico  
✅ **Mantenibilidad**: Fácil de modificar y extender  
✅ **Reutilización**: Las clases DAO pueden usarse en diferentes contextos  
✅ **Testabilidad**: Cada capa puede probarse independientemente  
✅ **Escalabilidad**: Fácil agregar nuevas funcionalidades

---

## 🗄️ Modelo de Datos

### Diagrama de Entidad-Relación

```
┌─────────────────────┐
│   COMMUNITIES       │
│─────────────────────│
│ PK community_id     │─────┐
│    nombre           │     │
│    region           │     │ 1
│    poblacion        │     │
│    anyo_inicio      │     │
│    meta_energia_MW  │     │
└─────────────────────┘     │
                            │
         ┌──────────────────┼──────────────────┬──────────────────┐
         │                  │                  │                  │
         │ N                │ N                │ N                │
         │                  │                  │                  │
┌────────▼──────────┐  ┌────▼───────────────┐  ┌────▼──────────────────┐
│   HOUSEHOLDS      │  │  ENERGY_PROJECTS   │  │  TRAINING_SESSIONS    │
│───────────────────│  │────────────────────│  │───────────────────────│
│PK household_id    │  │PK project_id       │──┐PK session_id         │
│FK community_id    │  │FK community_id     │  │FK community_id        │
│   direccion       │  │   tipo_proyecto    │  │   tema                │
│   num_residentes  │  │   capacidad_MW     │  │   fecha_sesion        │
│   nivel_socioeco  │  │   fecha_lanzamiento│  │   num_asistentes      │
└───────────────────┘  │   estado           │  └───────────────────────┘
         │             └────────────────────┘
         │                      │
         │ 1                    │ 1
         │                      │
         │ N                    │ N
         │                      │
┌────────▼──────────────┐  ┌────▼────────────────┐
│CONSUMPTION_RECORDS    │  │   EQUIPMENTS        │
│───────────────────────│  │─────────────────────│
│PK cons_record_id      │  │PK equipment_id      │──┐
│FK household_id        │  │FK project_id        │  │
│   fecha_registro      │  │   tipo_equipo       │  │
│   consumo_kWh         │  │   fabricante        │  │
│   importacion_red_kWh │  │   fecha_instalacion │  │
└───────────────────────┘  │   capacidad_kW      │  │
                           └─────────────────────┘  │
                                    │                │
                                    │ 1              │
                                    │                │
                                    │ N              │ N
                                    │                │
                           ┌────────▼──────────┐┌────▼──────────────┐
                           │GENERATION_RECORDS ││STATE_INCENTIVES   │
                           │───────────────────││───────────────────│
                           │PK gen_record_id   ││PK incentive_id    │
                           │FK equipment_id    ││FK project_id      │
                           │   fecha_registro  ││   tipo_incentivo  │
                           │   generacion_kWh  ││   monto_USD       │
                           │   exportacion_kWh ││   fecha_aprobacion│
                           └───────────────────┘└───────────────────┘
```

### Descripción de Entidades

#### 🏘️ COMMUNITIES (Comunidades)

Representa las comunidades energéticas registradas en el sistema.

| Campo             | Tipo          | Descripción                  |
| ----------------- | ------------- | ---------------------------- |
| `community_id`    | INT (PK)      | Identificador único          |
| `nombre`          | VARCHAR(150)  | Nombre de la comunidad       |
| `region`          | VARCHAR(100)  | Región geográfica (Colombia) |
| `poblacion`       | INT           | Número de habitantes         |
| `anyo_inicio`     | INT           | Año de fundación             |
| `meta_energia_MW` | DECIMAL(10,2) | Meta de generación en MW     |

#### 🏠 HOUSEHOLDS (Hogares)

Hogares participantes dentro de cada comunidad.

| Campo            | Tipo         | Descripción                  |
| ---------------- | ------------ | ---------------------------- |
| `household_id`   | INT (PK)     | Identificador único          |
| `community_id`   | INT (FK)     | Comunidad a la que pertenece |
| `direccion`      | VARCHAR(200) | Dirección física             |
| `num_residentes` | INT          | Número de residentes         |
| `nivel_socioeco` | VARCHAR(10)  | Nivel socioeconómico (1-6)   |

#### ⚡ ENERGY_PROJECTS (Proyectos Energéticos)

Proyectos de generación de energía renovable.

| Campo               | Tipo          | Descripción                                  |
| ------------------- | ------------- | -------------------------------------------- |
| `project_id`        | INT (PK)      | Identificador único                          |
| `community_id`      | INT (FK)      | Comunidad propietaria                        |
| `tipo_proyecto`     | VARCHAR(100)  | Tipo: solar, eólica, hidroeléctrica, biomasa |
| `capacidad_MW`      | DECIMAL(10,2) | Capacidad instalada en MW                    |
| `fecha_lanzamiento` | DATE          | Fecha de inicio                              |
| `estado`            | VARCHAR(50)   | planeación, en construcción, operativo       |

#### 🔧 EQUIPMENTS (Equipamiento)

Equipos utilizados en los proyectos energéticos.

| Campo               | Tipo          | Descripción                                    |
| ------------------- | ------------- | ---------------------------------------------- |
| `equipment_id`      | INT (PK)      | Identificador único                            |
| `project_id`        | INT (FK)      | Proyecto al que pertenece                      |
| `tipo_equipo`       | VARCHAR(100)  | panel_solar, turbina_eolica, inversor, batería |
| `fabricante`        | VARCHAR(100)  | Marca fabricante                               |
| `fecha_instalacion` | DATE          | Fecha de instalación                           |
| `capacidad_kW`      | DECIMAL(10,2) | Capacidad en kW                                |

#### 📊 GENERATION_RECORDS (Registros de Generación)

Histórico de energía generada por cada equipo.

| Campo                 | Tipo          | Descripción                |
| --------------------- | ------------- | -------------------------- |
| `gen_record_id`       | INT (PK)      | Identificador único        |
| `equipment_id`        | INT (FK)      | Equipo que generó          |
| `fecha_registro`      | DATE          | Fecha del registro         |
| `generacion_kWh`      | DECIMAL(12,2) | Energía generada en kWh    |
| `exportacion_red_kWh` | DECIMAL(12,2) | Energía exportada a la red |

#### 📉 CONSUMPTION_RECORDS (Registros de Consumo)

Consumo energético de cada hogar.

| Campo                 | Tipo          | Descripción                 |
| --------------------- | ------------- | --------------------------- |
| `cons_record_id`      | INT (PK)      | Identificador único         |
| `household_id`        | INT (FK)      | Hogar que consumió          |
| `fecha_registro`      | DATE          | Fecha del registro          |
| `consumo_kWh`         | DECIMAL(12,2) | Energía consumida en kWh    |
| `importacion_red_kWh` | DECIMAL(12,2) | Energía importada de la red |

#### 🎓 TRAINING_SESSIONS (Sesiones de Capacitación)

Capacitaciones ofrecidas a las comunidades.

| Campo            | Tipo         | Descripción             |
| ---------------- | ------------ | ----------------------- |
| `session_id`     | INT (PK)     | Identificador único     |
| `community_id`   | INT (FK)     | Comunidad capacitada    |
| `tema`           | VARCHAR(200) | Tema de la capacitación |
| `fecha_sesion`   | DATE         | Fecha de realización    |
| `num_asistentes` | INT          | Número de asistentes    |

#### 💰 STATE_INCENTIVES (Incentivos Estatales)

Apoyos económicos del estado a proyectos.

| Campo              | Tipo          | Descripción                                                |
| ------------------ | ------------- | ---------------------------------------------------------- |
| `incentive_id`     | INT (PK)      | Identificador único                                        |
| `project_id`       | INT (FK)      | Proyecto beneficiado                                       |
| `tipo_incentivo`   | VARCHAR(100)  | subsidio, bono, reintegro, crédito_blando, exención fiscal |
| `monto_USD`        | DECIMAL(12,2) | Monto en dólares                                           |
| `fecha_aprobacion` | DATE          | Fecha de aprobación                                        |

---

## 📁 Estructura del Proyecto

```
project_energy_communites/
│
├── 📄 pom.xml                          # Configuración Maven
├── 📄 README.md                        # Documentación (este archivo)
│
├── 📂 src/
│   ├── 📄 community_energy_db.sql     # Script de creación de BD
│   │
│   └── 📂 main/
│       ├── 📂 java/
│       │   └── 📂 com/
│       │       └── 📂 talentotech/
│       │           │
│       │           ├── 📂 app/                    # 🎯 Capa de Presentación
│       │           │   └── 📄 CommunityEnergyApp.java
│       │           │       • Clase principal con main()
│       │           │       • Menús interactivos por consola
│       │           │       • Gestión de flujo de la aplicación
│       │           │
│       │           ├── 📂 model/                  # 📦 Capa de Modelo
│       │           │   ├── 📄 Community.java
│       │           │   │   • Clase POJO de Comunidad
│       │           │   │   • Getters y Setters
│       │           │   │
│       │           │   ├── 📄 EnergyProject.java
│       │           │   │   • Clase POJO de Proyecto Energético
│       │           │   │   • Manejo de LocalDate
│       │           │   │
│       │           │   └── 📄 Household.java
│       │           │       • Clase POJO de Hogar
│       │           │       • Atributos socioeconómicos
│       │           │
│       │           ├── 📂 dao/                    # 🔧 Capa de Acceso a Datos
│       │           │   ├── 📄 CommunityDAO.java
│       │           │   │   • insertar(Community)
│       │           │   │   • listarTodos()
│       │           │   │   • buscarPorId(int)
│       │           │   │   • eliminar(int)
│       │           │   │
│       │           │   ├── 📄 EnergyProjectDAO.java
│       │           │   │   • CRUD de Proyectos Energéticos
│       │           │   │   • Manejo de PreparedStatement
│       │           │   │
│       │           │   └── 📄 HouseholdDAO.java
│       │           │       • CRUD de Hogares
│       │           │       • Validación de FK
│       │           │
│       │           └── 📂 util/                   # ⚙️ Capa de Utilidades
│       │               └── 📄 DatabaseConnection.java
│       │                   • Singleton de conexión
│       │                   • getConnection()
│       │                   • testConnection()
│       │
│       └── 📂 resources/
│           └── (vacío - sin archivos de configuración)
│
└── 📂 target/                          # 🔨 Archivos compilados (Maven)
    ├── 📂 classes/
    └── 📂 generated-sources/
```

### Descripción de Paquetes

#### 📦 `com.talentotech.app`

**Responsabilidad**: Interfaz de usuario y punto de entrada de la aplicación.

- `CommunityEnergyApp.java`: Clase principal que contiene el método `main()` y gestiona los menús interactivos.

#### 📦 `com.talentotech.model`

**Responsabilidad**: Clases del dominio (POJOs - Plain Old Java Objects).

Representan las entidades de la base de datos como objetos Java con:

- Atributos privados
- Constructores (vacío y completo)
- Getters y Setters
- Método `toString()` para depuración

#### 📦 `com.talentotech.dao`

**Responsabilidad**: Acceso a datos y operaciones CRUD.

Cada DAO encapsula las operaciones de base de datos para una entidad específica:

- **Crear** (INSERT)
- **Leer** (SELECT)
- **Actualizar** (UPDATE) - _Pendiente de implementar_
- **Eliminar** (DELETE)

#### 📦 `com.talentotech.util`

**Responsabilidad**: Utilidades y servicios transversales.

- `DatabaseConnection.java`: Gestiona la conexión a MySQL usando JDBC.

---

## 🎨 Patrones de Diseño

### 1️⃣ Patrón DAO (Data Access Object)

**Objetivo**: Separar la lógica de negocio de la lógica de acceso a datos.

```java
// Ejemplo: CommunityDAO.java
public class CommunityDAO {

    // Consultas SQL como constantes
    private static final String INSERT =
        "INSERT INTO communities (nombre, region, ...) VALUES (?, ?, ...)";

    // Método para insertar
    public int insertar(Community c) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getRegion());
            // ... más parámetros

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
```

**Ventajas**:

- ✅ Centraliza el acceso a datos
- ✅ Facilita el cambio de base de datos
- ✅ Código más limpio y mantenible

### 2️⃣ Patrón Singleton (DatabaseConnection)

**Objetivo**: Garantizar una única instancia de conexión a la base de datos.

```java
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://...";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "...";

    // Método estático para obtener conexión
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Falta el Driver MySQL", e);
        }
    }
}
```

### 3️⃣ Patrón POJO (Plain Old Java Object)

Las clases del paquete `model` son POJOs puros que representan entidades:

```java
public class Community {
    // Atributos privados
    private int communityId;
    private String nombre;

    // Constructor vacío
    public Community() {}

    // Constructor completo
    public Community(int id, String nombre, ...) {
        this.communityId = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getCommunityId() { return communityId; }
    public void setCommunityId(int id) { this.communityId = id; }
}
```

### 4️⃣ Try-with-Resources

Gestión automática de recursos para evitar fugas de memoria:

```java
try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement(SQL);
     ResultSet rs = ps.executeQuery()) {

    // Procesar resultados

} catch (SQLException e) {
    e.printStackTrace();
}
// Conexión, PreparedStatement y ResultSet se cierran automáticamente
```

---

## ⚙️ Funcionalidades Principales

### 🏘️ Gestión de Comunidades

```
┌──────────────────────────────────┐
│   MENÚ COMUNIDADES              │
├──────────────────────────────────┤
│ 1. Listar todas las comunidades │
│ 2. Buscar comunidad por ID      │
│ 3. Insertar nueva comunidad     │
│ 4. Eliminar comunidad           │
│ 0. Volver al menú principal     │
└──────────────────────────────────┘
```

**Operaciones**:

- ✅ **Listar**: Muestra todas las comunidades con su ID, nombre y región
- ✅ **Buscar**: Busca una comunidad específica por su ID
- ✅ **Insertar**: Crea una nueva comunidad solicitando:
  - Nombre
  - Región
  - Población
  - Año de inicio
  - Meta energética (MW)
- ✅ **Eliminar**: Elimina una comunidad por ID (con validación de FK)

### ⚡ Gestión de Proyectos Energéticos

```
┌──────────────────────────────────┐
│   MENÚ PROYECTOS ENERGÉTICOS    │
├──────────────────────────────────┤
│ 1. Listar todos los proyectos   │
│ 2. Buscar proyecto por ID       │
│ 3. Insertar nuevo proyecto      │
│ 4. Eliminar proyecto            │
│ 0. Volver al menú principal     │
└──────────────────────────────────┘
```

**Operaciones**:

- ✅ **Listar**: Muestra proyectos con ID, tipo y capacidad (MW)
- ✅ **Buscar**: Busca un proyecto específico
- ✅ **Insertar**: Crea un nuevo proyecto con:
  - ID de comunidad asociada
  - Tipo (solar, eólica, hidroeléctrica, biomasa)
  - Capacidad en MW
  - Estado (planeación, en construcción, operativo)
  - Fecha de lanzamiento
- ✅ **Eliminar**: Elimina un proyecto por ID

### 🏠 Gestión de Hogares (Households)

```
┌──────────────────────────────────┐
│   MENÚ HOUSEHOLDS               │
├──────────────────────────────────┤
│ 1. Listar todos los hogares     │
│ 2. Buscar hogar por ID          │
│ 3. Insertar nuevo hogar         │
│ 4. Eliminar hogar               │
│ 0. Volver al menú principal     │
└──────────────────────────────────┘
```

**Operaciones**:

- ✅ **Listar**: Muestra hogares con ID y dirección
- ✅ **Buscar**: Busca un hogar específico
- ✅ **Insertar**: Registra un nuevo hogar con:
  - ID de comunidad
  - Dirección
  - Número de residentes
  - Nivel socioeconómico
- ✅ **Eliminar**: Elimina un hogar por ID

### 🔐 Validaciones Implementadas

```java
// Validación de conexión a BD al iniciar
if (!DatabaseConnection.testConnection()) {
    System.err.println("❌ No hay conexión a la base de datos.");
    return;
}

// Validación de integridad referencial en DAOs
try {
    // Operación de BD
} catch (SQLException e) {
    if (e.getMessage().contains("foreign key constraint")) {
        System.err.println("❌ No se puede eliminar: existen registros relacionados");
    }
    e.printStackTrace();
}
```

---

## 🚀 Instalación y Configuración

### Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

```
✅ Java Development Kit (JDK) 25 o superior
✅ Maven 3.6+
✅ MySQL 8.0+
✅ IDE (IntelliJ IDEA / Eclipse / VS Code)
```

### Paso 1: Clonar el Repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd project_energy_communites
```

### Paso 2: Configurar la Base de Datos

#### Opción A: Base de Datos Local

1. Crear la base de datos en MySQL:

```sql
CREATE DATABASE energy_communities;
```

2. Ejecutar el script de creación:

```bash
mysql -u root -p energy_communities < src/community_energy_db.sql
```

#### Opción B: Base de Datos en la Nube (Aiven)

El proyecto está configurado para usar **Aiven MySQL Cloud**. La configuración se encuentra en `DatabaseConnection.java`.

### Paso 3: Configurar Credenciales

Edita el archivo `src/main/java/com/talentotech/util/DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://TU_HOST:PUERTO/energy_communities?sslMode=REQUIRED";
private static final String USER = "tu_usuario";
private static final String PASSWORD = "tu_contraseña";
```

### Paso 4: Compilar el Proyecto

```bash
mvn clean compile
```

### Paso 5: Ejecutar la Aplicación

#### Desde Maven:

```bash
mvn exec:java -Dexec.mainClass="com.talentotech.app.CommunityEnergyApp"
```

#### Desde tu IDE:

1. Abrir el proyecto en IntelliJ IDEA / Eclipse
2. Localizar `CommunityEnergyApp.java`
3. Ejecutar el método `main()`

---

## 💻 Uso del Sistema

### Inicio de la Aplicación

Al ejecutar el programa, verás la pantalla de bienvenida:

```
=== SISTEMA DE COMUNIDADES ENERGÉTICAS ===
✓ Conexión exitosa a BD

--- MENÚ PRINCIPAL ---
1. Gestionar Comunidades
2. Gestionar Proyectos Energéticos
3. Gestionar Households
0. Salir
Seleccione opción:
```

### Ejemplo de Uso: Crear una Comunidad

```
Seleccione opción: 1

--- MENÚ COMUNIDADES ---
1. Listar
2. Buscar por ID
3. Insertar
4. Eliminar
0. Volver
Seleccione: 3

--- NUEVA COMUNIDAD ---
Nombre: Comunidad Solar Bogotá
Región: Cundinamarca
Población: 5000
Año inicio: 2024
Meta MW: 3.5

✅ Comunidad Insertada.
```

### Ejemplo de Uso: Listar Proyectos

```
Seleccione opción: 2

--- MENÚ PROYECTOS ENERGÉTICOS ---
1. Listar
2. Buscar por ID
3. Insertar
4. Eliminar
0. Volver
Seleccione: 1

--- PROYECTOS ---
ID 1 | Tipo: biomasa | 1.90 MW
ID 2 | Tipo: hidroeléctrico | 3.02 MW
ID 3 | Tipo: hidroeléctrico | 2.90 MW
ID 4 | Tipo: eólica | 2.89 MW
...
```

---

## 🗃️ Base de Datos

### Configuración de la BD

```sql
-- Configuración del motor
ENGINE=InnoDB

-- Codificación
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci

-- Integridad Referencial
FOREIGN KEY (community_id) REFERENCES communities (community_id)
ON DELETE CASCADE
```

### Datos de Ejemplo

La base de datos viene pre-cargada con **datos de prueba**:

- 📊 **20 comunidades** en diferentes regiones de Colombia
- 📊 **20 hogares** distribuidos en las comunidades
- 📊 **20 proyectos energéticos** (solar, eólica, hidroeléctrica, biomasa)
- 📊 **20 equipos** (paneles, turbinas, inversores, baterías)
- 📊 **20 registros de generación** energética
- 📊 **20 registros de consumo** de hogares
- 📊 **20 sesiones de capacitación**
- 📊 **20 incentivos estatales**

### Consultas SQL Útiles

```sql
-- Ver todas las comunidades con proyectos activos
SELECT c.nombre, COUNT(ep.project_id) as num_proyectos
FROM communities c
LEFT JOIN energy_projects ep ON c.community_id = ep.community_id
WHERE ep.estado = 'operativo'
GROUP BY c.community_id;

-- Capacidad total instalada por región
SELECT c.region, SUM(ep.capacidad_MW) as capacidad_total
FROM communities c
JOIN energy_projects ep ON c.community_id = ep.community_id
GROUP BY c.region
ORDER BY capacidad_total DESC;

-- Promedio de residentes por comunidad
SELECT c.nombre, AVG(h.num_residentes) as promedio_residentes
FROM communities c
JOIN households h ON c.community_id = h.community_id
GROUP BY c.community_id;
```

---

## 📸 Capturas de Pantalla

### Menú Principal

```
=== SISTEMA DE COMUNIDADES ENERGÉTICAS ===
✓ Conexión exitosa a BD

--- MENÚ PRINCIPAL ---
1. Gestionar Comunidades
2. Gestionar Proyectos Energéticos
3. Gestionar Households
0. Salir
```

### Listado de Comunidades

```
--- COMUNIDADES ---
ID 1 | Comunidad Solar 1 | Antioquia
ID 2 | Comunidad Solar 2 | Cundinamarca
ID 3 | Comunidad Solar 3 | Valle del Cauca
ID 4 | Comunidad Solar 4 | Atlántico
...
```

### Inserción de Proyecto

```
--- NUEVO PROYECTO ---
Community ID: 1
Tipo de proyecto: solar
Capacidad MW: 2.5
Estado: operativo
Fecha lanzamiento (YYYY-MM-DD): 2024-11-27
Proyecto creado.
```

---

## 🎓 Conclusiones

### Logros Alcanzados

✅ **Implementación exitosa** de un sistema CRUD completo  
✅ **Arquitectura en capas** bien definida y documentada  
✅ **Patrón DAO** aplicado correctamente  
✅ **Gestión de conexiones** con JDBC de forma eficiente  
✅ **Base de datos relacional** normalizada y poblada  
✅ **Interfaz de usuario** intuitiva por consola  
✅ **Manejo de excepciones** robusto  
✅ **Código limpio** siguiendo buenas prácticas Java

### Aprendizajes Principales

📚 **Arquitectura de Software**: Diseño en capas (MVC + DAO)  
📚 **Bases de Datos**: Diseño relacional, normalización, integridad referencial  
📚 **Java SE**: POJOs, colecciones, manejo de fechas (LocalDate)  
📚 **JDBC**: Conexiones, PreparedStatement, ResultSet  
📚 **Patrones de Diseño**: DAO, Singleton, POJO  
📚 **Maven**: Gestión de dependencias  
📚 **Trabajo en Equipo**: Colaboración y distribución de tareas

### Trabajo Futuro

🔮 **Mejoras Planificadas**:

- [ ] Implementar operación UPDATE en todos los DAOs
- [ ] Agregar validaciones más robustas (reglas de negocio)
- [ ] Interfaz gráfica (JavaFX o Swing)
- [ ] Reportes y estadísticas (generación vs consumo)
- [ ] Sistema de autenticación de usuarios
- [ ] API REST para integración con frontend web
- [ ] Implementar logs con Log4j
- [ ] Tests unitarios con JUnit

---

## 👥 Autores

<table>
  <tr>
    <td align="center">
      <h3>🧑‍💻 Andrés Gutiérrez</h3>
      <p>Desarrollador Backend</p>
      <p><i>Especialista en arquitectura de software</i></p>
    </td>
    <td align="center">
      <h3>🧑‍💻 Javier Guzmán</h3>
      <p>Desarrollador Backend</p>
      <p><i>Especialista en bases de datos</i></p>
    </td>
    <td align="center">
      <h3>🧑‍💻 José Buritica</h3>
      <p>Desarrollador Backend</p>
      <p><i>Especialista en JDBC y DAOs</i></p>
    </td>
  </tr>
</table>

---

## 📄 Licencia

Este proyecto fue desarrollado con fines educativos como parte del **Bootcamp de Programación Intermedio de TalentoTech 2025**.

---

## 🙏 Agradecimientos

Agradecemos a:

- 🎓 **TalentoTech** por la oportunidad de aprendizaje
- 👨‍🏫 **Instructores** por su guía y conocimientos compartidos
- 🤝 **Compañeros** del bootcamp por el apoyo mutuo
- 🌐 **Aiven** por el servicio de base de datos en la nube

---

<div align="center">

### 🌱 _"Energías renovables para un futuro sostenible"_ ⚡

**Desarrollado con ❤️ por el equipo TalentoTech 2025**

---

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

**⭐ Si este proyecto te fue útil, considera darle una estrella ⭐**

</div>
