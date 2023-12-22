# URL-Database
The URL Database is a compact Java command-line tool for basic URL management with features like storing, retrieving, counting, listing, deleting, and updating URLs in a local, in-memory database.

Getting Started
Prerequisites
Java Development Kit (JDK) installed on your machine.



1. Data Structure
The program uses a HashMap to store URL data. Each URL is associated with a unique short key, and the corresponding data (URL, count) is encapsulated in the UrlData class.



2. Command-Line Interface
The program provides a simple command-line interface where users can enter commands to perform various operations. The main loop continually waits for user input and executes the corresponding commands.



3. Command Operations
  storeurl: Adds a new URL to the database with a unique short key and initializes the usage count to 0.

  get: Retrieves the short key for a given URL and increments its usage count.

  count: Returns the latest usage count for a given URL.

  list: Displays all stored URLs and their usage counts in JSON format.

  geturlbyshortkey: Retrieves the URL associated with a given short key.(additional feature)

  delete: Deletes a URL from the database based on its short key.(additional feature)

  update: Updates the URL associated with a given short key.(additional feature)



4. Example Interaction
Users can interact with the program by entering commands. For example:

> storeurl https://www.google.com
URL stored with short key: url1

> get https://www.google.com
Short key for https://www.google.com: url1

> count https://www.google.com
Usage count for https://www.google.com: 1

> list
URLs and counts in the database:
{
  "url1": "https://www.google.com (Usage Count: 1)"
}

> geturlbyshortkey url1
URL for short key url1: https://www.google.com

> update url1 https://www.updatedurl.com
URL with short key url1 updated to: https://www.updatedurl.com

> list
URLs and counts in the database:
{
  "url1": "https://www.updatedurl.com (Usage Count: 1)"
}

> delete url1
URL with short key url1 deleted.

> list
URLs and counts in the database: {}

> exit
Exiting URL Database. Goodbye!

This project provides a basic foundation for managing URLs via a command-line interface in a local environment. It can serve as a starting point for further enhancements based on specific requirements.





