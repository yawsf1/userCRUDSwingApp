# User CRUD Swing Application

A Java-based desktop application built with Swing for managing user data. This project demonstrates a clean, layered architecture for implementing Create, Read, Update, and Delete (CRUD) operations on user records through an intuitive graphical user interface.

## Overview

The User CRUD Swing Application provides a desktop solution for user management with a modern three-tier architecture pattern. It separates concerns between data persistence, business logic, and user interface, making the code maintainable and scalable.

## Project Architecture

The application follows a **layered architecture** approach:

```
src/
├── dao/          # Data Access Layer - Database operations and persistence
├── metier/       # Business Logic Layer - Core application rules and user operations
└── presentation/ # Presentation Layer - Swing GUI components and user interactions
```

### Layer Descriptions

- **DAO (Data Access Object)**: Handles all database communication, CRUD operations at the data storage level
- **Métier (Business Logic)**: Contains the core business rules, validation, and application logic
- **Presentation**: Swing-based GUI components that interact with the user

## Features

- Create new user records to the system
- Read and view user information
- Update existing user data
- Delete user records from the system
- User-friendly graphical interface built with Java Swing
- Clean separation of concerns with layered architecture

## Technology Stack

- **Language**: Java
- **GUI Framework**: Swing
- **Architecture**: MVC/Layered Pattern
- **Project Type**: IntelliJ IDEA Project

## Project Structure

```
userCRUDSwingApp/
├── .gitignore
├── .idea/                 # IntelliJ IDEA configuration
├── src/
│   ├── dao/              # Data access objects
│   ├── metier/           # Business logic classes
│   └── presentation/     # GUI components
└── swingApp.iml          # IntelliJ module file
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA (recommended) or any Java IDE

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yawsf1/userCRUDSwingApp.git
   cd userCRUDSwingApp
   ```

2. Open the project in IntelliJ IDEA:
   - Open IntelliJ IDEA
   - File → Open → Select the `userCRUDSwingApp` directory
   - The IDE will recognize the `.iml` module file

3. Build and run the application:
   - Build: Build → Build Project
   - Run: Right-click the main class in the presentation layer and select "Run"

## Usage

1. Launch the application
2. Use the GUI to manage user records:
   - **Add User**: Fill in user details and click Create
   - **View Users**: Browse the list of existing users
   - **Update User**: Select a user and modify their information
   - **Delete User**: Remove users from the system

## Data Flow

```
User Interface (Swing GUI)
        |
Presentation Layer
        |
Business Logic Layer (Métier)
        |
Data Access Layer (DAO)
        |
Database/Data Storage
```

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (git checkout -b feature/YourFeature)
3. Commit your changes (git commit -m 'Add your feature')
4. Push to the branch (git push origin feature/YourFeature)
5. Open a Pull Request

## License

This project is available under an open-source license. See the repository for more details.

## Author

**yawsf1** - [GitHub Profile](https://github.com/yawsf1)

## Support and Contact

For issues, questions, or suggestions, please open an [Issue](https://github.com/yawsf1/userCRUDSwingApp/issues) on GitHub.

---

Last Updated: March 2026
