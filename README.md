# Android Jetpack Compose Architecture Demo

This repository demonstrates a clean and scalable Android Jetpack Compose project structure, following recommended practices for production use.
The project emphasizes modularity, testability, and maintainability, while keeping the setup simple for mobile-only use cases.

## Core Ideas

**Separation of Concerns**

- `core_data` module: handles data & domain (e.g., API interactions, repositories, models).
- `app` module: contains everything else (presentation layer, navigation, and DI setup).
- Since this project targets Android Mobile only, we keep UI-related code in a single module instead of creating multiple feature modules.

**Android Official Architecture Guidelines**

- Presentation Layer: Jetpack Compose UI (Composable functions) + ViewModel for state management.
- Domain/Data Layer: Repository & data sources in `core_data` module.
- Separation of layers ensures testability, scalability, and clarity.

**Dependency Injection with Hilt**

- All dependencies are managed using Hilt, simplifying DI across modules.

## Why This Architecture?

- Follows official Android recommendations.
- Keeps data domain logic reusable and isolated.
- Simplifies the app structure by not over-modularizing UI for a mobile-only target.
- Scalable for future features (easy to add more modules if needed).
- Provides clean separation of layers, making the app easier to maintain and test.
