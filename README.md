<h2 align="center">Sistema Gerenciador de Eventos 🎫 Rest API</h1>
<h4 align="center">Por: Raquel Kuntz Oliveira, RA: 121036</h1>

#### 🔗 Deploy: [Heroku](event-rest-api.herokuapp.com/)

#### 💾 JSONs para salvar novas entidades:
- 👤 Admin:
```
{
    "name": "Admin Name",
    "email": "admin@email.br",
    "phoneNumber": "1532223333"
}
```
- 👤 Attend:
```
{
    "name": "Attend Name",
    "email": "attend@emil.br",
    "balance": 25.0
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
    "emailContact": "event@email.br",
    "amountFreeTickets": 20,
    "amountPayedTickets": 100,
    "priceTicket": 15.0,
    "admin": adminId
}
```
