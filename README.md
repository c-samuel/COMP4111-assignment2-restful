# COMP4111 Assignment 2 - Restful 

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## API


The following operations are supported. Please note that it is case sensitive.

### Adding Books

You may add books with the following POST request.

```
POST http://localhost:8080/BookManagementService/books
```

The request body shall be a JSON string with the following keys.

key | type | required
--- | --- | ---
Title | String | Yes
Author | String | Yes
Publisher | String | Yes
Year | Number | Yes

### Book Lookup

You may lookup books with the following GET request.

```
http://localhost:8080/BookManagementService/books?
```

The request parameters shall be any combination of the following.

key | type | remarks | required
--- | --- | --- | ---
id | String | a valid hexadecimal representation of an ObjectId | 
title | String | search by title substring | 
author | String | search by author substring | 
year | Number | search by year | 
limit | Number | limit the number of returned results | 
sortby | String | the sorting attribute | required with ```order```
order | String | either ```asc``` or ```desc``` | required with ```sortby```

### Book Loaning and Returning

You may loan books with the following PUT request.

```
PUT http://localhost:8080/BookManagementService/books
```

The request body shall be a JSON String with the following key.

key | type | required
--- | --- | ---
Available | Boolean | Yes

### Book Deletion

You may delete books with the following DELETE request.

```
DELETE http://localhost:8080/BookManagementService/books/{_id}
```

```_id``` shall be the book ID.

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
