# BillBoard Specification

## Project Structure

- Taking important points forom the **Explicilt Requirements** and **User Stories** I've complied the below diagram explaining the basic functions and the most basic strucuture of the app

<img src="images/app.png">

## BillBoard Viewer

<img src="images/viewer.png">

### Design

- It will make HTTP request to the server every 15 seconds asking for current billboard.
- It will get the message, information,picture url,picture type as an object passed down by the DB(Refer Billboard table) to the server, which the server will give to billboard.
- The viewer will create the XML with the data given by server by template literals as shown :-

```java
String template = "status is %s, data key is %s"
String result = String.format(template, status, key);
```

- There is a boolean value isURL in billboard table. As an image can either be uRL or basencoded string (page - 9 last para). This will let you make the XML better with an if else condition.
- IF the HTTP request fails, or the server doesn't respond. We show the error message.
- In case of incomplete info refer the page number 10 of the Specs.

## BillBoard Control Panel

<img src="images/control_panel.png">

### Design
