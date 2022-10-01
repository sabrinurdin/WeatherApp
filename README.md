# WeatherApp
Applikasi WeatherApp dengan menggunakan desigN pattern MVVN
<img src="/preview/weatherapp.gif" align="right" width="32%"/>
# Teknologi
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Glide](https://github.com/bumptech/glide) Loading images from network.
- Jetpack
    - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
    - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
    - DataBinding - Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    - Room Persistence - Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)

# Architecture
WeatherApp didasarkan pada arsitektur MVVM dan pola Repositori.
