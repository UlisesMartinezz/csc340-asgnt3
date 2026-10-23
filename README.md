# Naruto Character API

## Description

The Naruto Character API is a RESTful Spring Boot application that stores and manages information on Naruto Character

The API allows users to:

- Create characters
- Retrieve all characters
- Retrieve a character by id 
- Update characters
- Delete characters
- Search characters by partial name
- Filter characters by village

The application uses: 
- Spring Boot 
- Spring Data JPA
- PostgreSQL (Neon)
- Render

---

## Character Attributes

| Attribute | Type | Rules |
|------------|--------|---------|
| id | Long | Auto-generated primary key |
| name | String | Required (`@NotBlank`) |
| description | String | Required (`@NotBlank`) |
| village | Village | Required (`@NotNull`) |
| rank | String | Optional |

### Available Villages

- KONOHAGAKURE
- SUNAGAKURE
- KUMOGAKURE
- IWAGAKURE
- KIRIGAKURE
- OTHER

---

## API Endpoints

| Method | Endpoint | Description | Success Status |
|----------|----------|-------------|----------------|
| GET | `/api/characters` | Get all characters | 200 OK |
| GET | `/api/characters/{id}` | Get a character by ID | 200 OK |
| POST | `/api/characters` | Create a character | 201 Created |
| PUT | `/api/characters/{id}` | Update a character | 200 OK |
| DELETE | `/api/characters/{id}` | Delete a character | 204 No Content |
| GET | `/api/characters?name=nar` | Search by partial name (case-insensitive) | 200 OK |
| GET | `/api/characters?village=KONOHAGAKURE` | Filter by village | 200 OK |

---

## Example POST Request

**POST** `/api/characters`

```json
{
  "name": "Naruto Uzumaki",
  "description": "member of team 7",
  "village": "KONOHAGAKURE",
  "rank": "Hokage"
}
```

**Response:** `201 Created`

---

## Example PUT Request

**PUT** `/api/characters/1`

```json
{
  "name": "Naruto Uzumaki",
  "description": "Hero of the Fourth Great Ninja War",
  "village": "KONOHAGAKURE",
  "rank": "Hokage"
}
```

**Response:** `200 OK`

---

## Error Handling

### 404 Not Found

Returned when a character ID does not exist.

Example:

```http
GET /api/characters/999
```

Response:

```http
404 Not Found
```

### 400 Bad Request

Returned when a POST or PUT request contains a missing or blank name or description.

Example:

```json
{
  "name": "",
  "description": ""
}
```

Response:

```http
400 Bad Request
```

---

## Deployment

### Render URL


```
https://csc340-asgnt3.onrender.com
```

### Cold Start Notice

This application is hosted on Render's free tier. If the application has been inactive, the first request may take up to a minute to process and run.

---

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (Neon)
- Maven
- Render

---

