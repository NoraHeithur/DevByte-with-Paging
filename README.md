# DevByte with Paging

![Kotlin 1.6.21](https://img.shields.io/badge/Kotlin-1.6.21-7F52FF?style=for-the-badge&logo=kotlin) ![Gradle 7.2](https://img.shields.io/badge/Gradle-7.2-02303A?style=for-the-badge&logo=gradle) ![AGP 7.1.3](https://img.shields.io/badge/AGP-7.1.3-3DDC84?style=for-the-badge&logo=android)

DevByte with Paging is a revamped application that follows the name of the [original demo](https://github.com/udacity/andfun-kotlin-dev-bytes) in my versions. This project demonstrates the DevByte playlist data, insert the data into Room database, and loads it with the Paging 3 library. The app is based on the Android architecture and Koin as a dependency injection.

<p align="center">
<br>
<img src="misc/DevByte-demo.gif" width="50%">
</p>

## Tech-stack
- Minimum Sdk level 24
- Tech-stack
    - Kotlin - based language
    - Coroutines - handle background operations
    - Jetpack
        - LiveData - notify view about data change
        - Lifecycle - act when lifecycle state changes
        - ViewModel - store and manage data for UI-related with lifecycle aware
        - Room - store offline cache
        - Navigation - in-app navigation
        - Paging - load and display pages of data from local storage or over network
    - Coil - image loading
    - Koin - dependency injection
    - Retrofit - construct type-safe HTTP for networking
    - Moshi - modern JSON library for Android
    - Timber - application debugging
    - Localization - localizing library for Android
- UI
    - Material components - material design for UI
- Architecture
    - MVVM Architecture

## Open API
This project uses [data](https://devbytes.udacity.com/devbytes.json) list from [Developing Android Apps with Kotlin](https://classroom.udacity.com/courses/ud9012) course.

## Acknowledge & Guideline
The relevant knowledge resources inspired and guided me in app development.

### Android Projects
- [android-showcase](https://github.com/igorwojda/android-showcase) - a sample project that demonstrates a modern Android development with popular libraries and best development practices.
- [RickAndMorty](https://github.com/metinozcura/RickAndMorty) - a demo app for Paging 3 and basic Hilt implementation.
- [CoinRanking](https://github.com/annchar/CoinRanking) - a demo app that demonstrates cryptocurrency data and renders it with Paging.

### Codelab
- [Using Kotlin Coroutines in your Android App](https://developer.android.com/codelabs/kotlin-coroutines?authuser=2#0) - how to use Kotlin Coroutines in an Android app.
- [Advance Kotlin Coroutines with Flow and LiveData](https://developer.android.com/codelabs/advanced-kotlin-coroutines#0) - how to use the LiveData builder to combine Kotlin coroutines with LiveData, and using Flow a type of collection whose values are lazily produced.
- [Android Paging Basics](https://developer.android.com/codelabs/android-paging-basics#1) - how to use basics of Paging 3 library and components.

### Course
- [Developing Android Apps with Kotlin](https://classroom.udacity.com/courses/ud9012) - how to use the basics of the Paging 3 library and components.

## Upcoming improvements
- Create tests

## License
This project is licensed under the [MIT](https://github.com/NoraHeithur/CovDecem/blob/main/LICENSE) license.