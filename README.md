# LBG Assessment

 This is a simple Android application consisting of two screens - 
1. Product List 
2. Product Details. 
It implements MVVM architecture, Retrofit for API calls, clean code architecture and multi modular approach to achieve flexibility and maintainability.


## Folder Structure


### **App Module**
- **LBGApp**: Initializes the app.
- `MainActivity`: App entry point.

### **Core Module**
- **common**: `UIState` to update UI states.

### **Data Module**
- **di**: `NetworkModule` and repository binding.
- **mapper**: Maps `ProductListDTO` to domain models.
- **model**: `ProductListDTO` api response list data class.
- **network**: `ApiService` network call interface.
- **repository**: `ProductRepositoryImpl` fetches product list.

### **Domain Module**
- **utils**: `Constants` holds constant values.
- **model**: Defines response parser data model `ProductItem`.
- **repository**: `ProductRepository` for fetching data.
- **usecase**: `GetProductListUseCase` to retrieve product list and emit into viewmodel.

### **Presentation Module**
- **navigation**: Manages screen navigation:
  - `AppNavGraph`: declaring navigation routes.
  - `AppNavHost`: initializing NavHost.
  - `NavigationLBG`: sealed class navigation routes names.
- **routes**: initializes & navigates to UI screens with added argument:
  - `ProductListRoute`: initializes & navigates to List Screen.
  - `ProductDetailsRoute`: initializes & navigates to Details  Screen.
- **ui.screen**: Screens for the app:
  - `ProductListScreen`: Displays product list.
	- `ListItem`: List item UI Products 
  - `ProductDetailsScreen`: Displays product details.
- **ui.state**: Holdes list state:
  - `ProductListState`: holds the current product list state.
- **viewmodel**: `ProductListViewModel` holds business logic.
	

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case interacts with Repositories to generate data response and pass onto UI.
4. Each Repository returns data from a Data Source (Cached or Remote).
5. Information flows back to the UI where we display the list of posts.

## Key Technologies and Principles  

- **MVVM Architecture (Model-View-ViewModel):**
  - Model: Data and business logic.
  - View: UI elements and layout.
  - ViewModel: Intermediary for UI logic.

- **Retrofit:**
  - Type-Safe HTTP clients.
  - Easy network requests and JSON handling.
  - Integration with libraries like Gson.

- **Hilt:**
  - Dependency injection for modular code.
  - Simplified dependency injection with Hilt.

- **Clean Architecture:**
  - Maintainable, easy-to-read code.
  - Highly testable and scalable.
  - Separation of concerns for flexibility.

## App Overview      
 The app features a 2 screen navigation      
      
- List screen displaying products list      
         
   <img alt="Products List" height="250px" src="https://github.com/divya-gitrepo/LBG/blob/master/list.jpg" />      
         
- Details screen showing the details of the item clicked in the list screen      
      
    <img alt="Product Details" height="250px" src="https://github.com/divya-gitrepo/LBG/blob/master/details.jpg" />

## Dependency Use

- Jetpack Compose for UI: Modern UI toolkit for building native Android UIs
- Retrofit for Networking: A type-safe HTTP client for smooth network requests
- Coroutines, flow: for handling async task and transmitting data into UI.
- Dagger Hilt for Dependency Injection: Simplifies dependency injection
- Mockito, JUnit for Testing: Ensures the reliability of the application