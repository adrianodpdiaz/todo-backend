<h1>Todo Manager (Java REST API)</h1>

This project was bootstraped with [`Spring Initializr`](https://spring.io/).

To install/update the dependencies, you can use [`Maven`](https://maven.apache.org/).

<h2> Requirements </h2>

* Create a new PostgreSQL Database;
* Update the file: `./src/main/resources/aplication.properties` with your database information. 

<h2> Deployed app </h2>

You can access this app's deployment online at [`ToDo Manager App`](https://todo-smart-backend-db.herokuapp.com/).

<h2> Endpoints </h2>

<ins>**POST `/user`**</ins>

| Parameter     | Required      | Type      |
| ------------- |:-------------:| ---------:|
| `id`          | true          | string    |
| `name`        | true          | string    |
| `avatar`      | true          | string    |

<ins>**GET `/todo`**</ins>

| Parameter     | Required      | Type      |
| ------------- |:-------------:| ---------:|
| `userId`      | true          | string    |

<ins>**POST `/todo`**</ins>

| Parameter     | Required      | Type      |
| ------------- |:-------------:| ---------:|
| `userId`      | true          | string    |
| `content`     | true          | string    |
| `deadline`    | true          | Date      |

<ins>**PATCH `/todo/complete/:id`**</ins>

| Parameter     | Required      | Type      |
| ------------- |:-------------:| ---------:|
| `id`          | true          | number    |

<ins>**DELETE `/todo/:id`**</ins>

| Parameter     | Required      | Type      |
| ------------- |:-------------:| ---------:|
| `id`          | true          | number    |

<br/>

Made by [`Adriano Diaz`](https://www.linkedin.com/in/adriano-diaz/) :bird:
