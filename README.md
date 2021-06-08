<h2 align="center">Sistema Gerenciador de Eventos 🎫 Rest API</h1>
<h4 align="center">Por: Amanda Perrone Degrande, RA: 140501 & Raquel Kuntz Oliveira, RA: 121036</h1>

#### 🔗 Deploy: [Heroku](https://event-rest-api.herokuapp.com/)

#### 💾 JSONs para salvar novas entidades:

- 👤 Admin:

```
{
    "name": "Admin Name",
    "email": "admin@email.com",
    "phoneNumber": "1532223333"
}
```

- 👤 Attendee:

```
{
    "name": "Attendee Name",
    "email": "attend@email.com"
}
```

- 📌 Place:

```
{
    "name": "Place Name",
    "address": "Place Address"
}
```

- 🎫 Event:

```
{
    "name": "Event Name",
    "description": "Event Description",
    "startDate": "20/04/2021",
    "endDate": "22/04/2021",
    "startTime": "08:00:00",
    "endTime": "10:30:00",
    "emailContact": "event@email.com",
    "amountFreeTickets": 20,
    "amountPayedTickets": 100,
    "priceTicket": 15.0,
    "idAdmin": 1
}
```

- 🎟️ Ticket:

```
{
    "idAttendee": 5,
    "type": 0
}
```
