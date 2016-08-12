select e.name, e.startDateTime, e.category, t.ticketsBooked, t.amount from Ticket t, Event e, Person p
where p.id = t.userId and e.id = t.eventId and t.status = "confirmed" and p.id =48;
