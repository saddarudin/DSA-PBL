# Data Analysis and Management Projects

This repository includes three Problem-Based Learning (PBL) projects, each focusing on data analysis, data structure management, and information retrieval using Java. These projects were developed to practice advanced data structures and algorithms while analyzing different datasets related to Pakistani universities, car crashes, and earthquake records.

## Project Summaries

### 1. Pakistani Universities Ranking and Publication Analysis

This project provides a structured approach to managing and analyzing information about Pakistani universities, including world rankings, national rankings, location, and publication counts. The project implements a hash table for efficient university data retrieval, a stack for custom ranking based on publication counts, and another stack based on the rankings.

#### Key Steps:
- **Data Structure**: Hash table for efficient lookup, stacks for custom ranking.
- **Features**:
  - **Retrieve Data**: Search university data using unique keys with no collision.
  - **Rankings**: Access top and bottom universities by publication count and ranking.
  - **Provincial Comparison**: Analyze university performance at the provincial level.

### 2. Car Crash Analysis Based on Weather and Timing

This project analyzes car crash data, organizing information by time and weather conditions. It uses queues to store crash data by month, weather conditions, and day of the week. Additionally, it creates binary trees to manage 'hit and run' vs. 'non-hit and run' crash cases by month.

#### Key Steps:
- **Data Structure**: Queues for organizing crash data, binary trees for managing crash types.
- **Features**:
  - **Deadliest Days**: Identify the deadliest days and Fridays of each month.
  - **Weather-Related Crashes**: Retrieve crash counts based on rainy weather.
  - **Crash Type Comparison**: Identify months with highest and lowest 'hit and run' crashes.
  - **Analysis by Day and Light Conditions**: Evaluate crash frequency based on weekends and light conditions.

### 3. Earthquake Data Analysis and Country Vulnerability Assessment

This project involves analyzing earthquake data by year and country from 1965 to 2016. Using reverse geocoding, the program determines the country for each earthquake based on coordinates, then structures the data into a queue, stack, and linked list.

#### Key Steps:
- **Data Structure**: Yearly queue for biggest quakes, country-specific stacks for earthquake history, linked list for most recent earthquakes by country.
- **Features**:
  - **Earthquake Vulnerability**: Calculate average annual earthquakes per country.
  - **Major Earthquakes**: Identify significant earthquakes between 2005 and 2015.
  - **Recent Earthquakes**: Retrieve recent earthquake information for each country.
  - **High-Magnitude Events**: Find recent earthquakes with magnitude above 6.

## Common Functionality Across Projects

Each project includes a structured approach using:
- **Data Structures**: Hash tables, stacks, queues, binary trees, and linked lists.
- **Data Organization**: Data is sorted or filtered based on specific attributes (e.g., publication count, crash conditions, or earthquake magnitude).
- **Query Methods**: Designed to answer various questions based on dataset specifics, such as retrieving top-ranked entities or filtering by specific criteria.

## Installation and Usage

1. **Clone the Repository**: Download or clone the repository to your local machine.
2. **Build and Run**: Compile the Java files and run each project individually based on your preferred Java IDE or CLI.
3. **Data Input**: Ensure data is correctly formatted and provided for each project (e.g., crash data, university rankings, earthquake information).
4. **Execute Queries**: Use the provided methods to retrieve answers to the various problems stated in each project’s description.

## Future Improvements

These projects could be further enhanced by:
- Adding GUI interfaces to visualize data and results.
- Integrating real-time data APIs to keep information updated.
- Optimizing data structures and methods for larger datasets.
