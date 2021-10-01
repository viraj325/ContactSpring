# ContactSpring Description
This is a Contact Management application written in Java/HTML/CSS using Spring Framework utilizing MVC pattern.
This application has CRUD REST APIs in which users can access on Localhost.
When using the GET request, the output will be in HTML with CSS styling and can be accessed using Chrome browser
For POST/PUT/DELETE, users will need Postman for POST, PUT, DELETE requests.

Intro
![Snapshot1](https://user-images.githubusercontent.com/37918393/135691650-150b9627-fbe0-495a-b2ee-8bf56f365cbd.png)

Search Contacts
![Snapshot2](https://user-images.githubusercontent.com/37918393/135691656-74a6e255-6676-47a2-92c6-e31c3832a255.png)

# Install ContactSpring

For ContactSpring to work correctly make sure to have Tomcat Server downloaded and started, recommended through IntelliJ.
You can use the Github CLI - "gh repo clone viraj325/ContactSpring" to clone the project or simply just download the zip.

# How does it work?
The application runs on localhost with api endpoints listed below.

/create(POST)
Parameters: String name, String email, String phone, String address
To create a new user.

/contact(GET)
To get list of all contacts.

/search/{phone}(GET)
Parameters: String phone
To search a specific contact.

/update(POST)
Parameters: String name, String email, String phone, String address, String initialPhone
To update a specific contact.

/delete/{phone}(DELETE)
Parameters: String phone
To delete a specific contact.

/delete(DELETE)
To delete all contacts.
