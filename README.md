# GitHub Repository Details README

This project is a GitHub repository details application that retrieves information about repositories and their branches for a given GitHub user. The application is implemented in Kotlin using the Quarkus framework, incorporating MicroProfile REST Client and SmallRye Mutiny for reactive programming.

## Table of Contents

1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Getting Started](#getting-started)
4. [Usage](#usage)

## Introduction

The GitHub Repository Details application is designed to fetch repository information for a specified GitHub user. It utilizes the GitHub API through a REST client and provides a structured response containing details about each repository, including the repository name, owner's login, and a list of branches with their corresponding last commit SHA.

## Project Structure

The project is structured as follows:

- **`src/main/kotlin/com/ziola/githubclient/controller`**: Contains the main controller class (`GhController`) responsible for handling incoming HTTP requests.

- **`src/main/kotlin/com/ziola/githubclient/service/impl`**: Houses the service class (`GhService`) responsible for interacting with the GitHub API and processing the retrieved data.

- **`src/main/kotlin/com/ziola/githubclient/client`**: Holds the GitHub REST client interface (`GhClient`), which defines the methods for interacting with the GitHub API.

- **`src/main/kotlin/com/ziola/githubclient/dto`**: Contains the data transfer objects (DTOs) used to model the response data, including `ApiResponses`, `RepoBranchCommit`, and `GhRepository`.

## Getting Started

To run the GitHub Repository Details application locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone <repository-url>

2. Navigate to the project directory:

   ```bash
   cd <project-directory>

3. Build the application:

    ```bash
   ./gradlew build
    
4. Run the application:

    ```bash
    ./gradlew quarkusDev

## Usage

The main endpoint of the application is accessible at /username/{username}, where {username} is the GitHub username for which you want to retrieve repository details.

Example:

    curl http://localhost:8080/username/johndoe
    
This will return a JSON response containing information about the repositories and their branches for the specified GitHub user.


