# User Explorer App

A modern Android application built with **Kotlin**, **Jetpack Compose**, **MVVM**, and **Retrofit** to explore user information from a remote REST API.

This project is being developed as a learning project to gain practical experience with modern Android architecture and best practices.

---

## Features

- Fetch users from REST API using Retrofit
- Display users in a modern Material 3 interface
- MVVM architecture
- Reactive UI using StateFlow
- Display profile images using Coil
- Open website in browser
- Open email client
- Open phone dialer
- Open user location in Google Maps
- Loading and error state handling

---

## Screenshots

> Screenshots will be added soon.

---

## Architecture

This project follows the **MVVM (Model-View-ViewModel)** architecture.

```
                UI (Jetpack Compose)
                        │
                        ▼
                 UserViewModel
                        │
                 StateFlow<UserUiState>
                        │
                        ▼
                UserRepository
                        │
                        ▼
                  Retrofit API
                        │
                        ▼
              JSONPlaceholder API
```

### Data Flow

```
UserScreen
      │
      ▼
UserViewModel
      │
      ▼
UserRepository
      │
      ▼
Retrofit
      │
      ▼
Remote API
      │
      ▼
UserDto
      │
      ▼
StateFlow
      │
      ▼
Compose UI
```

---

## Project Structure

```
com.example.userexplorerapp
│
├── model
│   ├── UserDto.kt
│   └── UserResponse.kt
│
├── network
│   ├── RetrofitInstance.kt
│   └── UserApi.kt
│
├── presentation
│   └── UserScreen.kt
│
├── repository
│   └── UserRepository.kt
│
├── uiState
│   └── UserUiState.kt
│
├── viewmodel
│   └── UserViewModel.kt
│
└── MainActivity.kt
```

---

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit
- Gson Converter
- Kotlin Coroutines
- StateFlow
- Coil
- Material 3
- Implicit Intents

---

## APIs Used

### User API

```
https://jsonplaceholder.typicode.com/users
```

### Profile Images

```
https://i.pravatar.cc/
```

---

## What I Learned

This project is helping me gain practical experience with:

- MVVM Architecture
- Retrofit
- REST API integration
- Repository Pattern
- StateFlow
- Jetpack Compose
- UI State Management
- Material 3
- Implicit Intents
- Modern Android Project Structure

---

## Getting Started

### Clone the repository

```bash
git clone https://github.com/<your-username>/UserExplorerApp.git
```

### Open the project

Open the project in Android Studio.

### Sync Gradle

Allow Gradle to download all dependencies.

### Run

Run the application on an emulator or physical Android device.

---

## Future Improvements

- User Details Screen
- Hilt Dependency Injection

---

## Author

**Deepak Kumar**

Android Developer

---

## Project Goal

The primary goal of this project is to strengthen my understanding of:

- Modern Android Development
- Clean MVVM Architecture
- Retrofit Networking
- Reactive UI with StateFlow
- Building production-style Android applications