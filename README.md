# PROJECT PART 1
By: Pratik Kadam & Samarth Kedilaya

## Instructions:
The main files are in the directory "src/com/dbimpl/dbwiscops". The "main.java" file consists of the main code for data generation. While the "DbAdapter.java" file in the dao folder consists of the Database connection configurations.

## Brief Description:
The main objective of this part 1 of the project was to generate data based on the Wisconsin Benchmark specification. The data is generated using a script developed in Java Programming language. Once the data is generated, we loaded that into our PostgreSQL database.

## System of Choice and why?
The database system that we used for this project is PostgreSQL and the programming language that we used for generating the data is Java. The reason that we chose Postgres is that we were already quite familiar with it as we also used it in the CS 586 class. Also has a very reliable performance and is easy to  use. The reason for choosing Java was that it is the language that we are most familiar with.

## Proof of data is loaded into system:
The CSV files in the DataGenerated folder are the ones that we extracted from the postgres select queries.

## Lessons learnt / Problems encountered: 
This project helped us to connect the bridge between a java program and a database system. We learned to generate relations in pgadmin and populate them through a Java file. We did face some hurdles. One of it was to randomise the values for unique1. So, for that we implemented ArrayList and used Collections.shuffle to shuffle that ArrayList. Other thing that made us to think a lot was generating values for string4. We used switch case statement for implementing it.
