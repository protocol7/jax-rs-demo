# Background
This is a very simple (too simple?) demo of some of the JAX-RS functionality. It's an application for handling time reports, each consisting of
a number of events. Supports output both to HTML and ICS, depending on conneg. Well, that's pretty much it.

# Download ICS file example
wget --header="Accept: text/calendar" http://localhost:8080/report/niklas